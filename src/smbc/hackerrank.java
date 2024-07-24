package smbc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class hackerrank {
    public static void main(String[] args) {
        String res = repalceSubString("ab?e??d?f", "aec");
        System.out.println("res "+res);

    }

    public static String repalceSubString(String word, String sub){

        int start = -1;
        int end = -1;
        for (int i = 0;i<word.length();i++){
            if(word.charAt(i)=='?' || word.charAt(i)==sub.charAt(0)){
                if(word.length()-i>=sub.length()) {
                    boolean found = true;
                    for (int j = 0; j < sub.length(); j++) {
                        if (word.charAt(i+j) != '?' && word.charAt(i+j) != sub.charAt(j)) {
                            found = false;
                            break;
                        }
                    }

                    if (found) {
                        start = i;
                        end = i + sub.length() - 1;
                        break;
                    }
                }
            }
        }
        String res = "";
        if(start>=0){
            for(int i = 0;i<word.length();i++){
                if(i>=start && i<=end){
                    res += sub.charAt(i-start);
                }else if(word.charAt(i)=='?') {
                    res += 'a';
                } else {
                    res += word.charAt(i);
                }
            }
            return  res;
        }
        return "-1";

    }
}
