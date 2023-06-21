import java.util.*;

public class LCP41_chessboard {
    int[][] dists = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    public int flipChess(String[] chessboard) {
        int n = chessboard.length;
        int m = chessboard[0].toCharArray().length;
        int maxResult = 0;
        char[][] chessboardArray = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                chessboardArray[i][j] = chessboard[i].charAt(j);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char data = chessboardArray[i][j];
                if(data == '.'){
                    int result = BFS(chessboardArray, i, j);
                    maxResult = Math.max(maxResult, result);
                }

            }
        }
        return maxResult;
    }

    public int BFS(char[][] chessboardArray, int i, int j){
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        char[][] newChessBoardArray = new char[chessboardArray.length][chessboardArray[0].length];
        int n = chessboardArray.length;
        int m = chessboardArray[0].length;
        for(int a = 0; a < n; a++){
            for(int b = 0; b < m; b++){
                chessboardArray[a][b] = chessboardArray[a][b];
            }
        }
        newChessBoardArray[i][j] = 'X';
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                int[] node = queue.poll();

                for(int[] dist : dists){
                     List<int[]> list = changeChess(newChessBoardArray, node, dist);
                     result += list.size();
                     for(int[] newNode : list){
                         newChessBoardArray[newNode[0]][newNode[1]] = 'X';
                         queue.offer(newNode);
                     }
                }
            }
        }
        return result;
    }

    public List<int[]> changeChess(char[][] chessboardArray, int[] node, int[] dist){
        List<int[]> changeChessArray = new ArrayList<>();
        int x = node[0] + dist[0];
        int y = node[1] + dist[1];
        int n = chessboardArray.length;
        int m = chessboardArray[0].length;
        while(x >= 0 && y >= 0 && x < n && y < m && chessboardArray[x][y] != '.'){
            if(chessboardArray[x][y] == 'O'){
                changeChessArray.add(new int[]{x, y});
            }
            if(chessboardArray[x][y] == 'X'){
                return changeChessArray;
            }
            x = x + dist[0];
            y = y + dist[1];
        }
        changeChessArray.clear();
        return changeChessArray;
    }

    //------------------------------------------------------------------------
    static int[][] dirs = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public int TitleFlipChess(String[] chessboard) {
        int res = 0;
        for (int i = 0; i < chessboard.length; ++i) {
            for (int j = 0; j < chessboard[0].length(); ++j) {
                if (chessboard[i].charAt(j) == '.') {
                    res = Math.max(res, bfs(chessboard, i, j));
                }
            }
        }
        return res;
    }

    public int bfs(String[] chessboard, int px, int py) {
        char[][] board = new char[chessboard.length][chessboard[0].length()];
        for (int i = 0; i < chessboard.length; ++i) {
            for (int j = 0; j < chessboard[0].length(); ++j) {
                board[i][j] = chessboard[i].charAt(j);
            }
        }
        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{px, py});
        board[px][py] = 'X';
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            for (int i = 0; i < 8; ++i) {
                if (judge(board, t[0], t[1], dirs[i][0], dirs[i][1])) {
                    int x = t[0] + dirs[i][0], y = t[1] + dirs[i][1];
                    while (board[x][y] != 'X') {
                        queue.offer(new int[]{x, y});
                        board[x][y] = 'X';
                        x += dirs[i][0];
                        y += dirs[i][1];
                        ++cnt;
                    }
                }
            }
        }
        return cnt;
    }

    public boolean judge(char[][] board, int x, int y, int dx, int dy) {
        x += dx;
        y += dy;
        while (0 <= x && x < board.length && 0 <= y && y < board[0].length) {
            if (board[x][y] == 'X') {
                return true;
            } else if (board[x][y] == '.') {
                return false;
            }
            x += dx;
            y += dy;
        }
        return false;
    }
}
