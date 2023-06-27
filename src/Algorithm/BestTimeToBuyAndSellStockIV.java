package Algorithm;

public class BestTimeToBuyAndSellStockIV {
    /**
     * Input: k = 2, prices = [3,2,6,5,0,3]
     * Output: 7
     * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * @param args
     */
    public static void main(String[] args) {

    }

    //dp
    public static int solution1(int[] prices, int k ){

        int dp[][] = new int[k+1][prices.length];// (i,j) , max profit at i_th trade, on day j
        //init dp

        for(int i = 0; i<prices.length;i++){
            dp[0][i]= 0; //k =0, zero trades, -> pnl =0
        }

        for(int i=0; i<k+1;i++){
            dp[i][0]=0;//on day 0, cant sell , realized pnl=0;
        }


        //
        /*
        dp(i,j) = max( dp(i,j-1) ,   max( p[j] - p[jj]+ dp[i-1, jj-1]))
        jj is  0 to j-1


         */
        for(int i =1; i<k+1;i++){
            int tmpMax = -prices[0];//max cashflow, pnl , or sell at p[0]
            for(int j =1; j<prices.length;j++){
                dp[i][j]= Math.max(dp[i][j-1], prices[j]+tmpMax);//sell at p[j] -> +P[j], and plus max cashflow sofar

                //max(tmpMax, previous pnl at (i-1,j-1) and sell at p[j])
                //tmpMax will be used in next j, (potential buy at next j)
                tmpMax = Math.max(tmpMax, 0-prices[j]+ dp[i-1][j-1]);

            }
        }
        return dp[k][prices.length-1];
    }
}
