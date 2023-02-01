public class GenericsTest {
  public static void main(String[] args) {
    Box b1 = new Box();
    b1.setItem("abc");    //문자열 담기
    Box b2 = new Box();
    b2.setItem(100);      //숫자 담기
    System.out.println(b1.getItem());

    //저장된 데이터에 맞는 형태로 변경하여 사용.
    //형변환 연산자가 필요하다. 잘못 형변환을 하면 예외사항이 발생.
    String rb =(String)b1.getItem(); //아이템을 직접 꺼낼때는 무슨 타입인지 알 수 없음. 위에가서 확인하고나서 형변환 해줘야함.
    //int rb2 = (int)b1.getItem();    //Object는 다 받아주긴 하지만, 꺼낼때는 타입에 맞춰서 꺼내야한다. 넣을땐 맘대로지만 나갈땐..




    //generics box 사용
    Box2<String> gb1 = new Box2<>();      // 아래 박스2에 T로 선언했던 부분을 String으로 치환

    Box2<Integer> gb2 = new Box2<>();  //숫자열을 저장하는 박스 생성(레퍼클래스 사용)

    gb1.setItem("xyz"); //시작할때부터 정한 타입만 사용가능하다.
    gb2.setItem(300);

    String rgb1 = gb1.getItem();
    int rgb2 = gb2.getItem();


  }
}


//기본적으로 클래스는 따로 만들지만, 한 파일에 만들어도 문제가 생기진 않는다.
//out폴더에 두개의 클래스가 생성된 거 확인.
//public은 하나에만 붙일 수 있는데, public에서 사용되는 클래스(일종의 서브클래스)를 한 파일에 작성한 형태로 사용됨.


class Box {   //private과 public을 작성하는 이유, 어떤걸 작성하는지 - 정리
  private Object item;    //모든 것을 담을 수 있는 Object가 됨

  public void setItem(Object item){
    this.item = item;
  }
  public Object getItem(){
    return item;

  }
}//box end

class Box2<T>{
  private T item;     //T : type의 대명사

  public void setItem(T item){
    this.item=item;
  }
  public T getItem(){
    return item;
  }

}