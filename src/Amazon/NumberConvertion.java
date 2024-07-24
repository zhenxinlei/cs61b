package Amazon;

import java.util.HashMap;
import java.util.Map;

public class NumberConvertion {



//
//    字符串由01234构成，编码成0-9, a-z的字符串。本质上是10进制转36进制。follow up是
//
//1. 不使用大数类怎么写，2.5进制转36进制。

    public static void main(String[] args) {
        String res = solution1("0010");
        System.out.println(res);
    }


    public static String solution1(String str){
        // 5-cimal to decimal to 36-cimal
        long decimal = 0;
        for(int i =0;i<str.length();i++){
            int c = str.charAt(str.length()-1-i)-'0';

            decimal += c*Math.pow(5,i);
            System.out.println("update decimal  value "+ decimal+" c "+c);
        }
        System.out.println(" decimal  value "+ decimal);

        Map<Integer, Character> mapTo36 = new HashMap<>();
        for(int i =0;i<36;i++){
            if(i<=9) {
                int c = '0'+i;
                mapTo36.put(i, (char) c);
            }
            else {
                int c = 'a'-10+i;
                mapTo36.put(i,(char) c);
            }
        }
        System.out.println(" map "+ mapTo36);

        StringBuilder res = new StringBuilder();
        while (decimal>0){
            int remainder = (int)decimal%36;
            res.append(mapTo36.get(remainder));
            decimal = decimal/36;
        }

        return  res.reverse().toString();

    }


}
