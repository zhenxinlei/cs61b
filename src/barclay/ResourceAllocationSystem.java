package barclay;


import java.math.BigInteger;
import java.util.*;

/*
N application with ID (1 to N)
M type of resources are available with a unique resourceID
each applicateion send request message in struct :
    request message:
        - request time
        - execution ending time MMSS, mintues and second

   system can only execution one application , and deined other until finish the previous one
 */
public class ResourceAllocationSystem {


    public static void main(String[] args) {





        String[] input= new String[]{"6 3", "1200 1250 1","1210 1220 1","1225 1230 1","1340 1345 2","1330 1340 2","1330 1345 2"};

        input= new String[]{"6 3", "1200 1250 1","1210 1220 1","1225 1230 1","1200 1250 2","1210 1220 2","1225 1230 2"};


        String[] string_1= input[0].split(" ");
        int num = Integer.valueOf(string_1[0]);

        HashMap<Integer, List<Message>> apps = new HashMap<>();
        for(int i =1;i<=num;i++){
            String[] appsArgs  =  input[i].split(" ");
            int resId = Integer.valueOf(appsArgs[2]);
            List<Message> list =  apps.getOrDefault(resId, new ArrayList<Message>());
            list.add(new Message(Integer.valueOf(appsArgs[0]), Integer.valueOf(appsArgs[1]), resId));
            apps.put(resId, list);
        }

        int count =0;
        for( Map.Entry<Integer, List<Message>> entry:  apps.entrySet())   {
            count +=getMaxExecution( entry.getValue());
        }

        System.out.println(" result "+count);

    }

    public static int getMaxExecution(List<Message> list){
        if(list.isEmpty()|| list.size()==1)
            return list.size();

        Collections.sort(list, (a,b)->a.startTime- b.startTime);

        int lastEndTime = -1;
        int count = 0;
        Message tmp = list.get(0);
        for(int i =1; i <list.size();i++){
            if(tmp.endTime>list.get(i).startTime){
                //overlap
                if(list.get(i).endTime<=tmp.endTime){
                    tmp = list.get(i);//update tmp
                }
            }else {
                count++;
                tmp = list.get(i);
            }
        }

        System.out.println(" count  "+count+" list "+ list);

        return count+1;
    }

    static class Message{
        int startTime;
        int endTime;
        int resId;

        Message(int startTime, int endTime, int resId){
            this.startTime =startTime;
            this.endTime = endTime;
            this.resId = resId;
        }
    }
}
