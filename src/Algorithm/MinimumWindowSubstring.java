package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
    	if (S==null ||S.isEmpty()) return "";
    	String sDup=S;
    	int startIndex=-1;
    	int endIndex=-1;
    	//int t=0; //tracking T
    	
    	Set<Character> t=new HashSet<Character> ();
    	Set<Character> tDup=new HashSet<Character> ();
    	int i=0;
    	while (i<T.length()){
    		t.add(T.charAt(i++));
    	}
    	
    	
    	
    	for (i=0; i<S.length();i++){
    		if(startIndex==-1&& t.contains(S.charAt(i))){
    			startIndex=i;
    		}
    		if( t.contains(S.charAt(i))){
    			endIndex=i;
    			tDup.add(S.charAt(i));
    		}
    	}
    	
    	if (tDup.size()<T.length()) return "";
    	
    	//if (S.substring(startIndex,endIndex+1).length()<minWin.length()) minWin=S.substring(startIndex,endIndex+1);
    	return minWindow(S.substring(startIndex+1, endIndex+1), T).isEmpty()? S.substring(startIndex,endIndex+1):minWindow(S.substring(startIndex+1, endIndex+1), T);
    	
        
    }

	public String minWindow2(String s, String t) {
		int[] freq = new int[128];
		int count = t.length();
		for(int i = 0; i < t.length();i++){
			freq[t.charAt(i)]++; //freq of char in T
		}

		int l =0, r = 0;
		int start =-1;//start index of result string , if -1(not found) return ""
		int min = Integer.MAX_VALUE; //min length
		while (r<s.length()){//if r reach end , will move left till no more match , then r++ , and exit
			if(freq[s.charAt(r)]-->0){//not match char freq <0 , match char will be Zero
				count--;//found match in s
			}
			//count ==0 , all matched in window l to r
			while(count==0){
				if(r-l+1<min){
					min = r-l+1;
					start = l;
				} else {
					if(freq[s.charAt(l)]==0){ //removing match char
						count++;
					}
					freq[s.charAt(l)]++;
					l++;
				}
			}

			r++;
		}
		return start==-1?"":s.substring(start,start+min);
	}
    
    //private String minWin="";
    
    public static void main(String[] arg){
    	MinimumWindowSubstring win=new MinimumWindowSubstring();
    	String S="KSABHDCJBSACKDFEWEBCASDFEBDSCA";
    	String T="ABC";
    	System.err.println(win.minWindow(S, T));
    }

}
