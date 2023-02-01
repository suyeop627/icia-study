public class AbstractTest {
  public static void main(String[] args) {
    //Animal a = new Animal();
    // cannot be instantiated 에러 발생 - 추상클래스는 인스턴스 생성 불가.

    Cat c = new Cat(); //정상적으로 인스턴스 생성 가능.


    // TestInterface.d = 1000;  - int d= 40; 제어자 없이 작성했지만,
    // public static final이 생략된 형태로, 접근 제어자의 속성을 모두 갖는다.
    // 가져다 쓸 순 있지만(static), 값을 변경할 순 없다.(final)

    //TestInterface b = new TestInterface() ;  인스턴스 생성하려고 하면, 추가해야할 메소드들 확인할 수 있음. 상속받아서 재정의 후 사용해야한다.

    System.out.println(TestInterface.d);  //값을 가져올 수 는 있다.


    InterClass ic = new InterClass();
    TestInterface tf = ic;    //다형성 취급이 가능함.

  }
}


abstract class Animal {
  String name;
  int age;
  String gender;
  abstract void howl();    //동물은 울긴 하는데, 어떻게 우는지는 종마다 달라서 여기서 정의하기 어려움
                            //오버라이딩 필요.
  void eat()
  {
    System.out.println("먹는다");
  }
}

//class Cat extends Animal{}  Animal 클래스를 상속받을 때,
// 추상메서드를 다시 추상화하거나 재정의 해야한다는 에러 발생.
//하위 클래스로 다시 넘길 수도 있고, 여기서 정의할 수 있음
//에러에서 implement method 클릭 -> ok -> howl에 대해 재정의 하는 코드 생성


class Cat extends Animal{

  @Override
  void howl() {
    System.out.println("야옹~");
  }
}



interface TestInterface {
  //아래 선언된 모든 멤버변수는 상수다.
  public static final int a = 0;      //상수는 반드시 초기화 필요.
  final int b = 20;                   //public static 생략가능
  static int c = 30;                  //public, final 생략가능
  int d = 40;                         //제어자 모두 생략.


  //public abstract void method1(){} - 에러발생 : 구현부를 가질 수 없다.
 // public void method2(){};    - 에러 발생 : abstract 가 생략된 형태이므로, 구현부를 가질 수 없다.
  void method();            //-OK
  public abstract void method1();
  public void method2();
}

class InterClass implements TestInterface {
  @Override
  public void method() {

  }

  @Override
  public void method1() {

  }

  @Override
  public void method2() {

  }

}










