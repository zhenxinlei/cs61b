package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class NumberOfExcellentPairs {

    public long solution(int nums[],int k){
        ///The Inclusion-Exclusion Principle
        //bits(num1 OR num2) + bits(num1 AND num2) = bits(num1) + bits(num2)
        long[] bitCounts = new long[32];
        long res = 0;

        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        //count numbers with same bits
        for(int s : set){
            bitCounts[Integer.bitCount(s)]++;
        }

        for(int i = 1 ; i<32;i++){
            for(int j = 1;j<32;j++){
                if(j+i>=k)
                    res++;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(" bit count "+ " "+(Integer.bitCount(0xffffffff)));
    }



}
