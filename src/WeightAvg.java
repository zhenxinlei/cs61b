
public class WeightAvg{
	
	public double weight(int N, double next, double[] a){
		 double [] w=new double[N];
		 double[] ary=new double[N];
		 double movingWeight=0.0;

		if( a.length>N){
			int cnt=0;
			for (int i=(a.length-N); i<a.length;i++){
				ary[i-a.length+N]=a[i];
				cnt++;
				w[i-a.length+N]=cnt;
			}
			
			for(int i=0;i<N-1;i++){
				ary[i]=ary[i+1];
			}
			ary[N-1]=next; 
			
			for (int i=0; i<N; i++){
				movingWeight+=w[i]*ary[i];
			}		
		}
		return movingWeight;
	}
	//TEST
	public static void main(String[] arg){		
		WeightAvg W=new WeightAvg();
		double [] a={ 3.33,34.3,23.34,454.23,3.0,3.0,2.0};
		System.out.println(W.weight(3, 1.0, a));		
	}
}