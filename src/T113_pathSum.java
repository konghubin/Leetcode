import java.util.*;

public class T113_pathSum {
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> queue = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        DFS(root, targetSum);
        return res;
    }

    private void DFS(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        int target = targetSum - root.val;
        queue.offer(root.val);
        if(root.left == null && root.right == null){
            if(target == 0){
                res.add(new LinkedList<>(queue));
            }
        }
        DFS(root.left, target);
        DFS(root.right, target);
        queue.pollLast();
    }
    //--------------------------------------------------------------------------------------
    public List<List<Integer>> titlePathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(root==null){
            return resultList;
        }
        int now = 0;
        int deep = 0;
        int maxdepth=maxDepth(root);
        int [] path=new int [maxdepth];
        travel(root,targetSum,now,deep,resultList,path);
        return resultList;
    }
    void travel(TreeNode root, int targetSum, int now, int deep, List<List<Integer>> resultList, int[] path){
        now = now + root.val;
        path[deep] = root.val;
        if(now == targetSum && root.left == null && root.right == null){
            List<Integer> IntegerList = new ArrayList<Integer>();
            for(int i = 0; i <=deep; i++){
                IntegerList.add(path[i]);
            }
            resultList.add(IntegerList);
        }
        if(root.left!=null){
            travel(root.left,targetSum,now,deep+1,resultList,path);
        }
        if(root.right!=null){
            travel(root.right,targetSum,now,deep+1,resultList,path);
        }
        
    }

    int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }
}
