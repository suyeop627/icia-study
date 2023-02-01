public class ConstructorTest {
  public static void main(String[] args) {
    Car c1 = new Car(); //'Car()'부분이 기본 생성자.1*
  //  c1.setColor("white");//white값을 가진 인스턴스가 만들어진건 아니지만, 만들자마자 color에 white값을 입력하는 형태.

//->2)생성자 사용에서 만든거로 생성해보면,
    // Car c1 = new Car("white");2*



    //overloading으로 생성한 Car
    Car c2 = new Car("white");
    Car c3 = new Car( "black", "auto");
    Car c4 = new Car ("white", "auto", 4);


    Car c5 = new Car(null, "manual");   //color는 값을 주지 않고, 기어타입만 값을 넣을 경우, null값을 줄 수도 있다.
    Car c6 = new Car(null, null, 5);//문자열이라서 null을 넣은 거임. 자료형이나 상황에 따라 초기화 할것.

    Car c7 = new Car(3);    //유일한 int type의 매개변수로 식별 가능함.


    //지역변수
    //int a;    초기화 안돼있음
    int a = 0;
    System.out.println(a);

    c1.printAll();

  }


}

class Car {     //getter와 setter를 사용하고, 클래스내 선언 변수는 private로! -> 맞는지 확인.
  private String color;
  private String gearType;
  private int door;
  // public Car();              ->생성자가 없는 클래스에는 자동으로 기본 생성자를 컴파일러가 작성하여 처리한다.


  //필드에 값 입력 방법
  //1)setter 사용
  public void setColor(String color) {
    this.color = color;
  }

  //2)생성자 사용
  public Car(String color) {   //생성할 때 color를 입력하도록.
    this.color = color;
  }//개발자가 어떤 생성자를 작성하는 순간 컴파일러는 기본 생성자를 작성해주지 않는다.->처음에 선언했던  Car c1 = new Car();에 에러 발생

  public Car() {
  }

  ;
  //위에 1*과 2*의 방법을 모두 사용하고 싶으면, 기본 생성자를 새로 선언해줘야함.
  //생성자도 메소드이므로, 동일한 이름의 생성자 사용 가능.(overloading의 조건을 만족할 경우에만 )

  public Car(String color, String gearType) {
    this.color = color;
    this.gearType = gearType;
  }

  public Car(String color, String gearType, int door) {
    this.color = color;
    this.gearType = gearType;
    this.door = door;
  }

  public Car (int door){      //매개변수는 하나지만, 자료형 int 로, 다른 생성자와 다르다. 특정할 수 있으므로 overloading 가능.
    this.door=door;
  }
  /*
  public Car (String gearType){       //위에 String color랑 매개변수 타입과 개수가 같으므로 생성 불가.
    this.gearType = gearType;
  }

*/


  public void printAll(){
    System.out.println(color);
    System.out.println(gearType);
    System.out.println(door);

  }
}

