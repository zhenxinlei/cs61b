package Algorithm;

import java.util.Arrays;

/**
 * 31 NextPermutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * /////////////   THOUGHT    ///////////////////
 *
 *  1,2,3,4,5  -> 1,2,3,5,4 ( has lager number on right )  swap last two
 *  1,2,3,4,1 ->  1,2,4,3,1 -> 1,2,4,1,3 ( swap 3,4 then 1,3)
 *  4,2, 3, 1 -> 4,3,1,2
 *
 *  1,2,3,2,1 ->  i: point to last digit has lager number on right
 *                j: point to last digit has smaller number on left
 *
 *  Think from back ,
 *
 *   4,2,1, 2, 4, 4,3,3,1-> 2 is the first descending number, swap 2, and the last higher number 4, 4,3,3,1 (the 2nd 3)
 *  4,2,1, 3, 4, 4,3,2,1  ->  swap 2, and the last higher number 4, 4,3,3,1 (the 2nd 3) right part is the max Permutation
 *                              thus get the next perm have to swap 2, and next higher number (3)
 *                              become 4,4,3,2,1 and this it the max perm, reverse it to get min perm
 *  4,2,1, 3, 1,2,3,4,4 -> reverse 4, 4,3,2,1   -> 1,2,3,4,4
 *
 *
 */


public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,2,3,1};
        System.out.println("case 1 [4,2,3,1,2]");
        nextPermutation(nums);

        nums = new int[]{1,2,3,4,5};
        System.out.println("case 2");
        nextPermutation(nums);

        nums = new int[]{4,3,2,1};
        System.out.println("case 3");
        nextPermutation(nums);

        nums = new int[]{2};
        System.out.println("case 4");
        nextPermutation(nums);

        nums = new int[]{3,3,3};
        System.out.println("case 5");
        nextPermutation(nums);

        nums = new int[]{2,2,4,4,2,3,1};// 2,2,4,4,3,1,2
        System.out.println("case 6");
        nextPermutation(nums);

        nums = new int[]{1,3,2};// 2,1,3
        System.out.println("case 7");
        nextPermutation(nums);

    }

    public static void nextPermutation(int[] nums) {
        int i=-1, j =-1;

        for (int k=0;k<nums.length-1; k++){
            if( nums[k]<nums[k+1]){
                i=k;


            }

            if( nums[k]>nums[k+1]){
                j=k;
            }



        }

        if(j==-1 && i!=-1&& i == nums.length-2){
            //System.out.println("ascending ");
            int tmp = nums[i+1];
            nums[i+1]=nums[i];
            nums[i]=tmp;
            System.out.println("ascending "+ Arrays.toString(nums));
            return;
        }

        if ( i==-1 && j!=-1 && j== nums.length-2 ){
            //descending
            Arrays.sort(nums);
            System.out.println("descending "+ Arrays.toString(nums));
            return;
        }

        if ( i!=-1 && j!=-1){
            System.out.println(" i="+ i+" j="+j);
            if ( j<i){
                int tmp = nums[i+1];
                nums[i+1]=nums[i];
                nums[i]=tmp;
                Arrays.sort(nums, i+1, nums.length);
            } else if ( i<j){
                int tmp = nums[i+1];
                nums[i+1]=nums[i];
                nums[i]=tmp;
                Arrays.sort(nums, i+1, nums.length);
            }


            System.out.println("result  "+ Arrays.toString(nums));
        }

        System.out.println(" i="+ i+" j="+j);


    }
}
