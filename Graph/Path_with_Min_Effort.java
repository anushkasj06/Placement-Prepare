import java.util.PriorityQueue;

public class Path_with_Min_Effort {
    static class Pair{
        int distance;
        int row;
        int col;
        Pair(int distance, int row, int col){
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)1e9;
            }
        }
        dist[0][0] = 0;
        pq.add(new Pair(0,0,0));
        int[] delr = {-1,0,1,0};
        int[] delc = {0,1,0,-1};
        while(!pq.isEmpty()){
            Pair p = pq.peek();
            pq.remove();
            int d = p.distance;
            int r = p.row;
            int c = p.col;
            if(r==n-1 && c==m-1){
                return d;
            }
            for(int i=0;i<4;i++){
                int nrow = r+delr[i];
                int ncol = c+delc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int effort = Math.max(Math.abs(heights[r][c]-heights[nrow][ncol]),d);
                    if(effort<dist[nrow][ncol]){
                        dist[nrow][ncol] = effort;
                        pq.add(new Pair(effort, nrow, ncol));
                    }

                }
            }
        }
        return -1;
    }
}
