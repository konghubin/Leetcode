public class T931_minFallingPathSum {
    Integer meno[][];
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        meno = new Integer[n][n];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int res = dfs(matrix, n - 1, i);
            if(res < min){
                min = res;
            }
        }
        return min;
    }

    private int dfs(int[][] matrix, int i, int j){
        int n = matrix.length;
        if(j < 0 || j >= n){
            return Integer.MAX_VALUE;
        }
        if(i == 0){
            return matrix[i][j];
        }
        if(meno[i][j] != null){
            return meno[i][j];
        }
        int minValue = Math.min(dfs(matrix, i - 1, j), Math.min(dfs(matrix, i - 1, j - 1), dfs(matrix, i - 1, j + 1))) + matrix[i][j];
        meno[i][j] = minValue;
        return meno[i][j];
    }
}
