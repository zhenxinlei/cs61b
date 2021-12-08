package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class BitWiseLongestSubSequence {

    /**
     *
     * @param args
     * find  BIT AND NONE ZERO max subSequence
     */

    public static void main(String[] args) {

    xorEqualK(new int[]{3, 2, 4, 3, 5}, 1);

    int result = longestIncreasingSubSeq(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15});
    System.out.println(" longest Increasing Sub Seq "+ result);

    }


    /**
     * Length of the longest subsequence such that XOR of adjacent elements is equal to K
     * @param arr
     * @return
     *
     * Given an array arr[] of N non-negative integers and an integer K, the idea is to find the length of the longest subsequence having Xor of adjacent elements equal to K.
     *
     *
     * Initialize an integer say ans =0 to store the length of the longest subsequence and an array say dp[] to store the state of DP.
     * Initialize a HashMap say mp to store the longest length of subsequence ending at an element.
     * Define base case as dp[0] = 1 and push the pair {arr[0], 1} in mp.
     * Iterate over the range [1, N-1]:
     * Find the length of the longest subsequence say dpj ending at element arr[i] ^K from HashMap mp.
     * Update dp[i] as max(dp[i], dpj+1) and update the longest length of subsequence ending at element arr[i] in HashMap mp.
     * Update the ans = max(ans, dp[i]).
     * Finally, print the maximum length of the longest subsequence ans.
     */
    public static int xorEqualK(int[] arr, int k ){
       int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int dp[] =  new int[arr.length];

        map.put(arr[0],1);
        dp[0]=1;

        for (int i=1; i<arr.length;++i){
            System.out.println(" XOR k "+arr[i]+",  "+(arr[i]^k)+", "+ ((arr[i]^k)^arr[i]));
            Integer dpj = map.get(arr[i]^k);

            if (dpj != null)
                dp[i] = Math.max(dp[i], dpj + 1);
            ans = Math.max(ans, dp[i]);

            map.put(
                    arr[i],
                    Math.max(map.getOrDefault(arr[i], 1), dp[i]));

        }

        return ans >= 2 ? ans : 0;
    }

    /**
     * Longest Increasing Subsequence using Dynamic Programming
     * The longest increasing subsequence problem is to find a subsequence of
     * a given sequence in which the subsequence’s elements are in sorted order, lowest to highest,
     * and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous or unique.
     *
     * For example, the longest increasing subsequence of [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
     * is [0, 2, 6, 9, 11, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
     *
     * @param arr
     * @return
     */
    public static int longestIncreasingSubSeq(int[] arr){
        int ans = 0;
        //dp[i] = max length ending at i
        int dp[] = new int[arr.length];
        dp[0]= 1;

        for ( int i =1; i<arr.length;i++){
            for (int j =0; j<=i-1; j++){
                if(arr[j]<=arr[i]){
                    dp[i]= Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        return dp[arr.length-1];

    }



    public static int solution(int[] arr){
        if (arr.length== 0 || arr.length==1)
            return arr.length;

        int tmp = arr[0];
        int max = arr[0]==0? 0: 1 ;
        int start = 0;
        int end = 0;

        for (int i =1 ; i< arr.length; i++){

            if(arr[i]==0){
                start = i +1;
                end = i+1;
                continue;
            }
            tmp = arr[i]&tmp;



        }


    return 0;
    }
}
