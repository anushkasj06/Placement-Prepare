import java.util.*;

public class Shortest_Dist_Binary_Maze {
    static class Pair{
        int first;
        int second;
        int third;
        Pair(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0]==destination[0] && source[1]==destination[1]){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)1e9;
            }
        }
        dist[source[0]][source[1]] = 0;

        int[] delr = {-1,0,1,0};
        int[] delc = {0,1,0,-1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,source[0], source[1]));
        while(!q.isEmpty()){
            int d = q.peek().first;
            int r = q.peek().second;
            int c = q.peek().third;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = r+delr[i];
                int ncol = c+delc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && dist[nrow][ncol]>(d+1)){
                    dist[nrow][ncol] = d+1;
                    if(nrow==destination[0] && ncol==destination[1]){
                        return d+1;
                    }
                    q.add(new Pair(d+1, nrow, ncol));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){}
}
