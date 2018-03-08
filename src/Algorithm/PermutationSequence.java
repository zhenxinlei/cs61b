package Algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */

public class PermutationSequence {
	
	List<Integer> per =new ArrayList<Integer>();
	
	public String getPermutation(int n, int k){
		
		List<Integer> array=new ArrayList<Integer>();
		String s="";
		
		k=k-1;
		for (int i=0; i <n;i++){
			array.add(i+1);
		}
		
		for(int j=0; j<n; j++){
			
			int per=permutation(array.size()-1);
			int i=0;
			while (per*i<=k){
				
				i=i+1; 
				
			}
			
			// k is between [i-1,i);
			k=k-per*(i-1);
			s=s+array.get(i-1);
			array.remove(i-1);
			
			
		}
		
		
		return s;
		
	}
	
	private int getFirstNumber( List<Integer> array,  int k ){
			
		int n=array.size()-1;
		
		int per=permutation(n);
		
		int i=0; 
		while (per*i<=k){
			
			i=i+1; 
			
		}
		
		
		// number is locate between i-1 to i
		
		
		int result=array.get(i-1);
		array.remove(i-1);
		
		
		return result ;
		
		
	}
	
	public int permutation(int n){
		if (per.isEmpty()) per.add(0, 1);
		if (per.size()>=(n+1)) return per.get(n);
		
		for (int i=per.size()-1;i<n;i++){
			per.add(per.get(i)*(i+1));
			
		}
		
		
		
		return per.get(n);
	}
	public static void main(String[] args) {
		PermutationSequence per=new PermutationSequence();
		Permutations per2=new Permutations();
		System.err.println(per.getPermutation(3, 4));
		
	}

}
