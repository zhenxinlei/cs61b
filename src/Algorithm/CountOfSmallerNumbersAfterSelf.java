package Algorithm;

import javax.xml.stream.XMLInputFactory;
import java.util.ArrayList;
import java.util.Arrays;

//leetcode 315
public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
      int[] res1=  solution1(new int[]{2,0,1});
      Arrays.asList(res1);
      System.out.println(Arrays.toString(res1));

        res1=  solution1(new int[]{5,2,6,1});
        Arrays.asList(res1);
        System.out.println(Arrays.toString(res1));
    }

    public static int[] solution1(int[] array){
        int [] count = new int[array.length];

        int [] sortedIndex = new int[array.length];
        for(int i =0; i<sortedIndex.length;i++){
            sortedIndex[i]=i;
        }
        mergeSort1(array,sortedIndex,0,array.length-1, count);
        return count;
    }

    public static  void mergeSort1(int[] array, int sortedIndex[], int left, int right, int[] count){
        if(left>=right)
            return ;
        int mid = left+ (right-left)/2;
        mergeSort1(array, sortedIndex, left, mid, count);
        mergeSort1(array,sortedIndex,mid+1, right, count);

        merge1(array,sortedIndex, left, mid,right, count);

    }

    private static void merge1(int[] array,int[]sortedIndex, int left, int mid, int right, int[] count) {
        int leftSize = mid-left+1;
        int rightSize = right-mid;

        int[] leftAry = new int[leftSize];
        int[] rightAry = new int[rightSize];

        for (int i =0; i< leftSize; i++){
            leftAry[i]=sortedIndex[left+i];
        }

        for (int i =0; i< rightSize; i++){
            rightAry[i]= sortedIndex[mid+i+1];
        }


        int i = 0;
        int j =0;
        int k = left;
        int rightCount =0;
        while (i<leftSize && j<rightSize){
            if(array[leftAry[i]]<=array[rightAry[j]]){

                sortedIndex[k]=leftAry[i];
                // update the counter array when theres a bigger on left array
                count[leftAry[i]] +=rightCount;
                k++;
                i++;
            } else if(array[ leftAry[i]]>array[rightAry[j]]){
                sortedIndex[k]=rightAry[j];
                //count how many smaller on right array,
                //will update the counter array when theres a bigger on left array
                rightCount++;
                k++;
                j++;
            }
        }

        while (i<leftSize){
           sortedIndex[k]=leftAry[i];
           count[leftAry[i]] +=rightCount;
            k++;
            i++;
        }
        while (j<rightSize){
            sortedIndex[k]=rightAry[j];
            k++;
            j++;
        }
    }
}
