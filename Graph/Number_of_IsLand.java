import java.util.LinkedList;
import java.util.Queue;


public class Number_of_IsLand {
    class pair{
        int first;
        int second;
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && visited[i][j]==0){
                    count++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int[][] visited, int i, int j){
        int n = grid.length, m = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i, j));
        visited[i][j] = 1;

        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.poll();
            for(int delRow = -1; delRow <= 1; delRow++){
                for(int delCol = -1; delCol <= 1; delCol++){
                    int nrow= r + delRow;
                    int ncol = c + delCol;
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                       grid[nrow][ncol] == '1' && visited[nrow][ncol] == 0 &&
                       (Math.abs(delRow) + Math.abs(delCol) == 1)) {
                        q.add(new pair(nrow, ncol));
                        visited[nrow][ncol] = 1;
                    }
                }
            }
            
        }
    }

    public static void main(String[] args) {
        Number_of_IsLand obj = new Number_of_IsLand();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + obj.numIslands(grid));
    }
}
