package mainpackage;

import subpackage.UseClass;

public class MainClass {
  public static void main(String[] args) {
    UseClass uc = new UseClass();
    uc.ccc = 600;//public
   // uc.bbb = 300; //default 사용 불가.
   // uc.aaa = 100; //private 사용 불가.
  }
}
