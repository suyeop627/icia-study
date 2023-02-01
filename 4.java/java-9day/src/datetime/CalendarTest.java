package datetime;

import java.util.Calendar;

public class CalendarTest {
  public static void main(String[] args) {
    //Calendar인스턴스 생성
    //Calendar cal = new Calendar(); Calendar는 싱글톤패턴으로 만들어진 클래스이며, abstract이기 때문에 인스턴스를 바로 생성할 수 없다.

    Calendar cal = Calendar.getInstance();    //메소드를 실행해서 Calendar 클래스에서 생성된 인스턴스를 반환받고, 그 인스턴스를 변수에 저장하는 식으로 활용한다.

    //System.out.println(cal);
    /*
    출력값 : java.util.GregorianCalendar
    [time=1663897177205,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo
    [id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null]
    ,firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=8,WEEK_OF_YEAR=39,WEEK_OF_MONTH=4,
    DAY_OF_MONTH=23,DAY_OF_YEAR=266,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=4,AM_PM=0,HOUR=10,HOUR_OF_DAY=10,
    MINUTE=39,SECOND=37,MILLISECOND=205,ZONE_OFFSET=32400000,DST_OFFSET=0]
   */

    //연, 월, 일 구하기
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH)+1;
    //우리나라는 1월~12월이라고 표현하지만, 영어에선 각 월에 해당하는 명칭이 따로 있다. 각 명칭을 배열에 넣으면 index 0~11에 저장된다. 따라서, +1을 해줘야 9번째 달에 9를 출력받을 수 있다.
    int day = cal.get(Calendar.DATE);
    System.out.println(year + "년 " + month + "월 " + day + "일 ");

    int hour = cal.get(Calendar.HOUR);
    int minute = cal.get(Calendar.MINUTE);
    int second = cal.get(Calendar.SECOND);
    System.out.println(hour + "시 " + minute + "분 " + second + "초 ");

    //달의 마지막 날 구하기
    int lastDayofMonth = cal.getActualMaximum(Calendar.DATE);
    System.out.println("이번달의 마지막 날 : " + lastDayofMonth);


    //날짜 지정
    Calendar cal2 = Calendar.getInstance();

    //연, 월, 일 지정
    cal2.set(Calendar.YEAR, 2022);
    cal2.set(Calendar.MONTH, 7); //실제 월 -1 값 입력
    cal2.set(Calendar.DATE, 1);
   // System.out.println(cal2);

    //시작일의 요일(1:일요일, 7:토요일)
    int startDay = cal2.get(Calendar.DAY_OF_WEEK);
    System.out.println(startDay);
    int lastDay = cal2.getActualMaximum(Calendar.DATE);
    System.out.println(lastDay);






  }
}
