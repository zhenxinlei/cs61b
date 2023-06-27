package sort;

import java.util.Arrays;

import javax.crypto.AEADBadTagException;

public class MergeSortAlgo {


	
	public static void main(String[] args) {
		
		//Test1 
		int [] arr = new int[]{3,6,1,8,2,9,4,0,3,2,5,1,4,6,7};
		
		MergeSortAlgo.mergeSortArray(arr, 0, arr.length-1);

		System.out.println(Arrays.toString(arr));



		arr = new int[]{3,6,1,8,2,9,4,0,3,2,5,1,4,6,7};
		MergeSortAlgo.inPlaceMergeSortArray(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
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

	public static void inPlaceMergeSortArray(int[] array, int lo, int hi  ){

		if (lo < hi ){

			int mid = (lo + hi)/2;

			mergeSortArray(array, lo, mid);
			mergeSortArray(array, mid + 1, hi);

			inPlaceMerge(array, lo , mid, hi  );


		}
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


	private static void inPlaceMerge(int[] array, int lo , int mid , int hi) {
		int leftId= lo;
		int rightId = mid+1;

		while(leftId<=mid && rightId<=hi){
			if(array[leftId]<=array[rightId]){
				leftId++;
			} else {
				int value = array[rightId];
				int idx = rightId;

				//shift leftId to rightId by 1
				while (idx!=leftId){
					array[idx]=array[idx-1];
					idx--;
				}
				array[idx]=value;
				leftId++;
				mid++;
				rightId++;
			}
		}
	}
}
