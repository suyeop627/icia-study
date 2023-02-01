package sigletonpkg;

public class SingletonTest {
  //자신의 인스턴스를 저장하는 참조변수(멤버) 선언
  private static SingletonTest instance = null;      //인스턴스가 없는 상태에서, 인스턴스 주소를 저장해야하므로, static

  //생성자는 private으로 선언 - 다른 클래스에서 인스턴스를 만들지 못하도록 설정.
  private SingletonTest() {

  }

  //인스턴스를 제공하는 메소드를 정의(public으로 작성해서 메소드의 접근을 자유롭게한다)
  public static SingletonTest getInstance() {  //인스턴스가 없는 상태에서도 사용할 수 있어야해서 static
    if (instance == null) {                   //메서드 실행할때, 인스턴스 없으면
      instance = new SingletonTest();         //생성
    }
    return instance;                          //있으면 인스턴스 반환

  }
  //기타 기능 제공 메소드
  public void method1(){
    System.out.println("싱글톤이다.");
  }




}
