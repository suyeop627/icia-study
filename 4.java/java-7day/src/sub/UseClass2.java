package sub;

import basic.Parent1;

public class UseClass2 {
  Parent1 p2 = new Parent1();

  void method3(){
    //다른패키지 내부의 클래스에서 선언된 변수 사용 가능 여부
    p2.a = 1000;    //public
    //p2.b = 2000;  //protected
    //p3.c = 3000;  //default
    //p4.d = 4000;  //private
  }
}
