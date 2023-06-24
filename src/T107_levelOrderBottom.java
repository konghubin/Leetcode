import java.util.*;

public class T107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<List<Integer>> stack = new ArrayDeque<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            stack.push(level);
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
   }

   //----------------------------------------------------
   LinkedList<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> titleLevelOrderBottom(TreeNode root) {
        if(root==null){
            return res;
        }
        cal(root,1);
        return res;
    }

    private void cal(TreeNode root,int level){
        if(root==null){
            return ;
        }
        if(level>res.size()){
            res.addFirst(new ArrayList<>());
        }
        res.get(res.size()-level).add(root.val);
        if(root.left!=null){
            cal(root.left,level+1);
        }
        if(root.right!=null){
            cal(root.right,level+1);
        }
    }
}
