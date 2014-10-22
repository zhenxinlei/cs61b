package Algorithm;

public class StringManipulation {
	
	public char[] deleteChar(String str, char c){
		
		char[] s;
		s=str.toCharArray();
		int hole=-1;
		int i=0;
		
		
		for ( i=0; i<s.length; i++){
			if (s[i] == c)
	        {
	            if (hole == -1)
	            {
	                hole = i;
	            }
	        }
	        else
	        {
	            /*Check if it's a first hole or not*/
	            if (hole != -1)
	            {
	                s[hole++] = s[i];
	            }
	        }
	        //i++;
	    }
		//s[hole]='1';
		
		return s ; 
	}
	
	public static void main (String[] arg) {
		String str="accdefcg";
		char ch='c';
		StringManipulation sm=new StringManipulation();
		System.out.println(sm.deleteChar(str, ch));
		
	}

}
