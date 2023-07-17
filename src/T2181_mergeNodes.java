public class T2181_mergeNodes {
    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode();
        ListNode o = res;

        int data = 0;
        while(head.next != null){
            if(head.next.val != 0){
                data += head.next.val;
            }else{
                ListNode newNode = new ListNode(data);
                o.next = newNode;
                o = o.next;
                data = 0;
            }
            head = head.next;
        }
        return res.next;
    }
}
