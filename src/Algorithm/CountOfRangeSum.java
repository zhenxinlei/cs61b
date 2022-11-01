package Algorithm;

public class CountOfRangeSum {

    public static int countRangeSum(int[] nums, int lower,int upper){
        int[] prefixSum = new int[nums.length+1];
        for(int i = 0; i<nums.length;i++){
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }
        // s           e
        // 0, X, X, X, X
        return mergeSort(prefixSum,0,prefixSum.length-1, lower,upper);


    }

    //why prefix sum, find rang in between,
    //count (i,j) s.t.  lower<= prefixSum[j]-prefixSum[i]<= upper
    //lower+prefixSum[i]<=prefixSum[j]  and  prefixSum[j]<=upper+prefixSum[i]
    //find j st, prefixSum[j] >=lower+prefixSum[j]
   //  [X X X  X   X ]
   //          i

    static int res = 0;

    //start, end is (start, end]   count range between start-1, to end
    public static int  countRange(int[] prefixSum, int start, int end, int lower , int upper){
        if (start>=end)
            return 0;
        if(start==end-1){
             if(prefixSum[end]-prefixSum[start]>=lower && prefixSum[end]-prefixSum[start]<=lower)
                 return 1;
             else
                 return 0;
        }
        int mid = (end-start)/2+start;
        int leftCt = countRange(prefixSum, start,mid, lower,upper);
        int rightCt = countRange(prefixSum, mid, end, lower,upper);

        //[xxxx] || [xxxx]
        //  i         j
        // fixed i (on left side) find how many J (from right side) st. in range
         for (int i = start; i<=mid; i++){
            int leftId  = lowerbound(prefixSum, start, mid, prefixSum[i]+lower);


            int rightId = upperbound(prefixSum, mid+1, end, prefixSum[i]+upper);
            //res += rightId-leftId;

             int j=mid+1;
             while (j<prefixSum.length-1 ){
                 if(prefixSum[j]>=prefixSum[i]+lower){
                     break;
                 }
                 j++;
             }
             int k = end;
             while (k>=mid+1){
                 if(prefixSum[k]<=prefixSum[i]+upper){
                     break;
                 }
                 k++;
             }
             res += (k-j);
        }

        //merge sort left and right
        mergeSort(prefixSum, start,mid, end);
        return res;
    }

    private static  int mergeSort(int[] pfxSum, int low, int high, int lower, int upper){
        if (low >= high) return 0 ;
        int mid = low + (high - low) / 2;

        int ctLt = mergeSort(pfxSum,low, mid, lower, upper);
        int ctRt = mergeSort(pfxSum,mid+1, high, lower, upper);
        int res = ctRt+ctLt;
        int i = mid + 1, j = mid + 1;
        for (int k = low; k <= mid; k++) {
            while (i <= high && pfxSum[i] - pfxSum[k] < lower) i++;
            while (j <= high && pfxSum[j] - pfxSum[k] <= upper) j++;

            res += j - i;
        }

        mergeSort(pfxSum, low, mid, high);

        return res;
    }



    public static void mergeSort(int[] nums, int lo, int mid , int hi ){
        int i = lo, j = mid+1, p=0;
        int[] tmp=new int[hi-lo+1];
        while( i<=mid && j<=hi){
            if(nums[i]<=nums[j]){
                tmp[p]=nums[i];
                i++;
            }else{
                tmp[p]=nums[j];
                j++;
            }
            p++;
        }

        while(i<=mid){
            tmp[p++]=nums[i++];
        }
        while(j<=hi){
            tmp[p++]=nums[j++];
        }

        for(i=0; i<hi-lo+1; i++){
            nums[i+lo]=tmp[i];
        }
    }




    //array is sorted, find first element;s idx not less than key
    // min i st. num[i]>=key,
    public static int lowerbound( int[] array, int lo, int hi, int key){

        while (lo<hi){
            int mid = lo+(hi-lo)/2;
            if (key<=array[mid]){
                hi =mid;
            } else {
                lo = mid+1;
            }
        }
        if(lo<array.length && array[lo]<key)
            lo++;
        return lo;
    }
    //first element'd id  greater than the key
    // min i s.t. key <num[i]
    public static int upperbound(int[] array, int lo, int hi, int key){
        while (lo<hi ){
            int mid = lo+(hi-lo)/2;
            if(key>=array[mid]){
                lo = mid+1;
            } else {
                hi = mid;
            }
        }

        if(lo<array.length&&array[lo]<key){
            lo++;
        }
        return lo;
    }

    public static void main(String[] args) {
        int res = lowerbound(new int[]{1,1,2,2,4,5,6,6,7,8},0,9,1);
        System.out.println("res idx "+res);
        res = upperbound(new int[]{1,1,2,2,4,5,6,6,7,8},0,9,9);
        System.out.println("upperbound res idx "+res);

        int arr[] = new int[]{-2,5,-1};
        res = countRangeSum(arr, -2,2);
        System.out.println(res);
        System.exit(0);
    }

}
