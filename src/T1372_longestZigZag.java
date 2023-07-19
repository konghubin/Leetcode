public class T1372_longestZigZag {
    int res = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        dfs(root, 1, 0);
        return res - 1;
    }

    private void dfs(TreeNode node, int dir, int length){
        if(dir == 0){
            if(node.right == null){
                res = Math.max(res, length + 1);
            }else{
                dfs(node.right, 1, length + 1);
            }
            if(node.left != null){
                dfs(node.left, 0, 1);
            }else{
                res = Math.max(res, 1);
            }
        }
        if(dir == 1){
            if(node.left == null){
                res = Math.max(res, length + 1);
            }else{
                dfs(node.left, 0, length + 1);
            }
            if(node.right != null){
                dfs(node.right, 1, 1);
            }else{
                res = Math.max(res, 1);
            }
        }
    }
}
