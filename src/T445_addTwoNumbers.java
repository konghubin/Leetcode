import java.util.*;

public class T445_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Deque<Integer> resStack = new ArrayDeque<>();
        ListNode res = new ListNode();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int data = stack1.pop() + stack2.pop() + flag;
            if(data > 9){
                data = data - 10;
                flag = 1;
            }else{
                flag = 0;
            }
            resStack.push(data);
        }
        while(!stack1.isEmpty()){
            int data = stack1.pop() + flag;
            if(data > 9){
                data = data - 10;
                flag = 1;
            }else{
                flag = 0;
            }
            resStack.push(data);
        }
        while(!stack2.isEmpty()){
            int data = stack2.pop() + flag;
            if(data > 9){
                data = data - 10;
                flag = 1;
            }else{
                flag = 0;
            }
            resStack.push(data);
        }
        ListNode index = res;
        if(flag == 1){
            ListNode node = new ListNode(1);
            index.next = node;
            index = node;
        }
        while(!resStack.isEmpty()){
            ListNode node = new ListNode(resStack.pop());
            index.next = node;
            index = node;
        }
        return res.next;
    }

    //--------------------------------------------------------------------
    public ListNode titleAddTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;

        ListNode head1=reverseNode(l1);
        ListNode head2=reverseNode(l2);
        ListNode res=new ListNode();
        ListNode temp=res;
        int val1=0,val2=0;
        int carry=0;
        while(head1!=null||head2!=null){
            val1=head1==null?0:head1.val;
            val2=head2==null?0:head2.val;
            res.next=new ListNode( (val1+val2+carry)%10 );
            carry=(val1+val2+carry)/10;
            res=res.next;
            head1=head1==null?null:head1.next;
            head2=head2==null?null:head2.next;
        }
        if(carry!=0)res.next=new ListNode(carry);
        return reverseNode(temp.next);


    }
    public ListNode reverseNode(ListNode node){
        if(node.next==null) return node;
        ListNode prev=null;
        ListNode cur=node;
        ListNode curBehind=null;
        while(cur!=null){
            curBehind=cur.next;
            cur.next=prev;
            prev=cur;
            cur=curBehind;
        }
        return prev;
    }
}
