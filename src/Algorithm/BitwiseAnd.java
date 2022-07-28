package Algorithm;


import java.util.ArrayList;
import java.util.List;

public class BitwiseAnd {
    //given array A consiting of N interges, return size of largest possible subset of A
    // s.t. AND of all elemts is greater than 0

    // neg , 100100..   first bit is 1

    public static void main(String[] args) {
        int[] ary = new int[]{-5,-1,-3,-2};
        int res  = getSubSetSize(ary);
       System.out.println("1 Result "+ res);

        ary = new int[]{5,1,3,2};
        res  = getSubSetSize(ary);
        System.out.println("2 Result "+ res);

        ary = new int[]{-5,-1,0,-3,-2};
        res  = getSubSetSize(ary);
        System.out.println("3 Result "+ res);

        ary = new int[]{-5,-1,0,3,-2};
         res  = getSubSetSize(ary);
        System.out.println("4 Result "+ res);

        ary = new int[]{5,2,1};
        res  = getSubSetSize(ary);
        System.out.println("5 Result "+ res);
    }


    public static int getSubSetSize(int[] ary){
        int size =0;
        int bits[] = new int[32];
        for(int i =0;i<ary.length;i++){
            int bit_pos = 31;
            while (ary[i]>0){
                if( (ary[i] & 1)==1){
                    bits[bit_pos]++; //count '1' at each bit
                }
                bit_pos--;
                ary[i]=ary[i]>>1;
            }
        }

        for(int i =31; i>=0;i--){
            size = Math.max(size, bits[i]);
        }

        return size;

    }

    //dp
    public static int getSubSetSize2(int[] ary){
        int r = ary.length-1;
        int c = r;
        int dp[][]= new int[r+1][r+1];
        int size =0;
        dp[r][r]=ary[r];
        //init diag
        for (int i = r ;i>=0 ;i--){
            dp[i][i]= ary[i];
            if(ary[i]>0)
                size=1;
        }

        for (int i = r ;i>=0 ;i--){
            for ( int j =i-1 ; j>=0;j--){
                dp[i][j]=  dp[i][j+1] & ary[j];

                System.out.println(" i  "+i+"j "+j +" "+ dp[i][j]+",  "+ dp[i][j+1] +" & "+ary[j]);

                if(dp[i][j]>0){
                    size = Math.max(i-j+1, size);
                    System.out.println("* i j "+i+" "+j +" "+ dp[i][j]+" "+size);
                }
            }
        }

        return size;

    }

    public static int getSubSetSize1(int[] ary){
        int negCt = 0;
        int posCt =0;
        List<Integer> testList = new ArrayList<>();
        int andRes =ary[0];
        for(int i=0;i<ary.length; i++){
            if(ary[i]>0) {
                posCt++;
                andRes &= ary[i];
                System.out.println("pos and "+ ary[i]+" "+ andRes);
            }
            else if(ary[i]<0) {
                negCt++;
                andRes &= ary[i];
            }
        }

        if(posCt>0) {
            System.out.println("AND result "+ andRes);
            return posCt + negCt;
        }
        else {
            System.out.println(" non pos  "+ andRes);
            return 0;
        }
    }
}
