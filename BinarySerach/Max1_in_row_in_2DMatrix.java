public class Max1_in_row_in_2DMatrix {
    public int findMax1InRow(int[][] matrix) {
        int cntMax =0;
        int index = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int cntOne = m- lowerBound(matrix[i], m, 1);
            if (cntOne > index) {
                cntMax = cntOne;
                index = i;
            }
        }
        return index;
    }

    public int lowerBound(int[] arr, int n, int target) {
        int left = 0, right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                ans = mid; // Update ans to the current mid
                left = mid + 1; // Move to the right side

            } else {
                right = mid - 1; // Move to the left side
            }
        }
        return ans; // Return the index of the first occurrence of target or where it would be inserted
    }
}
