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
        String test1 = solution1("ac");
        System.out.println(" solution1() "+test1);

        System.out.println("Sol2() "+solution2("cbbd"));

        System.out.println(" pratice1 "+practice1("cbbd"));
    }

    //dp [i][j] = substring start at i , end at j is palindorme or not
    public static String solution1(String str){

        int len = str.length();
        if (len<2)
            return str;
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
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

    //iter all possible center and expand , pay attention to duplicate letters
    public static String solution2(String s) {
        if (s==null||s.isEmpty()) return "";

        int start=0;
        int maxlen=1;

        for (int i=0; i<s.length();i++){

        //substring exclude j(start ), k (end)
            int j=i;
            int k=i;

            //skip duplicate letter
            while (k<s.length()&&s.charAt(i)==s.charAt(k)){
                k++;
            }

            // asdfdghhhhhhgdflkjoijiou
            //       j/i  k
            k--;
            //expand to two side
            while (j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
                k++;
                j--;
            }

            int tempSize=k-j-1;

            if (maxlen<tempSize){
                maxlen=tempSize;
                start=j+1;
            }

        }
        return s.substring(start,start+maxlen);
    }

    //pratice
    public static String practice1(String s){ //on^2
        //dp
        /**
         *  col end id
         *  row start id
         *
         *
         */
        boolean [][] dp = new boolean[s.length()][s.length()];

        dp[0][0]=true;
        int maxLen = 0;
        int resStart=0;
        int resEnd = 0;
        for(int end=1; end<s.length();end++){
            for(int start = 0; start<end;start++){
                if(s.charAt(start)!=s.charAt(end)){
                    dp[start][end]=false;
                } else{
                    if(start==end || start+1==end || start+1==end-1){
                        dp[start][end]=true;
                    } else {
                        dp[start][end]= dp[start+1][end-1]; //update from priouse state ,   [.... start, start+1, .... end-1, end.. ]
                    }
                }

                if(dp[start][end] && end-start+1> maxLen ){
                    maxLen = end-start+1;
                    resStart=start;
                    resEnd = end;
                }
            }
        }

        return s.substring(resStart, resEnd+1);
    }


}
