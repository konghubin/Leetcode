import java.util.*;

public class T994_orangesRotting {
    public int orangesRotting(int[][] grid) {
        boolean startFlag = true;
        int dirs[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    startFlag = false;
                }
            }
        }
        if(startFlag){
            return 0;
        }

        int minute = 0;
        while(!queue.isEmpty()){
            System.out.println(queue.size());
            int num = queue.size();
            for(int s = 0; s < num; s++){
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];

                for(int[] dir : dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }

            }
            minute++;
        }
        

        boolean flag = true;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            return minute - 1;
        }else{
            return -1;
        }
    }

    // ---------------------------------------------------------------
    public int titleOrangesRotting(int[][] grid) {
        int lenm = grid.length;
        int lenn = grid[0].length;
        int count = 0;
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<lenm;i++){
            for(int j = 0;j<lenn;j++){
                if(grid[i][j] ==2) {
                    queue.add(new int[]{i, j});
                }else if(grid[i][j] ==1) count++;
            }
        }
        while(count >0&&!queue.isEmpty()){

            int size = queue.size();
            
            ans++;
            for(int k = 0;k<size;k++){
int[] tmp = queue.poll();
	int i=tmp[0];
          	  int j=tmp[1];
                if(i-1>=0&&grid[i-1][j]==1){
                    queue.add(new int[]{i-1, j});
                    count--;
                    grid[i-1][j] =2; 
                 }
                 if(i+1<grid.length&&grid[i+1][j]==1){
                     queue.add(new int[]{i+1, j});
                    count--;
                    grid[i+1][j] =2; 
                 }
                 if(j-1>=0&&grid[i][j-1]==1){
                     queue.add(new int[]{i, j-1});
                     count--;
                     grid[i][j-1] =2; 
                 }
                if(j+1<grid[0].length&&grid[i][j+1]==1){
                    queue.add(new int[]{i, j+1});
                     count--;
                    grid[i][j+1] =2; 
                }
            }
            
        }
        if(count >0) return -1;
        else return ans;
    }
}
