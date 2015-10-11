package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
       /* Stack<Integer> mainStk=new Stack<Integer>();
        
        List<Integer> resultList=new ArrayList<Integer>();*/
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        
       /* int i=n;
        //load stack
        while(i>0){
        	mainStk.push(i--);
        }
        
        for (i=1;i<=n-k+1;i++){
        	resultList.clear();
        	resultList.add(i);
        	if (k==1){
        		result.add(new ArrayList<Integer>(resultList));
    			continue;
        	}
        	secondNum:
        	for (int l=i+1; l<=i+k-1;l++){
        		
        		int j=l;
        		
        		while (j<=i+k-1){
        		
        		if (j<=i+k-1) resultList.add(j++);
        			
        		if (j>=i+k-1){
        			//for (;j<=n;j++){
        			while (resultList.size()<3&&j<=n){
        			resultList.add(j++);
        			result.add(new ArrayList<Integer>(resultList));
        			resultList.remove(k-1);
        			}
        			
        			resultList.clear();
                	resultList.add(i);
        			continue secondNum;
        		}
        		
        		
        		
        		}
        	}
        	
        	
        }*/
        ArrayList<Integer> path=new ArrayList<Integer>(Collections.nCopies(k, 0));
        result=combine_2(n, k, result, path);
        
        return result;
        
    }
    
    public List<List<Integer>> combine_2(int n, int k,List<List<Integer>> result, ArrayList<Integer> path ) {
		if (k==0){
			result.add(new ArrayList<Integer>(path));
			return result;
		}
		
		for (int i=n; i>=1;i--){
				path.set(k-1, i);
				
				result= combine_2(i-1, k-1, result, path);
		}
    	
    	
    	return result;
    
    }
    
    public static void main(String[] arg){
    	Combinations c=new Combinations();
    	List<List<Integer>>a=c.combine(4, 3);
    	System.out.print(a.toString());
    }
}
