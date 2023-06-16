public class T24_swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode tailNode = swapPairs(second.next);
        first.next = tailNode;
        second.next = first;

        return second;
    }
    public ListNode TitleSwapPairs(ListNode head) {
        ListNode virtualNode = new ListNode(0,head);
        ListNode cur = virtualNode;

        ListNode firstNode;
        ListNode secondNode;

        while(cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            cur = firstNode;
        }
        return virtualNode.next;
    }
}
