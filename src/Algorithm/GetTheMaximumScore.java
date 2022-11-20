package Algorithm;

public class GetTheMaximumScore {

    /*
    two pointer
    get max sum before shared number ,
      int A[]=new int[]{2,4,5,8,10};
        int B[]=new int[]{4,6,8,9};

     shared number: 4
     sumA=2
     sumB=0 --> res += max(2, 0)+ 4
     reset sumA|B

     remove aid, bid , which A[aid] or B[bid] is smaller


     */
    public static int solution(int A[], int B[]){
        int a =0;//sumA reset if encounter shared number
        int b =0; //sumB
        int aid = 0;
        int bid = 0;
        int mod = 1000000007;

        int res = 0;
        while (aid<A.length || bid<B.length){
            if(aid<A.length && (bid>=B.length ||  A[aid]<B[bid] )){
                a += A[aid];
                aid++;
            } else if(bid<B.length && (aid>=A.length ||  A[aid]>B[bid] )){
                b += B[bid];
                bid++;
            } else {
                res += Math.max(a,b)+A[aid];
                aid++;
                bid++;
                a=0;
                b=0;
            }

        }

        res += Math.max(a,b);
        return res % mod ;
    }

    public static void main(String[] args) {
        int A[]=new int[]{2,4,5,8,10};
        int B[]=new int[]{4,6,8,9};
        int res = solution(A,B);
        System.out.println(res);

        A=new int[]{1,3,5,7,9};
         B=new int[]{3,5,100};
         res = solution(A,B);
        System.out.println(res);
    }
}
