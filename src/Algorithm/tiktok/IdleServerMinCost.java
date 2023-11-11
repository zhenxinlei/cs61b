package Algorithm.tiktok;

import java.util.ArrayDeque;
import java.util.Arrays;

public class IdleServerMinCost {
    /*
    int data[2N]: array of int denoting number of people using that ith DB
    int k: a non neg int , capacity need to achieve

    have a pair of servers, options
        * idle the smaller one , cost increment 1
        * idle the bigger one, cost 0

     ie {3,1,2,5}, k = 6
     pair [1,5], [2,3]
          idle 1 2  -> 5+3=8 >=k  cost = 2 ,
          idle 1,3 -> 5+2 >=k cost =1 , * best min cost
          idle 5,2 -> 1+3<k cost 1
          idle 5,3 -> 1+2 < k cost 0
     */

    public static void main(String[] args) {
        int[] ary = new int[]{1,2,5,6,7,8};
        int k =8;
        int sol = solution(ary, k );
        System.out.println(sol );

       ary = new int[]{1,2,2,3,3,4};
         k =8;

        ary = new int[]{1,2,3,4,5,6,7,8};
        k =24;

        ary = new int[]{2,5,1,7,3,8};
        k =14;
         sol = solution(ary, k );
        System.out.println(sol );
        sol = minCost(ary, k );
        System.out.println(sol );
        sol = minCost(2,ary, k );
        System.out.println("DP"+sol );

        ary = new int[]{1,2,3,4};
        k =4;
        sol = minCost(ary, k );
        System.out.println(sol );


        ary = new int[]{1,2,3,4,5,6,7,8};
        k =24;

        sol = minCost(2,ary, k );
        System.out.println("DP"+sol );

//        ary = new int[]{1,2,3,4};
//        k =4;
//        sol = minCost2(ary, k );
//        System.out.println("minCost 2 "+sol );
//
//        ary = new int[]{1,2,2,3,3,4};
//        k =8;
//        sol = minCost2(ary, k );
//        System.out.println("minCost 2 "+sol );

        ary = new int[]{1,2,3,4,5,6,7,8};
        k =24;
        sol = minCost2(ary, k );
        System.out.println("minCost 2 "+sol );

    }

   //Correct solution:
    public static int minCost2(int[] capacity, int k) {
        Arrays.sort(capacity);
        //const == 0关闭最大的，最佳匹配方式从右至左找到第一个比其小且未被使用的服务器
        int sumCapacity = 0;
        //考虑capacity存在相同的情况,单调栈维护右边比其大且未被使用的服务器，如果capacity都不相同排序相邻配对
        int[] preSum = new int[capacity.length + 1];
        for (int i = 1; i <= capacity.length; i++) {
            sumCapacity += capacity[i - 1];
            preSum[i] = sumCapacity;
        }
        //二分枚举cost,最大的拿出一台服务器和最小的去匹配
        int l = 0, r = capacity.length / 2;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            //mid = cost ， close mid 个较少服务器，
            if (sumCapacity - closeMax(mid, capacity, preSum[mid]) >= k) { //sum- curCloseCap, = 当前可用cap
                r = mid - 1; //减少一个  close较小 服务器 cost 变少
            } else {
                l = mid + 1; //增加一个  close较小 服务器 cost 变大
            }
        }
        return  l;
    }


    /*
        1，2，3，4，5，6，7，8
        before entering method：
            if cost =2， 已经选择关闭  1， 2， curCloseCap = 3， 保留最大 7，8
        inside method
            from aryLeng-1-cost to cost
            从 3，4，5，6 中选择 close *相邻* 较大 ， 因为 可以使保留 最大，且cost 不变
                反例 close （5，6）， 保留（3+4，）  < (3+5)

     */
    //已经选择关闭 较小 c = cost 个服务器， close=当前 close capacity,
    //剩下的选择较大服务器， then cost 不变
    public static int closeMax(int cost, int[] capacity, int close) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //考虑capacity存在相同的情况,单调栈维护右边比其大且未被使用的服务器，如果capacity不相同排序相邻配对
        System.out.println(" cost "+cost+ " close "+ close);
        for (int i = capacity.length - 1 - cost; i >= cost; i--) {
            boolean pop = false;
            System.out.println(" i "+i+ " capacity[i] "+ capacity[i]);
            if (!stack.isEmpty() && stack.peek() > capacity[i]) { //pop 相邻较大， dont push back the smaller one
                close += stack.pop();  //当前capacity 和
                pop = true;
            }
            if (!pop) {
                stack.push(capacity[i]);
            }
            System.out.println("stack "+ stack);
        }
        System.out.println("close "+close);
        return close;  //当前capacity 和
    }





    public static int solution(int[] data, int k ){

                Arrays.sort(data);
                int max = 0;
                int min = 0;
                for (int i = 0; i < data.length; i++) {
                    if(i<data.length/2){
                        min+=data[i];
                    } else {
                        max+=data[i];
                    }
                }
                if (max<k) {
                    return -1;
                }

                int left = 0, right = data.length-1;
                int cost = 0;
                while(left<right && k-min>0){
                        cost++;
                        k-=data[right];
                        min-=data[left];

                    left++;
                    right--;
                }
                return cost;
            }

    public static int minCost(int[] data, int k){
        Arrays.sort(data);
        int n = data.length/2;
        int max = 0;
        for(int i = n; i< data.length; i++){
            max += data[i];
        }
        if (max<k) {
            return -1;
        }
        int cost = Math.min(iteration(data, k, 0),iteration(data, k, 1));
        return cost;
    }

    public static int iteration(int[] data,int k, int idx){
        int cost = 0;
        int cur = 0;
        for(int i = idx; 2*i< data.length; i++){
            cur += data[2*i];
        }
        if (idx==1) {
            cur += data[0];
        }
        if (cur>=k) {
            return cost;
        }
        if (idx==1) {
            cost++;
            cur=cur+data[data.length-1] - data[0];
            for (int i = data.length-2; i >0; i-=2) {
                if (cur>=k) {
                    break;
                }
                cost++;
                cur = cur + data[i] -data[i-1];

            }
        } else {
            for (int i = data.length-1; i >0; i-=2) {
                if (cur>=k) {
                    break;
                }
                cost++;
                cur = cur + data[i] -data[i-1];
            }

        }
        return cost;

    }


    public static int minCost(int n, int[] data, int k) {
        int[] prefixSum = new int[data.length + 1];
        for (int i = 1; i <= data.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + data[i - 1];
        }

        Arrays.sort(data);
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE; // Initialize with a large value
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // Don't set the current server to idle
                if (j >= data[i - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - data[i - 1]]);
                }

                // Set the current server to idle
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
            }
        }

        // Find the minimum cost for achieving a working capacity of at least k
        int minCost = Integer.MAX_VALUE;
        for (int j = k; j >= 0; j--) {
            if (dp[n][j] != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, dp[n][j]);
            }
        }

        return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
    }



}
