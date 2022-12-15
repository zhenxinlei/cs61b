package Algorithm;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        findNext("ABABAE");
        strStr("sadeisad", "sad" );
    }
    public static int strStr(String s, String t) {
        //s.contains(t);
        int[] nxt = findNext(t);
        int i = 0;
        int j = 0;
        while ( i<s.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            } else if(j!=0){
                //update t index per next[]
                //so upate j （next iter check j at next【j-1】
                j = nxt[j-1];
            } else {
                i++;
            }

            if(j==t.length()){
                return i-j;
            }
        }
        return -1;
    }

    public static  int[] findNext(String p){
        /*
        next[i] 表示 P[0] ~ P[i] 这一个子串，使得 前k个字符恰等于后k个字符 的最大的k.
         特别地，k不能取i+1（因为这个子串一共才 i+1 个字符，自己肯定与自己相等，就没有意义了）。
         */
        int nxt[]=new int[p.length()];

        int j=1;
        int i=0;
        /*  i
            ABCDABC
                j
         */
        while(j<p.length()){//prefix suffix self matching
            //i 可理解为待检验 index

            if(p.charAt(i)==p.charAt(j)){
                i++;
                nxt[j]=i;//why +1, 因为若失配于 j，相当于0 - (j-1) 相配，因从（j+1）开始与S 逐一比较
                /*   i       j
                     A B C D A B C E
                 nxt        i+1

                     i       j
                     A B C D A B C E
                 nxt         1
                 因为若失配于 B， 即 ABCDA match
                 next P index = next（5-1） =1

                 */
                //下次与主string 比较是 p 的index 为nxt（j-1）

                j++;
            } else if (i!=0){
                // i ， j not match，means 0 to i-1 match till j-1，
                //so upate i （next iter check i at next【i-1】

                i=nxt[i-1];//i
                /*
                     A B A B A E
                         A B A B A E
                 */

                //why not having j++?

            } else { //!= and i==0

                nxt[j]=i;
                j++;
            }

        }
        return nxt;
    }
}
