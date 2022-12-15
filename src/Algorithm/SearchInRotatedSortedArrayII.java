package Algorithm;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(solution(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(solution(new int[]{4,5,6,7,8,1,2,3}, 8));
        System.out.println(solution(new int[]{1,0,1,1,1}, 0));
    }

    // has duplicate in nums
    public static boolean solution(int nums[], int t){

        int lo = 0;
        int hi = nums.length-1;

        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(t== nums[lo] || t==nums[mid] || t==nums[hi])
                return true;

            if(nums[mid]>nums[lo]){ //lhs not roated
                if(t<=nums[mid] && t>=nums[lo] ){ //easier to  decide if t in ordered subarray
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
            } else if(nums[mid]<nums[lo]){//lhs rotated
                if(t>=nums[mid] && t<=nums[hi]){
                    lo = mid+1;
                } else{
                    hi = mid-1;
                }
            } else {//lo == mid
                lo++;
            }
        }

        if(lo>hi)
            return false;


        return true;
    }
}
