public class MethodTest {
  //1


  //인스턴스 멤버변수 - 인스턴스가 있어야 존재하는 변수 (설계도상에 이런게 있다 정도만 적어놓은 거고, 인스턴스가 있어야 실제하게됨)
  //int a;
  static int a; //static member 변수 (클래스 변수) - 전역변수
  float b;
  String c;
//+) method area에 스태틱 맴버 변수(=클래스변수) / call stack에 지역변수 / heap에 인스턴스 변수('필드'라고도 함)가 저장됨
  public static <add> void main(String[] args) {
    //자바 프로그램의 실행 시작 메소드
    //+)프로그램은 운영체제가 실행한다.
    //메인메소드가 없으면 자바 실행이 안된다.
    //public - 접근 제어자 <-> private
    //static - instance 생성 없이 사용 가능하다.
    //인스턴스는 프로그램이 실행되어야 생성됨. 인스턴스가 실행 없이 만들어 질 수 있게?
    //운영체제랑 관련해서 뭔가 있는듯 - 더 찾아서 정리
    //인스턴스가 있어야 프로그램을 실행할 수 있는데, 인스턴스 생성 없이 프로그램을 실행시킬 수 있게 하는게 static member
    //객체 안에 작성하는걸 member라고함. (매소드 맴버, 변수맴버)

    //void - 반환값이 없다. return을 사용하지 않음. (할 수도 있음 - 중단하는 의미로는 사용할 수 있음.)
    //main - 고정된 이름.
    //String[] args - 프로그램 시작 시 옵션값을 저장하는 배열

    System.out.println(args[0]);
    System.out.println(args[1]);
    System.out.println(args[2]);

  //  int a = 100;    //this는 클래스를 지칭함. 외부에 적은 변수와 내부에 적은 변수의 이름이 같을 수 있지만 가까운걸 불러옴.
                    //내부에 있는걸 사용하기 위헤서 this.a의 형식으로 작성할 수 있는데, this는 해당 클래스를 지칭한다.
  method1();  //static이 작성된 메소드 안에서는 static이 작성된 메소드만 사용할 수 있다.
 // a = 10000;
   // a = 10000; 메인이 인스턴스 없이 동작하는데, a는 인스턴스가 있어야 동작하므로, a= 10000;은 에러발생
    //위에 int a;선언한 거를 static int a; 로 선언하면 에러 없어짐.


  }//main end

  //static이 붙는 멤버(변수, 메소드 모두)는 static이 붙은 멤버만 사용할 수 있다.
  //static이 작성된 거는 인스턴스 생성없이 사용가능하다 > static이 없으면 인스턴스가 생성돼야한다.
  //static은 설계도 안에서만 뭐를 하는거고 static이 없는건 실물(인스턴스)로 뭔가 하는건데, 실물은 실물이 있어야 상호작용 가능하고,
  //설계도는 설계도끼리 상호작용할 수 있다?
  //static이 작성된거 안에서 static이 없는걸 사용하려면 new생성자 사용해서 실체를 만들고나서 해야한다.

  //void를 사용하는 메소드 작성
  static void method1(){
    System.out.println("return 없는 메소드 실행");
    add();//메소드 호출
  }


/*
  int add(){
  return 0; //반환형을 지정할 경우, 그에 해당하는 값을 return하는 문장이 있어야하는데, void는 return을 하지 않으므로
    해당 문장을 작성할 필요가 없다.
}*/
  //메소드를 실행하려면, 다른 메소드 안에서 호출해야한다.
static int add(){
  System.out.println("return 있는 메소드 실행");
  return 100;
}

}//class end
