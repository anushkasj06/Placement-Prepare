import java.util.LinkedList;
import java.util.Queue;

public class Rotten_Orange {
    class pair{
        int first;
        int second;
        int tm;
        pair(int first, int second, int tm){
            this.first = first;
            this.second = second;
            this.tm = tm;
        }
    }

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int n = grid.length, m = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        int cntFresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new pair(i, j, 0));
                    visited[i][j] = 2;
                } else{
                    visited[i][j] = 0;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }

        int tm = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int cnt=0;
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            int t = q.peek().tm;
            q.poll();
            tm = Math.max(tm, t);
            for(int i = 0; i < 4; i++){
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                   grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0) {
                    q.add(new pair(nrow, ncol, t + 1));
                    visited[nrow][ncol] = 2;
                    cnt++;               
                }
            }
        }
        if(cnt != cntFresh) return -1; // If not all fresh oranges can rot
        return tm; // Return the time taken to rot all oranges
    }

    public static void main(String[] args) {
        Rotten_Orange obj = new Rotten_Orange();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println("Time taken to rot all oranges: " + obj.orangesRotting(grid));
    }
}
