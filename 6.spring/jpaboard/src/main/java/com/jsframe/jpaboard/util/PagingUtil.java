package com.jsframe.jpaboard.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PagingUtil {
  private int totalPage; //전체 페이지의 개수(pageable이 전체 데이터의 개수를 구해준다)
  private int pageNum; //현재 보이고 있는 페이지의 번호
  private int pageCnt; //화면에 보여질 페이지 번호의 개수
  private String listName;//여러개의 게시판이 있을 경우 게시판을 구분하는 url 지정


  //페이징용 html 코드를 만드는 메서드
  public String makePaging(){
    String pageHtml=null;
    StringBuffer sb = new StringBuffer();
    /*
    String은 처음 만들 때 크기를 정할 수 없으므로, heap area에 동적으로 저장된다.
    stack area는 크기가 정해진 기본 자료형을 저장할 수 있지만, String은 heap area에 저장됨
    이때 문자열을 수정하면 매번 메모리를 새로 만들고 처리하므로 메모리효율이 좋지 않음
    스트링버퍼를 사용하면 처음에 어느정도의 작업공간을 할당받아서, 다 처리가 된 후에 문자열로 내보내는 식으로 할 수 있다.
    그냥 스트링을 처리하는 것보다 메모리를 효율적으로 처리할 수 있음
    */

    //1. 현재 페이지가 속한 그룹 구하기 - 한 페이지에 보일 페이지 번호가 5개일 때
    //[이전] 6 7 8 9 10 [다음] = 6,7,8,9,10번이 한 그룹

    int curGroup = (pageNum % pageCnt) >0 ? pageNum/pageCnt + 1: pageNum/pageCnt;
    //현재 7페이지일때, 7%5 >0 ? (7/5=1)+1 ==2 , curGrounp = 2

    //2. 현재 보이는 페이지 그룹의 시작 번호 구하기

    int start = (curGroup * pageCnt) - (pageCnt-1);

    //3. 현재 보이는 페이지 그룹의 마지막 번호 구하기
    //위의 예에서 10을 구함.(다음 페이지는 11)
    int end = (curGroup * pageCnt)>=totalPage ? totalPage : curGroup*pageCnt;
    //>=를 >로 해도 같은 결과가 나오지만, >=로 하면 곱연산을 한번 덜 할 수 있다.(totalpage=10일 경우)



    //paging용 HTML 태그 작성
    //1. 이전 페이지 처리
    if(start !=1){ //첫 페이지에서는 [이전]버튼을 출력하지 않음.
      sb.append("<a class='pno' href='/" + listName + "pageNum="+(start-1) + "'>");
      sb.append("&nbsp;이전&nbsp;</a>");
    }//<a class='pno' href='/?pageNum=5'>이전 </a>


    //2.그룹 내 페이지 번호 처리
    for(int i=start;i<=end;i++){
      if(pageNum ==i){//보여질 페이지 번호 처리(링크가 없는 페이지 번호)
        sb.append("<font class='pno' style='color:red;' >");
        sb.append("&nbsp;" + i + "&nbsp;</font>");
      }//<font class='pno' style='color:red;'> 3 </font>

      else{//링크가 붙는 페이지 번호
        sb.append("<a class='pno' href='/" + listName + "pageNum="+ i +"'>");
        sb.append("&nbsp;"+i+"&nbsp;</a>");
      } //<a class='pno' href='/?pageNum=1'> 1 </a>
    }//for end

    //3. [다음] 버튼 처리

    if(end!=totalPage){
      sb.append("<a class='pno' href='/" + listName + "pageNum="+(end+1)+"'>");
      sb.append("&nbsp;다음&nbsp;</a>");
    }//<a class='pno' href='/?pageNum=11'> 다음 </a>


    //StringBuffer에서 작성한 문장을 문자열로 변환
    pageHtml = sb.toString();
    return pageHtml;
  }
}
