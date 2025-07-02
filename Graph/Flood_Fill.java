import java.util.*;

public class Flood_Fill{
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        
        int initialColor = image[sr][sc];
        if (initialColor == color) {
            return image; // No need to fill if the color is the same
        }

        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            ans[i] = Arrays.copyOf(image[i], image[i].length);
        }      
        
        int[] delRow  = {-1,0,1,0};
        int[] delCol  = {0,1,0,-1};
        dfs(sr, sc, image , ans, initialColor, color, delRow, delCol);
        return ans;
    }

    public void dfs(int row, int col, int[][] image, int[][] ans, int initialColor, int color, int[] delRow, int[] delCol) {
        ans[row][col] = color; // Fill the current cell with the new color
        
        for(int i=0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            
            // Check if the new position is within bounds and has the initial color
            if (nrow >= 0 && nrow < image.length && ncol >= 0 && ncol < image[0].length && 
                image[nrow][ncol] == initialColor && ans[nrow][ncol] != color) {
                dfs(nrow, ncol, image, ans, initialColor, color, delRow, delCol);
            }
        }
    }
}