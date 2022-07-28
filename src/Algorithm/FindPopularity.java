package Algorithm;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindPopularity {
    public static void main(String[] args) {
        func(new int[]{3,5,-2},3);
    }

    public static void func(int[] pop, int k){
        int sum =0;

        PriorityQueue<Integer> q = new PriorityQueue<>(3, Collections.reverseOrder());
        q.add(0);
        for(int i =0; i <pop.length; i++){
            q.add(pop[i]);
            int tmp = sum+pop[i];
            System.out.println(" adding tmp i "+i+"; " + pop[i]);
            for( int j =i+1 ; j<pop.length;j++){
               int newSum = tmp + pop[j];
               q.add(newSum);
               System.out.println(" adding "+j+": " + pop[j]);
            }
            sum = sum+pop[i];
        }

        for (int i = q.size();i>k; i--){
            int tmp = q.poll();
            System.out.println("poll "+tmp);
        }
        System.out.println(q);
    }
}
