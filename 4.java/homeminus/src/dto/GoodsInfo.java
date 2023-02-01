package dto;
/*
상품 관리 프로그램 프로젝트
홈마이너스  동네 마트의 상품을 관리하기 위한 프로그램 작성 의뢰.
  상품의 주요 정보 : 상품이름, 가격. 미성년자 판매 가능여부, 보관 방법
  기능 : 상품입력, 상품 출력, 상품 검색, 상품 수정, 상품 삭제

 ~11:50
 */
public class GoodsInfo {
  private String name;
  private int price;
  private String adultOnly;
  private String storage;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getAdultOnly() {
    return adultOnly;
  }

  public void setAdultOnly(String adultOnly) {
    this.adultOnly = adultOnly;
  }

  public String getStorage() {
    return storage;
  }

  public void setStorage(String storage) {
    this.storage = storage;
  }



}
