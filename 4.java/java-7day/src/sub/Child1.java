package sub;

import basic.Parent1;

public class Child1 extends Parent1 {
  void someMethod(){
    //다른 패키지의 클래스를 상송한 뒤, 해당 클래스의 변수 사용 가능 여부.
    a = 10000;  //public
    b = 20000;  //protected
   //c = 30000;  //default
   //d = 40000;  //private
  }

}
