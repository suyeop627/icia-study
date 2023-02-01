package basic;

public class UseClass1 {
  Parent1 p = new Parent1();
  void method2(){
    //같은 패키지 안에서 다른 클래스의 변수 사용 가능 여부
    p.a = 100;  //public
    p.b = 200;  //protected
    p.c = 300;  //default
    //p.d = 400;  //private   사용 불가.
  }

}
