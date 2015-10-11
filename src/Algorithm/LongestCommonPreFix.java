package Algorithm;

import java.util.List;

public class LongestCommonPreFix {

	    public String longestCommonPrefix(String[] strs) {
	        int i=0;
	        
	        if (strs.length==0||strs[0]=="")return "";
	        if (strs.length==1) return strs[0];
	        //try {
	        
	       // if (strs[0]=="") return "";
	        
	        try{
	        outerloop:
	        for ( i=0;i<strs[0].length();i++){
	            char c=strs[0].charAt(i);
	            for( int j=1; j<strs.length;j++){
	                
	                if (c!=strs[j].charAt(i)) {
	                    
	                    if(i==0) return "";
	                    break outerloop;
	                
	                }
	            
	                
	            }
	            
	            
	        }
	        
	        }
	        catch(Exception e){
	            
	        }
	        finally {
	        	
	        	System.err.println(strs[0].substring(0,i));
	            return  strs[0].substring(0,i);
	        }
	    }
	    
	    public String longestCommonPrefix2(String[] strs) {
	        if(strs == null || strs.length == 0)    return "";
	        String pre = strs[0];
	        int i = 1;
	        while(i < strs.length){
	        	
	        	System.err.println("indext of pre: "+strs[i].indexOf(pre));
	        	
	            while(strs[i].indexOf(pre) != 0)
	                pre = pre.substring(0,pre.length()-1);
	            i++;
	        }
	        return pre;
	    }
	    
	    
	        public String longestCommonPrefix3(List<String> strs) {
	            if(strs.size()==0) return "";
	            StringBuilder lcp=new StringBuilder();
	            for(int i=0;i<strs.get(0).length();i++){
	                char c=strs.get(0).charAt(i);
	                for(String s:strs){
	                    if(s.length()<i+1||c!=s.charAt(i)) return lcp.toString();
	                }
	                lcp.append(c);
	            }
	            return lcp.toString();
	        }
	    


	
	public static void main(String[] args) {
		LongestCommonPreFix l=new LongestCommonPreFix();
		
		String[] strs={"avda","avdavdb"};
		System.err.println(l.longestCommonPrefix2(strs));
	}
	
}
