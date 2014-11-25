package Algorithm;

import java.util.Arrays;

/**
 * 
 * @author Zhenxin Lei Given an array of integers, every element appears three
 *         times except for one. Find that single one.
 * 
 *         Note: Your algorithm should have a linear runtime complexity. Could
 *         you implement it without using extra memory?
 * 
 */

public class SingleNumberII {
	public int singleNumber(int[] A) {
		if (A.length < 4)
			return A[0];
		Arrays.sort(A);
		int i = 0;
		while (i < A.length) {
			//unique number in the end
			if (i == A.length - 2) {
				if (A[i] != A[i + 1])
					break;
			}
			//unique number in begin
			if (i == 0 && A[i] != A[i + 1]) {
				i--;
				break;
			}
			//normal situation 
			if (A[i] != A[i + 1] && A[i + 1] != A[i + 2])
				break;
			
			i++;
		}
		return A[i + 1];
	}

	public static void main(String[] args) {
		System.out.println("Hello World");
		SingleNumberII f = new SingleNumberII();
		int[] a = { 0, 1, 0, 1, 0, 1, 99 };
		int print = f.singleNumber(a);
		System.out.println("Hello World: " + print);
	}

}
