package Algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDocDelimeterDigit {
	
	
	public void sort(List<String> list){
		Collections.sort(list, new MyComparator());
	}
	
	
	
	
	class MyComparator implements Comparator<String>{

		@Override
		public int compare(String arg0, String arg1) {
			if (arg0.equals(arg1)){
				return 0;
			}
			String[] s0=arg0.split("\\.");
			String[] s1=arg1.split("\\.");
			
			int shortest=Math.min(s0.length, s1.length);
			
			for (int i =0; i<shortest;i++){
				if (s0[i].compareTo(s1[i])==0) continue; 
				if (s0[i].compareTo(s1[i])<0) {
					return -1;
				}
				else{
					return 1;
				}
				
			}
			
			return s0.length-s1.length;
		}
		
	}
	
	public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        
        
        
        int len=Math.max(v1.length,v2.length);
        
        for (int i=0;i<len;i++){
            
        	//v1[i]=trimZeros(v1[i]);
        	//v2[i]=trimZeros(v2[i]);
        	
        	 int a=i<v1.length?Integer.parseInt(v1[i]):0;
             int b=i<v2.length?Integer.parseInt(v2[i]):0;
            if (a==b){ continue;}
            
            else if (a>b) {return 1;}
            
            else {return -1;}
            
        }
        
        return 0;
    }
    
    public String trimZeros(String s){
        boolean zeros=true;
        int start=0;
        
        while (zeros==true){
        	if (start==s.length()-1) break;
            if (s.charAt(start)!='0'){
                zeros=false;
                break;
            }
            start++;
        }
        
        return s.substring(start,s.length());
        //System.err.println(s);
    }

	
	public static void main(String[] args) {
		SortDocDelimeterDigit sd=new SortDocDelimeterDigit();
		String[] s={"1.2","3.2.1","1.2.1","02","2.3","3.1.2"};
		List<String> list =Arrays.asList(s);
		sd.sort(list);
		System.err.println(list);
		
		System.err.println("result :"+sd.compareVersion("1.0", "1"));
	}
	
}
