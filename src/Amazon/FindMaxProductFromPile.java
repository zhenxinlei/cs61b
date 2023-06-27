package Amazon;

import java.util.Stack;

/*
   piles=[7,4,5,2,6,5]
   get product from piles, and must has greater # of product of previous

   like possible resutl
        [3,4,5,0,0,0] -> total = 12
        [0,0,1,2,4,5] -> total = 12

       ....
       max of all result =12


 */
public class FindMaxProductFromPile {
    public static void main(String[] args) {
        int piles[] = new int[]{7,4,5,2,6,5};
        int res = solution(piles);

        System.out.println(" res "+res);

        solution( new int[]{4,4,4,4,4});
    }

    //hit mono stack
    public static int solution ( int[] piles){
        Stack<Integer> monoStack = new Stack<>();//id
        int [] dp = new int[piles.length];
        int res = 0;
        for(int i  = 0; i < piles.length;i++){
            //make sure stack element are able to be 等差数列, until at  peek() not valid then  from i to peek()+1 等差数列 ,
            // ie 7,4,5 , when i = 5
            while(!monoStack.isEmpty() && piles[monoStack.peek()]>=piles[i]- (i-monoStack.peek())){
                monoStack.pop();
            }

            //  1。 i-peek(): from i to peek()+1 等差数列，or 2。 stack empty: max len is min (from i to 0 or, piles[i] high, )
            // piles[i] high <- ie. hight = 4, len can only be 4 ,
            int len = monoStack.isEmpty()?Math.min(i+1, piles[i]):(i-monoStack.peek());
            int cur = (piles[i]+piles[i]-len+1)*len/2+(monoStack.isEmpty()?0:dp[monoStack.peek()]);
            res = Math.max(res,cur);
            dp[i]=cur;
            monoStack.push(i);
        }
        return res;
    }
}
