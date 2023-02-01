import dao.DataDao2;
import dto.MemberDto;

import java.util.Scanner;

public class MainClass {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    DataDao2 dao = new DataDao2();      //생성자 만들었으므로, 인스턴스 생성시, 드라이버 로드가 완료된다.
    dao.connectionTest();

    System.out.println("로그인 처리");
    System.out.print("야이디 : ");
    String m_id = scan.nextLine();

    System.out.print("비밀번호 : ");
    String m_pwd = scan.nextLine();

    String dbpwd = dao.selectPwd(m_id);

    if(m_pwd.equals(dbpwd)){
      System.out.println("로그인 성공");
    }
    else {
      System.out.println("비밀번호 오류");
    }

    MemberDto md = new MemberDto();
    md.getM_id();  //자동으로 생성된 getter 메소드

  }
}
