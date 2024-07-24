package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Inpurt:  {3,9,20,#,#,15,7}
Output: [[9],[3,15],[20],[7]]
Explanation:
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7

map <level, node>



 }
 */
public class BinaryTreeVerticalOrderTraversal {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        int col;

        TreeNode(int val ){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root= contractTree();
        List<List<Integer>> res = solution(root);
        System.out.println(res);
    }

    public static TreeNode contractTree(){
        TreeNode root = new TreeNode(3);
        TreeNode tmp = root;
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        tmp.left = left;
        tmp.right = right;

        tmp= left;
        tmp.left = new TreeNode(1);
        tmp.right = new TreeNode(4);

        tmp = right;
        tmp.left = new TreeNode(15);
        tmp.right = new TreeNode(7);
        return root;

    }

    public static List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> res= new ArrayList<>();
        List<TreeNode> q = new ArrayList<>();
        List<TreeNode> nxt_q = new ArrayList<>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();

        q.add(root);
        root.col=0;
        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (q.size()>0){
           TreeNode node =  q.remove(0);
           if(node==null){
               System.out.println(" node is null ");
           }
            List<TreeNode> list = map.getOrDefault(node.col, new ArrayList<TreeNode>());
            list.add(node);
            map.put(node.col, list);
           min  = Math.min(min, node.col);
           max = Math.max(max, node.col);
           if( node.left!=null) {
               node.left.col = node.col-1;
               nxt_q.add(node.left);
           }
           if(node.right!=null) {
               node.right.col = node.col + 1;
               nxt_q.add(node.right);
           }

           if(q.isEmpty()&& !nxt_q.isEmpty()){
               q.addAll(nxt_q);
               nxt_q.clear();
           }
        }
        for(int i = min; i<=max;i++){
            List<Integer> list = new ArrayList<>();
            for(TreeNode node : map.get(i)){
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }
}
