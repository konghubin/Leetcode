import java.util.*;

public class T1315_sumEvenGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        int res = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.val % 2 == 0){
                    if(node.left != null && node.left.left != null){
                        res += node.left.left.val;
                    }
                    if(node.left != null && node.left.right != null){
                        res += node.left.right.val;
                    }
                    if(node.right != null && node.right.left != null){
                        res += node.right.left.val;
                    }
                    if(node.right != null && node.right.right != null){
                        res +=  node.right.right.val;
                    }
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
