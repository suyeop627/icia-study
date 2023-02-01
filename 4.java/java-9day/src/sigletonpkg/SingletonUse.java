package sigletonpkg;

public class SingletonUse {
//SingletonTest st = new SingletonUse();      <- 에러발생 (SingletonTest는 private)
  SingletonTest st = SingletonTest.getInstance();
}
