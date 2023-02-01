package basic;

public class Parent1 {

  public int a;
  protected int b;
  int c;  //default
  private int d;


  void method() {
    //같은 클래스 안에서는 접근제어자에 상관없이 사용 가능.
    a = 10;
    b = 20;
    c = 30;
    d = 40;
  }
}
