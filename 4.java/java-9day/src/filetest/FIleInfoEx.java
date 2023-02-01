package filetest;

import java.io.File;
import java.io.IOException;

public class FIleInfoEx {
  public static void main(String[] args) {
    //1. 파일 정보 확인하기
    //파일 객체 생성
    File f = new File("test.txt");  //메모리상에만 test.txt 파일을 만듦
    try {
     boolean b =  f.createNewFile(); //파일이 있으면 파일 생성하지 않음. false , 파일이 없으면, 생성하고 true
                                        //이미 해당 이름의 파일이 메모리에 있으면 false
      if(b){    //b가 true라면,
        System.out.println("파일 생성 성공");
      }
      else {
        System.out.println("이미 파일이 존재함");
      }
    } catch (IOException e){
      e.printStackTrace();
    }
    //파일 존재 여부 및 파일/폴더 구분
    // 파일 객체와 연결된 부분이 실제 파일인지 확인(폴더인지 파일인지/파일이 존재하는지 안하는지 판단)
    System.out.println("파일인가? "+f.isFile());      //파일인지 확인하는 매서드 .isFile()
    //마지막 수정 시간
    System.out.println("수정 시간 : "+f.lastModified());  //- 밀리초 단위로 환산
    //시간과 관련하여 산출된 밀리초의 시작은 1970.1.1부터.



    System.out.println("읽기 가능 : " + f.canWrite());
    System.out.println("쓰기 가능 : " + f.canWrite());
    System.out.println("읽기 가능 : " + f.canExecute());
    System.out.println("숨김파일? " + f.isHidden());
    //파일 존재 여부
    System.out.println("존재하는가? " + f.exists());
    //파일 크기
    System.out.println("파일의 크기" + f.length());//영어는 1바이트, 한글은 3바이트
    //줄바꿈(enter) 2비이트 -> 줄을 바꾸고 가장 앞으로 돌려줘야 하므로, 두가지의 데이터가 함께 저장된다.


    //파일 경로
    //상대 경로 정보
    System.out.println("상대경로 : " + f.getPath());  //프로젝트 폴더에서부터 시작된 경로
    //절대 경로 정보 - 상대경로보단 절대결로를 사용하는 게, 경로와 관련된 자잘한 문제가 발생할 가능성이 적다.
    System.out.println("절대 경로 :" + f.getAbsolutePath());  // 드라이브부터 해당 파일까지의 경로



    /*
    //파일 이름 변경
    File f2 = new File("test2.txt");    //새로운 파일을 만들고, 변경할 이름을 인자로 넣기
    //변경할 파일의 이름이 이미 존재할 경우, 파일을 생성하지 못하므로
    boolean rb = f.renameTo(f2);
    if(rb){
      System.out.println("변경 실패");
    }
    else{
      System.out.println("변경 성공");
    }

    //파일 이동
    File f3 = new File("target\\test2.txt");
    boolean rb2 = f2.renameTo(f3);
    if(rb2){
      System.out.println("이동 성공");
    }
    else {
      System.out.println("이동 실패");
    }

  //복사(ctrl + c) : 원본 유지  (복사본도 원본이다.)
  //이동(ctrl + x) : 원본 삭제
  */


  //파일 삭제
  if(f.exists()){ //파일이 존재해야 삭제 가능하므로, 존재유무부터 확인
    f.delete();
  }






  }
}
