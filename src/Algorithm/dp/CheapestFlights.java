package Algorithm.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlights {

    public static void main(String[] args) {

        int[][] flights = new int[3][];
        flights[0]=new int[]{0,1,100};
        flights[1]=new int[]{0,2,500};
        flights[2]=new int[]{1,2,100};



        int cost = BfsSolution(3,flights, 0, 2 , 2 );

        System.out.println(" resurt "+ cost);





    }

    public static int BfsSolution(int n , int[][]flights, int src, int dst, int K){

        // q element {src, -> child , cost}

        Map<Integer, ArrayList<Integer[]>>  srcTodest = new HashMap<>();

        for (int[] f : flights){

            if(!srcTodest.containsKey(f[0]))
                srcTodest.put(f[0], new ArrayList<>());

            srcTodest.get(f[0]).add(new Integer[]{f[1],f[2]});
        }



        LinkedList<Integer[]> pq = new LinkedList<>();

        LinkedList<Integer[]> nextLevel= new LinkedList<>();

        Integer[] s= new Integer[]{src, 0}; // src - > {dest, cost }
        pq.add(s);


        int min = Integer.MAX_VALUE;
        int count=0;

        while (!pq.isEmpty()){


            Integer[] node = pq.poll(); // src to node , and cost

            ArrayList<Integer[]>  srcChildDst = srcTodest.get(node[0]);


            if (count > K ) // if count > k , node need to check next level
                break;

                System.out.println("  srce to child dst " + srcChildDst + " , node srce " + node[0]);

                if (node[0] == dst)
                    min = Math.min(min, node[1]);



            if (srcChildDst !=null) {

                for (Integer[] f : srcChildDst) {

                    if (node[1] + f[1] > min)
                        continue;

                    nextLevel.push(new Integer[]{f[0], f[1] + node[1]});

                }
            }

            if ( pq.isEmpty()){
                //copy nextLevl to pq

                pq.addAll(nextLevel);
                nextLevel.clear();

                if(count ++ >K ) {
                    System.out.println(" count "+ count);
                    break;

                }
            }



        }


        return min==Integer.MAX_VALUE ? -1: min;

    }
}
