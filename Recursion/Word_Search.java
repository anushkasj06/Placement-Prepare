import java.util.*;

public class Word_Search{
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) { 
                    if (dfs(board, word, i, j, 0, visited)) {
                        return true; 
                    }
                }
            }
        }
        
        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true; // Found the word
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || 
            visited[row][col] || board[row][col] != word.charAt(index)) {
            return false; // Out of bounds or already visited or character does not match
        }
        
        visited[row][col] = true; // Mark as visited
        
        // Explore all four directions
        boolean found = dfs(board, word, row + 1, col, index + 1, visited) ||
                        dfs(board, word, row - 1, col, index + 1, visited) ||
                        dfs(board, word, row, col + 1, index + 1, visited) ||
                        dfs(board, word, row, col - 1, index + 1, visited);
        
        visited[row][col] = false; // Unmark as visited
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        
        System.out.println(exist(board, word)); // Output: false
    }
}