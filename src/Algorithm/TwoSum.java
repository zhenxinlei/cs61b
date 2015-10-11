package Algorithm;
import java.util.ArrayList;


public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int residual[]=new int [nums.length];
        int[] result=new int[2];
        ArrayList resi=new ArrayList();
        int temp=0,i=0;
        
        for ( i=0;i<nums.length;i++){
            temp=target-nums[i];
            residual[i]=temp;
        }
        boolean found=false;
        for ( i=0;i<=nums.length-1;i++){
        	if (!found&&nums[i]!=residual[i]&&nums[i]+residual[i]==target){
                result[0]=i+1;
                //result[1]=nums.length-1-i+1;
                found=true;
                continue;
            }
        	if (found&&nums[i]!=residual[i]&&nums[i]+residual[i]==target){
                result[1]=i+1;
                //result[1]=nums.length-1-i+1;
                break;
            }
        }
        
        return result;
    }
	
	public static void main(String[] arg){
		TwoSum t=new TwoSum();
		int [] a={3,2,3};
		System.err.println(t.twoSum(a, 6).toString());
		
	}
}
