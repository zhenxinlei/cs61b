package Algorithm.string;

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


	/***
	 * LeetCode passed
	 * @param s
	 * @return
	 */
	public static  int lengthOfLongestSubstring2(String s) {
		if(s == null || s.isEmpty() )
			return 0;

		int char_index[] = new int[256];
		for (int i =0; i <256; i++){
			char_index[i]=-1;
		}

		char[] cArray=s.toCharArray();

		int maxSoFar = 0;
		int max =0;

		int start = 0;

		//O(n)
		for (int i =0 ; i < cArray.length ; i ++ ){
			int c = cArray[i];
			int index = c;
			int charPrevIndex = char_index[index];

			if (char_index[index]>=0 && char_index[index] >= start){//repeate char

					start = char_index[index] +1;
					char_index[index] = i;
					// no need to update maxsofar ,

			} else {

				maxSoFar = i -start +1;
				max = Math.max(maxSoFar, max);
				char_index[index] = i;

			}

		}
		return max;


	}

	//2021/12/08
	//leetcode #3
	public static int lengthOfLongestSubstring3(String s ){
		//sliding window
		if (s== null || s.length()==0)
			return 0;

		int[] freq = new int[256];
		//init freq array
		//for (int i=0;i<freq.length;i++){
		//	freq[i]=-1;
		//}

		int left =0;
		int right = -1;
		int res = 0;

		while (left<s.length()) {
			if(right+1<s.length()&& freq[s.charAt(right+1)]==0){ // first occurrence
				freq[s.charAt(right+1)]++;
				right++; //move right index;
			} else { //repeat char
				freq[s.charAt(left)]--;
				left++; //move left index
			}

			res = Math.max(res, right-left+1);
		}

		return res;
	}

		                                                     
	    
	    public static void main(String[] args) {
	    	String s="tmmzuxt";
			System.err.println(LongestSubstring.lengthOfLongestSubstring(s));


			System.out.println(LongestSubstring.lengthOfLongestSubstring2(s));

			System.out.println(" lengthOfLongestSubstring3():   "+ lengthOfLongestSubstring3(s));
		}

}
