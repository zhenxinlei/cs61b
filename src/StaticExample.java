public class StaticExample{
//static block
static{
	System.out.println("Static Block");
}

//static variable
private static int sv;

public void testStaticVariable(){
	sv++;
	System.out.println("Non-Static method example: static varible value is: "+sv);
}

public static int staticMethod(int i ){
	return i*2;
	
}

/*TEST*/
public static void main (String[] arg){
	StaticExample se=new StaticExample();
	se.testStaticVariable();
	
	int i=1;
	System.out.println("first time call Static method example, value is: "+se.staticMethod(i));
	se.testStaticVariable();
	System.out.println("second time call Static method example, value is: "+se.staticMethod(i));
	

}
}