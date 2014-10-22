package Antra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartNumberGuessing {

	public static void main(String arg[]) throws IOException {
		NumberGuessingGameImpl game=new NumberGuessingGameImpl();
		String lowerLimit;
		String upperLimit = null;
		double ll, ul;

		System.out.println("Input the lower of the guessing range: ");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		lowerLimit= bufferRead.readLine();
		System.out.println("Input the upper of the guessing range: ");
		upperLimit=bufferRead.readLine();
		
		ll=Double.valueOf(lowerLimit);
		ul=Double.valueOf(upperLimit);
		game.Guessing(ll, ul);
	}
}
