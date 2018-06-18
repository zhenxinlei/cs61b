package sort;

public class BubbleSortAlgo {
	
	public static void main(String[] args) {
		//Test1 
				int [] arr = new int[]{3,6,1,8,2,9,4,0,3,2,5,1,4,6,7};
				
				BubbleSortAlgo.bubbleSort(arr);
				for (int i : arr) {
					System.out.print(i+", ");
				}
	}

	public static void bubbleSort(int [] arr) {
		
		int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
	}
}
