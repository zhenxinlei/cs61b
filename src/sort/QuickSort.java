package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] input = new int[]{3,7,8,5,2,1,9,5,4};

        quickSort(input,0, input.length-1);

        System.out.println(Arrays.toString(input));
    }

    public static  void quickSort(int[] input, int lo, int hi ){

        if (lo >= 0 && hi >= 0 && lo < hi ){
            int p = partition(input, lo, hi);

            quickSort(input, lo, p); //p included
            quickSort(input, p+1, hi);
        }



    }

    public static int partition(int[] input ,int lo, int hi){
        int p = input[( hi+lo)/2];

        int i = lo-1;
        int j = hi+1;
        while (true) {
            //check i = lo-1+1 =lo , if <p continue ,
            //if  a[i] >=p break
            while (input[++i] < p)
                continue;

            //check j= hi+1-1 =hi , if <p continue ,
            //if  a[j] <=p break
            while (input[--j] > p)
                continue;

            //loop forever until i>=j
            //means,    left side is <=P   and right side >=p
            // sort two side again (lo, P) and (p+1,hi)
            if (i >= j) {
                return j;
            }

            //if i < j , swap a[i], a[j] ====>    1,2,3 ... a[j] ...P ... a[i]....n
            swap(input, i,j);
        }
    }


    public static void swap(int[] input, int i , int j){
        int tmp = input[i];
        input[i]=input[j];
        input[j]=tmp;
    }
}
