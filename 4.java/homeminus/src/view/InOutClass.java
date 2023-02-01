package view;

import java.util.Scanner;


  public class InOutClass {
    private Scanner scan = new Scanner(System.in);

    public String inputString(String input) {
      onePrint(input);
      String check = scan.nextLine();
      return check;
    }

    public int inputNumber(String input) {
      onePrint(input);
      String check = scan.nextLine();
      int num = -1;
      if (check.equals("")) {
        num = -1;
        return num;
      }
      try {
        num = Integer.parseInt(check);

      } catch (Exception e) {
        twoPrint("잘못입력하셨습니다.");
        num = -1;

      }
      return num;
    }







    public void onePrint(String input) {
      System.out.print(input);
    }

    public void twoPrint(String input) {
      System.out.println(input);
    }


  }


