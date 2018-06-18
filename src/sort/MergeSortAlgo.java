package sort;

import java.util.Arrays;

import javax.crypto.AEADBadTagException;

public class MergeSortAlgo {


	
	public static void main(String[] args) {
		
		//Test1 
		int [] arr = new int[]{3,6,1,8,2,9,4,0,3,2,5,1,4,6,7};
		
		MergeSortAlgo.mergeSortArray(arr, 0, arr.length-1);
		
		for (int i : arr) {
			System.out.print(i+", ");
		}
		
	}
	
	
	// O(nLogn)
	public static void mergeSortArray(int[] array, int lo, int hi  ){
		
		if (lo < hi ){
		
		int mid = (lo + hi)/2;
		
		mergeSortArray(array, lo, mid);
		mergeSortArray(array, mid + 1, hi);
		
		merge(array, lo , mid, hi  );
		
		
		}
		
		
		
	}
	
	private static void inplaceMerge(int[] array, int lo , int mid , int hi){
		int leftsize = mid-lo +1; // include mid 
		int rightsize = hi -mid; //  include hi
		
		
		int i=0, j=0 ,k=lo;
		
		
		
		
	}

	private static void merge(int[] array, int lo , int mid , int hi) {
		
		int leftsize = mid-lo +1; // include mid 
		int rightsize = hi -mid; //  include hi
		
		int[] left = new int[leftsize];
		int[] right = new int[rightsize];
		
		for (int i =0; i< leftsize; i++){
			left[i]=array[lo+i];
		}
		
		for (int i =0; i< rightsize; i++){
			right[i]= array[mid+i+1];
			
		}
		
		int i=0, j=0;
		int k = lo;
		while ( i < leftsize && j < rightsize){
			if (left[i]< right[j]){
				array[k]= left[i];
				++i;
				++k;
			} else {
				array[k]=right[j];
				++j;
				++k;
			}
		}
		
		//System.out.println("i,j "+ i+", "+ j+", lo "+lo+", mid "+ mid+ ", hi "+hi);
		
		while ( i< leftsize){
			array[k]=left[i];
			++i;
			++k;
		}
		
		while ( j< rightsize){
			array[k]=right[j];
			++j;
			++k;
		}
	}
}
