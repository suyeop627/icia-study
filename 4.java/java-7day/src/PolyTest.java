public class PolyTest {
  public static void main(String[] args) {
    ChildClass1 ch5 = new ChildClass1();
    ChildClass2 ch6 = new ChildClass2();


    //up casting
    PrentClass p5 = ch5;  //자식 클래스의 참조변수를 부모 클래스의 참조변수에 저장
    PrentClass p6 = ch6;

    p5.a = 10;
    p5.b = 20;
    //p5.c - 30; - 자식클래스에서 선언된 멤버는 사용불가

    //down casting
    ChildClass1 cc5 = (ChildClass1) p5; //부모클래스의 참조변수를 자식 클래스의 참조변수에 저장(형변환 필수)
    ChildClass2 cc6 = (ChildClass2) p6;


    //PrentClass  p = new ChildClass1();
    PrentClass  p = new ChildClass2();

    if (p instanceof ChildClass1) {     //자손이 맞은지 틀린지 검증 가능
      ChildClass1 cc7 = (ChildClass1) p;
      System.out.println("ChildClass1로 만든 인스턴스임");
      cc7.c = 300; //자식 인스턴스로 다운캐스팅
      System.out.println(cc7.c);
    } else {
      ChildClass2 cc8 = (ChildClass2) p;
      System.out.println("ChildClass2로 만든 인스턴스임");
      cc8.d = 400;
      System.out.println(cc8.d);
    }
  }
}

class PrentClass {
  int a;
  int b;

}

class ChildClass1 extends PrentClass {
  int c;
}

class ChildClass2 extends PrentClass {
  int d;
}

