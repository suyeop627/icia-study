package filetest;

import java.io.File;
import java.util.Scanner;

public class FolderTest {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    while(true){
      System.out.println("---------------------");
      System.out.println("1.폴더생성");
      System.out.println("2.폴더 정보 보기");
      System.out.println("3.폴더 이름 변경 ");
      System.out.println("4.폴더 경로 변경");
      System.out.println("5.폴더 삭제");
      System.out.print("입력>");

      int menu = scan.nextInt();

      if(menu ==0){
        return;
      }
      switch(menu){
        case 1 :
          //폴더 생성
          makeFoler();
          break;
        case 2 :
          //폴더 정보 보기
          folderInfo();
          break;
        case 3 :
          //폴더 이름 변경
          changeNameOfFolder();
          break;
        case 4 :
          //폴더 경로 변경
          moveFolder();
          break;
        case 5 :
        //폴더 삭제
        deleteFolder();
        break;


      }
    }







  }
  //폴더 생성
  private static void makeFoler() {
    String path = "testfolder"; //만들 폴더 이름

    File folder = new File(path);

    if (!folder.isDirectory()) {    //folder가 같은 이름의 폴더가 있는지?(동명의 파일이 있더라도 폴더만 확인), forder라는 폴더가 존재하는지 확인.(folder가 파일이어도 괜찮고, 없어도 괜찮다.)
      if (folder.mkdir()) {       //폴더 생성 메소드   - 서버 관련해서 사용할 거임. 이쪽 부분 복습 확실히 할 것.
        System.out.println("생성 성공");
        System.out.println("---------------------");
      } else {
        System.out.println("생성 실패");
        System.out.println("---------------------");
      }
    }//if end
    else {
      System.out.println("폴더 존재함.");
      System.out.println("---------------------");
    }
  }//makeFolder end
  //폴더 정보 보기
  private static void folderInfo() {
    String path = "testfolder";

    File folder = new File(path);
    if (folder.exists()) {
      //폴더 내부에 저장된 파일 목록 가져오기 : listFiles();
      File[] list = folder.listFiles();     //File 타입의 배열을 만들어서 각 파일들을 배열에 저장

      //파일명만 출력
      for (File f : list) {
        if (f.isFile()) {
          System.out.println(f.getName() + " <- 파일");
        } else {       //else문 미작성 시, 파일명만 가져올 수도 있음
          System.out.println(f.getName() + "<- 폴더");
        }
      }
    }        System.out.println("---------------------");
  }
  //폴더 이름 변경
  private static void changeNameOfFolder() {
    //폴더 이름 변경
    String name = "testfolder";
    File folder = new File(name);

    String name2 = "testfolder2";
    File folder1 = new File(name2);


    boolean rb = folder.renameTo(folder1);
    if(rb){
      System.out.println("변경 성공");
      System.out.println("---------------------");
    }
    else{
   System.out.println("변경 실패");
      System.out.println("---------------------");
    }


  }
  //폴더 경로 변경
  private static void moveFolder() {
    //폴더 이동
    String path = "testfolder";
    File  folder= new File(path);
    File folder2 = new File("target\\" + path);
    boolean rb2 = folder.renameTo(folder2);
    if(rb2){
      System.out.println("이동 성공");
      System.out.println("---------------------");
    }
    else {
      System.out.println("이동 실패");
      System.out.println("---------------------");
    }

  }
  //폴더 삭제


  private static void deleteFolder() {      //폴더는 내부에 파일이 있으면 삭제 불가능. testfolder\\subfolder 내부에도 파일이 있다면, subfolder와 testfolder의 내부 파일을 모두 지워야 하는 식
    String path = "testfolder";
    File folder = new File(path);
    if(folder.exists()){
      //폴더 내부의 파일 및 폴더 삭제(선행되어야 한다)
      File[] list = folder.listFiles();
      for(File f : list){
        f.delete();   //내부 파일과 폴더 삭제
      }
      //최종 목적 폴더 삭제
      if(folder.delete()){
        System.out.println("삭제 성공");
      }
      else {
        System.out.println("삭제 실패");

      }
      System.out.println("---------------------");
    }//if end
    else{
      System.out.println("폴더 없음");
      System.out.println("---------------------");
    }        System.out.println("---------------------");
  }//deleteFolder end









}//class end
