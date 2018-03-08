package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
	
	public List<List<Integer>> permute(int[] num) {
	    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
	    res.add(new ArrayList<Integer>());
	    for (int n : num) {
	        int size = res.size();
	        for (; size > 0; size--) {
	            List<Integer> r =  res.pollFirst();
	            for (int i = 0; i <= r.size(); i++) {
	                List<Integer> t = new ArrayList<Integer>(r);
	                t.add(i, n); // add new element in between. 
	                res.add(t);
	            }
	        }
	    }
	    return res;
	}

	
	public static void main(String[] arg){
		int[] num={1,2,3};
		Permutations p=new Permutations();
		String str=p.permute(num).toString();
		System.err.println(str);
		
	}

}