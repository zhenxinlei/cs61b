package CoreJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    while ((s = in.readLine()) != null) {
	        long a= Long.parseLong(s);
	        
	      System.out.println(solution(a));
	    }
	    
	    
	  }
	  
	  
	  
	   public static String solution(long a){
		   String num1[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		     String num10[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	        String num1000[]={"", "Thousand", "Million", "Billion"};
	    //if (a==0) return "";
	    long num=a ;
	    String rest="Dollars";
	    /*while (){
	        if (num==1){
	            System.out.println("OneDollar");
	            continue;
	        }
	    */    
	        
	        int uIndex=0;
	        while(num>0L){
	            long  temp = num%1000L;
	            int rem=(int) temp;
	            if ( rem !=0){
	                rest=Three(rem)+num1000[uIndex]+rest;
	            }
	            num/=1000L;
	            uIndex++;
	        }
	        
	   // }

		  return rest;
	  }
	  
	  public static String Three(int a){
	      String num1[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		     String num10[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	   if (a==0) return "";
	   String rest="";
	   if (a>=100){
	       rest=num1[a/100]+"Hundred";
	       a%=100;
	   }
	   if (a<=19L){
	       rest+=num1[a];
	       
	   }else{
	       rest+=num10[a/10];
	       a%=10;
	       if (a>0) rest+=num1[a];
	   }
	   return rest;
	  }
	  
}
