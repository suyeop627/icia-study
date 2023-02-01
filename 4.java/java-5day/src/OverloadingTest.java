import java.util.Scanner;

public class OverloadingTest {
  public static void main(String[] args) {
    System.out.println();       //ctrl 누르고 클릭하면 해당 클래스 볼 수 있음 - 대표적인 오버로드 메소드

    SimpleCal sc = new SimpleCal();
    int result = sc.add(10, 20);
    result = sc.add(1, 3.14f);
    float rf = sc.add(5.4f, 3.7f);
    result = sc.add(10, 20, 30);


  }
}


class SimpleCal {
  public int add(int a, int b){   //정수형만 덧셈.
    int r = a + b;
    return r;
  }

  public int add(int a, int b, int c){
    int r = a + b + c;
    return r;
  }

    /* overloading이 되지 않는 경우.
  public float add(int x, int y){ //반환형이 float이라고 해도, 매개변수의 수와 자료형이 같으면 overloading 할 수 없다.
    float r = x + y;
    return r;
  }
  */




  public int add(int a, float b){     //매개변수의 자료형이 하나라도 다르면, overloading 할 수 있다.
    float r = a+b;
    return(int)r;
  }


  public float add(float a, float b){ //실수 덧셈
    float r = a + b;
    return r;
  }





}
