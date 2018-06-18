package Algorithm;

import java.util.Arrays;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 
Each element in the array represents your maximum jump length at that position. 

Determine if you are able to reach the last index. 

For example:
 A = [2,3,1,1,4], return true. 

A = [3,2,1,0,4], return 

 * 
 */

public class JumpGame {
 public boolean solution(int nums[]){
	 //if (nums.length==1) return true;
	 
	 boolean[] result=new boolean [nums.length];
	 Arrays.fill(result, false);
	 
	 result[nums.length-1]=true;
	 
	 
	 for(int i=nums.length-1;i>=0;--i){
		 if (nums[i]!=0){
			 int j=nums[i];
			 if (j>=nums.length-1-i) {
				 result[i]=true;
				 continue;
			 }
			 for (;j>0;j--){
				 result[i]=(result[i+j]||result[i])?true:false;
				 if (result[i]){ 
					 
					 break;
				 }
					 
			 }
		 }
	 }
	 
	 return result[0];
 }
 
 public boolean canJump(int[] nums) {
     int needStepAmt = 1;
     for(int i = nums.length-2; i>=0; i--){
         if(nums[i] < needStepAmt){
             needStepAmt++;
             continue;
         }
         needStepAmt = 1;
     }
     return needStepAmt==1;
 }
 
 public static void main (String[] arg){
	 	JumpGame cj=new JumpGame();
	 	int [] nums={3,2,1,1,4};
		System.err.println(cj.solution(nums));
		
		System.err.println(cj.canJump(nums));
		
		
	}
}
