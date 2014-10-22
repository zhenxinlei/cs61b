import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class FindRepeat {

	/* package whatever; // don't place package name! */
	
	/* Name of the class has to be "Main" only if the class is public. */
	

	/* 
	public void map(String string){
	char[] str=string.toCharArray();
	int l= str.length;
	Map<Character,Integer> m=new HashMap<Character,Integer>();
	for (int i=0; i<l; i++){
	if (m.containsKey(str[i])) m.put(str[i], m.get(str[i])+1);
	m.put(str[i], 1);
	}
	for (int i =0; i<l; i++){
	if (m.get(str[i])==1) System.out.println(str[i]+m.get(str[i]));
	} 
	}

	*/ 
	public Map map(String string){
	char[] str=string.toCharArray();
	
	//use Key to store characters, and Value to record number of times that characters appears
	Map<Character,Integer> m=new HashMap<Character,Integer>(); 
	for (int i=0; i<str.length; i++){
		//if the character appears before
	if (m.containsKey(str[i])){ 
		m.put(str[i], m.get(str[i])+1); 
	} 
	//if the character doesn't appears before
	else {
		m.put(str[i], 1);
		}

	}
	//remove characters appears only once
	for (int i =0; i<str.length; i++){
	if (m.get(str[i])==1) m.remove(str[i]);
	} 
	return m;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
	FindRepeat hw=new FindRepeat();
	// hw.myFunc(1,11,1,1,1);
	String string="aaassgeee";
	hw.map(string);
	Map<Character,Integer> m=new HashMap<Character,Integer>();
	m=hw.map(string);
	


	Iterator iterator = m.entrySet().iterator();
	while (iterator.hasNext()) {
	Map.Entry mapEntry = (Map.Entry) iterator.next();
	//mapEntry.
	if ( mapEntry.getValue()==(Integer) 2 )
	System.out.print( mapEntry.getKey());
	}
	// your code goes here
	}
	

	
	
	
}
