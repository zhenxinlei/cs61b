package Algorithm;

import java.util.Arrays;

//leetcode 1229
/*
Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.



Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []
 */
public class MeetingScheduler {
    public static void main(String[] args) {

        int[] res = pratice_230206(new int[][] { { 10,50}, { 60,70 },{71,210} }, new int[][] { { 0,15 }, { 60,70} }, 8);
        System.out.println(" res "+Arrays.toString(res));
    }

    public static int[] pratice_230206(int[][] slot1, int[][] slot2, int duration){
        Arrays.sort(slot1,(a,b)-> a[0]-b[0]);
        Arrays.sort(slot2,(a,b)-> a[0]-b[0]);

        int i =0;
        int j =0;
        while(i<slot1.length && j< slot2.length){
            if(slot2[j][0]>=slot1[i][1]){
               i++;
               continue;
            } else if(slot2[j][1]<=slot1[i][0]){
               j++;
               continue;
            } else {
                int startTentative = Math.max(slot1[i][0], slot2[j][0]);
                int endTentative = Math.min(slot1[i][1], slot2[j][1]);

                if (endTentative - startTentative >= duration) {
                    return new int[]{startTentative, startTentative + duration};
                }
                if(slot2[j][1]<slot1[i][1]){ //slot2 end earlyier , next j
                    j++;
                } else {
                    i++;
                }
            }

        }
    return new int[0];
    }

}
