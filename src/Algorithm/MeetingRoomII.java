package Algorithm;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
   end1 <= start2
   check if all ends <= starts
     if true, can attend all meetings

 */
public class MeetingRoomII {
    /*
    Given an array of meeting time intervals consisting of
    start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
     */


    /*
     扫描线
     将所有时间点 排序
     [[0, 15],[5, 20],[25, 30]],
     S  S  E E S E
     见S 加 1 ， E 减1

     */
    public static int solution2(int[][] meetings){
        class  Node{
            int m_time;
            boolean m_isStart;
            Node(int time, boolean isStart){
                m_time = time;
                m_isStart = isStart;
            }
        }

        PriorityQueue<Node> q = new PriorityQueue<Node>( new Comparator<Node>(){
            public int compare(Node node1, Node node2){
                if(node1.m_time!=node2.m_time)
                    return node1.m_time-node2.m_time;
                if(node1.m_isStart){
                    return -1;
                }else
                    return 1;
            }
        });

        for(int[] meeting: meetings){
            q.add(new Node(meeting[0],true));
            q.add(new Node(meeting[1],false));

        }

        int ct=0, max=0;
        while (!q.isEmpty()){
            Node node = q.poll();
            if(node.m_isStart){
                ct++;
                max = Math.max(ct, max);
            }else{
                ct--;
            }
        }


        return max;
    }



    /*
      after sorting:
       case 1   [0,30], [10,25] (2)
       case 2   [0,25] [10,30]  (2)
       case 3   [0,20], [21,30] (1)

       case 1 and case 2 are equ , need two rooms
       two pointer points to start and end array
       if start<end , need +1 room , and move start_pointer to right
       else
     */
    public static int solution(int[][] meetings){
        int[] starts = new int[meetings.length];
        int[] ends = new int[meetings.length];

        for(int i = 0;i< meetings.length;i++){
            starts[i]=meetings[i][0];
            ends[i]=meetings[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        int i = 0;
        int j =0;
        int ct = 0;
        int max = 0;
        while (i< meetings.length && j<meetings.length){
            if(starts[i]<ends[j]){
                i++;
                ct++;
                max = Math.max(ct,max);
            }else  { //if == , only need one room, thus minus 1
                j++;
                ct--;
            }
        }

        return max;
    }

    //pq + sort
    public static int pratice_230206_2(int[][] meetings){
        PriorityQueue<int[]> pq_endtime = new PriorityQueue<>((a,b)-> a[1]-b[1]); //offer meeting into q, pop up the least
         //end time first
        Arrays.sort(meetings,(a,b)-> a[0]!=b[0]? a[0]-b[0]: a[1]-b[1]); //sort meeting by start time
        int max = 0;
        pq_endtime.add(meetings[0]);
        for(int i =1; i < meetings.length;i++){
            if(meetings[i][0]> pq_endtime.peek()[1]){//start after meeting in q;
                pq_endtime.poll();
            }
            pq_endtime.add(meetings[i]);
            max = Math.max(max, pq_endtime.size());
        }
        return max;
    }

    public int pratice_230206_1(int[][] meetings){
        int[] starts = new int[meetings.length];
        int[] ends = new int[meetings.length];

        for(int i =0; i <meetings.length; i++){
            starts[i]=meetings[i][0];
            ends[i]=meetings[i][1];
        }
        Arrays.sort(starts);//nlogn
        Arrays.sort(ends);
        int ct = 0;
        int max = 0;
        int i =0;
        int j =0;
        while(i<starts.length && j<ends.length){//On
            if(starts[i]<ends[j]){
                ct++;
                max = Math.max(ct,max);
                i++;
            } else {
                ct--;
                j++;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int ct = solution(new int[][]{{0, 30},{5, 10},{15, 20}});
        System.out.println(ct);

         ct = solution2(new int[][]{{0, 30},{5, 10},{15, 20}});
        System.out.println(ct);

        ct = pratice_230206_2(new int[][]{{0, 30},{5, 10},{15, 20}});
        System.out.println(ct);
    }

}
