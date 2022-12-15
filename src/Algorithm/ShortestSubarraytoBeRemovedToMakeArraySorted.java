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
        int min = r;
        for(;l<arr.length;l++){
            if(l>0 && arr[l-1]>arr[l])
                break;
            while (r<arr.length && arr[l]>arr[r]){
                r++;
            }
            min = Math.min(min, r-l-1);
        }

        //min = Math.min(r , l);

        return min;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,10,4,2,3,5};
        int res = solution(arr);
        System.out.println(res);

        arr= new int[]{16,10,0,3,22,1,14,7,1,12,15};
        System.out.println(solution(arr));

        arr= new int[]{5,4,3,2,1};
        System.out.println(solution(arr));

        arr= new int[]{1,2,3,10,4,2,3,5};
        System.out.println(solution(arr));
    }
}
