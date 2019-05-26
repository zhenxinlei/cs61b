package Algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author ZhenxinLei
 * 
 * leet code 220
 * Given an array of integers, find out whether there are two distinct indices i and j 
 * in the array such that the absolute difference between nums[i] and nums[j] 
 * is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false

 *
 */
public class ContainDuplicate3 {
	
	public static boolean isContainDuplicate(int[] arr , int k , int t){
		
		Set<Integer> lowBounds = new HashSet<>();
		
		int i = 0;
		for ( int j =0 ; j < arr.length; j++){
			int lowB = arr[j]-t;
			if( j-i > k ){
				lowBounds.remove(lowB);
				i++;
			}
			else if ( lowBounds.contains(lowB)){
				return true;
			} else{
				lowBounds.add(lowB);
				//i++; 
			}
			
			//tmp
		}
		
		return false;
	}
	

}
