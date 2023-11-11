package TwoSigma;

import Algorithm.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitTree {
    /*
    water flow
    find smallest diff of flow by spliting tree of drain system
     */
    public static void main(String[] args) {
        int[] parent = new int[]{
                -1, 0, 0, 1, 1, 2
        };
        int[] input = new int[]{
                1, 2, 2, 1, 1, 1
        };

        solution(parent, input);

        parent = new int[]{
                -1, 0, 1,2
        };
         input = new int[]{
                1, 4,3,4
        };

        solution(parent, input);
    }

    static int MIN_DIFF = Integer.MAX_VALUE;

    public static int solution(int[] parent, int[] input) {
        TreeNode root = contractTree(parent, input);
        int totalFlow = 0;
        for (int i : input) {
            totalFlow += i;
        }
        MIN_DIFF= Integer.MAX_VALUE;
        getFlow(root, totalFlow);

        System.out.println(MIN_DIFF);
        return MIN_DIFF;
    }

    public static int getFlow(TreeNode node, int totalFlow) {
        if (node == null)
            return 0;
        int total = node.input;
        for (TreeNode child : node.child) {
            total += getFlow(child, totalFlow);
        }

        if(node.id!=0) {
            MIN_DIFF = Math.min(MIN_DIFF, Math.abs(totalFlow - 2* total));
            if (MIN_DIFF == Math.abs(totalFlow - total)) {
                System.out.println(" total " + total + " id " + node.id + " min diff " + MIN_DIFF);
            }
        }
        return total;
    }

    public static class TreeNode {
        int id;
        int input;
        TreeNode parent;
        ArrayList<TreeNode> child = new ArrayList<>();
    }

    public static TreeNode contractTree(int[] parent, int[] input) {
        TreeNode root = new TreeNode();
        root.id = 0;
        root.input = input[root.id];


        Map<Integer, TreeNode> idToNode = new HashMap<>();
        idToNode.put(0, root);
        for (int i = 1; i < parent.length; i++) {
            TreeNode node = new TreeNode();
            node.id = i;
            node.input = input[node.id];
            //System.out.println(parent[i]+" , "+i );
            TreeNode p = idToNode.get(parent[i]);
            p.child.add(node);
            node.parent = p;
            idToNode.put(node.id, node);
        }

        return root;
    }
}
