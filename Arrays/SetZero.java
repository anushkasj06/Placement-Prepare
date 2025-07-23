public class SetZero {
    public void setZeroMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // First pass: mark the rows and columns that need to be zeroed
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Second pass: set the marked rows and columns to zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public void setzerobruteforce(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // Set the entire row to zero
                    for (int k = 0; k < n; k++) {
                        if(matrix[i][k] != 0) {
                            matrix[i][k] = -1; // Mark as zeroed
                        }
                    }
                    // Set the entire column to zero
                    for (int k = 0; k < m; k++) {
                        if(matrix[k][j] != 0) {
                            matrix[k][j] = -1; // Mark as zeroed
                        }
                    }
                }
            }
        }

        // Final pass to convert -1 back to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
