package substring;

public class RemoveDuplicate {
	
	public char[] removeDup(char[] str){
		
		char[] netStr=new char[str.length];
		int tail=1;
		for (int i=1; i<str.length; i++){
			int j;
			for (j=0; j<tail;++j){
				if(str[i]==str[j]) break;
			}
			if (j==tail){
				str[tail]=str[i];
				++tail;
			}
		}
		
		str[tail]=0;
		
		return netStr=str;
	}
	
	public static void main(String[] arg){
		String string="aaeeebbcccee";
		char[] str=string.toCharArray();
		RemoveDuplicate rd=new RemoveDuplicate();
		System.out.println(rd.removeDup(str));
		
		
	}

}
