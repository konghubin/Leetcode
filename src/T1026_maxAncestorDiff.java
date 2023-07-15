public class T1026_maxAncestorDiff {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }

    private void dfs(TreeNode node, int max, int min){
        if(node == null){
            return;
        }
        if(node.val > max){
            max = node.val;
            res = Math.max(res, max - min);
        }
        if(node.val < min){
            min = node.val;
            res = Math.max(res, max - min);
        }
        dfs(node.left, max, min);
        dfs(node.right, max, min);
    }
}
