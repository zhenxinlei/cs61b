
import java.util.HashMap;
import java.util.Map;

public class findLargestRepeat{
	
	public int findRepeat(String s){
		char[] str = s.toCharArray();
		int len=str.length;
		Map<Character, Integer> mp=new HashMap<Character, Integer>();
		if (len!=0){
			for (int i=0; i<len; i++){
				mp.put(str[i], 1);
			}
		}
		
		for (int i=len-1;i>0; i--){
			if(str[i]==str[i-1]) mp.put(str[i-1], (mp.get(str[i-1])+mp.get(str[i])));	
		}
			
		int position=0;
		mp.put('M', 0);
		for (int i=0; i<len; i++){
			if(mp.get(str[i])>mp.get('M')){
				mp.put('M', mp.get(str[i]));
				position=i+1;
			}
		}
		
		return position;
	}
		
	public static void main(String[] arg){
		String str="sdaaa##sdkjkjwww22";
		findLargestRepeat p = new findLargestRepeat();
		System.out.println(p.findRepeat(str));
		
		
	}
	
}
