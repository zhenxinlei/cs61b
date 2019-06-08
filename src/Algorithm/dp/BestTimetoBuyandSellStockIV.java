package Algorithm.dp;

/**
 *  Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 */


import utils.PrintUtils;

/**
 *  dp == so far profit at day j , and transcation i
 *      p:  0, 1, 2. ... n-1
 *   K: 0
 *      1
 *    ...
 *
 *     k-1
 */

public class BestTimetoBuyandSellStockIV {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockIV stk = new BestTimetoBuyandSellStockIV();

        int[] test1 = new int[]{5,4,5,2,3,4};

        stk.maxProfit(3, test1);
    }


//TODO finish it
    public int maxProfit(int k, int[] prices) {
        // dp (i,j)
        // tmp max profit at day j, if allow i transaction,
        int[][] dp = new int[k+1][prices.length];

        for (int i = 1; i < k+1; i++) {
            // find max profit at day j,  if k = i;
            int localMinCost = dp[i-1][0]- prices[0]; //  local max posible profit,   lowest buy cost  and its negative
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max( dp[i][j-1] , prices[j]+ localMinCost );
                localMinCost = Math.max(  localMinCost,  dp[i-1][j]- prices[j] ); // since localMinCost is negative, thus use Math.max
            }
        }

        //print 2d array
        PrintUtils.print2DArray(dp);
        return dp[k][prices.length-1];
    }

}
