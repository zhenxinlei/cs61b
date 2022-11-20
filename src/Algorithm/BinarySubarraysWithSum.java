package Algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {

    public  int solution(int[] nums, int S){
        int res= 0;
        int[] pSum = new int[nums.length+1];
        for(int i =1;i<=nums.length;i++){
            pSum[i]=pSum[i-1]+nums[i-1];
        }

        //find subarry sum -> pSum[j]== pSum[i]+S, return such (i,j) pair count
        // like two sum
        Map<Integer, Integer> map = new HashMap<>();//previous number to count
        for (int i: pSum){
            res += map.getOrDefault(i, 0); //get j count , andd to res
            map.put(i+S,map.getOrDefault(i+S,0)+1);
        }

        return res;
    }

    public int atMost(int[] A, int S) {
        //10101
        //res += j-i+1
        //1
        //10, 0
        //101,01,1

        //1100-1
        //all combination atmost  2, all combine <=2
        //all combin <=1
        //atmost 2 - atmost 1

        if (S < 0) return 0;
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            S -= A[j];
            while (S < 0)
                S += A[i++];
            res += j - i + 1; // count all  combinatin
        }
        return res;
    }

    //this is wrong
    public int solutionWrong(int arr[], int goal ){
        int res = 0;

        int l=0;
        int r=0;

        //_10101
        //_11223

        int[] pSum = new int[arr.length+1];
        for(int i =1;i<=arr.length;i++){
            pSum[i]=pSum[i-1]+arr[i-1];
        }

        System.out.println(Arrays.toString(pSum));

        r = 1;
        while( l<r){
            //if sum<goal
              // if r +1 valid || r+1 ==0 --> r+1
              //else if r+1 not valid -> break
              //else if r+1!=0 -> r+1
            //else if sum> goal :
              //l +1
            // else if sum==goal
               // res ++
               //if r+1 valid || r+1 ==0 -> r+1
               //else if r+1 not valid -> l +1
               //else -> l +1

            int sum = pSum[r]-pSum[l];
            if(sum<goal){
                if(r+1<pSum.length ){
                    r++;
                } else {
                    break;
                }
            } else if (sum>goal){
                l++;
            } else {
                res++;
                if(r+1<pSum.length && pSum[r+1]==pSum[r]){
                    r++;
                } else {
                    l++;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum c = new BinarySubarraysWithSum();
        int [] nums= new int[]{1,0,1,0,1};
        int res =0;
        // res= c.solution(nums, 2);
       // System.out.println(res);

        res= c.atMost(nums,2);

        nums= new int[]{0,0,0,0,0};
        res= c.solution(nums, 0);
        System.out.println(res);




    }

}
