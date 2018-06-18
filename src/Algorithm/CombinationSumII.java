package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {
public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        return dsf( candidates,  target,0);
        
    }
    
    
    public static List<List<Integer>> dsf(int[] array, int target, int cIdx){

       if (cIdx>array.length-1)
           return  new ArrayList<List<Integer>>();
       
       //System.out.println("  target "+target+",  value  cid "+ cIdx+", "+array.length);
       System.out.println("  target "+target+",  value "+ array[cIdx]+ " cid "+ cIdx);
        
        if (array[cIdx]>target){
            return dsf( array,  target,  cIdx+1);
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (array[cIdx]==target && cIdx == array.length-1 ){
             List<Integer> tmp = new ArrayList<>();
            tmp.add(array[cIdx]);
            result.add(tmp);
            return result;
        } 
        else if(array[cIdx]==target && cIdx < array.length-1){
        	List<Integer> tmp = new ArrayList<>();
            tmp.add(array[cIdx]);
            
            
            List<List<Integer>> tmp_1 = dsf( array,  target,  cIdx+1);
            for (int i =0 ;i<tmp_1.size(); i++){
                tmp_1.get(i).add(array[cIdx]);
            }
            
            tmp_1.add(tmp);
            
            return tmp_1;
            
        }
        else if (array[cIdx]<target){
            List<List<Integer>> tmp = dsf( array,  target-array[cIdx],  cIdx+1);
            List<List<Integer>> tmp_1=dsf( array,  target,  cIdx+1);
            
            for (int i =0 ;i<tmp.size(); i ++){
                tmp.get(i).add(array[cIdx]);
            }
            
            for (int i =0 ;i<tmp_1.size(); i ++){
                tmp_1.get(i).add(array[cIdx]);
                tmp.add(tmp_1.get(i));
            }
            
            
            return tmp;
        }
        
        return result;
        
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> result = CombinationSumII.combinationSum2(new int[]{10,1,2,7,5}, 8);
    	for (List<Integer> list : result){
    		System.out.println("[");
    		for (Integer i : list){
    			System.out.print(","+i);
    		}
    		System.out.print("]");
    		
    	}
	}
}
