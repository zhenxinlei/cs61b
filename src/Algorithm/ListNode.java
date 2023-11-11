package Algorithm;


class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
   }


    public static String print(ListNode head) {
        ListNode node = head;
        StringBuilder sb = new StringBuilder();
        while(node!=null){
           sb.append((node==head?"":"->")+node.val);
           node = node.next;
        }
        return sb.toString();
    }
}
