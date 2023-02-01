import java.sql.SQLOutput;
//2
public class SelfInstanceClass {
  //인스턴스 멤버(static 없는거)
  int a;
  float b;
  String c;

  public static void main(String[] args) {
    //a = 100; //인스턴스 멤버는 메소드 내부에서 바로 사용할 수 없다.
    SelfInstanceClass sfc = new SelfInstanceClass();  //같은 클래스 안에서 자기 자신의 인스턴스를 만들어서 사용.
                                                      //일단 실행은 돼야하기 때문에, static안에서 (메인 안에서)사용해야함.
    sfc.a=100;
    sfc.b = 50.0f;
    sfc.c = "1000";
    sfc.add();

  }

  void add (){
    System.out.println(a+b+c);
  }
}
