package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort<T extends Comparable> {
	
	public static<T> List<T> sort(List<T> list,int lo, int hi){
		if (lo>=hi)return list;
		if (list==null||list.isEmpty()||list.size()==1) return list;
		
		int pivotIndex=pivotIndex(list,lo,hi);
		T pivotValue= list.get(pivotIndex);
		partition(list, lo,hi,pivotValue);
		
		int mid=lo+(hi-lo)/2;
		sort(list, lo, mid-1);
		sort(list,mid+1,hi);
		
		return list;
		
	}

	private static<T> void partition(List<T> list, int lo, int hi, T pivotValue) {
		// TODO Auto-generated method stub
		int storeIndex=lo;
		for (int i =lo; i<=hi-1;i++){
			if (((Comparable) list.get(i)).compareTo(pivotValue)<0) {
				swap(list,i,storeIndex++);
			}
		}
		swap(list,hi,storeIndex);
	}

	private static<T> int pivotIndex(List<T> list, int lo, int hi) {
		// TODO Auto-generated method stub
		//find median of {lo, mid, hi}
		if (hi==lo)return lo;
		
		if (lo+1==hi)return hi; // while list partition less than 2 numbers 
		
		int mid=lo+(hi-lo)/2;
		
		if (((Comparable) list.get(lo)).compareTo(list.get(mid))>0) swap( list,lo,mid);
		if (((Comparable) list.get(hi)).compareTo(list.get(mid))<0) swap(list,mid,hi);
		if (((Comparable) list.get(lo)).compareTo(list.get(mid))>0) swap( list,lo,mid);
		
		// put median/ pivot value to end;
		swap(list,mid,hi);
		
		
		return hi;
	}

	private static<T> void swap(List<T> list, int a, int b) {
		// TODO Auto-generated method stub
		T temp = list.get(a);
		list.set(a, list.get(b));		
		list.set(b,temp);
	}
	
	public static void main(String[] args) {
		int []a=InputOutput.scannIntegerArray();
		List<Integer> list=new ArrayList<Integer>();
		for (int elem:a){
			list.add(Integer.valueOf(elem));
		}
		
		List sortedList=QuickSort.sort(list, 0, list.size()-1);
		System.out.println("LIST: "+sortedList.toString());
	}
	
	

}
