import com.dto.PhoneInfo;

public class ThisConstructorTest {
  public static void main(String[] args) {
   // Car c1 = new Car(); //기본생성
    Car c1 = new Car("white");


    //setter 대신 생성자를 사용해서 정보 입력.
    String str = "홍길동";

    PhoneInfo p = new PhoneInfo("str",
        "010-0000-0000",
        "05-04", 12);


  }
}


class Car {
  private String color;
  private String gearType;
  private int door;

  //기본 생성자
  public Car(){}      //생성자를 만들지 않으면, 컴파일러가 생성자를 만들어서 실행하지만, 생성자를 만들면, 컴파일러는 생성자를 만들지 않는다.


  public Car(String color){
  //  this.color = color;   //지역변수 color와 구분하기 위해 this.color로 사용.
                          //this를 사용하지 않아도, 지역변수의 명칭을 다르게 작성할 순 있지만, ide의 자동완성 기능을 활용하는데 제약이 생긴다.


  //  this(color, null);

  }

  public Car(String color, String gearType){
   // this.color=color;
    //this.gearType=gearType;
    this(color, gearType, 0);
  }

  public Car(String color, String gearType, int door){
    this.color=color;
    this.gearType = gearType;
    this.door=door;
  }

  public void constrCall() {      //constructor body의 첫번재 줄에서만 사용 가능
    //this("white")   this()생성자는 인스턴스가 생성될 때만 사용가능하다
                      //인스턴스가 생성되고 나서 this()메소드를 사용할 수 없음.


  }

}