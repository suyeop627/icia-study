import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling2 {
  //5

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n1 = 0, n2 = 0, result = 0;


    try {
      System.out.print("N1 : ");
      n1 = scan.nextInt();
      System.out.print("N2 : ");
      n2 = scan.nextInt();
    }catch(InputMismatchException ime){
      System.out.println("입력미스!!");
      return;
    }catch(ArithmeticException ae){
      System.out.println("0으로 나눌 수 없습니다.");
      return;
    }
    result = div(n1, n2);
    System.out.println("나눗셈 결과 : "+result);

  }
    static int div(int n1, int n2) throws ArithmeticException{ //이 매소드를 호출한 매소드에서 해당 예외를 처리해야함,
    //예외사항을 모아서 한번에 처리하기 위해서 사용함. 각 매서드마다 예외처리하는 것보다 한쪽에서만 하는게 나을 때도 있음.
      int result = 0;   //main매서드 안에 있는 result랑은 다른 변수임(지역변수개념)

      try {
        result = n1 / n2;
      }catch (ArithmeticException ae ){
        System.out.println("0으로 나눌 수 없습니다.");
      }
      return result;

  }
}
