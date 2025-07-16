import java.util.*;

public class Number_of_Island_II {
    public List<Integer> numOfIsLand(int n , int m , int[][]operators){
        Disjoint_Set ds = new Disjoint_Set(n * m);
        int[][] grid = new int[n][m];
        List<Integer> result = new ArrayList<>();
        int count = 0;

        for (int[] op : operators) {
            int x = op[0];
            int y = op[1];

            if (grid[x][y] == 1) {
                result.add(count);
                continue; // Already land, no change
            }

            grid[x][y] = 1; // Mark as land
            count++;

            // Check all 4 directions
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                    int nodeno = x * m + y;
                    int neighborNo = nx * m + ny;
                    if(ds.findPar(nodeno) != ds.findPar(neighborNo)) {
                        ds.unionbySize(nodeno, neighborNo);
                        count--; // Decrease count if connected to an existing island
                    }
                }
            }

            result.add(count);
        }

        return result;
    }
}
