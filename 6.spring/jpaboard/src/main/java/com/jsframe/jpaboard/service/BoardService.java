package com.jsframe.jpaboard.service;

import com.jsframe.jpaboard.entity.Board;
import com.jsframe.jpaboard.entity.BoardFile;
import com.jsframe.jpaboard.repository.BoardFileRepository;
import com.jsframe.jpaboard.repository.BoardRepository;
import com.jsframe.jpaboard.util.PagingUtil;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Service
@Log
public class BoardService {
  @Autowired
  private BoardRepository bRepo; //게시글 DB 처리용
  @Autowired
  private BoardFileRepository bfRepo; //파일 DB 처리용

  private ModelAndView mv;

  //게시글 저장 메서드
  @Transactional  //실행결과가 정상적일 경우 commit, 예외 발생시 rollback처리
  public String insertBoard(List<MultipartFile> files, //업로드 파일 목록 MultipartFile 업로드한 파일을 쉽게 다룰 수 있게 도와주는 객체
                            Board board,
                            HttpSession session,  //파일 업로드할때 필요.
                            RedirectAttributes rttr) { //저장 성공시 메세지 출력
    log.info("insertBoard()");
    String msg = null;
    String view = null;

    try {
      //insert와 update 처리 메서드 save()

      bRepo.save(board);  //저장과 동시에 select도 처리
      //자동생성되는 rdate와 pnum은 controller에서 전달받은 parameter에 없었지만,
      //save()메서드를 실행하고나면, db에 저장된 Board의 데이터를 담아서 반환한다.
      // 동시에 여러 insert가 발생할 경우, 가장 최근에 저장된 게시글을 조회할 때, 잘못된 조회가 이루어질 수 있다.
      // insert된 데이터를 바로 select하는 과정이 필요.)
      //bRepo.save(board);  메서드의 실행 이후, board 인스턴스에는 rdate와 bnum이 저장돼있다.

      log.info("bnum : " + board.getBnum());
      //파일 저장(외래키에 해당하는 게시글 번호가 필요함 - 게시글번호는 insert할 때 자동생성되는데,


      fileUpload(files, session, board);

      view = "redirect:/"; //목록 화면으로 돌아가기
      msg = "저장 성공";

    } catch (Exception e) {
      e.printStackTrace();
      view = "redirect:writeFrm";
      msg = "저장 실패";
    }
    rttr.addFlashAttribute("msg", msg);
    return view;
  }


  private void fileUpload(List<MultipartFile> files,
                          HttpSession session, Board board) throws Exception {
    log.info("fileUpload()");

    //파일 저장 위치 지정. session 활용
    String realPath = session.getServletContext().getRealPath("/");//getServletContext : 연결중인 세션의 정보를 가져옴. getRealPath: 물리적인 경로("/" : 루트 경로)
    log.info("realpath : " + realPath);

    //파일 업로드용 폴더를 자동으로 생성하도록 처리(업로드용 폴더 : upload)
    //webapp은 웹으로 처리되는 것들을 저장하는 장소이므로, 저장용 폴더를 따로 생성해서 저장한다.
    realPath += "upload/";
    File folder = new File(realPath); //물리적인 장소(디스크 내의 경로 reapath)에 저장된 File을 메모리에 담아서 처리하는 형태로 처리된다.
    if (folder.isDirectory() == false) {//파일이 없을 경우, upload라는 명을 가진 파일만(폴더x) 있을경우
      folder.mkdir();//폴더 생성 메서드
    }


    for (MultipartFile mf : files) { //MultipartFile의 List이므로, 반복문을 통해 저장된 데이터를 가져온다.
      String orname = mf.getOriginalFilename(); //업로드 파일명 가져오기
      if (orname.equals("")) {//업로드하는 파일이 없는 상태
        return; //파일 저장 처리 중지
      }
      //파일 정보를 저장(boardfiletbl 테이블)
      BoardFile bf = new BoardFile();
      bf.setBfbid(board);
      bf.setBforiname(orname);
      String sysname = System.currentTimeMillis()//1970.1.1부터의 밀리초 값
          + orname.substring(orname.lastIndexOf("."));// + 확장자
      bf.setBfsysname(sysname);

      //업로드하는 파일을 upload 폴더에 저장
      File file = new File(realPath + sysname);
      //파일 저장(upload폴더)
      mf.transferTo(file);//MultipartFile mf를 file변수에 저장

      //파일 정보를 DB에 저장
      bfRepo.save(bf);
    }//for end
  }//fileUpload() end


  //페이징 처리된 목록을 가져오는 메서드
  public ModelAndView getBoardList(Integer pageNum, HttpSession session) {//래퍼클래스인 Interger로 인수를 받으면, 전달받은 값이 없어도 ?
    log.info("getBoardList()");
    mv = new ModelAndView();

    if (pageNum == null) {
      //처음에 접속했을 때는 pageNum이 넘어오지 않는다.
      pageNum = 1;
    }
    int listCnt = 5;//페이지당 보여질 게시글의 개수
    //페이징 조건
    Pageable pb = PageRequest.of((pageNum - 1), listCnt, Sort.Direction.DESC, "bnum");
    Page<Board> result = bRepo.findByBnumGreaterThan(0L, pb);

    List<Board> bList = result.getContent();

    int totalPage = result.getTotalPages();
    String paging = getPaging(pageNum, totalPage);

    mv.addObject("bList", bList);
    mv.addObject("paging", paging);

    //현재보이는 페이지의 번호를 저장(뒤로가기 버튼 눌렀을 때 출력할 페이지)
    //ModelAndView에 저장할 경우, 페이지를 이동할때마다 전달해줘야하는데, session에 저장할 경우 해당 데이터를 유지할 수 있다.
    //보안과 관련된 정보는 직접 넘겨줘야하지만, 민감한 데이터가 아닐경우에는 세션에 저장하는 방식이 편의성이 높다.
    session.setAttribute("pageNum", pageNum);
    return mv;
  }


  //페이징 처리 메서드(외부에서 사용할 일이 없으므로, private으로 제어)
  private String getPaging(Integer pageNum, int totalPage) {

    String pageHtml = null;
    int pageCnt = 2;  //화면에 보여질 페이지 번호 개수
    String listName = "?";
    PagingUtil paging = new PagingUtil(totalPage, pageNum, pageCnt, listName);
    pageHtml = paging.makePaging();
    return pageHtml;

  }

  //상세보기
  public ModelAndView getBoard(long bnum) {
    log.info("getBoard()");
    mv = new ModelAndView();


    //게시글 가져와서 담기

    //findById는 Optional로 DB에서 꺼내오고, 꺼내온걸 가져오는게 get()메서드
    Board board = bRepo.findById(bnum).get();
    mv.addObject("board", board);


    //첨부파일(목록) 가져와서 담기(selet * from boardfiletbl where bfbid = ?)


    //bfbid로 검색해야하는데 자동완성되지 않으므로, 직접 메서드 생성
    List<BoardFile> bfList = bfRepo.findByBfbid(board);
    mv.addObject("bfList", bfList);

    return mv;
  }

  //파일 다운로드 처리) //org.springframework.core.io.Resource
  public ResponseEntity<Resource> fileDownload(BoardFile bfile, HttpSession session) throws IOException {
    log.info("fileDownload()");
    //파일 저장 경로 구하기
    String realpath = session.getServletContext().getRealPath("/");
    //DispatcherServlet에는 session이 동작하는데 필요한 정보(context)를 함께 가지고 있으므로, ServletContext에서 루트경로(~/webapp까지의 경로)를 구할 수 있다.
    realpath += "upload/" + bfile.getBfsysname();


    //resource를 관리하는 inputstream으로 통로 연결. // 통로만 연결하는 inputstream도있고, 관련 처리를 함께 하는 inputstream도 있따.
    InputStreamResource fResource = new InputStreamResource(new FileInputStream(realpath));

    //original file name이 한글일 경우 제대로 동작하지않을 수도 있으므로 utf-8로 인코딩 처리
    //비영어권 언어를 사용할 경우, 인코딩은 필수로 처리한다.
    String fileName = URLEncoder.encode(bfile.getBforiname(), "UTF-8");

    return ResponseEntity.ok() //- 상태코드 200을 처리하는 메서드
        .contentType(MediaType.APPLICATION_OCTET_STREAM) //통신으로 전송되는 데이터(application에서 만들어진 데이터)인데, 8비트로 된 데이터(바이너리 데이터)의 파일임을 contentType으로 지정
        .cacheControl(CacheControl.noCache())//캐시로 처리하지 않도록 지정(임시저장하지 않도록)
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
        //서버에서 넘어오는 데이터는 파일덩어리가 아니라 비트열로 넘어오는데,
        // 어디부터 어디까지가 파일인지를 패킷에 담아 보내준다.
        // 이걸 모아서 하나의 파일로 완성하는데, 비트열로 넘어온 데이터라서 따로 이름 담겨있진 않다.
        // 그래서 파일이름을 다시 지정해줘야한다.
        .body(fResource); //파일의 실제 데이터
  }

  //게시글 수정
  @Transactional
  public String boardUpdate(List<MultipartFile> files,
                            Board board,
                            HttpSession session,
                            RedirectAttributes rttr) {
    log.info("boardUpdate()");
    String msg = null;
    String view = null;
    try {
      bRepo.save(board); //insert, update 겸용(pk에 해당하는 값이 있다면, update, 없으면 insert)

      fileUpload(files, session, board);//신규 파일 업로드

      msg = "수정 성공";
      view = "redirect:detail?bnum=" + board.getBnum();
    } catch (Exception e) {
      e.printStackTrace();
      msg = "수정 실패";
      view = "redirect:updateFrm?bnum" + board.getBnum();
    }
    rttr.addFlashAttribute("msg", msg);
    return view;
  }

  //게시글 및 관련 파일 삭제
  @Transactional
  public String boardDelete(long bnum,
                            HttpSession session,
                            RedirectAttributes rttr) {

    log.info("boardDelete()");
    String msg = null;
    String view = null;
    Board board = new Board();
    board.setBnum(bnum);

    String realPath = session.getServletContext().getRealPath("/");
    realPath += "upload/";

    List<BoardFile> bfList = bfRepo.findByBfbid(board);


    try {
      //파일 삭제
      for (BoardFile bf : bfList) {
        String delPath = realPath+bf.getBfsysname();
        File file = new File(delPath);

        if (file.exists()) {
          file.delete();//파일이 있으면 삭제
        }
      }

      //파일 정보 삭제
      bfRepo.deleteByBfbid(board);
      //게시글 삭제
      bRepo.deleteById(bnum);
      msg="삭제 성공";
      view="redirect:/";
    } catch (Exception e) {
      e.printStackTrace();
      msg="삭제 실패";
      view ="redirect:detail?bnum="+bnum;
    }
    rttr.addFlashAttribute("msg", msg);

    return view;
  }


}
