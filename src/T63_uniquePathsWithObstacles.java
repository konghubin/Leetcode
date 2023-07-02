public class T63_uniquePathsWithObstacles {
    Integer[][] meno;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        meno = new Integer[m][n];
        return dfs(obstacleGrid, m - 1, n - 1);
    }

    public int dfs(int[][] obstacleGrid, int m, int n){
        if(m == 0 && n== 0){
            return 1;
        }
        if(m < 0 || n < 0 || obstacleGrid[m][n] == 1){
            return 0;
        }
        if(meno[m][n] != null){
            return meno[m][n];
        }
        meno[m][n] = dfs(obstacleGrid, m - 1, n) + dfs(obstacleGrid, m, n - 1);
        return meno[m][n];
    }

    //------------------------------------------------------------------------------
    public int titleUniquePathsWithObstacles(int[][] arr) {
        int m=arr.length;//二维数组行数
         int n=arr[0].length;//二维数组列数
         int [][]dp=new int [m][n];
         if (arr[0][0]==1||arr[m-1][n-1]==1) {
             return 0;
         }
         
         for (int i = 0; i < m&&arr[i][0]==0; i++) {
             dp[i][0]=1;
         }
         for (int i = 0; i < n&&arr[0][i]==0; i++) {
             dp[0][i]=1;
         }
         
         
         for (int i = 1; i < m; i++) {
             for (int j = 1; j < n; j++) {
                 dp[i][j]=arr[i][j]==0?dp[i-1][j]+dp[i][j-1]:0;
             }
         }
         return dp[m-1][n-1];
     }
}
