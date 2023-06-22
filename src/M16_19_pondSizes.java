import java.util.*;

public class M16_19_pondSizes {
    public final int[][] directions = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1 ,1}};
    public int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<Integer> resList = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 0){
                    int res = BFS(land, i, j);
                    resList.add(res);
                }
            }
        }
        int[] resArray = new int[resList.size()];
        for(int i = 0; i < resList.size(); i++){
            resArray[i] = resList.get(i);
        }
        Arrays.sort(resArray);
        return resArray;
    }

    private int BFS(int[][] land, int i, int j){
        int res = 0;
        int m = land.length;
        int n = land[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        land[i][j] = -1;
        while(!queue.isEmpty()){
            res++;
            int[] node = queue.poll();
            for(int[] direction : directions){
                int newX = node[0] + direction[0];
                int newY = node[1] + direction[1];
                if(newX >= 0 && newX < m && newY >= 0 && newY < n && land[newX][newY] == 0){
                    queue.offer(new int[]{newX, newY});
                    land[newX][newY] = -1;
                }
            }
        }
        return res;
    }

    //-------------------------------------------------------------------------------------------------------
    private List<Integer> res = new ArrayList<>();

    public int[] titlePondSizes(int[][] land) {
        // DFS

        int m = land.length;
        int n = land[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    int size = dfs(land, i, j);
                    res.add(size);
                }
            }   
        }

        int[] arr = new int[res.size()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }

        Arrays.sort(arr);

        return arr;
    }

    private int dfs(int[][] land, int i, int j) {
        int m = land.length;
        int n = land[0].length;

        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return 0;
        }

        if (land[i][j] != 0) {
            return 0;
        }

        land[i][j] = -1;

        return dfs(land, i+1, j) + 
            dfs(land, i-1, j) + 
            dfs(land, i, j+1) + 
            dfs(land, i, j-1) + 
            dfs(land, i+1, j+1) + 
            dfs(land, i-1, j+1) + 
            dfs(land, i-1, j-1) + 
            dfs(land, i+1, j-1) + 1;
    }
}
