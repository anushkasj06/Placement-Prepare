import java.util.ArrayList;
import java.util.List;

public class Rat_Maze_Iterative {
    public List<List<String>> findPath(int[][] m, int n) {
        List<List<String>> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        
        // Create a visited array to track the cells
        boolean[][] visited = new boolean[n][n];
        
        // Start the recursive function
        solve(0, 0, m, n, path, ans, visited);
        return ans;
    }

    public void solve(int i, int j, int[][] m, int n, StringBuilder path, List<List<String>> ans, boolean[][] visited) {
        // Base case: If we reach the bottom-right corner, add the path to the answer
        if (i == n - 1 && j == n - 1) {
            ans.add(new ArrayList<>(List.of(path.toString())));
            return;
        }

        if(i+1<n && m[i+1][j]==1 && !visited[i+1][j]){
            path.append("D");
            visited[i+1][j] = true; // Mark the new cell as visited
            solve(i+1, j, m, n, path, ans, visited);
            path.deleteCharAt(path.length() - 1); // Backtrack
            visited[i+1][j] = false; // Unmark the new cell
        }
        if(j+1<n && m[i][j+1]==1 && !visited[i][j+1]){
            path.append("R");
            visited[i][j+1] = true; // Mark the new cell as visited
            solve(i, j+1, m, n, path, ans, visited);
            path.deleteCharAt(path.length() - 1); // Backtrack
            visited[i][j+1] = false; // Unmark the new cell
        }
        if(i-1>=0 && m[i-1][j]==1 && !visited[i-1][j]){
            path.append("U");
            visited[i-1][j] = true; // Mark the new cell as visited
            solve(i-1, j, m, n, path, ans, visited);
            path.deleteCharAt(path.length() - 1); // Backtrack
            visited[i-1][j] = false; // Unmark the new cell
        }
        if(j-1>=0 && m[i][j-1]==1 && !visited[i][j-1]){
            path.append("L");
            visited[i][j-1] = true; // Mark the new cell as visited
            solve(i, j-1, m, n, path, ans, visited);
            path.deleteCharAt(path.length() - 1); // Backtrack
            visited[i][j-1] = false; // Unmark the new cell
        }
            
    }
}
