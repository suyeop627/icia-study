import java.util.ArrayList;

public class datePractice {
  public static void main(String[] args) {


//    boolean avail = calDate();
//    if (avail) {
//      System.out.println("예약가능");
//    } else {
//      System.out.println("예약 불가능");
//    }


    run();


  }


  public static boolean calDate() {
    boolean avail = true;
//    String fromData = "2022-11-11";
//    String toDate = "2022-11-15";
    String fromData = null;
    String toDate = null;

    String inputDateS = "2022-11-16";
    String inputDateE = "2022-11-17";
    try {
      int fromDate1 = Integer.parseInt(fromData.replaceAll("-", ""));
      int toDate1 = Integer.parseInt(toDate.replaceAll("-", ""));
      int inputDateStart = Integer.parseInt(inputDateS.replaceAll("-", ""));
      int inputDate1End = Integer.parseInt(inputDateE.replaceAll("-", ""));


      int[] bookedDate = new int[toDate1 - fromDate1 + 1];
      int[] wantToBookDate = new int[inputDate1End - inputDateStart + 1];

      int b = fromDate1;
      int w = inputDateStart;

      for (int i = 0; i < toDate1 - fromDate1 + 1; i++) {
        bookedDate[i] = b++;
      }
      for (int i = 0; i < inputDate1End - inputDateStart + 1; i++) {
        wantToBookDate[i] = w++;
      }

      for (int j = 0; j <= wantToBookDate.length - 1; j++) {
        for (int i = 0; i <= bookedDate.length - 1; i++) {
          if (wantToBookDate[j] == bookedDate[i]) {
            avail = false;
            break;
          }
        }
      }
    } catch (
      NullPointerException e) {
    }
    return avail;

  }


  public static void run() {
    int[] aa = new int[]{1,2,3,4,5};
    int[]bb = new int[5];


    for (int i = 1; i < aa.length+1; i++) {
      bb[i-1] = aa[aa.length-i];
    }

    System.out.println("aa : " + aa[0] + aa[1] +aa[2] +aa[3]  + aa[4]);
    System.out.println("bb : " + bb[0] + bb[1] +bb[2] +bb[3]  + bb[4]);


  }


}



