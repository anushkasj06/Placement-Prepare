public class Find_Peak_in_2D_matrix {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int maxRowIndex = findMaxInRow(mat,n,m,mid);
            int left = mid-1 >=0 ? mat[maxRowIndex][mid-1] : -1;
            int right = mid+1 < m ? mat[maxRowIndex][mid+1] : -1;
            if(left < mat[maxRowIndex][mid] && right < mat[maxRowIndex][mid]){
                return new int[]{maxRowIndex, mid};
            }else if(left > mat[maxRowIndex][mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int findMaxInRow(int[][] mat, int n, int m, int mid){
        int max = -1;
        int maxIndex = -1;
        for(int i = 0; i < n; i++){
            if(mat[i][mid] > max){
                max = mat[i][mid];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
