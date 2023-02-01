package fileout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {//1
  public static void main(String[] args) {
    BufferedWriter bw = null; //FileWriter가 문자단위로 처리하므로, 모아서 처러하기 위해 사용하는 보조 성격의 클래스(메모리 효율이 좋아진다.)
    FileWriter fw = null;

    try{    //file not found exception / io exception 발생가능(?) -> 찾아서 정리
      File file = new File("data\\test.txt"); // '\\'파일 경로 나타낼때 사용함. 일반적으로 경로는 역슬레시로 사용하지만, 프로그래밍언어에서 \는 다른 의미를 갖는 경우가 많으므로, \를 사용하기위해 \를 하나 더씀
      //새로운 폴더를 거쳐서 파일을 생성할 경우, 해당 폴더가 없으면 파일이 생성되지 않는다.->폴더 생성
      File folder = new File("data");
      if(!folder.isDirectory()){
        folder.mkdir();
      }

      //FileWriter -> BufferedWriter 순서로 작성
      fw = new FileWriter(file, true);  //FileWriter의 두번째 인자로 true를 넣으면 붙여쓰기(append), 미입력시 덮어쓰기(overwrite)
      bw = new BufferedWriter(fw);
      String str = "파일에 저장할 내용\n";
      bw.write(str);
      bw.flush();
      System.out.println("저장 성공.");

    }catch (Exception e ){
      //e.printStackTrace();      //어떤 예외사항인지 확인하기 위해 사용 - 비정상적 예외사항이 발생했을 떄, 어떤 예외가 발생했는지 출력해준다. 보통 유저가 볼 수 없는 콘솔화면에 출력한다.
    }finally{  //입출력메소드(FileWriter나 BufferedWriter는 가비지 컬렉터가 제대로 지워주지 못하므로, finally에서 정리해줘야 한다.
      try {
        //BufferedWriter -> FileWriter  순서로 작성
        bw.close();   //close자체가 예외사항 발생할 수 있어서 try-catch문 사용
        fw.close();
      } catch (IOException e) {   //지역변수이므로, catch문의 e와는 별개의 변수이다.
        e.printStackTrace();
      }
    }
  }//main end
}//class end
