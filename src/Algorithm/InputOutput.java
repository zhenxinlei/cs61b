package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DataStructures.TreeNode;

public class InputOutput {
	
	public static int[] scannIntegerArray(){
		System.err.println("Input integers seperated with whitespace (end with none interger char): ");
		
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		while (scanner.hasNextInt())
		{
		  list.add(scanner.nextInt());
		  
		}
		//Integer[] arr = list.toArray(new Integer[list.size()]);
		int [] ret=new int[list.size()];
		for(int i = 0;i < ret.length;i++)
		    ret[i] = list.get(i);
		
        return ret;

	}
	
	public static void printBST(TreeNode root){
		if(root==null) return;
			printBST(root.left);
			System.out.print(root.val+", ");
			printBST(root.right);
		
		return ;
	}
	
	public static Integer[] intToWapperArray(int[] array){
		Integer[] wArray=new Integer[array.length];
		for (int i=0;i<array.length;i++){
			wArray[i]=(Integer)array[i];
		}
		return wArray;
		
	}
	
	public static void main(String[] args) {
		int []a =InputOutput.scannIntegerArray();
		for (int elem: a){
		System.err.println(elem);
		}
	}

}
