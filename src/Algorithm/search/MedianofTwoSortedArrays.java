package Algorithm.search;

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {

        //test 1
        double ans = solution(new int[]{} ,new int[]{2});
        System.out.println(ans);

    }

    public static double solution(int[] nums1, int[] nums2){
        if ( nums1.length > nums2.length){
            return solution(nums2,nums1);
        }

        int x = nums1.length;
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
