package Algorithm;

public class MedianofTwoSortedArrays {
	
	public static void main(String[] arg){
		MedianofTwoSortedArrays mta=new MedianofTwoSortedArrays();
		int [] A={1};
		int [] B={1};
		System.out.println(mta.findMedianSortedArrays(A,B));


        int [] nums1 ={1,2,3,4};
        int[] nums2 ={5,6,7,8,9};
        System.out.println(mta.solution1(nums1,nums2));
		
	}


    public  double solution1 (int[] nums1, int[]nums2){
        /*
            lo                             hi
            x0, x1,x2 x3...xi, | xi+1,,,,xm
                           xp
            y0,y1, y2...   yj, | yj+1,,,,yn
                           yp


            x0,x1..xi y0,y1 ..yj, |  xi+1...xm ,yj+1...yn 分割线后是median 后半部分
                   xp         yp
              0,1,2,3,4
            x 1,2|3,4  //xP = (0+4)/2 =2 //total = 9 median should be 4
            y 5,6|7,8,9  //yP =  (4+5+1)/2-xp = 3

            xi<=yj+1 && yj<=xi+1

         */
         if(nums1.length> nums2.length) //why always bigger ? make sure split line  in nums2 , the longer one
             return solution1(nums2, nums1);

         int x = nums1.length;
         int y = nums2.length;

         int low = 0;
         int high = x; //x not x-1 !!!

         while (low<=high){
             //binary find x,
             //median = one before split line,!!!!

             /*even 0,1,2,3
                    (0+4)/2
               odd 0,1,2 | 3,4 -> (0+5)/2 = 2. median = one before split line,
               that why  do this Math.max(maxLeftX,maxLeftY);
             */
             int xP =  (low+high)/2; //xp 指向分割线后一个 , why?

             /*
             why + 1
                4           5
             ---x---     ----y ---
             0 1,|2,3    0 1,2,|3,4
             (x+y+1)/2 -xp
             5-2 = 3

               odd
             0,1,2,3,4,| 5,6,7,8,9 (10)
             0,1,2,3,4,5,| 6,7,8,9 10 (10+11+1)/2-xp = 11-5 =6

             totoal median
             10+11 -> 10+1, -> total_split_index (the one after median )12
             xp=5, total_split_index = 12
             (x+y)/2+1+1 - 5 -1


              */
             int yP = (x+y+1)/2-xP;

             int maxLeftX = (xP==0)?Integer.MIN_VALUE : nums1[xP-1];
             int minRightX = (xP==x)?Integer.MAX_VALUE : nums1[xP];

             int maxLeftY = (yP==0)?Integer.MIN_VALUE : nums2[yP-1];
             int minRightY = (yP==y)?Integer.MAX_VALUE : nums2[yP];

             if(maxLeftX<=minRightY && maxLeftY<=minRightX){//found it
                 if((x+y)%2==0)
                     return  (double)((Math.max(maxLeftX, maxLeftY)+Math.min(minRightX,minRightY))/2.0);
                 else
                     return Math.max(maxLeftX,maxLeftY);
             } else if (maxLeftX>minRightY) {
                 high=xP-1;
             } else {
                 low = xP+1;
             }
         }


        return -1;
    }
	
	public double findMedianSortedArrays(int A[], int B[]) {
        if (A.length==0 &&B.length==0){
            return 0;
        }
        if (A.length==0 ||B.length==0){
            if (A.length==0 ){
                if (B.length%2==0){
                    return (B[B.length/2]+B[B.length/2-1])/2.0;
                }
                else{
                    return B[B.length/2];
                }
            }
            if (B.length==0 ){
                if (A.length%2==0){
                    return (A[A.length/2]+A[A.length/2-1])/2.0;
                }
                else
                {
                    return A[A.length/2];
                }
            }
        }
        int [] C=new int[A.length+B.length];
        int a=0;
        int b=0;
        for (int c=0;c<C.length;c++){
           if (a<A.length&&b<B.length){
               if (A[a]<B[b]){
                   C[c]=A[a];
                   a++;
               }
               else {
                   C[c]=B[b];
                   b++;
               }
               continue;
           }
            if (a>=A.length&&b<B.length){
               C[c]=B[b];
               b++;
               continue;
           }
            if (a<A.length&&b>=B.length){
               C[c]=A[a];
               a++;
               continue;
           }
        }
        
        if (C.length%2==0){
                    return (C[C.length/2]+C[C.length/2-1])*0.5;
        }
        else
        {
                    return C[C.length/2];
        }
    

    }
}
