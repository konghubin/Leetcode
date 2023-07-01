import java.util.*;

public class T2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> list = new ArrayList<>();
        int flag = 0;
        while(l1 != null && l2 != null){
            int temp = l1.val + l2.val + flag;
            if(temp > 9){
                list.add(temp - 10);
                flag = 1;
            }else{
                list.add(temp);
                flag = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int data = flag + l1.val;
            if(data > 9){
                list.add(data - 10);
                flag = 1;
            }else{
                list.add(data);
                flag = 0;
            }
            l1 = l1.next;
        }
        while(l2 != null){
            int data = flag + l2.val;
            if(data > 9){
                list.add(data - 10);
                flag = 1;
            }else{
                list.add(data);
                flag = 0;
            }
            l2 = l2.next;
        }
        if(flag != 0){
            list.add(1);
        }
        ListNode l = new ListNode(list.get(0));
        int len = list.size();
        for(int i = 1;i < len;i++){
            ListNode tempNode = new ListNode(list.get(i));
            ListNode node = l;
            while(node.next != null){
                node = node.next;
            }
            node.next = tempNode;
        }
        return l;
    }
}
