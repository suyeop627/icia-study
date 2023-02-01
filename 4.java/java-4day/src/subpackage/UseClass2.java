package subpackage;

public class UseClass2 {
  void method1(){
    UseClass uc = new UseClass();
    uc.ccc=100; //public 접근제어.
    uc.bbb=200; //default 접근제어. 같은 패키지 사용 가능
    //uc.aaa=300; //private 접근제어 사용불가
  }
}
