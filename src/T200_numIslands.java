import java.util.*;

public class T200_numIslands {
    boolean[][] flags;
    int[][] motions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        flags = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j <n; j++){
                if(grid[i][j] == '1' && flags[i][j] != true){
                    bfs(grid, i, j);
                    res += 1;
                }
            }
        }

        return res;
    }

    void bfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        flags[i][j] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                int[] node = queue.poll();
                for(int[] motion : motions){
                    int newI = node[0] + motion[0];
                    int newJ = node[1] + motion[1];
                    if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == '1' && flags[newI][newJ] != true){
                        queue.offer(new int[]{newI, newJ});
                        flags[newI][newJ] = true;
                    }
                }
            }
        }
    }

    //--------------------------------------------------------------------------------------------------------
    public int titleNumIslands(char[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if( grid[i][j] == '1' ){
                    mark(i,j,grid);
                    num++;
                }
            }
        }
        return num;
    }

    private void mark(int i,int j,char[][] grid){
        if( i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0' ){
            return;
        }
        grid[i][j] = '0';
        mark(i - 1, j,grid);
        mark(i + 1, j,grid);
        mark(i, j - 1,grid);
        mark(i, j + 1,grid);
    }
}
