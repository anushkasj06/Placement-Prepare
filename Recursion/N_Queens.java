import java.util.List;
import java.util.ArrayList;

public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String str = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(str);
        }
        solve(0,board, ans,n);
        return ans;

    }

    public void solve(int col, List<String> board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                char[] chars = board.get(row).toCharArray();
                chars[col] = 'Q';
                board.set(row, new String(chars));
                solve(col + 1, board, ans, n);
                chars[col] = '.'; // backtrack
                board.set(row, new String(chars));
            }
        }
    }

    public boolean isSafe(int row, int col, List<String> board, int n) {
        int dupRow = row;
        int dupCol = col;
        // Check for same column
        while (dupRow >= 0) {
            if (board.get(dupRow).charAt(dupCol) == 'Q') {
                return false;
            }
            dupRow--;
        }   
        dupRow = row;
        dupCol = col;
        // Check for upper left diagonal
        while (dupRow >= 0 && dupCol >= 0) {
            if (board.get(dupRow).charAt(dupCol) == 'Q') {
                return false;
            }
            dupRow--;
            dupCol--;
        }
        dupRow = row;
        dupCol = col;
        // Check for upper right diagonal
        while (dupRow >= 0 && dupCol < n) {
            if (board.get(dupRow).charAt(dupCol) == 'Q') {
                return false;
            }
            dupRow--;
            dupCol++;
        }
        return true;
    }
}
