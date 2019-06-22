package Algorithm;

import java.util.HashMap;
import java.util.Map;

/***
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2  ); //capacity  );

        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);       // returns 1
        cache.put(3,3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4,4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */

/**
 * LeetCode passed
 */
public class LRUCache {
    final int cap;
    int count=0;
    Map<Integer, DoubleLinkedNode> map = new HashMap<>();

    // double linked list
    // left most , is lease used , right most is most recent;
    DoubleLinkedNode leftMost = new DoubleLinkedNode(-1,-1);
    DoubleLinkedNode rightMost = new DoubleLinkedNode(-1,-1);


    public LRUCache(int capacity) {
        this.cap= capacity;

        leftMost.right = rightMost;
        rightMost.left = leftMost;

    }

    public int get(int key) {

        DoubleLinkedNode node = map.get(key);
        if (node == null) {
            System.out.println( " get "+key+", "+ -1);
            return -1;
        }
        //remove from list
        remove(node);
        insertNew( key,  node);

        System.out.println( " get "+key+", "+ node.val);


        return node.val;

    }

    public void put(int key, int value) {

        if(!map.containsKey(key)){ //new key
            if (count<cap) { // insert to right
                DoubleLinkedNode node = new DoubleLinkedNode(key, value);
                insertNew( key,  node);
                map.put(key,node);
                count++;
            }else { //full , remove least used
                DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);

                DoubleLinkedNode oldLeaseUsed = leftMost.right;


                //remove old
                remove(oldLeaseUsed);
                map.remove(oldLeaseUsed.key);
                //insert new
                insertNew( key,  newNode);
                map.put(key,newNode);


            }


        } else { // old key
            // remove old from d linked list , insert to last

            //update value
            DoubleLinkedNode node = map.get(key);
            node.val = value;

            //remove from list

            remove(node);

            //inset new
            insertNew( key,  node);

        }



    }

    public void  remove(DoubleLinkedNode node) {
        node.left.right = node.right;
        node.right.left = node.left;
        //map.remove(node.key);
    }

    public void insertNew(int key, DoubleLinkedNode node){
        //inset
        DoubleLinkedNode oldMostRecent = rightMost.left;

        oldMostRecent.right = node;
        node.left = oldMostRecent;

        rightMost.left = node;
        node.right = rightMost;

       // map.put(key,node);

    }


    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        int result = -1;
        cache.put(1,1);
        cache.put(2,2);

        result = cache.get((1));
        //System.out.println( " rest "+ result);

        cache.put(3,3);    // evicts key 2
        result = cache.get(2);       // returns -1 (not found)

        //System.out.println( " rest "+ result);
        cache.put(4,4);    // evicts key 1

        result = cache.get(1);       // returns -1 (not found)
        //System.out.println( " rest "+ result);
        result = cache.get(3);       // returns 3
        //System.out.println( " rest "+ result);
        result = cache.get(4);       // returns 4
        //System.out.println( " rest "+ result);


        cache = new LRUCache(1);
        result = -1;
        cache.put(2,1);
        cache.get(2);
        cache.put(3,2);
        cache.get(2);
        cache.get(3);

    }

}
