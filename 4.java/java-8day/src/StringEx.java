public class StringEx {
  public static void main(String[] args) {
    //String
    String str1 ="hello";  //
    String str2 = new String("hello");   //이게 원래 기본형태고, 위처럼 표기도 가능함
    char[] ch = {'h', 'e','l', 'l', 'o'};     //과거 문자열은 배열로 있었다.
    String str3 = new String(ch);              //문자의 배열을 문자열로 변환


    //StringBuffer
    StringBuffer sb = new StringBuffer();
    sb.append("abc");
    sb.append("def");
    String str4 = new String(sb);
    String str5 = sb.toString();
    System.out.println(str5);
    //출력값 : abcdef


    ///////////////////////////////////

    char c = str1.charAt(4);
    System.out.println(str1 + ":" + c); //출력값 : hello:o


    String str6 = "dog,cat:chiken-pig";
    //String strs[] = str6.split(" ");    //공백을 기준으로 자를경우
    String strs[] = str6.split("[,:-]"); //구분자가 여러개일때, 대괄호 안에 묶어서 사용한다.
    /*출력값
    dog
    cat
    chiken
    pig
     */


    for (String s:strs){
      System.out.println(s);
    }
    System.out.println(strs.length);  //출력값 : 4
    System.out.println(str6); //출력값 : dog,cat:chiken-pig
    //새로운 배열을 만들어내므로, 원본은 그대로 존재한다.


    String str7 ="aa0bbcc1aaee3ffaa5gg";
    System.out.println(str7);
    //출력값 : aa0bbcc1aaee3ffaa5gg
    String str8 = str7.replace("aa", "AA");
    System.out.println(str8);
    //출력값 : AA0bbcc1AAee3ffAA5gg
    String str9 = str7.replaceAll("aa", "ZZ");
    System.out.println(str9);
    //출력값 : ZZ0bbcc1ZZee3ffZZ5gg
    String str10 = str7.replaceAll("[0-9]", " ");
    System.out.println(str10);
    //출력값 : aa bbcc aaee ffaa gg

    String str11 = str7.substring(0,9);
    System.out.println(str7);
    //출력값 : aa0bbcc1aaee3ffaa5gg      //쉘로우 카피
    System.out.println(str11);
    //출력값 : aa0bbcc1a
  }
}
