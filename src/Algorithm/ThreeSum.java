package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        solution2(new int[]{-4,-1,-1,0,0,0,0,1,4});
    }


    public static List<List<Integer>> solution1(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<3){
            return res;
        }
        Arrays.sort(nums); //quick sort

        for (int i =0; i < nums.length-1; i++){
            int start = 0;

            //-4,-1,0,0,0,1,4
            if(i!=0 && nums[i]==nums[i-1]){// start from head of repeated numbers
                start=i-1;
            }

            int end = nums.length-1;

            while (start<i && i<end){
                if(start>0 && nums[start]==nums[start-1]){
                    start++;
                    continue;
                }

                if (end<nums.length-1 && nums[end]==nums[end+1]){
                    end--;
                    continue;
                }

                int sum = nums[start]+ nums[i]+ nums[end];
                if(sum==0){
                    List<Integer> tem=new ArrayList<>();
                    tem.add(nums[i]);
                    tem.add(nums[start]);
                    tem.add(nums[end]);
                    res.add(tem);
                    start++;
                    end--;
                }else if (sum<0){
                    start++;
                }else {
                    end--;
                }
            }

        }

        return res;
    }

    public static List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            //-4,-1,-1, 0,0 ,0 ,0 ,1, 4
            int start=i+1; // if i ==0 , other two numbers from 1 to end, and i==1, no need to check i=0, so start from 2 to end
            int end=nums.length-1;
            while(start<end){
                int sum=nums[i]+nums[start]+nums[end];
                if(sum>0){
                    end--;
                }
                else if(sum<0){
                    start++;
                }
                else{
                    List<Integer> tem=new ArrayList<>();
                    tem.add(nums[i]);
                    tem.add(nums[start]);
                    tem.add(nums[end]);
                    res.add(tem);
                    System.out.println( tem );

                    while(start+1<end&&nums[start]==nums[start+1]){
                        start++;
                    }
                    while(end-1>start&&nums[end]==nums[end-1]){
                        end--;
                    }
                    start++;
                    end--;
                }

            }

        }
        return res;
    }
}
