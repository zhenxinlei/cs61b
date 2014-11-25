package Algorithm;

/**
 * 
 * @author Zhenxin Lei
 *Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */

public class ValidPalindrome {
	
	public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        
        //remove all delimeter[,: ./]
        s=s.replaceAll("[^a-zA-Z0-9]","");
        if (s.equals("")) return true; 
        
        s=s.toUpperCase();
        
        int i=0;
        int j=s.length()-1;
        
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
	
	public static void main(String[] arg){
		String s=" ";
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome(s));
	}

}
