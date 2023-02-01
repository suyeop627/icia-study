public class PointTest {
  public static void main(String[] args) {

    Point p1 = new Point();
    Point3d p31 = new Point3d();
    p1.x = 10;
    p1.y = 20;
    p1.color = "red";

    p1.showPoint();               //출력값 - x : 10, y : 20, color : red
    System.out.println(p1);       //출력값 - x: 10, y: 20

    //p1.z = 40; 자손의 멤버는 사용불가
    p31.x = 30;
    p31.y = 50;
    p31.z = 25;

    p31.color = "blue";
    p31.showPoint();            //출력값 - x : 30, y : 50 z : 25,+color : blue
    System.out.println(p31);    //출력값 -  x: 30, y: 50 , z : 25

    p1.pattern = "물결";
    System.out.println(p1.pattern);   //출력값 - 물결
    System.out.println(p31.pattern);    //출력값 - null    ->부모클래스의 String pattern = "어떤모양";은 들어가지 않았다. =>메소드는 정의가 되지만, 변수는 재정의가 되지 않는다.
    p31.pattern = "구름";
    System.out.println(p31.pattern);    //출력값 - 구름
    p31.showPattern();    //출력값 - 부모의 pattern : 어떤 모양
                          //출력값 - pattern : 구름

  }
}

  class Point {  //2D 그래프용 점 객체(x,y 좌표에 점을 찍음)
    int x;
    int y;
    String color;
    String pattern = "어떤 모양";

    public Point(){}
    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }


    //상속을 하지 않고, Point에 int x;를 추가할 경우, 기존에 Point 클래스를 사용하던 것과 호환성 문제가 발생함.
    void showPoint(){
      System.out.println("x : " + x + ", y : " + y
          + ", color : " + color);

    }
    @Override
    public String toString() {
      return "x: " + x + ", y: " + y;
    }
  }
  /*
  class Point3d {  //상속을 받지 않고 작성할 경우,
    int x;
    int y;
    int z;
    String color;
  }
  */

  class Point3d extends Point {      //상속받아서 작성할 경우,
    int z;
    String pattern;     //부모클래스의 변수와 같은 이름이지만, 부모클래스의 pattern과는 다른변수이다. 부모변수의 pattern은 숨겨지고 자손요소의 pattern만 사용가능한 상태.


    public Point3d(){
      // super();      //기본생성자는 부모클래스의 생성자를 호출하도록 돼있는데, 생략 가능하다.
    }


    public Point3d(int x, int y, int z){
      super(x,y);   //x와 y는 부모클래스에서 초기화.  ->이때, super()는 맨 첫줄에 위치 해야한다.
      this.z = z;    //부모클래스에 없는 변수만 처리.

      //this는 맴버 변수/지역변수를 구분하는 용도
      //super는 부모클래스의 멤버변수와 자식클래스의 멤버변수를 구분하는 용도(이름이 같을경우)
      //super() 자식클래스의 생성자 안에서 자식클래스의 생성자를 호출할 때 사용
      //this()는 생성자 안에서 다른 생성자를 호출할 때 사용.

    }
    @Override
      //Annotation(어노테이션) - 없어도 동작은 하지만, 더 명확하게 알려주기 위해 작성한다.
    void showPoint() {
      System.out.println("x : " + x + ", y : " + y + ", z : " + z + ", color : " + color);
    }

    @Override
    public String toString() {
      return super.toString() + " , z : " + z;    //super : 부모클래스를 지칭하는 대명사.
    }

    public void showPattern(){
      System.out.println("부모의 pattern : " + super.pattern);  //+)다른 클래스에서는 super를 사용할 수 없다.
      System.out.println("pattern : " + pattern);
    }


  }



