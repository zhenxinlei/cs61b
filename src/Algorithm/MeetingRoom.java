package Algorithm;

/*
Easy

Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei),
determine if a person could attend all meetings.

Example 1:
Input:
[[0,30],[5,10],[15,20]]
Output:
 false

Example 2:
Input:
 [[7,10],[2,4]]

Output:
 true

 */

import java.util.Arrays;

/*
   end1 <= start2
   check if all ends <= starts
     if true, can attend all meetings

 */
public class MeetingRoom {
    public static boolean canAttendAll(int[][] meetings){
        int[] starts = new int[meetings.length];
        int[] ends = new int[meetings.length];

        for(int i = 0;i< meetings.length;i++){
            starts[i]=meetings[i][0];
            ends[i]=meetings[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for(int i =1;i<meetings.length;i++){
            if(starts[i]< ends[i-1]){//start before previous ends (i-1)
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //[[0,30],[5,10],[15,20]]
       boolean isCanAttendAll =  canAttendAll(new int[][]{{0,30},{5,10},{15,20}});
       System.out.println(isCanAttendAll);

        isCanAttendAll =  canAttendAll(new int[][]{{0,10},{15,20},{20,28}});
        System.out.println(isCanAttendAll);
    }

}
