public class TypeCast {
    public static void main(String[] args) {
        byte b = 10;
        int ivalue = b;     //자동 형변환     작->큰 으로 변환할 때(, int)b;로 적지 않아도 자동으로 형변환을 해준다.

        //short sh = ivalue; 문제있는 거에 커서 올리면 확인 가능, 권장하는 해결방법 중 클릭하면 적용됨.
        short sh = (short) ivalue;
        System.out.println(sh);
        int i2 = 1000000;
        //0000 0000 0000 1111 0100 0010 0100 0000 : 1,000,000
        sh = (short)i2;
        System.out.println(sh); //16960 출력 : 공간의 크기가 적은 type으로 변환해서, 2진수 표기 중 일부가 날아가서 수가 더 작은수로 저장됨
        //0100 0010 0100 0000 : 16.960

        float pi = 3.14f;
        long i3 = (long) pi;//long i3 = pi; float이 long보다 더 큰 개념이라서 float->long으로 할 경우 자료 손실 발생
        System.out.println(i3); //3 출력

        String str ="" +pi;     //String으로 변환할 때, 빈 문자열을 삽입하면 자동 형변환이 되도록 할 수도 있다.
        //문자열이 가장 큰 데이터 타입
        //연산 내부에서 자동으로 형변환이 발생(float -> String)



        //연산식에서의 자동 형변환 : 연산 순서에 따라 자동 형변환
        float rs = pi * 5;  //실수와 정수의 연산 -> '5'(int)의 값이 '5.0'(float)으로 형변환 된다.
        System.out.println(rs);

        //int rsi = pi * 5;  //pi*5는 float * int에서 float *float으로 형변환이 이루어졌는데, float을 int에 담으려니 에러 발생
        //우항을 int로 바꾼다면?


        float ff = 5.89f;

        int rsi = (int)ff * 6;          //30 출력 : 5.89가 먼저 형변환돼서, 5*6으로 연산됨.
        System.out.println(rsi);


        int rsi2 = (int)(ff * 6);     //35 출력 : 6이 먼저 float으로 바뀌어서, 5.89*6.0->35.xxx 먼저 구하고, int로 형변환됨
        System.out.println(rsi2);

        //연산의 오차가 적게 하기위해선, 연산을 먼저하고나서 형변환 하는게 나음

        String rsi3 = 5 + 4 + "";   // 9 출력
        System.out.println(rsi3);

        rsi3 = "" + 5 + 4;
        System.out.println(rsi3);   //54 출력 : 5라는 문자열이 먼저 만들어지고, 앞의 5가 더 큰 개념이므로 형변환이 일어나서 4도 문자열로 변환됨
                                    //두개의 문자열 5와 4를 함께 나열한 54가 출력됨
                                    //산술식을 먼저 처리하고싶으면 ()로 감싸기

        rsi3 = 5+ "" + 4;              //54 출력 : 위와 동일한 이유로 +연산자가 문자를 나열하는 형태로 사용됨
        System.out.println(rsi3);

        //숫자->문자열 변환 메소드 : String.valueOf(숫자);
        String sss = String.valueOf(5); //문자열 변환 메소드 : 5 + "" 와 같은 기능을 수행하는 메소드
        //형변환은 데이터가 대상이다. 변수의 타입은 변경되지 않는다. - 변수의 데이터를 꺼내서 형변환을 하는 형태. 변수의 타입 자체가 바뀌는 건 아니다.

        String numStr = "1000";
        //정수문자열 ->정수
        int numInt = Integer.parseInt(numStr);
        //실수문자열->실수
        numStr = "3.14";
        float numFloat = Float.parseFloat(numStr);
        System.out.println(numInt);
        System.out.println(numFloat);


        float dres = (float)(5 / 3);      //1.0 출력
        System.out.println(dres);
        float dres1 = (float)5 / 3;      //1.666666 출력
        System.out.println(dres1);

        int ires = 5/3;
        System.out.println("몫 : "   + ires);
        int r = 5 % 3;
        System.out.println(("나머지 : " + r));


    }
}
