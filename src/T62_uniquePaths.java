public class T62_uniquePaths {
    Integer[][] meno;
    public int uniquePaths(int m, int n) {
        meno = new Integer[m][n];
        return dfs(m - 1, n - 1)
    }

    public int dfs(int m, int n){
        if(m == 0 && n== 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }
        if(meno[m][n] != null){
            return meno[m][n];
        }
        meno[m][n] = dfs(m - 1, n) + dfs(m, n - 1);
        return meno[m][n];
    }

    //----------------------------------------------------
    public int titleUniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
