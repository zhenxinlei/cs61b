package Algorithm;

import java.util.Arrays;

public class LongestSubArraySumAtMostK {
    /*
                 [1, -2, 1, 20, 1, -8,-9 ,0]  ->
       neg_sum : [-2 ,0, 0,-16,-17,-9, 0, 0] -> sub array [i,j] then neg_sum[j] = sum array [j+1:]
       for all positive number:
           have start (i) index and end index,
           increment end (j) index if sum < K
           increment start index if sum >=K
           and keep track max length

       for positive and negative number:
           need check sum[i:j] + min_neg_sum[j+1:] <K and keep track of max length
           adding min_neg_sum means the rest part can reduce sum s.t. total < K
           if neg_sum [j+1] >0, set to 0
     */

    public static int solution(int[] array , int k ){

        int neg_cum_sum[] = new int[array.length]; // cum sum from right, if >0 set to 0

        int rest = 0;
        for(int i = neg_cum_sum.length-1; i>=0;--i){
            neg_cum_sum[i]=rest;
            rest=Math.min(0, array[i]+rest);
        }

        System.out.println(Arrays.toString(neg_cum_sum));

        int i =0;
        int j =0;
        int sum =0;
        int max_length = 0;
        int si=0;
        int sj = 0;
        for(j=0; j<array.length;j++){
            sum += array[j];
            while (i<j && sum+ neg_cum_sum[j]>k){ //shrink sub array i
                sum -= array[i];
                i++;
            }
            if(j-i+1 > max_length){
                max_length= j-i+1;
                si = i;
                sj = j ;
            }

        }
        System.out.println("max_length: "+max_length+" si " + si+" sj "+sj);
        return max_length;

    }

    public static void main(String[] args) {
        solution(new int[]{1, 2, 1, 0, 1, -8, -9, 0}, 4);
        solution(new int[]{1, -2, 1, 20, 1, -8, -9, 0}, 4);
    }
}
