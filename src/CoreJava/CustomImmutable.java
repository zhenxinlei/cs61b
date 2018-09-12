package CoreJava;

public final class CustomImmutable { //Final, can't be extended 

	private final int id; //final field 
	
	private final int[] arr;
	
	public CustomImmutable(int id, int[] arr) {
		this.id = id;
		this.arr = arr.clone(); //copy obj or data strute 
	}
	
	public int[] getArray(){
		
		return (int[]) this.arr.clone();
		
	}
}
