public class VariableTest {
    public static void main(String[] args) {
        //문자형(character)
        char ch;
        ch = 'A';    //""와 ''를 구분하므로, 문자형을 입력할 땐 ""로 입력한다.
        char aaaaAA0;
        char AAAAAA;
        char zzzzzz;// 대소문자를 구분하므로, 옆의 세 값은 다 다르다.
        //작명법: 대소문자 구분. a~z, A~Z, 0~9, $만 사용가능
        //                   첫글자를 사용 불가. 글자 사이에 공백 x
        //권장 사항 : 첫글자는 받ㄴ스기 소문자로 작성할것.


        //정수형 변수

        byte numByte;
        short numShort;
        int numInt; //가장 많이 사용하는 형태
//        long zzzzzz  / 타입이 달라도 같은 면수명을 사용할 수 없다.
        // long경고는 무시해도 상관없음
        long numLong = 100L;//접미사 'L'. long 타입의 값을 표시.
                            //생략 가능




        //실수형 변수
        float f = 0.0f;//접미사 'f'. 생략 불가
        double du = 0.0;

        float f2;
        int iva = 10;
        f2 = iva;
        // System.out.println(f2) ;

        boolean b = true;
        boolean bb = false;
        //boolean bb = 0; true  false 외의값은 넣을 수 없다.


        //참조형 String -
        // 데이터의 크기가 실제로는 얼마나 될지 모르기때문에, 위치만 저장하고 실제 데이터는 힙 영역에 저장한다.

        String str = "이건 문장입니다.";

        int n1 = 100;
        int n2 = 200;

        boolean res = (n1 == n2);
        System.out.println(res);

        String sb1 = "abc";  //메모리상에 sb1공간이 만들어지고, 힙 영역에 abc값 저장
        String sb2 = "abc";  //저장된 값중에 abc가 있으면 그걸 다시 가져와서 sb2랑 연결시킴
        res = (sb1 == sb2);   //sb1과 sb2의 주소 값이 같다를 물어봄 => true
        System.out.println(res);

        String s1 = new String("abc"); //s1만들어서 abc를 저장후 연결
        String s2 = new String("abc"); //s2를 만들고, abc를 새로 만들어서 저장한 뒤 s2와 연결
        res = (s1 == s2);//false                 //s1과 s2는 주소의 값이 서로 다르므로 false 반환됨.
        System.out.println(res);

        res = (s1.equals(s2));      //힙영역에 저장된 문자열을 직접 비교함.
        System.out.println(res);

    }
}
