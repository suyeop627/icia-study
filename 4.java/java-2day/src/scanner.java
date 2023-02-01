import java.util.Scanner;

public class scanner {
  public static void main(String[] args) {
    //scan instance 생성
    Scanner scan = new Scanner(System.in);

    //정수 입력 int 값
    System.out.print("정수입력 : ");//입력한 값이 화면에 먼저 출력되는 거 : 에코(echo)
    int i = scan.nextInt();         //정수 이외의 값을 입력받으면 에러
    System.out.println(("입력받은 정수 값 : " + i));
//
//    //실수 입력 float 값
//    System.out.print("실수 입력 : ");       //float은 정수값 입력받아도 저장은 1.0으로 저장됨
//    float f = scan.nextFloat();
//    System.out.println("입력받은 실수 값 : " + f);

    //문자열 입력
    System.out.println("문자열 입력 : ");
    String str = scan.nextLine();
    System.out.println("입력받은 문자열 값 : " + str);      //Scanner의 오류 발생





  }
}
