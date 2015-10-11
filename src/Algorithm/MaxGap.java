package Algorithm;
/**
 * 
 * @author ZhenxinLei
 *Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaxGap {
	
	 public int maximumGap(int[] nums) {
	        if (nums.length<2) return 0;
	        
	        
	       
	        
	       int lo=Math.min(nums[0],nums[1]);
	        int hi=Math.max(nums[0],nums[1]);
	        
	        int maxgap= Math.abs(hi-lo);
	        
	        for ( int i=1; i<nums.length;i++){
	            if (nums[i]==lo || nums[i]==hi){
	                continue;
	            }
	            
	            if (nums[i]<hi && nums[i]>lo){ //in between
	            maxgap=Math.max(nums[i]-lo, hi-nums[i]);
	            //update hi, lo
	                
	            }
	            if (nums[i]<lo){
	                maxgap=Math.max(maxgap, lo-nums[i]);
	            }
	            if (nums[i]>hi){
	                maxgap=Math.max(maxgap, nums[i]-hi);
	            }
	        }
	        
	        return maxgap;
	    }
	 
	 public static void main(String[] args) {
		MaxGap mg =new MaxGap();
		int [] a={0,7,1,2,3,4,5};
	}

}
