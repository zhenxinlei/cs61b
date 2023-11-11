package Algorithm.tiktok;

import java.util.Arrays;

public class minAbsSumDiff {
    /*
    input {1,4,1}, select one element and discount to half price
        sum :    |0-4|+ |4-1| = 7
         |1-2|+ |2-1| = 2
          |1-4|+ |4-0| = 7
          return 2
     */
    public static void main(String[] args) {
        int nums[]=new int[]{1,4,1};
        int sol =0;
        sol = solution(nums);

    }

    public static int solution (int[] nums){
        int totalCost = 0;
        for( int i =1;i<nums.length;i++){
            totalCost+=Math.abs(nums[i]-nums[i-1]);
        }

        int[] updatedCost = new int[nums.length];
        int minCost = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                int orig = Math.abs(nums[i]-nums[i+1]);
                int diff = Math.abs(nums[i]/2-nums[i+1]);
                updatedCost[i]=totalCost-orig+diff;
            } else if( i==nums.length-1){
                int orig = Math.abs(nums[i]-nums[i-1]);
                int diff = Math.abs(nums[i]/2-nums[i-1]);
                updatedCost[i]=totalCost-orig+diff;
            } else {
                int orig = Math.abs(nums[i]-nums[i-1])+Math.abs(nums[i]-nums[i+1]);
                int diff = Math.abs(nums[i]/2-nums[i-1])+Math.abs(nums[i]/2-nums[i+1]);
                updatedCost[i]=totalCost-orig+diff;
            }
            minCost = Math.min(updatedCost[i],minCost);
        }
       System.out.println(" minCost "+minCost);
    return minCost;

    }
}
