public class T25_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 判定是否为最后遗留的Node
        boolean flag = false;
        ListNode flagNode = head;
        for(int i = 0; i < k; i++){
            if(flagNode == null){
                flag = true;
                break;
            }
            if(i != k - 1){
                flagNode = flagNode.next;
            }
        }
        if(flag){
            return head;
        }
        ListNode tailNode = reverseKGroup(flagNode.next, k);
        flagNode.next = null;
        ListNode lastNode = reverseNode(head);
        lastNode.next = tailNode;
        return flagNode;

    }
    public ListNode reverseNode(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode tailNode = reverseNode(head.next);
        tailNode.next = head;
        head.next = null;
        return head;
    }

    //---------------------------------------------------------------------------

    public static ListNode TitleReverseKGroup(ListNode head, int k) {
		ListNode start = head;
		ListNode end = getKGroupEnd(start, k);
		if (end == null) {
			return head;
		}
		// 第一组凑齐了！
		head = end;
		reverse(start, end);
		// 上一组的结尾节点
		ListNode lastEnd = start;
		while (lastEnd.next != null) {
			start = lastEnd.next;
			end = getKGroupEnd(start, k);
			if (end == null) {
				return head;
			}
			reverse(start, end);
			lastEnd.next = end;
			lastEnd = start;
		}
		return head;
	}

	public static ListNode getKGroupEnd(ListNode start, int k) {
		while (--k != 0 && start != null) {
			start = start.next;
		}
		return start;
	}

	public static void reverse(ListNode start, ListNode end) {
		end = end.next;
		ListNode pre = null;
		ListNode cur = start;
		ListNode next = null;
		while (cur != end) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		start.next = end;
	}
}
