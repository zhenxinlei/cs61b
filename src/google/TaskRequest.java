package google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Assuming that each task has {id, priority}, you will receive three types of requests as a stream:
1. New task, meaning that task {id, priority} is newly generated.
2. Pick task, meaning that the task handler can handle the next task, so you have to return the highest priority task and remove it.
3. Change priority of task, meaning that specific task’s priority is changed, so you have to update the priority of the task.
For example,
New task {3, 2}  // id = 3, priority = 2
New task {5, 4}
New task {2, 3}
Pick → you should return task {3, 2} // if a task has a lower number for the priority, it is a higher priority.
Update priority {5, 1} // We changed the priority of task whose id is 5 from 4 to 1
Pick → you should return task {5, 1}
New task {1, 0}
New task {4, 6}
Update priority {2, 7}
New task {6, 5}
Pick → you should return task {1, 0}
Pick → you should return task {6, 5}
Pick → you should return task {4, 6}
 */
public class TaskRequest {
    //int[] stream request [request type, id, new_priority]
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);// orders with same priority?? timeupdated/ created
    Map<Integer, int[]> map = new HashMap<>();

    public void pushNew(int[] task){//might want a map to maintain uniques of task id
        int[] t = map.get(task[0]);
        if(t==null) {
            pq.offer(task);
            map.put(task[0], task);
        }
    }

    public int[] pickTask(){
        if(pq.size()==0)
            return null;
        int[] t =  pq.poll();
        map.remove(t[0]);
        return t;
    }

    public void updateTask(int[] task){
        int[] t = map.get(task[0]);
        if(t!=null){
            t[1]=task[1];
            pq.remove(t);//
            pq.offer(t);
        }

    }


    public static void main(String[] args) {
        TaskRequest tq = new TaskRequest();

        int[][] request = new int[][]{
                {0,3,2},{0,5,4},{0,2,3},
                {1,0,0},{2,5,1},{1,0,0},
                {0,1,0},{0,4,6},{2,2,7},
                {0,6,5},{1,0,0},{1,0,0},
                {1,0,0}
        };

        for(int[] req : request){
            if(req[0]==0){
                tq.pushNew(new int[]{req[1],req[2]});
            } else if (req[0]==1) {
                int[] t = tq.pickTask();
                System.out.println("pick "+ Arrays.toString(t));
            } else {
                System.out.println("update ");
                tq.updateTask(new int[]{req[1],req[2]});
            }
        }
    }

}
