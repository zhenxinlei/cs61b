package Algorithm;

public class BagpackKnapsack {

	public static void main(String[] args) {
		testZeroOneSolution();
	}
	/**
	 * 
	 * @param cap
	 * @param values
	 * @param weights
	 * @return
	 * 
	 * itemIdxToCap each element store max value can put in bag
	 * index i = item index
	 * index j = current bag capacity 
	 * 
	 */

	/*
	value:
	      0 1, 2, 3, 4, 5,
	cap 0
	    1
	    2
	    3
	    4
	    5
	    6
	    7

	 */

	public static int  ZeroOneSolution(int cap, int[] values, int[] weights){

		//max value of all stone before or equals i, and with bag cap  exact = j
		int[][] itemIdxToCap= new int[values.length][cap+1];
		int capLeft = 0;
		
		for (int i =0; i < values.length;i++){
			for (int j =1; j< cap+1;j++){
				capLeft =j;
				if ( weights[i]> j){ // weight > cap , cant put in item 
					itemIdxToCap[i][j]=itemIdxToCap[i-1][j];
				} else {
					if ( i ==0 ){
						itemIdxToCap[i][j]= values[i];
					} else {
						//not add i th, -> same as dp[i-1][j]
						//or adding ith stone ,
						// if j = 7 , weith[i]=2
						// dp[i-1][4 (6-2)]+ values[i]
						// dp[i-1][5 (7-2)]+ values[i]
						// 原来重量 是 j-w[i], add new stone w[i], 重量转移 为 j
						itemIdxToCap[i][j] = Math.max(itemIdxToCap[i - 1][j], values[i] + itemIdxToCap[i - 1][j - weights[i]]);
					}
				}
			}
		}

		return itemIdxToCap[values.length-1][cap];
	}

	//reduced dp dimension
	public static int  ZeroOneSolution2(int cap, int[] values, int[] weights){
		int[] dp = new int[cap+1];//max value with cap i,  cap 0,1,2,3,4,5,6,7

		for(int i = 0;i <values.length; i ++){ //iter all stone
			for(int j = cap; j>=weights[i];j--){//check cap from max Cap
				dp[j]=Math.max(dp[j], dp[j-weights[i]]+values[i]); //not add stone  or add i-th stone, and subtract cap
				//by weight i
			}
		}

		return dp[cap];
	}
	
	public static void testZeroOneSolution(){
		
		int maxValue = ZeroOneSolution(7, new int[]{1,4,5,7}, new int[]{1,3,4,5,});
		System.out.println(" 0-1 solution 1 max value "+ maxValue);

		 maxValue = ZeroOneSolution2(7, new int[]{1,4,5,7}, new int[]{1,3,4,5,});
		System.out.println(" 0-1 solution 1 max value "+ maxValue);
	}
}
