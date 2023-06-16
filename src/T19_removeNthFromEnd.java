public class T19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 1 && head.next == null){
            return null;
        }
        ListNode frontNode = head;
        ListNode flagNode = head;
        for(int i = 0; i < n; i++){
            flagNode = flagNode.next;
        }
        if(flagNode == null){
            return head.next;
        }
        while(flagNode.next != null){
            frontNode = frontNode.next;
            flagNode = flagNode.next;
        }
        frontNode.next = frontNode.next.next;
        return head;
    }

    public ListNode titleRemoveNthFromEnd(ListNode head, int n) {
        
        ListNode dumpNode = new ListNode(0,head);
        ListNode fast = dumpNode;
        ListNode slow = dumpNode;

        for(int i = 1 ; i<=n ; i ++) {
            fast = fast.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dumpNode.next;

    }
}
