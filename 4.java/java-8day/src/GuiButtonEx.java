import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiButtonEx extends JFrame {   //메인메서드가 담긴 클래스를 상속받아서 JFrame을 사용

  //기본적인 화면 구성에 대한 설정을 생성자로 처리
  public GuiButtonEx(){
    //제목 표시줄에 타이틀 출력
    setTitle("GUI 예제");

    //종료 버튼 클릭 시 프로그램 종료
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //EXIT_ON_CLOSE 에는 3이라는 값이 담겨있는데, 숫자말고 문자로 의미를 부여해서 더 가독성을 올린 케이스임

    //화면 요소를 담는 Container 생성
    Container c = getContentPane();

    //화면 요소를 배치하는 레이아웃 설정.
    c.setLayout(new FlowLayout());

    //버튼 추가
    JButton btn = new JButton("Action");
    //container 안에 버튼 넣기
    c.add(btn);

    //버튼이 눌렸을 때, 아래의 MyActionListener.actionPerformed(ActionEvent e)가 실행.
    MyActionListener mal = new MyActionListener();
    btn.addActionListener(mal);


    //내부클래스 활용예제 버튼
    JButton btn2 = new JButton("Action2");
    c.add(btn2);

    InnerActionListener ial = new InnerActionListener();
    btn2.addActionListener(ial);

    JButton btn3 = new JButton("Action3");
    c.add(btn3);


    //익명 클래스(전용 기능을 제공하는 객체 생성시 사용. 이 경우, btn3에만 특별한 기능을 부여하기 위해서 사용. 새로 클래스를 만들지 않고,
    // 해당 클래스를 생성하기 위해 필요한 부분만 채워서(overriding 이 필요한경우) 바로 생성할 수도 있다.
    btn3.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        if(b.getText().equals("Action3")){
          b.setText("액션3");
        }else{
          b.setText("Action3");
        }
        setTitle(b.getText());     //InnerActionListener 클래스에서 했던 거를 익명함수로 작성
      }
    });



    //화면 크기 설정(픽셀단위)
    setSize(500, 200);
    //----------메모리에 생성 완료

    //메모리에 생성한걸 화면에 출력
    setVisible(true);
  }

  class InnerActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
      //버튼은 생성자 안에서 만들어진거라서 다른 매서드 안에서 불러올 수 없지만, 내부클래스를 사용해서 외부클래스에서 선언된 멤버를 사용할 수 있다. -> 다시 찾아보기
      GuiButtonEx.this.setTitle("바뀐 제목");
    }

  }

  public static void main(String[] args) {
    new GuiButtonEx();
  }

}//class end


//버튼 이벤트 처리용 객체
class MyActionListener implements ActionListener{

  @Override
  public void actionPerformed(ActionEvent e) {
   //버튼을 눌렀을 때, 해당 이벤트의 정보가 ActionEvent e에 들어옴.

    //이벤트가 발생한 버튼의 정보를 받는다.
    JButton b = (JButton)e.getSource();
    if (b.getText().equals("Action")) {   //버튼의 text와 b.getText()에서 반환한 값이 일치한다면
      b.setText("액션");    //Text 새로 설정
    }
    else {
      b.setText("Action");  //  Text 새로 설정
    }
  }
}//MyActionListener end


