package Algorithm;

public class MaximumScoreOfAGoodSubarray {
    public static void main(String[] args) {
        int res = solution(new int[]{1,4,3,7,4,5},3);
        System.out.println(res);
    }
    public static int solution(int[] nums , int k ){
        //start at K, expand i, j
        int i = k;
        int j = k;
        int res = nums[k];
        int min = nums[k];
        while(i>0 || j<nums.length-1){
            if(i==0)
                j++;
            else if (j==nums.length-1)
                i--;
            else if(nums[j+1]> nums[i-1]){
                j++;
            } else if(  nums[j+1]< nums[i-1]) {
                i--;
            }

            min = Math.min(min,Math.min(nums[i],nums[j]));
            res = Math.max(res, min* (j-i+1));

        }
        return res;

    }
}
