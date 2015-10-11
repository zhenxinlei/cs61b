package Algorithm;

public class PatternMatch {
	
	public int search(String source, String target){
		
		char[] s=source.toCharArray();
		char[] t=target.toCharArray();
		
		int sl=s.length;
		int tl=t.length;
		
		int i=0; // track source position, or staet point of comparation
		int j=0; //track target position
		
		int flag= -1;
		
		while (i<sl){ 
			
			if (s[i]==t[j]){
				//compare next char
				//if j == tl-1; return match
				if (j==tl-1) return i-j;
				
				//starting point, reset flag to -1;
				if (flag==i) flag=-1;
				
				//flag match starting point. bug not getting first matching point
				if (j>0&& s[i]==t[0]&&flag==-1) {
					flag=i;
					System.err.println(" flag "+"flag="+flag+", s[flag]="+s[flag]);
				}
				
				System.err.println(" match "+"i="+i+", s[i]="+s[i]);
				System.err.print(" match "+"j="+j+", t[i]="+t[j]+"\n");
				
				
				i++;
				j++;
			}
			else{
				
				System.err.println("not match "+"i="+i+", s[i]="+s[i]);
				System.err.print("not match "+"j="+j+", t[i]="+t[j]+"\n");
				
				//do need check starting point even not match 
				if (j>0&& s[i]==t[0]&&flag==-1) {
					flag=i;
					System.err.println("Not match flag "+"flag="+flag+", s[flag]="+s[flag]);
				}
				
				//find next begin position in source
				j=0;
				
				
				
				//if flag !=-1 means match starting point exist like: ABABCD, ABCD
				//if flag ==-1 match staring point does NOT exist, to compare next point, increase i by 1
				i=flag!=-1?flag: ++i;
				
				
			}
			
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		PatternMatch pm= new PatternMatch();
		String source="dfABAerABAABCD";
		String target="ABAAB";
		int k=pm.search(source, target);
		try{
			for (int i=k;i<k+target.length();i++){
				System.err.print(source.charAt(i));
			}
		}
		catch (Exception e){
			System.err.println("not found");
		}
	}

}
