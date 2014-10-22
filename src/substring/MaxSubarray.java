package substring;

public class MaxSubarray {
	
	double maxSubarray(double[] A, int len, int i , int j){
		double T=A[0], V=A[0];
		double Tmin=min(0.0,T);
		for (int k=1; k<len; k++){
			T=T+A[k];
			if (T-Tmin>V){
				V=T-Tmin;
				j=k;
			}
			if(T<Tmin){
				Tmin=T;
				i=(k+1>j)? (k+1):j;
			}
		}
		return V;
	}

	private double min(double  i, double t) {
		if (i<t){
			return i;
		}
		else 
		return t;
	}
	
	
	public static void main (String[] arg){
		double[] A={1.0,2.0,-5,4,-3,2,6,-5,-1};
		int i=0, j=0;
		MaxSubarray max=new MaxSubarray();
		int len=A.length;
		System.out.println(max.maxSubarray(A, len, i, j));
	}

}
