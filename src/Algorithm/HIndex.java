package Algorithm;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author ZhenxinLei
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

   According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

    For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 */

public class HIndex {
	
public int hIndex(int[] citations) {
        
        //if HIndex is 2, means atleast 2 paper greater than 2, others lessthan 2 
       /** 
        3 0 6 1 5
        size =5
       h-index max_i [min (f(i),i)]
        **/
        
       //Arrays.sort(citations,  Collections.reverseOrder()); 
       
       reverseQuicksort(citations, 0, citations.length-1);
       
       for (int i : citations) {
    	   System.err.println(i);
		
	}
       
       
       int max_i=0;
       for (int i=0; i<citations.length;i++){
           int temp=Math.min(citations[i],i+1);
           max_i=Math.max(temp,max_i);
       }
       return max_i;
        
    }

public static void main(String[] args) {
	HIndex hindex=new HIndex();
	int[] a={3,0,6,1,5};
	System.err.println(hindex.hIndex(a));
}

private void reverseQuicksort(int[] citations, int lo, int hi) {
	if (lo<hi){
	int pivot = reversePartition(citations, lo, hi);
	
	reverseQuicksort(citations, lo, pivot-1);
	reverseQuicksort(citations, pivot+1, hi);
	}
	
	
}

private int reversePartition(int[] citations, int lo, int hi) {
	int pivot = lo + (hi-lo)/2;
	int pivotValue=citations[pivot];
	
	swap(citations, pivot, lo);
	
	int storeIndex=lo-1;
	for (int i=lo; i<=hi; i++){
		if (citations[i]>=pivotValue){
			
			storeIndex++;
			swap(citations, storeIndex, i);
			
		}
		
		
	}
	
	swap(citations, lo, storeIndex);
	return storeIndex;
}

private void swap(int[] citations, int j, int i) {
	int temp=citations[j];
	citations[j]=citations[i];
	citations[i]=temp;
	
}

}
