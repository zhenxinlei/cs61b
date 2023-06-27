package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {


    /*
    nums1: 1 1 2
    nums2: 1 2 3

    possible answer is on the upper left conrner
       1  1  2
    1  2  2  3
    2  3  3  4
    3  4  4  5

    store first row to pq, and the first one (upper left corner one) must be the smallest of all ,
    in while loop
        pop one from q , insert to result list
        add the next possible, (cur[0], numw2[ cur[2]+1], cur[2]+1) // cur[2]+1 next row idx (nums2 index)
        since arry are sorted, the next bigger number must be in nums2 at cur[2]+1
     */

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);

        for(int i = 0; i<k && i<nums1.length;i++){
            pq.offer(new int[]{nums1[i], nums2[0],0}); //last elemment is nums2.idx
        }

        while(k-- >0 && !pq.isEmpty()){
            int[] cur = pq.poll();
            //is result
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur[0]);
            tmp.add(cur[1]);
            res.add(tmp);
            if(cur[2]==nums2.length-1) //next element in q
                continue;
            //add next posible
            pq.offer(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
        }
        return  res;
    }

}
