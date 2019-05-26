public class stringStudy{
	public boolean isEqual(String str1, String str2){
		if (str1.equals(str2)) 
			return true;
		else 
		return false;
	}
	
	public String sepDigiComma(String s){
		return s;
		
		
		
	}
	
	public static void main (String[] arg){
		stringStudy str = new stringStudy();
		String s1="abc";
		String s2="abc";
		if (str.isEqual(s1,s2 )) System.out.println("Strings are equal.");
		
		
	}
	
}