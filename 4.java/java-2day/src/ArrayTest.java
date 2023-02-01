import java.util.Scanner;

public class ArrayTest {
  public static void main(String[] args) {
    //배열 선언
    int intArray[]; //    int[] intArray; 이렇게 선언할 수도 있다.

    //배열 생성
    intArray = new int[10];

    //배열 사용
    intArray[0] = 10;

    //System.out.println(intArray[0]);

    //intArray[10]  =200 // 배열의 크기를 10으로 잡아서, 배열의 index는 0~9까지 존재함.=>에러
    intArray[9] =200;

    String strArray[] = new String[5];
    strArray[0] = "abc";

    String fruits[] = {"apple", "banana", "pear"};
    //System.out.println(fruits[1]);


    //학생 수만틈 성적을 저장하는 배열을 만드시오.
    Scanner scan = new Scanner(System.in);
    System.out.print("학생 수 :" );
    int num = scan.nextInt();   //입력받은 값 num에 저장

    int score[] = new int[num]; //num만큼의 길이를 가진 배열 생성

    for(int i = 0; i<score.length; i++){
      System.out.println((i+1) + "번 학생 점수 : ");
      score[i] = scan.nextInt();
    }
    int sum=0;
    for (int j = 0; j<score.length;j++){
      sum += score[j];
    }
    System.out.println("총점 : " + sum);

  }
}
