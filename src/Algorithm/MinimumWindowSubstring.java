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
    
    //private String minWin="";
    
    public static void main(String[] arg){
    	MinimumWindowSubstring win=new MinimumWindowSubstring();
    	String S="KSABHDCJBSACKDFEWEBCASDFEBDSCA";
    	String T="ABC";
    	System.err.println(win.minWindow(S, T));
    }

}
