package barclay;

import jdk.jfr.Frequency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class CountLRUMiss {

    LinkedList<Integer> cache = new LinkedList<>();
    int SIZE = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    int miss = 0;
    CountLRUMiss(int size){
        SIZE = size;
    }

    public static void main(String[] args) {
        CountLRUMiss lru = new CountLRUMiss(2);

        int[] nums= new int[]{1,2,1,3,1,2};
        for(int p : nums){
            lru.request(p);
        }
        System.out.println(lru.miss);
    }

    public void request ( int page){
        if(map.containsKey(page)){
            //exist
        } else {
            miss++;
            if(map.size()>=SIZE) {
                //remove
                int first = cache.removeFirst();
                map.remove(first);
            }
                map.put(page,page);
                cache.addLast(page);
        }
    }
}
