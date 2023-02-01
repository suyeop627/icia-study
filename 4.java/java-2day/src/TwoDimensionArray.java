import java.util.Scanner;

public class TwoDimensionArray {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int stNum = 0;
    System.out.print("학생 수 : ");
    stNum = scan.nextInt();

    //공간의 개수 = 학생서 *3(과목수)
    int score[][] = new int[stNum][3];

    //학생수별 3과목 성적 입력
    for(int i = 0; i<score.length;i++){ //줄수만큼 반복 (stNum만큼)
      for(int j =0; j<score[i].length; j++){ //칸수만큼 반복 (3 만큼)
        System.out.print(i + "번 학생의 "+j + "번째 성적 : ");
        score[i][j] = scan.nextInt();     //break point -> f9

      }//inner for end
    }//outer for end

  }//main end
}//class end
