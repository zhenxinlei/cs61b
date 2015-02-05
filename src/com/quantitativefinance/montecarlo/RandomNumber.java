package com.quantitativefinance.montecarlo;


import java.util.Random;



//Box Muller Method Standard Normal Sampling
public class RandomNumber {
	private static double rand_max=.9999999999;
	
	private static Random randomNumberGenerator;

    private  synchronized Random initRNG() {
        Random rnd = randomNumberGenerator;
        return (rnd == null) ? (randomNumberGenerator = new Random()) : rnd;
    }
	
	public double getRandomNumber(){
	double y;
	double x;
	double  sizeSquared;
	double result;
	do{
		//System.out.println("random number :"+this.initRNG().nextDouble());
		x=2.0 * this.initRNG().nextDouble()/rand_max-1;
		y=2.0*this.initRNG().nextDouble()/rand_max-1;
		sizeSquared=x*x+y*y;
	}
	while (sizeSquared>=1.0);
	result =x*Math.sqrt(-2*Math.log(sizeSquared)/sizeSquared);
	return result; 
	}
}
