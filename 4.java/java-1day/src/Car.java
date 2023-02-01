public class Car {
    //상태(변수)
    String model;   //자바의 문자열 변수 js와는 다르게, 선언할때부터 타입을 정함. 저장된 값은 변경할 수 있지만, 타입은 변경 불가능
    String company;
    int tier;
    String color;

    //행동(기능, 메소드)
    void exel(int sp){              //void : 리턴값이 없을 때 선언.
        System.out.println("속도 " + sp + "올림");
    };
    void stop(){
        System.out.println("멈춤");
    }
}


//  객체 - 필요한거 모아서 묶어놓는거


/* 단축키
psvm : public static void main()메인메소드 생성
sout : System.out.println()생성 단축키

*/