package com.quantitativefinance.montecarlo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MonteCarloPricingImpl  {

	public String optionType;
	public String optionStyle;
	public double spot;
	public double strike;
	public double vol;
	public double r;
	public double expiry;
	public int numberOfPath ;
	
	public double getPrice(/*String optionType, String optionStyle, double spot, double strike, double vol, double r, double expiry, int numberOfPath*/ ){
		
		double variance=vol*vol*expiry;
		double rootVar=Math.sqrt(variance);
		double itoCorr=-0.5*variance;
		double a=Math.exp(r*expiry+itoCorr);
		double movedSpot=spot*Math.exp(r*expiry+itoCorr);
		double thisSpot;
		double runningSum=0;
		RandomNumber random=new RandomNumber();
		int optionTypeInd=optionType.equals("Call")? 1:-1;
		double timeStep=1000;
		double dt= 0.9/(vol*vol)/(1000*1000); //time step per day
		
		
		if (optionStyle.equals("American")){
			double drift =r-.5*vol*vol;
			List <Double> Z=new ArrayList<Double>();
			for (int i=0; i<numberOfPath; i ++){
				Z.add(i, random.getRandomNumber());	
			}
			
			List<Double> assetPriceList=new ArrayList<Double>();
			//init setup
			for (int i=0;i<numberOfPath; i++){
				assetPriceList.add(i,spot*Math.exp(drift*expiry+vol*Z.get(i)*Math.sqrt(dt)));
			}
			
			List<Double> optionValueList=new ArrayList<Double>();
			//init setup
			for (int i=0;i<numberOfPath; i++){
				optionValueList.add(i,Math.max(optionTypeInd*(assetPriceList.get(i)-strike), 0));
			}
			
			double mean=0;
			double dummy=(int)(expiry/dt)+1;
			for (int i=1;i<=(int)(expiry/dt)+1;i++){
				double sum=0.0;
				for (int p=0; p<numberOfPath; p ++){
					Z.set(p, random.getRandomNumber());	
					double assetPrice_before=assetPriceList.get(p)/( Math.exp(drift*dt+vol*Math.sqrt(dt)*Z.get(p)) );
					assetPriceList.set(p,assetPrice_before);
					//double optionValue_before=MathUtil.exp(-r*(dummy-i)*dt) *Math.max(MathUtil.exp(-r*dt)*optionValueList.get(p),Math.max(optionTypeInd*(assetPrice_before-strike),0.0));
					double optionValue_before=Math.max(Math.exp(-r*expiry)*optionValueList.get(p),Math.exp(-r*(dummy-i)*dt) *Math.max(optionTypeInd*(assetPrice_before-strike),0.0));
					optionValueList.set(p,optionValue_before);
					sum+=optionValue_before;
				}
				mean=sum/numberOfPath;
				
			}

			return mean;	

		}
		else //call european method 
		{
			for (int i=0; i<numberOfPath;i++){
				double thisGaussian=random.getRandomNumber();
				thisSpot=movedSpot*Math.exp(rootVar*thisGaussian);
				double thisPayOff=Math.max(optionTypeInd*(thisSpot-strike),0.0);
				runningSum+=thisPayOff;
				
			}
			double mean;
			mean= runningSum / numberOfPath;
			mean*=Math.exp(-r*expiry);
			return mean;
			
		}
			
		

	}

	private static class MultithreadMC implements Callable<Double>{
		
		private int myID;
		public String optionType;
		public String optionStyle;
		public double spot;
		public double strike;
		public double vol;
		public double r;
		public double expiry;
		public int numberOfPath ;
		
        public MultithreadMC(int myID,String optionType, String optionStyle, double spot, double strike, 
    			double vol, double r, double expiry, int numberOfPath) {
            this.myID = myID;
            this.expiry=expiry;
    		this.numberOfPath=numberOfPath;
    		this.optionStyle=optionStyle;
    		this.optionType=optionType;
    		this.r=r;
    		this.spot=spot;
    		this.vol=vol;
    		this.strike=strike;
        }
	@Override
	public Double call() throws Exception {
		MonteCarloPricingImpl mcPricing=new MonteCarloPricingImpl(optionType, optionStyle, spot, strike, vol, r, expiry, numberOfPath);
		//MonteCarloPricingImpl.this.getPrice();
		//double myID=this.myID;
		//System.out.println("Thread id"+myID);
		
		double variance=vol*vol*expiry;
		double rootVar=Math.sqrt(variance);
		double itoCorr=-0.5*variance;
		double movedSpot=spot*Math.exp(r*expiry+itoCorr);
		double thisSpot;
		double runningSum=0;
		RandomNumber random=new RandomNumber();
		int optionTypeInd=optionType.equals("Call")? 1:-1;
		double timeStep=1000;
		double dt= 0.9/(vol*vol)/(1000*1000);
		
		for (int i=0; i<numberOfPath;i++){
			double thisGaussian=random.getRandomNumber();
			thisSpot=movedSpot*Math.exp(rootVar*thisGaussian);
			double thisPayOff=Math.max(optionTypeInd*(thisSpot-strike),0.0);
			runningSum+=thisPayOff;
			
		}
		double mean;
		mean= runningSum / numberOfPath;
		//mean= runningSum ;
		mean*=Math.exp(-r*expiry);
		return mean;
		
		
	}
	}
	public MonteCarloPricingImpl (String optionType, String optionStyle, double spot, double strike, 
			double vol, double r, double expiry, int numberOfPath){
		this.expiry=expiry;
		this.numberOfPath=numberOfPath;
		this.optionStyle=optionStyle;
		this.optionType=optionType;
		this.r=r;
		this.spot=spot;
		this.vol=vol;
		this.strike=strike;
	}
	
	
	public static void main (String[] arg){
		
		 String optionType="Call";
		 String optionStyle="European";
		 double spot=100;
		 double strike=95;
		 double vol=0.1;
		 double r=0.05;
		 double expiry=1;
		 int numberOfPath =10000000;
		
		int threadcount=Runtime.getRuntime().availableProcessors();
		threadcount=4;
		
		ExecutorService executorService = Executors.newFixedThreadPool(threadcount); 
		ArrayList<Future<Double>> partialCounts = 
	            new ArrayList<Future<Double>>();
		double start=System.currentTimeMillis();
	        for (int i = 0; i < threadcount; ++i) {
	            partialCounts.add(executorService.submit(new MultithreadMC(i,optionType, optionStyle, spot, strike, vol, r, expiry, numberOfPath)));
	        }
	    double sum=(double) 0;
	    
	    try {
	    	for (Future<Double>future: partialCounts)  {  
				sum=sum+future.get();
	    	}
	    	System.out.println("result: " +sum/threadcount);
		    //System.out.println(start);
		    System.out.println("time used: " + (System.currentTimeMillis()-start));
		    executorService.shutdown();
		    
		     start=System.currentTimeMillis();
		     //System.out.println(start);
		    MonteCarloPricingImpl mcPricing=new MonteCarloPricingImpl(optionType, optionStyle, spot, strike, vol, r, expiry, 40000000);
		    System.out.println("Price :"+ mcPricing.getPrice());
		    System.out.println("time used :"+ (System.currentTimeMillis()-start));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    
	    
	}
	
}
