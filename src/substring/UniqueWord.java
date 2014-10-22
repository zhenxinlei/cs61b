package substring;

import java.util.*;

public class UniqueWord {
	public Map <String, Integer> map=new HashMap<String, Integer>();
	public Map <String, Integer> uniqueWord(String str){
		int wordCount=0;
		
		if (str.isEmpty()){
			System.out.println("empty str");
			 return map;
		}
		else {
			int len=str.length();
			String str2="";
			
			for (int i=0;i<len;i++){
				
					if(str.charAt(i)==' '){
						
						wordCount+=1;
						if(map.containsKey(str2)){
							map.put(str2, map.get(str2)+1);
						}
						else{
							map.put(str2,1);
						}
						str2="";
						continue; 
					}
					else if(str.charAt(i)==','||str.charAt(i)=='.'||str.charAt(i)=='.'){
						
						continue;
					}
					else{
						str2+=str.charAt(i);
					}
				
			}
		}
		return map;
		
	}
	
	public static void main(String[] arg){
		String str="hi man, i am zhenxin lei. i how are you man. ";
		UniqueWord uw=new UniqueWord();
		Map <String, Integer> map=new HashMap<String, Integer>();
		map=uw.uniqueWord(str);
		
		Iterator it=map.entrySet().iterator();
		while (it.hasNext()){
			Object obj=it.next();
			String temp=obj.toString();
			System.out.println(temp);
			
		}
		
	}
	
	
	

}
