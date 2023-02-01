package filetest;

import java.io.*;

public class FileOutput {
  public static void main(String[] args) {
    FileOutputStream fos = null;
    FileWriter fw = null;
    BufferedWriter bw = null;  //FileWriter에서 한글자씩 하던걸 BufferedWriter가 모아서 한번에 출력.

    try {
      //특정 폴더를 만들고 파일을 저장
      File folder = new File("data");
      if (!folder.isDirectory()) {
        folder.mkdir();       //'data'라는 이름의 폴더가 없을경우, 생성
      }
      File file = new File("data\\test1.txt");  //data 내부에 test1.txt 생성

      //FileOutputStream에서 사용
      //fos = new FileOutputStream(file, true);
      //file 뒤에 true를 넣으면, 붙여쓰기(append) | true를 빼면 덮어쓰기


      //FileWriter 사용
      fw = new FileWriter(file, true);
      bw = new BufferedWriter(fw);

      String str = "안녕하세요~~";

      /*FileOutputStream 사용
      문자열 -> byte 배열로 변환
      byte[] b = str.getBytes();
      byte 배열을 파일 출력
      fos.write(b);
      */

      //FileWriter사용
      //fw.write(str);

      //bufferedWriter 사용
      bw.write(str);

      //통로(스트림)에 전송되지 않은 데이터를 처리
      bw.flush();


      System.out.println("저장완료");

    } catch (FileNotFoundException fe){    //파일을 못찾았을때
      fe.printStackTrace();//오류가 없으면 넘어가고 오류가 있으면 관련 내용이 출력됨
    } catch (IOException ie) {          //파일쪽에 작성하려는데 문제가 생겼을 떄
      ie.printStackTrace();
    } finally {
      try {

       // fos.close();    //close()도 예외가 발생해서 try/catch로 감싸야한다.
        bw.close(); //BufferedWriter 사용시, BufferedWriter를 먼저 정리한 뒤, FileWriter를 정리한다.
        fw.close();     //<-fileWriter*/


      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
