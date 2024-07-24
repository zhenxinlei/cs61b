package Amazon;

import java.util.*;

/**
 * input:
 * 给一串 wordlist 比如 cats,csat, tsac, in, the, bat, tab
 * 再给你一个sentence list : [cats, in, the], [bat in csat]
 * 要求你返回anagram 的 product frequency
 * Ex: cats 有两个anagram, in 有一个, the 有一个, 所以第一个sentence是 2*1*1 = 2
 * Output: [2, 4]
 */
public class ProductOfAnagram {
    //cast sort , cast

    public static int solution_sort(List<String> list, List<String> sentence){
        HashMap<String, Set<String>> map = new HashMap<>();
        //init
        for(String str : list){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);

            Set<String> set = map.getOrDefault(sorted, new HashSet<>());
            set.add(str);
            map.put(sorted,set);
        }

        int prod = 0;
        for(String str:sentence){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);

            Set<String> set  = map.get(sorted);
            if(set==null)
                return 0;

            if(prod==0){
                prod=1;
            }

            prod*=set.size();

        }
        System.out.println("solution_sort "+prod);
        return prod;
    }

    //sol2  char counter

    //sol3  prime factor cons overflow
    public static void main(String[] args) {
        String[] strs = new String[]{"cast","astc","tasc","in","the","bat","tab"};
        List<String> list = Arrays.asList(strs);
        String[] senc = new String[]{"bat","in","cast"};
        List<String> sentence = Arrays.asList(senc);
        solution_sort(list,sentence);
    }

}
