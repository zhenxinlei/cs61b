package Algorithm;

import java.util.*;

public class Permutations {
	
	public List<List<Integer>> permute(Integer[] num) {
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

	public void permute_sol2(LinkedList<List<Integer>> res, Integer[] num, int start) {

		// start is last element , no need to do permute
		// append entire array to result
		if (start==num.length-1){
			ArrayList<Integer> tmp =new ArrayList<>(Arrays.asList(num));
			res.add(tmp);
			return;
		}
		for ( int i = start; i<num.length; i ++) {
			//swap index and start
			SWAP(num, start, i);
			permute_sol2(res, num, start + 1);
			// swap back
			SWAP(num, start,i);
		}
		return ;
	}



	
	public static void main(String[] arg){
		Integer[] num={1,2,3};
		Permutations p=new Permutations();
		String str=p.permute(num).toString();
		System.err.println(str);

		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		p.permute_sol2(res, num, 0);
		//print2DList(res);
		System.out.println(res.toString());

		System.out.println(permutation(7, new HashMap<Integer, Integer>()));

		res.clear();
		practice_230314(num, 0,   res);
		System.out.println(res.toString());

	}


	//utils
	public static void SWAP (Integer nums[], int i , int j ){
		Integer tmp= nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}

	public static void print2DList(LinkedList<List<Integer>> res){

		for( List<Integer> list : res){
			System.out.print("[");
			for (Integer ele: list){
				System.out.print(ele+",");
			}
			System.out.print("],");
		}

	}


	public static int permutation(int num, Map<Integer, Integer> perm){
		//System.out.println(num+" "+perm);
		Integer ans = perm.get(num);
		if(ans==null){
			ans = 1;
			if(num!=1){
				ans = num*permutation(num-1,perm);
			}
			perm.put(num, ans);
		}
		return ans;
	}

	//function get permutaion of nums rangr from startId to end
	public static void practice_230314(Integer[] nums, int startId,  List<List<Integer>> res){
		if(startId==nums.length-1){//last one, only one permuation , copy nums to res
			ArrayList<Integer> tmp = new ArrayList<>(Arrays.asList(nums));
			res.add(tmp);
		}

		for(int i = startId;i< nums.length;i++){
			SWAP(nums,i, startId);//swap later number into startID,
			practice_230314(nums,startId+1,res);//get permutaion of nums range from startId+1 to end
			SWAP(nums, i , startId);
		}
	}



}
