package Algorithm;

import java.util.HashMap;

public class MinWinSubstring {
	public static String minWindow(String s, String t) {
        String res = "";
        int count = t.length();
        HashMap<Character,Integer> hm = new HashMap();
        
        // initialize counts
        for (char c:t.toCharArray()){
            if (!hm.containsKey(c)) hm.put(c,1);
            else hm.put(c,hm.get(c)+1);
        }
        
        int beg = 0;
        int end = 0;
        
        while (end<s.length()){
            char c = s.charAt(end); //character at end of subsequence
            if (hm.containsKey(c)) {
                hm.put(c,hm.get(c)-1);
                if (hm.get(c)>=0) count--;
            }
            
            char cb = s.charAt(beg); //character at beginning of subsequence
            
            //remove characters from subsequence, that we do not need any more
            while ((!hm.containsKey(cb) || hm.get(cb)<0) && beg<end){
                beg++;
                if (hm.containsKey(cb)) hm.put(cb,hm.get(cb)+1);
                cb = s.charAt(beg);
            }
            
            if (count==0 && (res.equals("") || res.length()>end-beg+1))
                res = s.substring(beg,end+1);
            end++;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(minWindow("akdnbwekckjbancse", "abc"));
	}

}
