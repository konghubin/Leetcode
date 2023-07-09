public class T64_minPathSum {
    Integer[][] meno;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        meno = new Integer[m][n];
        return dfs(grid, m - 1, n - 1);
    }

    private int dfs(int[][] grid, int m, int n){
        if(m == 0 && n == 0){
            return grid[m][n];
        }
        if(m < 0 || n < 0){
            return Integer.MAX_VALUE;
        }
        if(meno[m][n] != null){
            return meno[m][n];
        }
        int pathSum = Math.min(dfs(grid, m, n - 1), dfs(grid, m - 1, n)) + grid[m][n];
        meno[m][n] = pathSum;
        return meno[m][n];
    }
}
