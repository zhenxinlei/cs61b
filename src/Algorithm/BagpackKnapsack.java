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
	
	public static int  ZeroOneSolution(int cap, int[] values, int[] weights){

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
						
					} else 
					itemIdxToCap[i][j]= Math.max(itemIdxToCap[i-1][j], values[i]+ itemIdxToCap[i-1][j - weights[i]] );
				}
			}
		}

		return itemIdxToCap[values.length-1][cap];
	}
	
	public static void testZeroOneSolution(){
		
		int maxValue = ZeroOneSolution(7, new int[]{1,4,5,7}, new int[]{1,3,4,5,});
		System.out.println(" 0-1 solution 1 max value "+ maxValue);
	}
}
