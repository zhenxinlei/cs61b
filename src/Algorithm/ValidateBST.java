package Algorithm;

import DataStructures.TreeNode;

public class ValidateBST {
	
	public  boolean isValidBST(TreeNode root){
		if (root==null) return true;
		
		
		
		
	}
	
	
	
	public boolean solution(TreeNode root){
		
		
		
		
		
		
		if (root.left!=null && root.val<root.left.val) return false;
		if (root.right!=null && root.val>root.right.val) return false;
		
		return solution(root.left)&&solution(root.right);
	}
	
	 

}
