import java.util.Scanner;
//4

public class ExceptionHandling {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = null;
    int n1 = 0, n2=0, result = 0;   //이렇게도 선언할 수 있나봄


    try {
      System.out.print("Number1 : ");
      s = scan.nextLine();
      n1 = Integer.parseInt(s);
      System.out.print("Number2 : ");
      s = scan.nextLine();
      n2 = Integer.parseInt(s);

      result = n1 / n2;
      //}catch(Exception e){
      // System.out.println("예외사항이 발생되었습니다.");
      // 0으로 나눴을때 에러랑 문자를 입력했을때의 에러가 발생했을 때를 하나로 퉁침
      //무슨 에러인지 명확하게 알 수는 없다.
    }catch(NumberFormatException nfe){
      System.out.println("숫자를 입력하세요.");//문자 입력 처리
    } catch (ArithmeticException ae){
      System.out.println("0으로 나눌 수 없습니다.");//0으로 나눈 거 처리
    } catch (Exception e){
      System.out.println("예외사항이 발생했습니다.");//나머지 예외사항 처리
    } //만약, Exception 을 가장 위에 작성하면, 아래에 있는 모든 예외사항들을 포괄해버림. =>개별적인 예외처리를 먼저하고 포괄처리는 마지막에.
    //switch case 문 작성할 때처럼, 각 case 별 실행문 작성하고 마지막에 default작성하듯이 작성한다.
    finally {//예외사항의 유무를 떠나서 반드시 실행되어야 하는 문장 작성
      System.out.println("이 문장은 항상 나옵니다.");
    }

    System.out.println(result);

    //파일이나 프로그램을 실행하면 메모리에 올려서 읽는다.
    //프로그램이 종료된 후, 메모리에 남기지 않고 다 지워져야하는데 남을 수도 있음
    //메모리에 남은거 : 가비지 / 치워주는거 : 가비지 컬렉터
    //사용자가 메모리에 쌓인 가비지를 지우지 않으면, 메모리에 사용하지 못하는 공간이 생긴다.=>메모리 릭
    //메모리 릭을 방지하기 위해서,  finally에서 메모리를 청소하는 작업을 시행해줌


  }
}
