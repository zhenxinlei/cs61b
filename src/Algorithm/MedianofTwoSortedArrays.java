package Algorithm;

public class MedianofTwoSortedArrays {
	
	public static void main(String[] arg){
		MedianofTwoSortedArrays mta=new MedianofTwoSortedArrays();
		int [] A={1};
		int [] B={1};
		System.out.println(mta.findMedianSortedArrays(A,B));
		
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
        if (A.length==0 &&B.length==0){
            return 0;
        }
        if (A.length==0 ||B.length==0){
            if (A.length==0 ){
                if (B.length%2==0){
                    return (B[B.length/2]+B[B.length/2-1])/2.0;
                }
                else{
                    return B[B.length/2];
                }
            }
            if (B.length==0 ){
                if (A.length%2==0){
                    return (A[A.length/2]+A[A.length/2-1])/2.0;
                }
                else
                {
                    return A[A.length/2];
                }
            }
        }
        int [] C=new int[A.length+B.length];
        int a=0;
        int b=0;
        for (int c=0;c<C.length;c++){
           if (a<A.length&&b<B.length){
               if (A[a]<B[b]){
                   C[c]=A[a];
                   a++;
               }
               else {
                   C[c]=B[b];
                   b++;
               }
               continue;
           }
            if (a>=A.length&&b<B.length){
               C[c]=B[b];
               b++;
               continue;
           }
            if (a<A.length&&b>=B.length){
               C[c]=A[a];
               a++;
               continue;
           }
        }
        
        if (C.length%2==0){
                    return (C[C.length/2]+C[C.length/2-1])*0.5;
        }
        else
        {
                    return C[C.length/2];
        }
    

    }
}
