package com.interview.visa;

import java.util.ArrayList;
import java.util.List;

/**
* Return limited instance of Class (LimitedInstance)
*
*
*/


public class LimitedInstance {
	
	private static int limitedSize=5;
	
	private int instanceID;
	
	
	private LimitedInstance(int instanceID){
		this.instanceID=instanceID;
	};
	
	private final static LimitedInstance[] instanceArray = new LimitedInstance[limitedSize];
	
	public static LimitedInstance getInstance(){

			int i=0;
			while (i<limitedSize-1 && instanceArray[i]!=null){
				i++;
			}
			
			if (instanceArray[limitedSize-1]==null){
				instanceArray[i]=new LimitedInstance(i+1);
				return instanceArray[i];
			}
			
			return instanceArray[(int) (Math.random()*5%5)];
	}
	
	public static void removeArray(){
		instanceArray[1]=null;
	}
	
	public static void main(String[] arg){
		
		List<LimitedInstance> insList=new ArrayList<LimitedInstance>();
		
		for (int i=0; i<10;i++){
			LimitedInstance limIns=LimitedInstance.getInstance();
			insList.add(limIns);
		}
		
		LimitedInstance.removeArray();
		
		for (int i=0; i<10;i++){
			System.out.println(insList.get(i).instanceID);
		}
		
		
		
		
		
	}

}
