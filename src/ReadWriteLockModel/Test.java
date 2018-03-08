package ReadWriteLockModel;

import java.util.HashSet;
import java.util.Set;

public class Test {
	
	public static int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        //M is floor, X is amount, Y weight 
        int countX=0;
        int countY=0;
        int count=0;
        //Set<Integer, Inetger> map= new HashSet<Integer, Integer>();
        Set<Integer> set= new HashSet<Integer>();
        for (int i=0;i<A.length;i++){
            if (countX+1<=X &&countY+A[i]<=Y){//load pp
                countX++;
                countY+=A[i];
              
                    set.add(B[i]);
                    if (i==A.length-1){
                    	count+=set.size();
                    	count+=1;
                    }
               
              
            }
            else if (countX+1>X||countY+A[i]>Y){
             	count+=set.size();
                countX=0;
                countY=0;
                set.clear();
                count+=1;
                i-=1;
            }
            
        }
        return count;
    }
	
	public static void main(String[] args) {
		int [] A={60,80,40};
		int [] B={2,3,5};
		int M=5, X=2,Y=200;
		System.err.println(Test.solution(A, B, M, X, Y));
	}

}
