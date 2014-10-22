package Algorithm;
import java.lang.*;

	public class FindNthLargest{
	    
	    public Integer find(Integer[] a, int n){
	    	Integer [] temp= new Integer [n+1]; 
	        for (int i =0; i <=n; i++){
	          temp[i] =a[i]; 
	        }
	        int i=n;
	        while ( a[i]!=null){
	            temp[n]=a[i];
	            int j=n;
	           for ( j =n ; j>0;j--){
	        	   if ( temp[j]>temp[j-1]){
	            	Integer temp1= temp[j-1];
	                temp[j-1]=temp[j];
	                temp[j]=temp1;
	        	   }
	                //j--;
	            }
	            i++;
	        }
	        return temp[n-1];
	        
	    }
	    

	     public static void main(String []args){
	        System.out.println("Hello World");
	        FindNthLargest f=new FindNthLargest();
	        Integer [] a ={4,2,1,5,1,1,4,5,9,10,11,14,12};
	        Integer print=f.find(a,4);
	        System.out.println("Hello World: "+print);
	     }
	}


