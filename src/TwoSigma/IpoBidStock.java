package TwoSigma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IpoBidStock {
    /*
    assign stock per bid (shares price, timestamp)
    1. price higher get stock ,
    2. timestamp smaller get stock, and round robin,
     Each bidder in the same price group gets assigned one share each consecutively,
     with each bidder being arranged inside the group based on their timestamp.
     Once a bidder gets the number of shares they bid for,
     they will be removed from the above iterative process and the process which then continues
     until all bidders are removed or the shares get exhausted, whichever comes first.
    inputs: bids: List(List(int)): 每个bid, bids : [user_id, shares, price, timestamp]
totalShares: int: 总共可用的股票

     */

    public static void main(String[] args) {
        List<List<Integer>> bids = new ArrayList<>();

        bids.add(Arrays.asList(new Integer[]{1,2,3,0}));
        bids.add(Arrays.asList(new Integer[]{2,4,2,1}));
        bids.add(Arrays.asList(new Integer[]{3,2,2,2}));
        bids.add(Arrays.asList(new Integer[]{4,2,2,3}));
        List<Integer> unAlloted = getUnallottedUsers(bids, 4);
        System.out.println(unAlloted);
    }

    public static List<Integer> getUnallottedUsers(List<List<Integer>> bids, int totalShares) {
        // Id, shares, price, timestamp
        Collections.sort(bids,
                (b1, b2) -> b1.get(2) != b2.get(2) ? b2.get(2) - b1.get(2) : b1.get(3) - b2.get(3));
        int i = 0;
        while (totalShares > 0 && i < bids.size()) {
            int groupTotalShares = 0;
            int j = i;

            while (j < bids.size() && bids.get(i).get(2) == bids.get(j).get(2)) {
                groupTotalShares += bids.get(j).get(1);
                j++;
            }
            int groupSize = j - i;
            if (totalShares < groupSize) {
                i += totalShares;
                break;
            } else {
                totalShares -= groupTotalShares;
            }
            i = j;
        }
        List<Integer> result = new ArrayList<>();
        while (i < bids.size()) {
            result.add(bids.get(i).get(0));
            i++;
        }
        Collections.sort(result);
        return result;
    }
}
