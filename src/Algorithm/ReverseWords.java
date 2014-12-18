package Algorithm;

/**
 * 
 * @author Zhenxin Lei Given an input string, reverse the string word by word.
 * 
 *         For example, Given s = "the sky is blue", return "blue is sky the".
 */
public class ReverseWords {
	public String reverseWords(String s) {
		if (s==null||s.isEmpty()) return ""; //cannot fix "   " all space problem 
		
		// reverse whole
		char[] a = s.toCharArray();
		revWord(a, 0, a.length);

		int st = -1;
		int end = -1;

		for (int i = 0; i < a.length; i++) {

			if (st == -1 && a[i] != ' ') {
				st = i;
			}
			if (end == -1 && a[i] == ' ') {
				end = i;
			}
			if (i == a.length - 1) {
				end = i + 1;
			}

			if (st != -1 && end != -1) {
				revWord(a, st, end);

				st = -1;
				end = -1;
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			sb = sb.append(a[i]);
		}
		return sb.toString();
	}

	
	public String reverseWordsMethod2(String s){
		
		if (s==null||s.isEmpty()||s.trim().isEmpty()) return "";
		char[] a=s.toCharArray();
		revWord(a, 0,a.length);
		int i=0,j=0;
		while (i<a.length&& j<a.length){
			if (a[j]==' '){
				revWord(a, i, j);
				i=j+1;
				j=j+1;
			}
			else {
				j++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < a.length; k++) {
			sb = sb.append(a[k]);
		}
		return sb.toString(); 
	}
	
	
	public static void revWord(char[] a, int s, int l) {
		l--;
		int mid = s + (l - s) / 2;
		

		for (int i = 0; i +s<= mid; i++, l--) {
			char t = a[s + i];
			a[s + i] = a[l];
			a[l] = t;
		}

	}
	
	public static void main (String[] arg){
		ReverseWords rw=new ReverseWords();
		String s=" fd sd";
		//rw.reverseWords(s);
		//System.out.println(rw.reverseWords(s));
		System.out.println(rw.reverseWordsMethod2(s));
	}

}
