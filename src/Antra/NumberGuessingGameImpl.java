package Antra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberGuessingGameImpl extends NumberGuessingGameAbs{
	
	@Override
	public void Guessing(double lowerLimit, double upperLimit) throws IOException {
		String answer;
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		double mid;
		do {
			mid=(upperLimit-lowerLimit)/2+lowerLimit;
			System.out.println("Is the number: "+mid);
			
		     answer = bufferRead.readLine();
		     
		     System.out.println(answer);
			if (answer.equals("higher")){
				lowerLimit=mid;
			}
			if (answer.equals("lower")){
				lowerLimit=mid;
			}
			else {
				System.out.println("Your answer is not recognized.");
			}
			
		}while (answer.toLowerCase()!="yes");
		
	}

}
