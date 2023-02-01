package controller;

import dto.GoodsInfo;
import view.InOutClass;

import java.util.ArrayList;

public class GoodsController {
private InOutClass io = new InOutClass();
ArrayList<GoodsInfo> goodsData = new ArrayList<>();

public void run(){
  int menu = -1;
  io.twoPrint("================================================================");
  io.twoPrint("Home Minus 상품 관리 프로그램");
  io.twoPrint("================================================================");


  while(true){

    menuShow();

    //종료
    menu = io.inputNumber("입력>");
    if (menu==0) {
      io.twoPrint("▶ 프로그램 종료.");
      return;
    }
    switch(menu){
      case 1:
        inputGoodsData();
          break;
      case 2:
        printGoodsData();
          break;
      case 3:
        searchGoodsData();
          break;
      case 4:
        updateGoodsData();
          break;
      case 5:
        deleteGoodsData();
          break;
      default :
        io.twoPrint("0~5까지 입력하세요.");
    }





  }//while end

}//run end
  private void menuShow(){

    io.onePrint("| 1.상품 입력 |");
    io.onePrint(" 2.상품 출력 |");
    io.onePrint(" 3.상품 검색 |");
    io.onePrint(" 4.상품 수정 |");
    io.twoPrint(" 5.상품 삭제 |");
    io.twoPrint("| 0.종료 |");
  }
  //상품입력
  private void inputGoodsData(){
    io.twoPrint("================================================================");
    io.twoPrint("▶ Home Minus 상품 정보 입력");
    io.twoPrint("----------------------------------------------------------------");
    //상품이름, 가격. 미성년자 판매 가능여부, 보관 방법
    GoodsInfo gInfo = new GoodsInfo();
    gInfo.setName(io.inputString("상품 이름 : "));
    gInfo.setPrice(io.inputNumber("상품 가격 : "));
    gInfo.setAdultOnly(io.inputString("미성년자 판매 가능 여부(y/n): "));
    gInfo.setStorage(io.inputString("보관 방법 : "));
    io.twoPrint("----------------------------------------------------------------");

    goodsData.add(gInfo);

    io.twoPrint("상품 정보 입력이 완료됐습니다.");
    io.twoPrint("================================================================");



  }
  //상품 출력
  private void printGoodsData(){
  if (goodsData.size()==0){
    io.twoPrint("저장된 상품 정보가 없습니다.");
    io.twoPrint("================================================================");
  return;
  }
    io.twoPrint("================================================================");
   io.twoPrint("▶ Home Minus 상품 정보 출력");
    io.twoPrint("----------------------------------------------------------------");

    for(GoodsInfo g : goodsData){
      io.twoPrint("상품 이름 : "+ g.getName());
      io.twoPrint("상품 가격 : "+ g.getPrice());
      io.twoPrint("미성년자 판매 가능 여부(y/n) : "+ g.getAdultOnly());
      io.twoPrint("보관 방법 : "+ g.getStorage());
      io.twoPrint("----------------------------------------------------------------");
    }
    io.twoPrint("상품 정보 출력이 완료됐습니다.");
    io.twoPrint("================================================================");


  }//printGoodsData end

  //상품 검색
private void searchGoodsData(){
  if (goodsData.size()==0){
    io.twoPrint("저장된 상품 정보가 없습니다.");
    io.twoPrint("================================================================");
    return;
  }
  io.twoPrint("================================================================");
  io.twoPrint("▶ Home Minus 상품 정보 검색");
  io.twoPrint("----------------------------------------------------------------");
  String nameToSearch = io.inputString("검색할 상품명 : ");
  io.twoPrint("----------------------------------------------------------------");
  io.twoPrint("검색결과\n");
for(GoodsInfo g : goodsData){
  if(nameToSearch.equals(g.getName())){
    io.twoPrint("상품 이름 : "+ g.getName());
    io.twoPrint("상품 가격 : "+ g.getPrice());
    io.twoPrint("미성년자 판매 가능 여부(y/n) : "+ g.getAdultOnly());
    io.twoPrint("보관 방법 : "+ g.getStorage());
    io.twoPrint("----------------------------------------------------------------");
    return;
  }
}
  io.twoPrint("상품 정보 검색이 완료됐습니다.");
  io.twoPrint("================================================================");

}//searchGoodsData end

  //상품 수정

  private void updateGoodsData(){
    if (goodsData.size()==0){
      io.twoPrint("저장된 상품 정보가 없습니다.");
      io.twoPrint("================================================================");
      return;
    }
    io.twoPrint("================================================================");
    io.twoPrint("▶ Home Minus 상품 정보 수정");
    io.twoPrint("----------------------------------------------------------------");


   String nameToUpdate = io.inputString("수정할 상품영 : ");
    io.twoPrint("검색 결과\n");
    int i;
    GoodsInfo g = null;
    for(i=0 ; i<goodsData.size();i++){
      g = goodsData.get(i);
      if(nameToUpdate.equals(g.getName())){
        io.twoPrint("상품 이름 : "+ g.getName());
        io.twoPrint("상품 가격 : "+ g.getPrice());
        io.twoPrint("미성년자 판매 가능 여부(y/n) : "+ g.getAdultOnly());
        io.twoPrint("보관 방법 : "+ g.getStorage());
        io.twoPrint("----------------------------------------------------------------");
        break;
      }
    }
      if(i==goodsData.size()){
        io.twoPrint("검색 결과가 없습니다.");
        return;
      }
      io.twoPrint("수정할 내용이 없으면 'Enter'를 누르세요.");

      int numberInput = io.inputNumber("상품 가격 : ");
      if(numberInput != -1){
        g.setPrice(numberInput);
      }
      String stringInput = io.inputString(("미성년자 판매 가능여부(y/n) : "));
      if(!stringInput.equals("")){
        g.setAdultOnly(stringInput);
      }

      stringInput = io.inputString(("보관 방법 : "));
      if(!stringInput.equals("")){
        g.setStorage(stringInput);
      }

      io.twoPrint("상품 정보 수정이 완료됐습니다.");
      io.twoPrint("================================================================");
  }




  //상품 삭제

public void deleteGoodsData(){
  io.twoPrint("================================================================");
  io.twoPrint("▶ Home Minus 상품 정보 삭제");
  io.twoPrint("----------------------------------------------------------------");


  String nameToUpdate = io.inputString("삭제할 상품영 : ");
  io.twoPrint("검색 결과\n");
  io.twoPrint("----------------------------------------------------------------");
  int i;
  GoodsInfo g = null;
  for(i=0 ; i<goodsData.size();i++){
    g = goodsData.get(i);
    if(nameToUpdate.equals(g.getName())){
      io.twoPrint("상품 이름 : "+ g.getName());
      io.twoPrint("상품 가격 : "+ g.getPrice());
      io.twoPrint("미성년자 판매 가능 여부(y/n) : "+ g.getAdultOnly());
      io.twoPrint("보관 방법 : "+ g.getStorage());
      io.twoPrint("----------------------------------------------------------------");
      break;
    }
  }

  if(i==goodsData.size()){
    io.twoPrint("검색 결과가 없습니다.");
    return;
  }
  io.twoPrint("----------------------------------------------------------------");
  String yn = io.inputString("삭제하시겠습니까?(y)");

  if(yn.equals("y")){
    goodsData.remove(i);
    io.twoPrint("상품 정보 삭제를 완료됐습니다.");
    io.twoPrint("================================================================");
  }
  io.twoPrint("상품 정보 삭제를 취소했습니다.");
  io.twoPrint("================================================================");

}

}//class end
