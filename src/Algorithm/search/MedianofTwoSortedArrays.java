package Algorithm.search;

/**
 * leetcode #4
 *
 *
 *
 */

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {

        //test 1
        double ans = solution(new int[]{9,10} ,new int[]{3,4,5,6,7,8});
        System.out.println(ans);


        ans = solution3(new int[]{1,3} ,new int[]{2});
        System.out.println(" solution3(): "+ans);

    }

    public static double solution(int[] nums1, int[] nums2){
        if ( nums1.length > nums2.length){
            return solution(nums2,nums1);
        }

        int x = nums1.length; //nums1.length < nums2.length
        int y = nums2.length;

        int low = 0;
        int high = x;

        while ( low <= high){

            int paritionX = (low+high)/2;
            int paritionY = (x+y + 1 )/2 -paritionX;

            System.out.println(" i "+ paritionX +" j "+ paritionY );

            int maxLeftX = (paritionX == 0)  ? Integer.MIN_VALUE : nums1[paritionX-1]; //  0...  px -1 |  px ...pn
            int minRightX = (paritionX == x)  ? Integer.MAX_VALUE: nums1[paritionX];

            int maxLeftY = (paritionY ==0 )? Integer.MIN_VALUE : nums2[paritionY-1];
            int minRightY = ( paritionY == y )? Integer.MAX_VALUE : nums2[paritionY];

            System.out.println(" maxLeftX "+ maxLeftX +" minRightX "+ minRightX );
            System.out.println(" maxLeftY "+ maxLeftY +" minRightY "+ minRightY);

            if ( maxLeftX <= minRightY && maxLeftY <= minRightX){
                if (( x+y)%2==0){
                    return ((double) ( Math.max(maxLeftX,maxLeftY)+ Math.min(minRightX, minRightY)))/2.0;
                }else {
                    return Math.max(maxLeftX,maxLeftY);

                }
            } else if ( maxLeftX> minRightY){
                high = paritionX-1;
            }else {
                low = paritionX+1;
            }


        }
        return -1;

    }


    //2021/12/08

    /**
     *  比较分割线 左右 大小
     *    * 分割线 左边<= 右边
     *    num1Left<= num2Right  && num2Left<= num1Left
     *
     *    1，2  |  MaxInt
     *           ——
     *    3，4，5， | 6，7，8，9
     *
     *    二分 查找 分割线
     *    * 分割线左边元素比右边多 1
     *
     */

    public static double solution3(int[] nums1, int[] nums2){
        //make sure nums1 length is shorter
        if (nums1.length>nums2.length){
            int[] tmp = nums1;
            nums1=nums2;
            nums2=tmp;
        }



        //** 定义 i 为 第一数组 分割线 右边第一个 元素
        //** 定义 j 为 第二数组 分割线 右边第一个 元素

        int m = nums1.length;
        int n = nums2.length;

        //totalLeft count , 合并后数组分割线左边 元素个数
        // * 分割线左边元素比右边多 1 ， 因此 +1
        int totalLeft = (m+n+1)/2 ; // （5+5+1）/2 =5  or (5+ 6+1) /2=6


        int left = 0;
        int right =m;
        //find separate line in nums1 [0,m) so that
        // nums1[i-1]<= nums2[j] && nums2[j-1]<=nums1[i]

        while (left< right){
            //binary search nums1
            int i = left+( right-left+1) /2;
            int j = totalLeft-i;

            if( nums1[i-1]> nums2[j]){//左移分割线
                //next round search [left, i-1]
                right=i-1;
            } else {
                //next round search [i, right]
                left =i;
            }
        }

        int i = left;
        int j = totalLeft-i;

        int nums1Left = i==0? Integer.MIN_VALUE: nums1[i-1];
        int nums1Right = i==m? Integer.MAX_VALUE: nums1[i];

        int nums2Left = j==0? Integer.MIN_VALUE: nums2[j-1];
        int nums2Right = j==n? Integer.MAX_VALUE: nums2[j];

        if( (m+n)%2==0) {//even
            // (left + right ) /2
            return (double) (Math.max(nums1Left,nums2Left)+Math.min(nums1Right,nums2Right))/2;
        } else{
            return Math.max(nums1Left,nums2Left);
        }


       // return -1;
    }

    //FIXME FAILED
    public static double solution2(int[] nums1, int[] nums2){
        if ( nums1.length > nums2.length){
            return solution2(nums2,nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x-1;

        int totalMedianIndex = (x+y-1)/2;
        // total_idex + 1 = i +1 + j+ 1 // counting must be same


        while ( low <= high){
            int i = (low+ high)/2 ;
            int j = totalMedianIndex -i -1;


            System.out.println(" i "+ i +" j "+ j + " totalMedianIndex "+totalMedianIndex);

            int maxLeftX = (i<0)  ? Integer.MIN_VALUE : nums1[i]; //  -1 |  0
            int minRightX = (i >= x-1)  ? Integer.MAX_VALUE: nums1[i+1];  // x-1 | x

            int maxLeftY = (j < 0 )? Integer.MIN_VALUE : nums2[j];
            int minRightY = ( j >=y-1 )? Integer.MAX_VALUE : nums2[j+1];

            System.out.println(" maxLeftX "+ maxLeftX +" minRightX "+ minRightX );
            System.out.println(" maxLeftY "+ maxLeftY +" minRightY "+ minRightY);



            if ( maxLeftX <= minRightY && maxLeftY <= minRightX){
                if (( x+y)%2==0){
                    return ((double) ( Math.max(maxLeftX,maxLeftY)+ Math.min(minRightX, minRightY)))/2.0;
                }else {
                    return Math.max(maxLeftX,maxLeftY);

                }
            } else if ( maxLeftX> minRightY){
                high = i-1;
            }else {
                low = i+1;
            }


        }
        return -1;

    }

    public static double getMedian(int[] nums, int otherV, int index, int xLenght,int yLength ){
        int left  = Math.max(nums[index],otherV);

        if ((xLenght+ yLength)%2 ==  0){
            return (left+nums[index+1])/2;
        }else
            return left;
    }

}
