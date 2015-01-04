package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/** 
 * 
 * @author Zhenxin Lei
 *	not finished 
 *
 */
public class BinaryTreeLevelOrderTraversal {
	
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        
        
	     
        if (root==null) return  new ArrayList<List<Integer>>();
         
         
        
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<TreeNode> curStack =new LinkedList<TreeNode>();
        List<TreeNode> nextStack =new LinkedList<TreeNode>();
        curStack.add(root);
        TreeNode curNode=null;
        List<Integer> curList=new ArrayList<Integer>();
         result.add(curList);
       
         
         
         int level=0;
        while (!curStack.isEmpty()){
            curNode=((LinkedList<TreeNode>) curStack).pollFirst();
            curList=result.get(level);
            curList.add(curNode.val);
            
            if (curNode.left!=null) nextStack.add(curNode.left);
            if (curNode.right!=null) nextStack.add(curNode.right);
            
            if (curStack.isEmpty()&&!nextStack.isEmpty()) {
                //Collections.copy(curStack,nextStack);
                curStack= new LinkedList<TreeNode>(nextStack);
                nextStack.removeAll(nextStack);
                List<Integer> newList=new ArrayList<Integer>();
                result.add(newList);
                level+=1;
            }
            
        }
        return result;
        
        
    }

	
	
	public static void main (String[] arg){
		TreeNode node=new TreeNode(1);
		TreeNode left=new TreeNode(2);
		node.left=left;
		BinaryTreeLevelOrderTraversal lt=new BinaryTreeLevelOrderTraversal();
		List<List<Integer>> result =lt.levelOrder(node);
		
	}

}
