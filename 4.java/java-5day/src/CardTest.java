public class CardTest {
  public static void main(String[] args) {
    Etc.cv = 100;//1
    //Etc.iv = 200;   //사용 불가.
    Etc e1 = new Etc();//새 인스턴스를 만들면 그 함수 안에 있던 static 사용 가능해짐
    e1.iv = 200;
    Etc e2 = new Etc();
    e2.iv = 300;

    e1.cv = 500;  //2  //1~3 의 cv는 모든 인스턴스가 공유하는 공간.
    e2.cv = 1000; //3

    System.out.println(Etc.cv);
    System.out.println(e1.iv);
    System.out.println(e2.iv);




    ///////////////////////////////////////
    Card c1 = new Card();
    c1.kind = "하트";
    c1.number = 7;
    Card c2 = new Card();
    c2.kind = "스페이드" ;
    c2.number = 3;
    Card.width = 50;  //1
    c2.height = 80;   //2 1~2중 어떻게 수정하든 아래의 출력문은 두개가 다 수정됨.

    System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" +c1.width + ", " + c1.height + ")");
    System.out.println("c1은 " + c2.kind + ", " + c2.number + "이며, 크기는 ("+ c2.width + ", " + c2.height + ")");

  }
}


class Etc{
  int iv;   //인스턴스 변수
  static int cv;  //스태틱 변수, 클래스 변수

  final int MAX = 100;   //변수에 final을 붙이면, 더이상 값 변경이 불가하므로 초기화를 꼭 해줘야 한다.
                        // 상수일 경우엔 대문자로 적는다.




  static void method1() {
    //iv = 10000;
    // 에러 발생 - 인스턴스가 있으면 iv에 접근할 수 있지만,
    // 인스턴스가 생성 될지 안될지는 확신할 수 없어서 아예 static안에서 static이 아닌 것은 사용하지 못하게 막아놓음.

    cv = 50000; //사용 가능. => static이 붙은 메소드 안에서는 static이 붙은 변수만 사용할 수 있다.
  }

  void method2() {
    iv = 20000;
    cv = 70000; //iv와 cv둘다 이상 없이 사용 가능
    //MAX = 200;// Cannot assign a value to final variable 'max'

  }
}


class Card {
  //카드의 모양 : 하트, 다이아몬드, 스페이드, 클로버
  //카드별 숫자 : 1~13
  //인스턴스 변수
  String kind;
  int number;

  //카드의 크기(가로/세로)는 모두 동일해야한다.
  //스태틱 (클래스)변수 사용 - 초기화도 함께 처리
  static int width = 100;
  static int height = 250;

}