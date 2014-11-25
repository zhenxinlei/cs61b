package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static void main (String[] arg){
		Set<String> dict=new HashSet();
		String s="a";
		dict.add("a");
		
		WordBreak wb=new WordBreak();
		boolean a=wb.wordBreak(s, dict);
		System.out.println(a);
		
	}
	
	public boolean wordBreak(String s, Set<String> dict) {
       //read from back to front to make sure every work is contain in dict. 
		return true;
    }
	
	

}
