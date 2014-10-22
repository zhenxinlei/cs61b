package substring;

import java.util.Arrays;
import java.util.Stack;

public class Reverse {
	
	public void reverse(String str){
		Stack stc=new Stack();
		int len=str.length();
		char[] arry=new char[len];
		for (int i=0; i<len; i++){
		stc.push(str.charAt(i));
		}
		for (int i=0; i<len; i++){
			arry[i]=(char) stc.pop();
		}
		String str2=Arrays.toString(arry);
		System.out.println(str2);
		
	}
	
	public static void main(String[] arg){
		Reverse r=new Reverse();
		r.reverse("abcdef");
	}

}
