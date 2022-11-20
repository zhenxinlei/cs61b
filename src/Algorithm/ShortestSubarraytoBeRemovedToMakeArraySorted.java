package Algorithm;

public class ShortestSubarraytoBeRemovedToMakeArraySorted {

    /*
    two pointer
    right: move to j st. arr[j:n] is ascending;
    loop left from 0 to n
        //break if not ascending
        while loop:
            move right (++) st nums[r]>= nums[l]
        get cur MIN = math.min(MIN, r-l-1)


     */
    public static  int solution (int arr[]){
        int l= 0;
        int r = arr.length-1;
        for( ; r>0;r--){
            if(arr[r-1]>arr[r])
                break;
        }
        if (r ==0) //all sorted
             return 0;
        int min = arr.length;
        for(;l<arr.length;l++){
            if(l>0 && arr[l-1]>arr[l])
                break;
            while (r<arr.length && arr[l]>arr[r]){
                r++;
            }
            min = Math.min(min, r-l-1);
        }

        return min;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,10,4,2,3,5};
        int res = solution(arr);
        System.out.println(res);
    }
}
