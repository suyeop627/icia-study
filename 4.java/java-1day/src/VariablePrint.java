import java.util.Scanner;

public class VariablePrint {
    public static void main(String[] args) {
        //변수에 데이터 대입
        int number1 = 0;//변수의 선언 및 초기화
        //매소드 내부에 변수를 만들 경우 초기화를 하는 것이 좋다.
        number1 = 350; //임의의 값을 대입
        //'=' : 대입연산자.우변의 값(또는 변수, 수식의 결과)을 좌변의 변수에 입력.
        int number2 = number1; //변수를 넣거나

        number2= number1 + 250;//수식을 넣을 수 있음
        boolean b = (number1 == number2);
        boolean b2 = b;
        //b2 = number1;  //다른 타입의 변수로 대입 불가
        //형변환(Type Casting) - 다른 타입으로 변환

        ////////////////////////////////////////////
        //일반적으로 많이 사용하는 출력문
        System.out.println(number1); //변수의 값 출력
        System.out.println("안녕하세요~"); //문자열 출력
        System.out.println(b);
        System.out.println('a');
        ///////////////////////////////////////////
        //출력문은 3가지 형태가 있다.
        //1. println : 출력 후 다음 라인으로 커서를 이동
        //2. print : 출력 후 현 위치를 유지
        System.out.print("첫 번째 print 출력.");
        System.out.print("두 번째 print 출력.");
        System.out.println();//라인만 바꿔주는 용도로, println()을 사용하기도 함
        Scanner scan = new Scanner(System.in);
        // System.out.print("입력> ");  //입력> abc
        // System.out.println("입력> ");//입력> 줄바꿈 후 입력 받아짐
        //String input = scan.nextLine();

        for(int i=1; i<=31; i++){
            //System.out.println(i + " ");
            System.out.print("\t"+i);       //\t : 탭
            if(i%7 ==0){
                System.out.println();
            }
        }
        System.out.println();
        ////////////////////////////////
        //3. printf("형식지정", 변수들);

        System.out.printf("number2의 값은 %d입니다.\n", number2);
        //print처럼 줄바꿈을 하지 않는다.
        //'\n\'은 줄바꿈을 표현하는 특수 문자.
        //서식지정자 : '%' 와 조합하여 사용하는 문자.
        //1. %d : 정수 변수의 값을 출력할 때 사용 '%5d'로 작성할 경우, 5칸만큼 공간을 잡고 출력함. %와 d사이에 숫자

        float fnum = 3.14f;
        System.out.printf("파이는 %f이다.\n", fnum); //소수는 소수점 아래 6자리가 기본으로 출력됨
        //3. %c : 문자 변수의 값을 출력할 때 사용
        //4. %s : 문자열 변수의 값을 출력할 때 사용

        char ch = 'A';
        String str = "Hello";
        System.out.printf("문자는 %c이고, 문자열은 %s입니다.", ch, str);//변수 여러개를 넣을땐 순서에 맞게 작성
        System.out.println("문자는 " + ch + "이고, 문자열은 " + str + "입니다.");
        }
}
//가입화면? -> 정보 받아서 변수에 저장. 나중에 모아서 출력하기