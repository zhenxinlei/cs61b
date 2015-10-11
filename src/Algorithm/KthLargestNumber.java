package Algorithm;

import java.util.Arrays;

public class KthLargestNumber {

	    public int findKthLargest(int[] nums, int k) {
	        //1. min heap
	    	if (k>0){
	    	int [] heap=buildHeap(nums, k);
	    	return heap[1];
	    	
	    	}
	        //2. quick select
	    	
	        return quickSelect(nums,k, 0, nums.length-1);//O(n+n/2+n/4...+4+2+1)=O(n) (sum of GP)
	        
	    }
	    
	    //min Heap solution
	    //int heap[]=new int [k+1];
	    //heap[0]=0;
	    
	    public int[] buildHeap(int[] nums, int k){
	        int heap[]=new int [k+1];
	        heap[0]=0;
	        
	        for (int i=1;i<=k;i++){
	        	heap[i]=nums[i-1];
	        }
	        
	        for (int i=(heap.length-1)/2;i>0;i--){
	        	//from bottom to top
	            heapify(heap,i);
	        }
	        
	      /*  for (int i=k; i<nums.length;i++){
	        	heapInsert(heap, nums[i]);
	        }*/
	        return heap;
	    }
	    
	    public void heapify(int[] heap,int parent){ //sink down heapify
	        //int pos=1;
	    	int num=heap[parent];
	    	int child = parent;
	    	//int pos=1;
	    	
	        for (; child*2<=heap.length-1; ){
	        	System.err.println("heap.length "+heap.length);
	        	child=child*2;
	        	if (child!=heap.length-1&&heap[child]>heap[child+1]) child++; // smaller int position
	        	
	        	if (num>heap[child]) {
	        		//heap[child/2]=heap[child];
	        		swap(heap, child, child/2);
	        	}
	        	else break;
	        }   
	        
	       //heap[child]=num;
	    }
	    
	    public void heapInsert(int[] heap, int num){
	    	//insert to last-> heapify-> delete last one
	    	//int[] tempheap=new int [heap.length+1];
	    	int[] tempheap=Arrays.copyOf(heap, heap.length+1);
	    	tempheap[heap.length]=num;
	    	
	    	
	    	for (int i=(tempheap.length-1)/2;i>0;i--){
	        	//from bottom to top
	    		heapify(tempheap,i);
	        }
	    	for (int i=1;i<=heap.length-1;i++){
	        	heap[i]=tempheap[i];
	        }
	    	
	    }
	    
	    
	    
	    //quick select solution
	    public int quickSelect(int[] nums, int k, int l ,int h){
	        
	       // int l=0;
	       // int h=nums.length-1;
	        
	        int pi=l+(h-l)/2;
	        int si=partition(nums, l,h,pi);
	        
	        if (si+1==k) {return nums[si];}
	        
	        else if(si+1>k) {return quickSelect(nums, k, l, si-1);}
	        else {return quickSelect(nums,k, si+1, h);}
	        
	        
	    }
	    
	    //quick select partition, return stored index
	    public int partition(int[] a, int s, int e, int pi){//O(n)
	        int si=s; //stored index
	        swap(a,pi,e);
	        for (int i =s; i<e;i++){
	            if (a[i]>a[e]){
	                swap(a,i,si++);
	            }
	            
	        }
	        
	        swap(a,e,si);
	        return si;
	    }
	    
	    public void swap(int[] a, int i, int j){
	        int temp=a[i];
	        a[i]=a[j];
	        a[j]=temp;
	    }
	
	public static void main(String[] args) {
		KthLargestNumber kl=new KthLargestNumber();
		int[] a={2,1,3,6,7,5,4,8,9};
		int k=5;
		System.err.println(kl.findKthLargest(a, k));
	}
	
}
