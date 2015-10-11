package Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {
	public int[] sortLSD(int[] inputs) {
		if (inputs.length==0) return new int[]{};
		
		int result[] = Arrays.copyOf(inputs, inputs.length);
		//record digit's times
		LinkedList<Integer>[] counter = new LinkedList[] {
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>() };
		
		//find maxdigit in inputs[]
		int max=result[0];
		for (int i =0; i< result.length;i++){
			max=max<result[i]?result[i]:max;
		}
		//System.out.println(max);
		int maxdigit=1;
		int mod=1;
		while (max/mod>10) {
			maxdigit++;
			mod*=10;
		}
		
		//System.out.println(maxdigit);
		
		mod=10;
		int dev=1;
		int digits=10; // given all inputs numbers are consist of 0~9 
		//O(k*10N) ,k is number length
		for (int i=0; i<maxdigit;i++,dev*=10){
			//get last digit of each number in inputs[].
			//add number to counter[digit]'s list
			//O(N)
			for (int j=0; j<result.length; j++){
				counter[(result[j]/dev)%mod].add((Integer)result[j]);// last digits 
			}
			
			//update result[]
			int k=0;
			//O(10N)
			for (int j=0;j<digits;j++){
				//O(N)
				while(!counter[j].isEmpty()){
					result[k++]=counter[j].poll().intValue();
				}
			}
			
		}
		
		
		return result;

	}

	public int[] sortMSD(int[] inputs) {
		int result[] = Arrays.copyOf(inputs, inputs.length);
		//record digit's times
		LinkedList<Integer>[] counter = new LinkedList[] {
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>() };
		
		int max=result[0];
		for (int i =0; i< result.length;i++){
			max=max<result[i]?result[i]:max;
		}
		int maxdigit=1;
		int mod=1;
		int dev=1;
		while (max/mod>10) {
			maxdigit++;
			mod*=10;
			dev*=10;
		}
		
		System.err.println("dev: "+dev);
		
		for (int i=0; i< maxdigit; i++, dev/=10){
			System.err.println("the "+(i+1)+ "loop. ");
			for (int j=0; j<result.length;j++){
				
				System.err.println( "number : "+result[j]+" this digit : "+ result[j]/dev%10 );
				counter[result[j]/dev%10].add((Integer) result[j]); // first digit store in bucket ,  0098 store in zero bucket (0), 9082 store in nine  (9) bucket
			}
			
			/*
			//copy from counter back to result.
			int k=0;
			for (int j=0 ; j<counter.length; j++){
				while (!counter[j].isEmpty()){
					result[k++]=counter[j].poll().intValue();
				}
					
			}
			*/
			
			
			
			
		}
		
		

		return result;

	}

	private static void msd(String[] a, int l, int r, int d)
	{
		
		if (r <= l + 1)
			return ;
		
		int N=a.length;
		String temp[]=new String[999999];
		int[] count = new int[256]; // 256 acii character 
		for (int i = 0; i < N; i++)
			count[a[i].charAt(d) + 1]++;
		for (int k = 1; k < 256; k++)
			count[k] += count[k - 1];
		for (int i = 0; i < N; i++)
			temp[count[a[i].charAt(d)]++] = a[i];
		for (int i = 0; i < N; i++)
			a[i] = temp[i];
		for (int i = 1; i < 255; i++)
			msd(a, l + count[i], l + count[i + 1], d + 1);
		
		
	}
	
	
	// inputs are all fixed digits number, i.e. 02301, 54321,00341
	public static void main(String[] arg) {

		//int[] inputs = { 2301, 54321, 341, 54312, 54312,00000, 99999, 7620 };
		String []inputs={"2302","232","000","32","99909"};
		RadixSort rs = new RadixSort();
		long starttime=System.nanoTime();
		//System.out.println("Start time (ms) :"+starttime);
		
		//int [] array=rs.sortLSD(inputs);
		
		rs.msd(inputs, 0, inputs.length, 0);
		
		long totalTime=System.nanoTime()-starttime;
		System.out.println("total time:"+totalTime);
		for (int i=0; i<inputs.length;i++){
			System.out.println(inputs[i]);
		}

	}

}
