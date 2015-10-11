package Algorithm;

import java.util.Arrays;

public class SpiralMatrixII {
   
    public int[][] generateMatrix(int n) {
        int[][] v=new int [n][n];
        
        int xi=0, yi=0, circ=0;
        for (int i=1; i<=n*n; ++i)
        {
            v[yi][xi] = i;
            if (yi==circ)
            {
                if (xi<n-circ-1)
                    ++xi;
                else
                    ++yi;
            }
            else
            if (xi==n-circ-1)
            {
                if (yi<n-circ-1)
                    ++yi;
                else
                    --xi;
            }
            else
            if (yi==n-circ-1)
            {
                if (xi>circ)
                    --xi;
                else
                    --yi;
            }
            else
            {
                if (yi>circ+1)
                    --yi;
                else
                {
                    ++xi;
                    ++circ;
                }
            }
        }
        return v;
    }
    
    
    
    public static void main(String[] arg){
    	SpiralMatrixII spMtx=new SpiralMatrixII();
    	int [][] a=spMtx.generateMatrix(5);
    	System.out.println(Arrays.deepToString(a));
    	
    }
    
}
