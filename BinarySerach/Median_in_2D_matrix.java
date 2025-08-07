public class Median_in_2D_matrix {
    public int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = findMin(matrix, n, m);
        int high = findMax(matrix, n, m);
        int req = (n * m) / 2;

        while (low <=high) {
            int mid = low + (high - low) / 2;
            int smallEqual = countSmallEqual(matrix, n, m, mid);
            if(smallEqual <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // This will be the median
    }

    int countSmallEqual(int[][] matrix, int n, int m, int mid) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += upperBound(matrix[i], mid);
        }
        return count;
    }

    int upperBound(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // This returns the count of elements <= target
    }

    public int findMin(int[][] matrix, int n, int m) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, matrix[i][0]);
        }
        return min;
    }

    public int findMax(int[][] matrix, int n, int m) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, matrix[i][m - 1]);
        }
        return max;
    }

}
