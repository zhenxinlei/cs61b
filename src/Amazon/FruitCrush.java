package Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FruitCrush {
    /*
       give type of friut [3,3,3,3,2,2,1,1]
        can eleminate pair if type not similar

        find minimum remain count

        ie [3,3,2,2,1]: crush pair (2,3),(2,3) -> only [1] left return answer 1

     */

    public static void main(String[] args) {
        int res = soluction1(new int[]{1,2,2,3,3});
        System.out.println(" res "+res);

        res = soluction1(new int[]{1,1,1,1,2,2,2,3,3,3,3});
        System.out.println(" res "+res);

        res = soluction1(new int[]{1,2,3,4});
        System.out.println(" res "+res);
    }

    public static int soluction1 (int [] nums){
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->b[1]- a[1]);//revers order
        Map<Integer, Integer> freq = new HashMap<>();
        for(int t :nums){
            int ct = freq.getOrDefault(t,0);
            freq.put(t,++ct);
        }

        for(Map.Entry<Integer,Integer> e: freq.entrySet()){
            q.add(new int[]{e.getKey(),e.getValue()});
        }//O(nlogn)

        //NlogN
        while (q.size()>1){
            int[] t1 = q.poll();
            int[] t2= q.poll();
            int diff = t1[1]-t2[1];
            if(diff!=0){
                t1[1]=diff;
                q.add(t1);
            }
        }
        if(q.size()>0)
            return q.peek()[1];
        else
            return 0;
    }
}
