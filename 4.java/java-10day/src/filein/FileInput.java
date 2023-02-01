package filein;

import java.io.*;

public class FileInput {//2
  public static void main(String[] args) {
   /* FileInputStream fis = null;*/
    FileReader fr = null;
    BufferedReader br = null; //try-catch문을 여러개 사용하므로 전역변수로 선언
    try{
      File file = new File("data\\test.txt");//파일관련 작업을 할땐, 메모리에 파일 객체가 로드되어 있어야 한다.
                                                      //파일이든 폴더든 있어야 입력받을 수 있다.(데이터 가져오기)
      /*  fis = new FileInputStream(file);//FileInputStream은 byte단위로 읽어온다.(알파벳은 파일에 저장할때 1바이트로 저장. 한글은 3바이트로 저장(0~255의 바이트가 3개). input stream은 1바이트씩만 읽어올 수 있다.(저번엔 바이트 배열로 처리함)
      int i = 0;  //읽어올 데이터(byte 단위)

      //read(): inputStream의 메서드. byte 단위로 읽어오는 메소드.
      //읽어온 내용이 없으면, -1을 반환한다.
      //for문을 사용해서 한 바이트씩 반복해서 읽어옴. (Writer는 알아서 반복 수행 후 읽어오지만,read()는 반복문을 작성해서 사용해야 한다.

      while((i = fis.read())!=-1){  //더이상 읽어올 데이터가 없으면 i에 -1이 들어가는데, i=-1과 -1이 같지 않을때, (조건문 false일때) while종료
        //System.out.print(i); 바이트 단위로 출력된다.(0~255의 숫자)
        System.out.write(i);  //byte를 문자로 변환후 출력해주는 메서드.
      }*/




      fr = new FileReader(file);  //글자를 읽어오는 건 일단 FileReader가 하고, 모아서처리하는걸 bufferedReader가 한다.
      br = new BufferedReader(fr);

      /* br사용시 사용 안하는 구간.(문자로 처리되므로 굳이 필요가 ㅇ벗다.)
      int i = 0;
      while((i=fr.read())!=-1){       //read()가 반환하는 값은 숫자.
        System.out.println((char)i);  //fis는 한 바이트단위로만 잘라서 숫자로 올라왔는데, fileReader는 세개의 byte가 조합돼있는 숫자로 출력되므로 변환만 시키면 됨.
      }
    */





      //bufferedReader 사용시
      String str = null;
      while((str = br.readLine())!=null) {      //readLine() : Line 단위로 데이터를 반환한다. 파일에 더이상 읽을 데이터가 없으면 null값을 반환한다.
        System.out.println(str);

      }



    }catch(Exception e){
      e.printStackTrace();
    }finally{
      try {
       /* fis.close();*/
        br.close();   //선언 순서에 역순으로 제거.(fr선언 br선언 -> br제거 fr제거)
        fr.close();
      } catch (IOException e) {      //딱히 처리할 수 있는게 없어서 비워놓는 경우도 종종있다. 단지 예외 회피를 위한 목적.
      }
    }
  }//main end
}//class end
