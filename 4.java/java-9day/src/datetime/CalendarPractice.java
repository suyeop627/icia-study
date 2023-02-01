package datetime;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarPractice {
  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    
    Scanner scan = new Scanner(System.in);
  
    int year;
    int month;
    int lastDay;
    int startDay ;

    System.out.println("연도와 월을 입력하세요.");
    System.out.print("연도 : ");
    year = scan.nextInt();
    System.out.print("월 : ");
    month = scan.nextInt();



    cal.set(Calendar.YEAR, year);
    cal.set(Calendar.MONTH, month-1);

    startDay = cal.get(Calendar.DAY_OF_WEEK);
    lastDay = cal.getActualMaximum(Calendar.DATE);


    System.out.println();
    System.out.println(year + "년\t\t\t\t\t" + month + "월");
    System.out.println("============================");
    System.out.println("일\t월\t화\t수\t목\t금\t토");
    System.out.println("============================");

    int cnt = 0;
    for(int i = 0; i<startDay; i++){
      if(startDay ==7)
        break;
      System.out.print("\t");
      cnt++;
    }

    for (int j = 1;j <= lastDay; j++){
      System.out.printf("%-2d", j);
      cnt++;
      if(cnt % 7 ==0){
        System.out.println();
      }
      else {
        System.out.print("\t");
      }
    }





  }
  
}
