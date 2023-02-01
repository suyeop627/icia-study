package subpackage;

public class UseClass {
  private int aaa;
  int bbb;
  public int ccc;

  void method(){
    aaa = 1; //UseClass2에서는 사용불가, UseClass에서는 사용가능
              // class 내부의 메소드에서 사용 가능.

  }

}
