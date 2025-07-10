import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Shortes_Distance_Maze_eight_direction {
    static class Pair {
        int first;
        int second;
        int third;

        Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] != 0 || grid[n - 1][m - 1] != 0) {
            return -1; // start or end blocked
        }

        if (n == 1 && m == 1) {
            return 1; // only one cell which is 0
        }

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        dist[0][0] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0, 0));

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int d = p.first;
            int r = p.second;
            int c = p.third;

            for (int i = 0; i < 8; i++) {
                int nrow = r + dx[i];
                int ncol = c + dy[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    grid[nrow][ncol] == 0 && dist[nrow][ncol] > d + 1) {

                    dist[nrow][ncol] = d + 1;
                    if (nrow == n - 1 && ncol == m - 1) {
                        return d + 1;
                    }
                    q.add(new Pair(d + 1, nrow, ncol));
                }
            }
        }

        return -1;
    }
}
