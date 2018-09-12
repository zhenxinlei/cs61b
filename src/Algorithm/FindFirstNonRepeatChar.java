package Algorithm;

import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author ZhenxinLei
 * 
 * Given a string, find the first non-repeating character in it. 
 * For example, if the input string is “GeeksforGeeks”, 
 * then output should be ‘f’ and 
 * if input string is “GeeksQuiz”, then output should be ‘G’.
 */
public class FindFirstNonRepeatChar {

	public static char solution(String s ){
		char[] input = s.toLowerCase().toCharArray();
		int[] letter_index = new int[26];
		char[] letter = new char[26];
		int[] counter = new int[26];
		
		List<Character> letter_list = new ArrayList<>();
		List<Character> counters = new ArrayList<>();
		int a = 'a';
		int z = 'z';
		//init 
		for (int i=0;i<letter_index.length;i++){
			letter_index[i]=-1;
		}
		
		int counter_last =0;
		for (char c : input){
			int arrayIndex = c-a;
			if ( letter_index[arrayIndex]==-1){
				//add letter to end of counter array 
				counter[counter_last]+=1;
				letter_index[arrayIndex]= counter_last;
				counter_last++;
			} else {
				counter[letter_index[arrayIndex]]+=1;
			}
		}
		
		int postion =-1;
		for(int i =0 ;i<counter.length; i++){
			if (counter[i] ==1 ){
				postion=i;
				break;
			}
		}
		
		int result=0;
		for (int i =0;i<letter_index.length;i++){
			if ( letter_index[i]==postion){
				result=i+a;
				break;
			}
		}
		
		
		
		return (char) result;
	}
	public static void main(String[] args) {
		char r = solution("GeeksforGeeks");
		System.out.println("GeeksforGeeks-> "+r);

		
		r = solution("Geeksfor");
		System.out.println("Geeksfor-> "+r);
		
		
	}
}
