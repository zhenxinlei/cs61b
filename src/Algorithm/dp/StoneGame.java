package Algorithm.dp;

/**
 * LeetCode 877 Stone Game
 * <p>
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * <p>
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 * <p>
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
 * <p>
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 */

public class StoneGame {

    public static void main(String[] args) {
        StoneGame sg = new StoneGame();


        int[] test1 = new int[]{7,7,12,16,41,48,41,48,11,9,34,2,44,30,27,12,11,39,31,8,23,11,47,25,15,23,4,17,11,50,16,50,38,34,48,27,16,24,22,48,50,10,26,27,9,43,13,42,46,24};



        boolean sol1 = sg.solution(test1);

        System.out.println(" test1 sol  "+ sol1);


        int [] test2 = new int[]{3,2,5};

        boolean sol2 = sg.solution(test2);

        System.out.println(" test2 sol  "+ sol2);

    }

    // A- B point diff
    //dp_points 2d array , dp(i,j) == max point diff picking from i to j


    public boolean solution(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];


        /**
         *    dp(0,1) = max( p(0)- dp(1,1), p(1) - dp(0,0)
         *    dp(1,2) = max( p(2)- dp(1,1), p(1) - dp(2,2)
         *
         *    ==>
         *    dp (0,2) =  max( p(0)- dp(1,2), p(2) - dp(0,1)
         *
         *    need to get value by diagonal first
         *
         *    OR always return true, first player always will
         */


        for (int i = 0; i<piles.length;i++){
            dp[i][i]= piles[i];
        }

        //  O(N^2)
        for ( int diag = 1 ; diag <piles.length;diag ++ ){
            for ( int row = 0 ; row<= piles.length-1 -diag; row ++ ){
                int col = row + diag;
                dp[row][col]= Math.max(piles[row]- dp[row+1][col], piles[col]-dp[row][col-1]);

            }
        }

        return dp[0][piles.length-1]>0;
    }



}
