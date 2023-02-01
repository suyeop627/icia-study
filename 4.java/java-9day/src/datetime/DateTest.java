package datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
  public static void main(String[] args) {
    //Date class : 현재 시간을 저장한 인스턴스 생성 java.util.Date(sql X)
    Date today = new Date();
    System.out.println(today);

    //SimpleDateFormat : 원하는 형태로 날짜와 시간 형식을 지정.
    SimpleDateFormat sdf1 =
      new SimpleDateFormat("G yyyy-MM-dd (E)");//G : AD /M : 월 / m : 분 / E : 요일
    String daystr = sdf1.format(today);
    System.out.println(daystr);

    SimpleDateFormat sdf2 =
      new SimpleDateFormat("[a] hh:mm:ss.SSS");   // a : 오전/오후 hh : 12시간 / HH||kk : 24시간 / s : 초/ S : 밀리초
    String timestr = sdf2.format(today);
    System.out.println(timestr);

    SimpleDateFormat sdf3 = new SimpleDateFormat("F w W D"); //F : 요일(월(0)~일(6) / w : 1년 중 몇 번째 주인지 / W  : 이번달 내에서 몇 번째 주차 / D : 1년 중 몇 번째 일차인지.
    String str = sdf3.format(today);
    System.out.println(str);
  }
}
