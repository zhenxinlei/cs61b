package Algorithm;

import java.util.ArrayList;
import java.util.List;


public class PathSum {
	 public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> res=new ArrayList<List<Integer>>();
	        List<Integer> path= new ArrayList<Integer>();
	        
	        res=helper(root,sum,path,res);
	        return res;
	    }
	    
	 public List<List<Integer>> helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res){
	        if (root==null) return res;
	        path.add(root.val); //put root to the path,
	        if (root.left==null&&root.right==null&&root.val==sum){
	        	List<Integer> list=new ArrayList<Integer>();  //copy element in path, and add path to result list;
	        	list.addAll(path);
	           res.add(list);
	        }
	        if (root.left!=null){
	            helper(root.left,sum-root.val,path,res);
	        }
	        if (root.right!=null){
	            helper(root.right,sum-root.val,path,res);
	        }
	        path.remove(path.size()-1); //remove the node just visited, in order to visit root.right node in next recursion  
	        return res;
	    }
	
	 public static void main (String[] arg){
		 TreeNode root=new TreeNode(5);
		 TreeNode l=new TreeNode(4);
		 TreeNode r=new TreeNode(8);
		 
		 root.left=l;
		 root.right=r;
		 
		 PathSum ps=new PathSum();
		 List<List<Integer>> res=ps.pathSum(root, 13);
		 
	 }

}
