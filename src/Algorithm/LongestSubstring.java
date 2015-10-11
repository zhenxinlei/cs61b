package Algorithm;

public class LongestSubstring {
	 public static int lengthOfLongestSubstring(String s) {
	      //  HashSet<Character> set=new HashSet<Character>();
	        
	        
	        if (s==null||s.isEmpty())return 0;
	        
	        char[] cArray=s.toCharArray();
	        int start=0,end=-1;
	        int maxLength=0;
	        
	        for (int i=0;i<cArray.length;i++ ){
	        	int index=findFirstIndex(cArray, i, start, end);
	        	if (index<i&&index>-1) {//repeate exist
	        		
	        		start=index+1;
	        		end=i;
	        		int temp=end-start+1;
	        		maxLength=Math.max(temp,maxLength);
	        		
	        	}
	        	else{
	        		end++;
	        		int temp=end-start+1;
	        		maxLength=Math.max(temp,maxLength);
	        	}
	        }
	        
	        return maxLength;
	        
	    }
	    
	    private static int findFirstIndex(char[] cArray, int cur, int start, int end) {
	    	for (int i=start;i<=end;i++){
	            if (cArray[cur]==cArray[i]) return i;//i can only be the first or current index
	        }
	        
	        return -1;
		
	}

		                                                     
	    
	    public static void main(String[] args) {
	    	String s="tmmzuxt";
			System.err.println(LongestSubstring.lengthOfLongestSubstring(s));
		}

}
