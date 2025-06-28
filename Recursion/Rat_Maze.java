import java.util.ArrayList;
import java.util.List;

public class Rat_Maze {
    public List<List<String>> findPath(int[][] m, int n) {
        List<List<String>> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        
        // Create a visited array to track the cells
        boolean[][] visited = new boolean[n][n];
        
        // Start the recursive function
        solve(0, 0, m, n, path, ans, visited);
        return ans;
    }

    private void solve(int i, int j, int[][] m, int n, StringBuilder path, List<List<String>> ans, boolean[][] visited) {
        // Base case: If we reach the bottom-right corner, add the path to the answer
        if (i == n - 1 && j == n - 1) {
            ans.add(new ArrayList<>(List.of(path.toString())));
            return;
        }


        // Explore all possible directions (down, right, up, left)
        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};
        String[] directions = {"D", "R", "U", "L"};

        for (int dir = 0; dir < 4; dir++) {
            int newRow = i + dRow[dir];
            int newCol = j + dCol[dir];

            // Check if the new position is valid
            if (isSafe(newRow, newCol, m, visited)) {
                path.append(directions[dir]);
                visited[newRow][newCol] = true; // Mark the new cell as visited
                solve(newRow, newCol, m, n, path, ans, visited);
                path.deleteCharAt(path.length() - 1); // Backtrack
                visited[newRow][newCol] = false; // Unmark the new cell
            }
        }
        
    }

    private boolean isSafe(int row, int col, int[][] m, boolean[][] visited) {
        return (row >= 0 && row < m.length && col >= 0 && col < m[0].length && m[row][col] == 1 && !visited[row][col]);
    }
    public static void main(String[] args) {
        Rat_Maze ratMaze = new Rat_Maze();
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        List<List<String>> paths = ratMaze.findPath(maze, maze.length);
        for (List<String> path : paths) {
            System.out.println(path);
        }
    }

}
