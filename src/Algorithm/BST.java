package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import DataStructures.Node;
import DataStructures.TreeNode;
import java.util.*;

public class BST <T extends Comparable>{

	public static <T> TreeNode<T> toBST(T[] array){
		if(array==null ||array.length==0)return null;
		
		Arrays.sort(array);
		TreeNode<T> root=toBST(array,0,array.length-1);
			
		return root;
		
	}
	
	public static <T> TreeNode<T> toBST(T[] array, int lo,int hi){
		
		if (lo>hi) return null; 
		
		int mid=lo+(hi-lo)/2;
		TreeNode<T> root=new TreeNode<T>(array[mid]);
		
		root.left=toBST(array,lo,mid-1);
		root.right=toBST(array,mid+1,hi);
			
		return root;
	}
	
	public static void printBST(TreeNode root){
		if(root==null) return;
			printBST(root.left);
			System.out.print(root.val+", ");
			printBST(root.right);
		
		return ;
	}
	
	public static<T> List<List<T>> toLinkedList(TreeNode root){
		List<List<T>> result=new ArrayList<List<T>>();
		if (root==null) return result;
		LinkedList<TreeNode> curlevel=new LinkedList<TreeNode>();
		LinkedList<TreeNode> nextlevel=new LinkedList<TreeNode>();
		LinkedList<T> temp=new LinkedList<T>();
		
		curlevel.add( root);
		TreeNode curNode=null;
		//queue.add((T) root);
		//int level=0;
		while (!curlevel.isEmpty()){
			curNode= curlevel.removeFirst();
			temp.add((T) curNode.val);
			if (curNode.left!=null) nextlevel.add(curNode.left);
			if (curNode.right!=null) nextlevel.add(curNode.right);
			
			if (curlevel.isEmpty()){
				curlevel.addAll(nextlevel);
				nextlevel.clear();
				
				result.add(new LinkedList<T>(temp));
				temp.clear();
				
			}
			
			
		}
		
		
		return result;
		
	}
	
	
	public static void main(String[] args) {
		int [] a=InputOutput.scannIntegerArray();
		Integer[] aI=InputOutput.intToWapperArray(a);
		
		TreeNode<Integer> root=BST.toBST(aI);
		//InputOutput.printBST(root);
		List<List<Integer>> ll=BST.toLinkedList(root);
		//for (int i=0;i<ll.size();i++){
			System.err.println(ll);
		//}
		
		
	}
}
