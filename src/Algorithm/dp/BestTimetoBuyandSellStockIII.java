package Algorithm.dp;

/**
 * 
 * @author ZhenxinLei
 *Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

public class BestTimetoBuyandSellStockIII {
	
	public int maxProfit(int[] prices) {
        
        /** 
         * find 2 maximum range, make sure lower index infront
         * 
         * */
         if (prices.length<=1) return 0;
         
         int revenue1= Integer.MIN_VALUE; int revenue2=Integer.MIN_VALUE;
         int cost1=0; int cost2=0;
         int len=prices.length;
         
      //  int d = Math.max(prices[len-1], prices[len-2]);
    //    int c = Math.max(prices[len-1] - prices[len-2], 0);
      //  int b = d;
        //int a = c;
         
         
         for (int i=0; i<prices.length;i++){
             revenue2=Math.max(revenue2, cost2+prices[i]);// i is selling price, cost2 is the buying (-)price 
             System.err.println("=====\n re2: "+revenue2);
             
            // cost2= Math.max(cost2, revenue1-prices[i]);// if we but 2nd stock
             cost2= Math.max(cost2, cost2-revenue1);
             System.err.println("cost2: "+cost2);
             
             revenue1=Math.max(revenue1, cost1+prices[i]);//i is selling price, cost2 is the buying (-)price
             System.err.println("re1: "+revenue1);
             
             cost1=Math.max(cost1, -prices[i]); 
             System.err.println("c1: "+cost1);
         }
         
         return revenue2;
         
        
    }




    public static int maxProfit2(int[] prices) {
        int n=prices.length;
        if(n==0) return 0;
        int[][] dp=new int[3][n];
        for (int k=1;k<=2;k++){
            int min=prices[0];
            for (int i=1;i<n;i++){
                min=Math.min(min, prices[i]-dp[k-1][i-1]);
                dp[k][i] = Math.max(dp[k][i-1], prices[i] - min);
            }
        }
        return dp[2][n-1];
    }
	
	public static void main(String[] args) {
		int [] a={3,3,5,0,0,3,1,4};
		BestTimetoBuyandSellStockIII bt=new BestTimetoBuyandSellStockIII();
		System.err.println(bt.maxProfit(a));
	}

}
