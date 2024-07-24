package Amazon;

import java.util.*;

public class NumberOfRectangles {
    /*
    假设有个XY坐标系，给你一堆点，问这些点能组成多少个长方形
     */

    public static void main(String[] args) {
        combination(4,2);

        int[][] cords = new int[][]{{1,2},{1,4},{2,2,},{2,4},{1,3},{2,3},{3,1},{3,4}};
        solution(cords);
    }

    public static  int solution(int[][] cordinates){
        //x1-> {y1, y2, y3}
        //x2-> {y1, y2, y3 , y4, y5 }
        //finc command set {y1, y2, y3 }

        //setup
        Map<Integer, Set<Integer>> map = new HashMap<>();

        //TODO remvoe duplicate points
        for (int i =0;i<cordinates.length;i++){
            int [] cor = cordinates[i];
            Set set = map.getOrDefault(cor[0], new HashSet<>());
            set.add(cor[1]);
            map.put(cor[0],set);
        }

        //
        Set<Integer> visited = new HashSet<>();
        int count =0;
        for(Integer cor1 : map.keySet()){
            for( Map.Entry<Integer,Set<Integer>> entry: map.entrySet()) {
                if (entry.getKey().equals(cor1) || visited.contains(entry.getKey())) {
                    continue;
                }
                //find common Ys
                Set commSet = new HashSet<>(map.get(cor1));
                commSet.retainAll(entry.getValue());

                System.out.println(cor1+" & "+entry.getKey()+" commSet "+commSet);
                if(commSet.size()<=1){
                    continue;
                } else {
                    int size = commSet.size();
                    count +=combination(size,2);

                }
            }
            visited.add(cor1);
        }

        System.out.println(" co unt "+count);
        return count;

    }

    //from n choose k
    public static int combination(int n, int k  ){
        //n!/ ((n-k)! k! )

        int n_fac = 1;
        int n_k_fac =1;
        int k_fac=1;
        for(int i =1;i<=n;i++){
            n_fac=n_fac*i;
            if(n-k>=i) {
                n_k_fac = n_k_fac * i;
               // System.out.println(" ,n_k_fac  "+n_k_fac+"," + i );
            }
            if(k>=i){
                k_fac=k_fac*i;
                //System.out.println("k_fac ,,"+k_fac+" i "+ i);
            }
        }


        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> (b-a ));
       // System.out.println(n_fac+" , "+n_k_fac+","+k_fac);
        return n_fac/(n_k_fac* k_fac);

    }
}
