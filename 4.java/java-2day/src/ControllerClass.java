import java.util.Scanner;
//메인 메서드가 없어서 바로 실행할 수는 없음. 메인 클레스에서 controllerClass를 불러와야함.
public class ControllerClass {
    //프로그램의 모든 부분을 처리하는 instance를 설계해 놓은 class
    //타이틀 : 관리 프로그램
    //메뉴 : 1. 입력, 2. 출력, 0. 종료

    public void run(){
        String menu; //메뉴 번호 저장 변수
        //입력객체(Scanner)준비
        Scanner scan = new Scanner(System.in);

        System.out.println("★★관리프로그램★★");
        System.out.println("================");
        //종료메뉴를 입력받을 때까지 프로그램이 계속 실행항태를 유지해야하므로, 무한루프가 사용된다.
        //메뉴 출력부터 종료까지 무한 반복
        //for(;;){ 실행문 } for문을 사용한 무한루프


        //while문을 사용한 무한루프
        while(true){
            System.out.println("1. 입력");
            System.out.println("2. 출력");
            System.out.println("0. 종료"); //메뉴가 추가/제거 될 경우 종료버튼 숫자를 바꿔야하므로, 0이나 99처럼 정해놓음
            System.out.print(("입력>"));//줄바꿈 일어나지 않도록, print 사용
            //메뉴 번호 받기
            menu = scan.nextLine();

            //종료 처리
            if(menu.equals("0")){//사용자가 "0"을 입력함.
                //while문을 사용중이므로 break;을 사용할 수 있음
                //return;으로 종료할 수도 있음
                System.out.println("프로그램 종료");
                break;
            }

            //나머지 메뉴 및 잘못 입력한 값 처리

            switch(menu){
                case "1":
                    System.out.println("입력을 실행합니다.");
                    break;
                case "2":
                    System.out.println("출력을 실행합니다.");
                    break;

                default :
                    System.out.println("잘못 입력하셨습니다.");
                    break;
            }//switch end
        }//while end
    }//run end
}//class end
