public class T1267_countServers {
    public int countServers(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rows[i] = rows[i] + 1;
                    cols[j] = cols[j] + 1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    if(rows[i] >= 2 || cols[j] >= 2){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
