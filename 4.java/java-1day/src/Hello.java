//library
import java.util.Scanner;

public class Hello {
    //메인 메소드
    public static void main(String[] args) {
        //화면에 문장을 출력 :
        System.out.println("Hello world!");
        System.out.println("안녕하세요");
        //키보드로 값 입력 :
        Scanner scan = new Scanner(System.in);  //scan - instance / scanner - object
        int num = scan.nextInt();  //모든 것을 객체로 만들어서 작업하는데, scannner 객체에 값을 받아오라는 명령
        System.out.println("입력 받은 값 : " + num); //값을 입력받아야 실행됨. //콘솔프로그램 ..?

        Car mycar = new Car();
        mycar.model = "소나타";
        mycar.company = "현대";
        mycar.tier=4;
        mycar.color = "검정색";
        mycar.exel(100);
        mycar.stop();
    }//main end
}//class end
