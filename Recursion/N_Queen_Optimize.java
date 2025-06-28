import java.util.ArrayList;
import java.util.List;

public class N_Queen_Optimize {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        
        // Create empty board with all "."
        String str = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(str);
        }

        // Initialize tracking arrays with 0s
        int[] leftrow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        solve(0, board, ans, n, leftrow, upperDiagonal, lowerDiagonal);
        return ans;
    }

    public void solve(int col, List<String> board, List<List<String>> ans, int n,
                      int[] leftrow, int[] upperDiagonal, int[] lowerDiagonal) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftrow[row] == 0 && upperDiagonal[row + col] == 0 && lowerDiagonal[n - 1 + col - row] == 0) {
                char[] chars = board.get(row).toCharArray();
                chars[col] = 'Q';
                board.set(row, new String(chars));

                // Mark the threats
                leftrow[row] = 1;
                upperDiagonal[row + col] = 1;
                lowerDiagonal[n - 1 + col - row] = 1;

                solve(col + 1, board, ans, n, leftrow, upperDiagonal, lowerDiagonal);

                // Backtrack
                chars[col] = '.';
                board.set(row, new String(chars));
                leftrow[row] = 0;
                upperDiagonal[row + col] = 0;
                lowerDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
}
