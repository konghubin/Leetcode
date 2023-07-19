public class T1448_goodNodes {
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return res;
    }

    private void dfs(TreeNode node, int value){
        if(node.val >= value){
            value = node.val;
            res++;
        }
        if(node.left != null){
            dfs(node.left, value);
        }
        if(node.right != null){
            dfs(node.right, value);
        }
    }
}
