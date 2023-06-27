package Algorithm;

import java.util.Arrays;

public class MaximumGap {
    public static void main(String[] args) {
        maximumGap(new int[]{1,1,1,1,1,5,5,5,5,5});
    }

    public static int maximumGap(int[] nums) {
       /*
          let say 4 elements
          min + g1 +g2 +g3 = max
          has 3 buckets
          |min, min+g1| min+g1, min+g1+g2 |   min+g1+g2, min+g1+g2+g3 |
        sort min and max in each bucket

     g1 +g2 +g3 >= max-min
        MaxGAP >= (min-max)/(n-1)
          if maxGap < above , means other < above ,then contracdicted
       */
        if(nums.length==1)
            return 0;
        int min = nums[0];
        int max = nums[0];
        for(int n: nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        if(min==max)
            return 0;
        int gap = (int) Math.ceil( (double)(max-min)/(nums.length-1));
        int[][] buckets = new int[nums.length+1][2];
        for (final int[] min_max : buckets) {
            Arrays.fill(min_max, -1);
        }

        //bucket : [ min+(k-1)*gap, min+ k*gap )
        for(int n : nums){
            int k =  (n-min)/gap;
            int[] loc_min_max = buckets[k];
            if(loc_min_max[0]==-1)
                loc_min_max[0]=n;
            if(loc_min_max[1]==-1)
                loc_min_max[1]=n;
            loc_min_max[0]=Math.min(n, loc_min_max[0]);
            loc_min_max[1]=Math.max(n, loc_min_max[1]);
        }

        int maxGap= 0;
        min = buckets[0][0];
        for ( int[] min_max : buckets) {
            if(min_max[0]==-1)
                continue;
            maxGap = Math.max(maxGap , min_max[0]-min);
            //maxGap = Math.max(maxGap , max-min);
            //maxGap = Math.max(maxGap , min_max[1]-min_max[0]);
            min=min_max[1];

        }
        return maxGap;
    }
}
