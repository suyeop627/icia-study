package com.jsframe.jpaboard.controller;

import com.jsframe.jpaboard.entity.Board;
import com.jsframe.jpaboard.entity.BoardFile;
import com.jsframe.jpaboard.service.BoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@Log
public class BoardController {
  ModelAndView mv;

  @Autowired
  private BoardService bServ;

  @GetMapping("/")
  public ModelAndView getList(Integer pageNum, HttpSession session) {  //페이징 추가예정
    log.info("getList()");
    mv = bServ.getBoardList(pageNum, session);
    mv.setViewName("list");
    return mv;
  }

  @GetMapping("writeFrm")
  public String writeFrm() {
    log.info("writeFrm()");
    return "writeFrm";
  }


  @PostMapping("writeProc")
  public String writeProc(@RequestPart List<MultipartFile> files,
                          Board board,
                          HttpSession session,
                          RedirectAttributes rttr) {

    log.info("writeProc()");
    String view = bServ.insertBoard(files, board, session, rttr);
    return view;

  }


  //예외 확인을 위한 매핑
  @GetMapping("error500")
  public String error500() throws Exception {
    log.info("error()");
    throw new Exception("강제로 발생시킨 예외!");
  }

  //상세보기
  @GetMapping("detail")
  public ModelAndView detail(long bnum) {
    log.info("detail()");
    mv = bServ.getBoard(bnum);
    mv.setViewName("detail");//list와 update에서 둘다 detail로 페이지를 호출하므로, controlelr에서 setViewName을 한다
    return mv;
  }

  //파일 다운로드
  @GetMapping("download")
  public ResponseEntity<Resource> fileDownload(BoardFile bfile, HttpSession session) throws IOException {
    ResponseEntity<Resource> resp = bServ.fileDownload(bfile, session);
    return resp;
  }

  //수정페이지로 전환
  @GetMapping("updateFrm")
  public ModelAndView updateFrm(long bnum){
    //상세보기페이지에서도 글 데이터를 가져와서 수정메서드로 보낼 수 있지만, 과정이 매우 번거롭다.
    //bnum만 가져와서 DB를 검색해오는게 편함

    log.info("updateFrm()");
    mv=bServ.getBoard(bnum);
    mv.setViewName("updateFrm");
    return mv;
  }

  @PostMapping("updateProc")
  public String updateProc(List<MultipartFile> files,Board board, HttpSession session, RedirectAttributes rttr){
    log.info("updateProc()");
    String view = bServ.boardUpdate(files,board,session, rttr);

    return view;
  }
@GetMapping("delete")
  public String deleteBoard(long bnum, HttpSession session, RedirectAttributes rttr){
    log.info("deleteBoard()");
    String view = bServ.boardDelete(bnum, session, rttr);

    return view;

}
}