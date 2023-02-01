package sbtest;
//1

import java.io.File;

public class StringBufferTest {
  public static void main(String[] args) {
    //기본 생성법(16칸의 공간을 형성)
    StringBuffer sb1 = new StringBuffer();
    //System.out.println(sb1.capacity());   //출력값 : 16
    //원하는 크기로 생성
    StringBuffer sb2 = new StringBuffer(100); //100byte의 Stringbuffer 생성
    //System.out.println(sb2.capacity()); //capacity이상의 문자열을 append를 사용한다면, 자동으로 byte가 늘어난다.
    sb1.append("abcdefghijklmnopqrstuvwxyz"); //16칸에 26자 입력
    //System.out.println(sb1.capacity()); //출력값 : 36 - 처음 16이었던 공간이 자동으로 늘어나며, 여유공간도 함께 추가된다.

    StringBuffer sb3 = new StringBuffer("abcd");
  //  System.out.println(sb3.capacity());//크기  - 출력값 : 20
    //System.out.println(sb3.length());//문자열의 길이 - 출력값 : 4


  //  System.out.println(sb1);
    StringBuffer sb4 = sb1.delete(2, 6);  //sb1에서 inx 2~5까지의 값을 제거(2~(6-1))(이경우, c,d,e,f, 제거)
 //System.out.println(sb4);
 //System.out.println(sb1);            //원본의 값도 같이 지워진다.


    sb4.insert(5, "와"); //index 5 위치에 "와" 삽입
    System.out.println(sb4);
    sb4.replace(6, 10, "오~~~~~~");//지울 문자와 넣을 문자의 길이가 같지 않아도 상관 없다.
    System.out.println(sb4);

    sb1.reverse();
    System.out.println(sb1);    //위에 sb4에 delete, insert, replace를 적용했던 것들이 sb1에도 적용돼있다.
                                // shallow copy. - 값을 다른 저장공간에 복사해서 처리하는 게 아니라, 위치정보가 복사돼어 두 변수에 저장되므로, 실제 저장공간을 공유하는 형태이다.
                              //문자열이나 문자열 버퍼는 일반적인 대입으로는 값을 복사해서 저장공간을 나눌 수 없고, 하나의 저장공간의 참조주소가 복사돼서 각 변수에 저장되는 형태.


    //최종적으로 문자열로 변환
    String s = sb1.toString();    //StringBuffer sb1에 저장된 문자열을 String s에 저장
                                //비유 - 퍼즐 다 맞추고, 완성된 퍼즐을 고정시키고 액자에 보관.


















  }

}
