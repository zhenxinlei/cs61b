package Algorithm;



import java.util.Arrays;
import java.util.Comparator;

public class LargestNumbers {
	public String solution(int [] nums){
		String result="";
		
		String[] NUMS = new String[nums.length];
		
		for(int c=0 ; c<nums.length;c++){
			NUMS[c]=Integer.toString(nums[c]);
		}
		
		Arrays.sort(NUMS, new Comparator<String>(){
			public int compare(String left,String right){
				String leftRight=left.concat(right);
				String rightLeft=right.concat(left);
				return rightLeft.compareTo(leftRight);
			}
		});
		
		for(int c=0 ; c<NUMS.length;c++){
			result=result.concat(NUMS[c]);
		}
		
		if (result.charAt(0)=='0') return "0";
		
		return result;
	}
	
	public static void main (String[] arg){
		LargestNumbers cj=new LargestNumbers();
		int nums[]={99999, 9999997, 99998, 99995, 99996};
		
		System.err.println(cj.solution(nums));
		
		Integer i=2;
		String.format("%5s", i);
		System.err.println(i);
	}

}
