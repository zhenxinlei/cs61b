package utils;

public class PrintUtils {
    public static void print2DArray(int[][] a2dArray){
        //System.out.println("{");
        for ( int i = 0; i< a2dArray.length; i++ ){
            System.out.println("[");
            for ( int j =0 ;j < a2dArray[0].length; j++){
                System.out.print(","+a2dArray[i][j]);
            }
            System.out.print("]");
        }
        //System.out.println("{");
    }
}
