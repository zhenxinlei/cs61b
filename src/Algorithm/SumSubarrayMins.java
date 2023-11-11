package Algorithm;

import java.util.Stack;

//leet code 907
public class SumSubarrayMins {
    public static void main(String[] args) {
        int res = solution(new int[]{3,1,2,4,3});
        System.out.println(res);
    }

    /*
        [3, 1, 2, 4, 3]
     0    3, 1, 1, 1, 1   =7
     1       1  1  1  1   =4
     2          2  2  2   =6
     3             4  3   =7
     4                3   =3
                 -----------
                     sum=
      dp[i] : sum  of subArray's min at array[i], or col i 's sum
      ie, i = 1; a[i]=1
      subArray : [3,1], and [1], both minElement sum = 1
      -> dp[i]=1+1
*/
    public  static  int solution(int[] arrays){
        int[] dp= new int[arrays.length];
        //mono statck, increasing
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        int res = 0;
        for(int i =0; i<arrays.length;i++){
            while (stack.size()>1&& arrays[stack.peek()]>=arrays[i]){
                stack.pop();
            }
            if(stack.size()<=1){
                dp[i]=(i-(-1))*arrays[i]; //i - (-1) , from i to left most (len) // %Mod in leetcode
            } else{
                dp[i]= dp[stack.peek()]+ (i-(stack.peek()))*arrays[i];// from peek()(not inclued)  to i value is Arrays[i] %Mod in leetcode
            }
            res += dp[i];
            stack.push(i);
        }

        return res;
    }
}
