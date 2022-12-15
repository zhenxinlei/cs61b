package Algorithm;

public class MaxConsecutiveOnesIII {
    /*
    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6
    Explanation: [1,1,1,0,0,1,1,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

    2pointer l , r , l = left most 0 , r = right most 0
    if i reach 0 , and k < 0, l++ ,
        1 0 0  1 1 1 1 1 0 0 0
          i j
            i            j
               i            j
                           i j // if k < 0, loop i++ st k==0,
     len = j-i+1


    preSum
    11100011110
    12333345677
     */


    public static int solution (int nums[], int K){
        int i = 0, j; // i left  , j right (not included )
        //11100011
        //   i j
        for (j = 0; j < nums.length; ++j) {
            if (nums[j] == 0) K--;
            if (K < 0 ){
                if(nums[i]==0){
                    K++;
                }
                i++;
            }
            System.out.println(" j "+j+" i "+i+" range "+(j-i)+" k "+K);
        }
        return j - i; //not inclue j, since ++j in loop
    }


    public static int solution2 (int nums[], int K){
        int i = 0, j; // i left  , j right (not included )
        //11100011
        //   i j
        int res = 0;
        int ct =0;//count zero
        for (j = 0; j < nums.length; ++j) {
           if(nums[j]==0){ //if j meet condition, ct++
               ct++;
           }

           while(ct>K){  //while not meet condition , i++ , and if ( meet again , ct--
               if(nums[i]==0)
                   ct--;
               i++;
           }

           res = Math.max(j-i+1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int res = solution(nums,2);

        System.out.println("res "+res);

        nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
         res = solution2(nums,2);

        System.out.println("res "+res);

    }
}
