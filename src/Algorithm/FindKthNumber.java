package Algorithm;

import DataStructures.Heap;

public class FindKthNumber <Type extends Comparable<Type>> {
	
	private Type[] heap; 
	private int size;

	
	public void findKthMinNumber(Type[] array, int k){
		//setup heap
		size=k;
		heap = (Type[]) new Comparable[size+1];
		
		//heap insert
		for (int pos=0;pos<k;pos++){
			heapInsert(array[pos]);
		}
		
		
		
		
		
		//Heap<Type> heap=new Heap<Type>();
		
		//heap insert
		
		//heap.heapSort(array);
		
	}
	
	private void heapInsert(Type element){
		if(size==heap.length-1) {
			Type[] newHeap=(Type[]) new Comparable[heap.length*2]; 
			System.arraycopy(heap, 1, newHeap,1,size);
			heap=newHeap;
		}
		
		int pos=size++;
		
		for(;pos>1 && element.compareTo(heap[pos/2])<0; pos=pos/2){
			heap[pos]=heap[pos/2];
		}
		heap[pos]=element;
	}
	
	private void heapSort(Type[] array){
		buildHeap(array);
		
		
	}

	private void buildHeap(Type[] array) {
		size=array.length;
		
		for(int pos=size/2; pos>0;pos--){
			percolatingDown(array, pos);
		}
		
		
	}

	private void percolatingDown(Type[] array, int pos) {
		
		Type tmp=array[pos];
		int smallerChild;
		
		//minheap push min to front
		for (;pos*2<=size;pos=smallerChild){
			smallerChild=2*pos;
			
			if (smallerChild != size && array[smallerChild].compareTo(array[smallerChild+1])>0) smallerChild++; //find the smaller Child
			
			if (tmp.compareTo(array[smallerChild])>0) // if one of the Child is smaller than  current position key, 
				array[pos]=array[smallerChild];
			else	
				break;
			
		}
		array[pos]=tmp; //place tmp at correct place
		
	}

}
