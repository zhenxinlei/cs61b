package Algorithm;

import java.util.Arrays;

//LeetCode 818
public class RaceCar_LC818 {
    /*
      128
      speed   2^0   2    4    8,  16 , 32, 64, 128, 256  512
       pos 0   1    3    7    15  31   63

       option 1
      0 ---------------------------------> 512-1
                     256        300  <---
       option 2
       0 ------------256 (RA)

                     256 -->  300


      i
     */

    public static void main(String[] args) {
        int res = solution(1);
        System.out.println(res);
    }

    public static int solution(int target){
        int[] dp = new int[target+1];
        Arrays.fill(dp,1,dp.length,-1);
        return raceCar(target,dp);
    }

    //not tested
    public static int raceCar(int i , int dp[]){
        if(dp[i]>=0)
            return dp[i];
        dp[i]=Integer.MAX_VALUE;

        int m = 1, j = 1;
        for(;j<i;j=(1<<++m)-1){
            for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                dp[i] = Math.min(dp[i],  m + 1 + q + 1 + raceCar(i - (j - p), dp));
            }
        }

        dp[i] = Math.min(dp[i], m + (i == j ? 0 : 1 + raceCar(j - i, dp)));

        return dp[i];
    }

    //TODO need to implement
    public static int solution2(int target){
        if(target==0)
            return 0;
        int[] dp = new int[target+1];
        dp[0]=0;

        for(int i =1; i<=target;i++){
            int rightPos =0;
            int rightStep = 0;
            //move to right till passed i
            while (rightPos<i){
                rightStep++;
                rightPos = (1<<rightStep)-1;
            }
            //reach at i
            if(rightPos==i){
                dp[i]=rightStep;
                continue;
            }

            //passed i , revise back
            dp[i]=rightStep+1+ dp[rightPos-i];




        }
        return -1;
    }
}
