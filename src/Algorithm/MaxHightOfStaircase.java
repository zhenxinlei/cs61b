package Algorithm;

/***
 * 
 * @author ZhenxinLei
 *
 * You have given an N number of squire blocks. Height of each squire Block is 1. your task is to create a  max height of the staircase that can be made from these blocks.

Note: The first stair would require one block, the second stair (height 2) would require two blocks and so on.

Input:

The first line of the input contains T i.e number of test cases. Each line of the test case contains a number  N i.e number of blocks. 

Output:

Each new line of the output contains only one single integer i.e Maximum height of staircase.

Constraints:

1<=T<=100

1<=N<=10^8

Example:

Input:

3
10
12
16

Output:

4
4
5
 *
 */
public class MaxHightOfStaircase {
	
	/**
	 * 
	 * @param num
	 * @return
	 *  using DP, (i+1) is the step of staircase
	 *  d[i] is the total block at step i+1
	 * 
	 */
	public static int func(int num){
		int[] d = new int[num/2];
		d[0]=1;
		int i =1;
		for ( i =1;i<num;i++){
			if(d[i-1]+i+1> num){
				System.out.println("--hight  "+ (i+1)+ " out "+d[i-1]);
				break;
			}
			
			d[i]=d[i-1]+i+1;
			System.out.println("hight  "+ (i+1)+ " out "+d[i]);
		}
		
		int hight = i ;
		System.out.println("input "+ num+ " out "+hight);
		return hight ;
		
	}

	public static void main(String[] args) {
		MaxHightOfStaircase.func(10);
		
	}
}
