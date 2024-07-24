package CoreJava;

import java.util.*;

public class CustomMap {

    public static void main(String[] args) {
        testSortedMap();
        func1();
    }

    public static void  testSortedMap(){
        Set<Object> set = new TreeSet<>();
       // set.add(new ArrayList<>());
        //set.add(Boolean.TRUE);
       // set.add(Integer.valueOf(1));


        //System.out.println(set);

        //set.equals(new TreeSet<>());
        Object obj1 = new Object();
        CustomMap map = new CustomMap();
        map.equals(obj1);

    }

    public static void func1 (){
        try {
            TreeMap<Object, Object> map = new TreeMap<>();
            map.put(new Object(), Integer.valueOf(1));
            map.put(new Object(), Integer.valueOf(1));
        } catch (ClassCastException e ){
            e.printStackTrace();
        }
    }


}
