package Algorithm;

public class ReverseNodesInKGroup {
    public static ListNode solution (ListNode head, int k ){

        ListNode helperHead = head ;
        ListNode helperTail = head;

        ListNode resHead =null ;

        loop:
        while(helperHead.next!=null){
            int i =0;
            for(i =0; i <k-1;i++){
                if(helperTail.next!=null){
                    helperTail= helperTail.next;
                }else
                    break loop;
            }
            //valid revese
            if(i==k-1){
                if(resHead==null)
                    resHead = helperTail;
                ListNode tail = helperTail.next;
                ListNode prev = tail;
                ListNode next;
                for(i =0; i <k;i++){
                    //prev = helperHead;
                    next = helperHead.next;
                    helperHead.next=prev;

                    prev= helperHead;
                    helperHead = next;

                }
                helperHead = tail;
                helperTail = tail;
            }
        }

        return resHead!=null?resHead: head;
    }

    public static void main(String[] args) {
        ListNode first  = new ListNode(0);
        ListNode node = first;
        for(int i = 1;i<=5;i++){
            node.next= new ListNode(i);
            node = node.next;
        }
        System.out.println(ListNode.print(first.next));
        ListNode res = solution(first.next,2);
        System.out.println(ListNode.print(res));
    }
}
