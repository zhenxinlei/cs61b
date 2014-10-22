package sort;

public class MergeSortedArray {
	
	public void merge(int[] a, int [] b, int n, int m){
		int k=m+n-1;
		int j=n-1;// array b 
		int i=m-1;// array a
				while (i>=0&& j>=0){
					if (a[i]>b[j]){
						a[k--]=a[i--];
					}
					else {
						a[k--]=b[j--];
					}
				}
		while (j>=0)
		{
			a[k--]=b[j--];
		}
				
	}
	
	//TEST
	public static void main(String[] arg){
		int [] a= new int[14] ;
		for (int i=0;i<6;i++){
			a[i]=i+3;
		}
		int [] b={3,5,6,8,11,19,24};
		MergeSortedArray merge=new MergeSortedArray();
		merge.merge(a, b, 7, 6);
		
		
	}

}
