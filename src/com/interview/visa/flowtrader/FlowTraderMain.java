package com.interview.visa.flowtrader;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Function;

public class FlowTraderMain {
    public static void main(String[] args) {

        String[] strings = new String[]{"a","abb","abc","abc"};
        Arrays.stream(strings)
                .filter(Filter.getPrefix("ab"))
                .map(Map.getCount())
                .forEach(word -> System.out.println(word.name+", "+word.count));

    }


}

class Filter {
    public  static Predicate<String> getPrefix(String prefix){
        return  p->p.startsWith(prefix);

    }
}

class  Map {
    public  static Function<String, CharCount> getCount(){
//        return (word, cc)->{
//            word.equals(cc.name) ? cc.count++:cc.count=cc.count;
//            return
//        };sxzz

        return w->new CharCount(w,1);
    }
}

class CharCount{
    String name;
    Integer count;

    CharCount(String name, Integer count){
        this.name = name;
        this.count = count;
    }

}
