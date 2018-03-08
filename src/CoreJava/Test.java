package CoreJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.runner.manipulation.Sortable;

public class Test {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    
	    while ((s = in.readLine()) != null) {
	     // System.out.println(s);
	    }
	    
	    
	    String[] st = s.split(" ");
	    int[] arr=new int[st.length];
	    for(int i=0; i<st.length;i++){
	    	arr[i]=Integer.parseInt(st[i]);
	    }
	    
	    System.out.println(solution(arr));
	  }
	
	public static int solution(int[] arr){
	      if (arr.length==0) return 0;
	      int sum=arr[0];
	      int newSum=arr[0];
	      for(int i=1; i <arr.length;i++){
	          newSum=Math.max(newSum+arr[i],arr[i]);
	          sum=Math.max(newSum, sum);
	      }
	      
	      if (sum<0) return 0;
	      return sum;
	  }
}
