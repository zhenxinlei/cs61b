package Algorithm;

import java.util.HashMap;

public class NumberOfArithmeticSlices {

    public static void main(String[] args) {
        int res = numberOfArithmeticSlices(new int[]{2,4,6,8,9,10});
    }

    public static int numberOfArithmeticSlices(int[] nums){
        int n = nums.length;
        int ans=0;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for(int i =0; i<n;i++)
            dp[i]= new HashMap<>();

        for(int i =0;i<n;i++){
            for (int j = 0;j<i;j++){
                long diff = nums[i]-nums[j];

                int count = dp[j].getOrDefault(diff,0);
                dp[i].put(diff, dp[i].getOrDefault(diff,0)+ count+1);
                ans+=count;
            }
        }
        return ans;
    }

}
