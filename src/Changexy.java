
public class Changexy{
	private int x, y;
	public  void ChangeX(){
		x=y+1;
	}
	public  void ChangeY(){
		y=x+1;
	}
	
	//TEST
	public static void main(String[] arg){	
		int x = 0, y = 0, z = 0;
		while(z < 1000)
		{
			z = z + 1;
//			Thread a = new Thread(ChangeX); a.start();
//			Thread b = new Thread(ChangeY); b.start();
		}

				
	}
	
}