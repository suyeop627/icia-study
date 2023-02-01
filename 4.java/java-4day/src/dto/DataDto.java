package dto;

public class DataDto {
  private  int number;
  private String str;
  private float fnumber;




//getter and setter /class 영역 내에서 우클릭 -> generate
  //변수 명을 소문자로 적는 이유는 getter나 setter만들 때 변수의 첫글자를 대문자로 변환 시키기 때문.
  //public으로 변환시키면서 다른 메소드에서 get set 가능

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
  }

  public float getFnumber() {
    return fnumber;
  }

  public void setFnumber(float fnumber) {
    this.fnumber = fnumber;
  }
}
