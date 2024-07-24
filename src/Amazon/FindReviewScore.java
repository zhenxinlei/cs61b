package Amazon;

import java.util.HashSet;
import java.util.Set;

public class FindReviewScore {
    /*
    given String str and probiding String[] words list
    find maxSubStringLength that doenst contain prohibited word in words

    review ="GoodProductButScrapAfterWash"
     words=["crap","odpro"]

     */

    public static void main(String[] args) {
        int res = solution1("GoodProductButScrapAfterWash", new String[]{"crap","odpro"});
        System.out.println(" res "+res);
    }

    public static int solution1(String review, String[] words){
        int left =0;
        int right =0;

        Set<String> set = new HashSet<>();
        int minLen = Integer.MAX_VALUE;
        for(String str : words){
            set.add(str);
            minLen = Math.min(minLen, str.length());
        }

        int maxLen = 0;
        for(int i =0;i<review.length();i++){
            for(int j =0;j<words.length;j++){
                String word = words[j];
                if(i-word.length()>=0) {
                    // 0 1 2 3 4
                   // System.out.println(review.substring(i-word.length()+1,i+1) +" "+(i-word.length()+1)+  " i "+i+" len " + (word));
                }

                if(i-word.length()>=0  && review.substring(i-word.length()+1,i+1).equalsIgnoreCase(word)){
                    System.out.println("FIND "+review.substring(i-word.length()+1,i+1) +" "+(i-word.length()+1)+  " i "+i+" len " + (word));
                    left = i-word.length()+2;
                    break;
                } else {
                    if(maxLen<i-left+1){
                        System.out.println("max update  "+review.substring(left, i+1) +" "+(i ));
                    }
                    maxLen =Math.max(maxLen, i-left+1);
                    //right++;
                }
            }


        }


        return maxLen;
    }
}
