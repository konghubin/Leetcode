public class T86_partition {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = new ListNode();
        ListNode resCur = res;
        ListNode big = new ListNode();
        ListNode bigCur = big;
        while(head != null){
            if(head.val < x){
                resCur.next = head;
                head = head.next;
                resCur = resCur.next;
                resCur.next = null;
            }else{
                bigCur.next = head;
                head = head.next;
                bigCur = bigCur.next;
                bigCur.next = null;
            }
        }
        resCur.next = big.next;
        return res.next;
    }
}
