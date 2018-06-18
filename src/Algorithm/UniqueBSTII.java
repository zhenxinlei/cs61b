package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {
	public List<TreeNode> generateTrees(int n) {
        if (n<= 0)
            return  new ArrayList<>();
        
        return genTree(1,n);
    }
    
    private List<TreeNode> genTree(int s, int e){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (s>e){
            result.add(null);
            return result;
        }
        
        List<TreeNode> leftSub;
        List<TreeNode> rightSub;
        for ( int i =s; i<=e; i++){
            leftSub = genTree(s, i-1);
            rightSub = genTree(i+1,e);
            
            for (TreeNode leftNode : leftSub) {
                for (TreeNode rightNode : rightSub) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
            
        }
        return result;
        
    }
    
    public static void main (String[] arg){
    	UniqueBSTII bst = new UniqueBSTII();
    	bst.generateTrees(2);
    }

}





/*class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}*/
