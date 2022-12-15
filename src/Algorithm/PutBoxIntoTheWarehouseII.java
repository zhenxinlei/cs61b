package Algorithm;

import java.util.Arrays;

public class PutBoxIntoTheWarehouseII {
    public static void main(String[] args) {

        int res = solution(new int[]{1,2,2,3,4}, new int[]{3,4,1,2});
        System.out.println(res);

        res = solution(new int[]{3,5,5,2}, new int[]{2,1,3,4,5});
        System.out.println(res);
    }

    /*
    此题的本质是贪心法。我们首先需要有这样一个概念，在最终的排列中，高的箱子会摆放在靠两边的位置。越高的箱子会摆得越靠边。

于是我们从高到低遍历每一个箱子，查看是否能fit仓库的第一个或者最后一个。如果两个都fit，那我们挑一个较矮的仓库。于是我们就把这个箱子安置好了。于是我们将指向仓库两头的指针做必要的移动，将其中一个挪开已经放置箱子的位置朝中间进发。

然后我们考察下一个箱子。因为这个箱子比刚才的矮，所以必然可以穿越之前那个箱子所在的仓库，等价于忽略掉warehouse的一个边缘元素。于是我们又面对一样的问题，此时的箱子能否fit仓库的第一个或者最后一个？如果两个都fit，那么我们再挑一个较矮的仓库。于是双指针中的一个又可以往中间移动。每移动一次就代表安置了一个箱子。

当箱子都遍历结束，或者双指针i>j的时候，就完成了探索。
     */
    public static int solution (int[] boxes, int [] warehouses){
        Arrays.sort(boxes);

        int l=0,r=warehouses.length-1;
        int i =boxes.length-1;
        int ct=0;
        while (l<=r && i >=0){
            if(warehouses[l]>=boxes[i] && warehouses[r]>=boxes[i]){
                ct++;
                if(warehouses[l]<=warehouses[r]){
                    l++;
                } else {
                    r--;
                }
            } else if (warehouses[l]>=boxes[i]){
                ct++;
                l++;
            } else if(warehouses[r]>=boxes[i]){
                ct++;
                r--;
            }

            i--;
        }


        return ct;
    }
}
