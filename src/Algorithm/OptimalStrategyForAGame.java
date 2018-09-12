package Algorithm;
/***
 * 
 * @author ZhenxinLei
 * 
 * Problem statement: Consider a row of n coins of values v1 . . . vn, 
 * where n is even. We play a game against an opponent by alternating turns.
 * In each turn, a player selects either the first or last coin from the row, 
 * removes it from the row permanently, and receives the value of the coin. 
 * Determine the maximum possible amount of money we can definitely win if we move first.
 * Note: The opponent is as clever as the user.
 *
 */
public class OptimalStrategyForAGame {
	
	public static int optimalStrategyOfGame(int[] array, int n){
		
		
		
		
		
		return -1;
	}
	
	
	public static int solution_1 (int[] array, int left, int right){
		
		if(left==right-1){
			return Math.max(array[left], array[right]);
		}
		
		if (left == right ){
			return array[left];
		}
		
		//pick left 
		int pick_left = array[left] + Math.min(solution_1(array, left+2, right), solution_1(array,left+1,right-1));
		
		int pick_right = array[right] + Math.min(solution_1(array, left, right-2), solution_1(array,left+1,right-1));
		
		/***
		 * Solution 2 :
		 * 
		 * left,right can be treat as x,y in coordinate 
		 * thus we can store value in 2d matrix, on diag with gap 
		 * 
		 * http://alturl.com/q6sea
		 * 
		 */
		
		
		return Math.max(pick_left, pick_right);
	}
	
	
	
	// Driver program 
    public static void main (String[] args) 
    {
        int arr1[] = {8, 15, 3, 7};
        int n = arr1.length;
        System.out.println("" + optimalStrategyOfGame(arr1, n));
     
        int arr2[] = {2, 2, 2, 2};
        n = arr2.length;
        System.out.println("" + optimalStrategyOfGame(arr2, n));
     
        int arr3[] = {20, 30, 2, 2, 2, 10};
        n = arr3.length;
        System.out.println("" + optimalStrategyOfGame(arr3, n));
        

        System.out.println("" + solution_1(arr1, 0, arr1.length-1));
 
 
    }
}
