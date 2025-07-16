import java.util.PriorityQueue;

class Pair {
    int curr;
    int x;
    int y;

    Pair(int curr, int x, int y) {
        this.x = x;
        this.y = y;
        this.curr = curr;
    }
}

public class Swim_Rising_Water {
    
    public int swimInWater(int[][] grid){
        int[][] vis = new int[grid.length][grid[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.curr - b.curr);
        pq.add(new Pair(grid[0][0], 0, 0));
        vis[0][0] = 1;
        int ans = Integer.MIN_VALUE;
        int[] dr = {1, -1, 0, 0};
        int[] dl = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            ans = Math.max(ans, p.curr);
            int x = p.x;
            int y = p.y;

            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return ans;
            }

            for (int i = 0; i < 4; i++) {
                int nr = x + dr[i];
                int nc = y + dl[i];

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && vis[nr][nc] == 0) {
                    vis[nr][nc] = 1;
                    pq.add(new Pair(grid[nr][nc], nr, nc));
                }
            }
        }
        return ans;
    }
}
