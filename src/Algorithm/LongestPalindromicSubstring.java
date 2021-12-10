package Algorithm;

/**
 * Leetcode #5
 *
 *  dp 0  1  2  3  4
 *  0  t  f  t
 *  1     t  f
 *  2        t
 *  3
 *  4
 *
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String test1 = solution1("abcbac");
        System.out.println(" solution1() "+test1);
    }

    //dp [i][j] = substring start at i , end at j is palindorme or not
    public static String solution1(String str){
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        int start = 0;
        //init dp diaglal element, must be true
        for (int i = 0 ;i<len;i++){
            dp[i][i]=true;
        }

        for (int j = 1; j<len;j++){ // iter from up-left to low-right
            for (int i =0 ; i<j; i++){
                if(str.charAt(i)!=str.charAt(j)){
                    dp[i][j]=false;
                } else {//head and tail equals
                    if( j-i<3) {// edge condition j-1 -(i+1) + 1<2 => middle substring is one char
                        dp[i][j]=true;
                        System.out.println(" check edge "+ i+", "+j );
                    } else {
                        dp[i][j]=dp[i+1][j-1];//**from lower left element => check string removed head and tail char
                    }

                }

                if(dp[i][j] && j-i+1>maxLen){
                    maxLen = j-i+1;
                    start = i;
                }

            }
        }

        return str.substring(start,start+maxLen);

    }

}
