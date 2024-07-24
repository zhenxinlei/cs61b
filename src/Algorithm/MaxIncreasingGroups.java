package Algorithm;

import java.util.*;

public class MaxIncreasingGroups {

    public static void main(String[] args) {
        MaxIncreasingGroups g = new MaxIncreasingGroups();
        List<Integer> limits= new ArrayList<>();
        limits.add(2);
        limits.add(2);
        limits.add(2);
        g.maxIncreasingGroups(limits);
    }

    public int maxIncreasingGroups(List<Integer> usageLimits) {
        //priority Q
        class  Holder implements Comparable {
            int id;
            int ct;
            Holder(int id , int ct){
                this.id = id;
                this.ct = ct;
            }

            @Override
            public int compareTo(Object o) {
                int res =  this.ct-((Holder) o).ct;
                if(res==0)
                    res= this.id -((Holder) o).id;
                return res;
            }
        }


        TreeSet<Holder> set = new TreeSet<>();//reverse order
        for(int i = 0;i<usageLimits.size();i++){
          //  System.out.println("add set  "+ i+", "+usageLimits.get(i));
            set.add(new Holder(i, usageLimits.get(i)));
        }

        int numLimitGtZero= usageLimits.size();
        int groupSize=0;
        int res  =0;
        while(groupSize+1<=numLimitGtZero){
            int ct = 0;
            Iterator<Holder> it = set.descendingIterator();
            List<Holder> updateHolders = new ArrayList<>();
           while(it.hasNext()){
               Holder holder = it.next();
                holder.ct--;
                ct++;
                updateHolders.add(holder);
                System.out.println(" num  "+ holder.id+" ct "+holder.ct+" ct "+ct+" "+(groupSize+1));
                if(holder.ct==0){
                    numLimitGtZero--;
                    System.out.println(" is Zero num "+ holder.id);
                }
                if(ct==groupSize+1) {
                    //groupSize++;
                    System.out.println("break ");
                    break;
                }
            }
//
//           for(Holder h:updateHolders){
//               set.remove(h);
//               set.add(h);
//           }
            System.out.println(" @new group  "+ ct+" , "+ groupSize);
            if(ct==groupSize+1) {
                groupSize++;
                res ++;
                System.out.println(" new group  "+ ct+" , "+ groupSize);
            }

        }
        return res;
    }
}
