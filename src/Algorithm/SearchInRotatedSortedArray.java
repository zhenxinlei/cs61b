package Algorithm;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(solution(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(solution(new int[]{4,5,6,7,8,1,2,3}, 8));
    }

    public static int solution(int nums[], int t){

        int lo = 0;
        int hi = nums.length-1;

        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(t== nums[lo])
                return lo;
            else if (t==nums[mid])
                return mid;
            else if(t==nums[hi])
                return hi;

            if(nums[mid]>nums[hi] && (t< nums[hi] || t>nums[mid])){
                lo = mid+1;
            } else if( nums[mid]<nums[hi] && t> nums[mid] && t<nums[hi]){
                lo = mid+1;
            } else if (nums[lo]>nums[mid] && ( t<nums[mid]|| t>nums[lo])){
                hi = mid-1;
            } else{
                hi = mid-1;
            }
        }

        if(lo>hi)
            return -1;


        return lo;
    }
}
