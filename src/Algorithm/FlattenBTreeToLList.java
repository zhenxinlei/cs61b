package Algorithm;

import java.util.Stack;

public class FlattenBTreeToLList {

	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {

			// push all element to buttom of stack, right will keep origal
			// sturture
			if (p.right != null) {
				stack.push(p.right);
			}
			// move left node to right
			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			}
			// pop node and point left node to the poped node
			else if (!stack.empty()) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}

			p = p.right;
		}
	}

	public static void main(String[] arg) {
		TreeNode root = new TreeNode(0);

		FlattenBTreeToLList btl = new FlattenBTreeToLList();
		btl.flatten(root);

	}
}
