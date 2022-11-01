package Algorithm.tiktok;

import java.util.*;

public class SocialNetwork {
    /**
     *
     * @param args
     *
     * T
     * M
     * 1,2
     * 3,4
     */



    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1,2}, {3,4},{5,4},{1,4}};

        args = new String[]{"2","2","1,2","2,3","3","5,4","1,2","3,7"};

        //int[][] pairs = new int[][]{{1,2}, {3,4},{5,4},{1,4}};
        Map<Integer, int[][]> map = new HashMap<>();
        int T = Integer.valueOf( args[0]);
        int lineCt = 0 ;
        int countryId= 0;

        for(int t=0; t< T;t++){
            int M = Integer.valueOf(args[++lineCt]);
            System.out.println("M "+M+"," +lineCt);
            int[][] pair= new int[M][2];
            map.put(countryId++, pair);
            for (int m = 0 ; m<M;m++){
                lineCt++;
                System.out.println(args[lineCt]);
                String[] str = args[lineCt].split(",");
                pair[m][0]=Integer.valueOf(str[0]);
                pair[m][1]=Integer.valueOf(str[1]);

            }

            System.out.println("  pair "+Arrays.toString(pair));
        }




        int res = solution(pairs);
        System.out.println(res);


    }
    //each country
    public static int solution(int[][] pairs){
        List<Set<Integer>> networks= new LinkedList<>();

        for (int[] pair : pairs){
            Integer a = pair[0];
            Integer b = pair[1];

            List<Set<Integer>> setToUnion = new LinkedList<>();
            boolean hasSet = false;
            for (Set<Integer> set : networks){
                if(set.contains(a)){
                    set.add(b);
                    hasSet = true;
                    setToUnion.add(set);
                } else if (set.contains(b)){
                    set.add(a);
                    hasSet = true;
                    setToUnion.add(set);
                }
            }

            if(setToUnion.size()>=2){
                Set<Integer> set =setToUnion.get(0);
                for(int i = 1; i <setToUnion.size(); i++) {
                    networks.remove(setToUnion.get(i));
                    set.addAll(setToUnion.get(i));
                }
            }

            if(!hasSet){
                HashSet<Integer> set = new HashSet<>();
                set.add(a);
                set.add(b);
                networks.add(set);
            }
        }

        int max = 0;
        for(Set<Integer> set: networks){
            max = Math.max(set.size(), max);
        }

        return max;
    }
}
