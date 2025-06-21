import java.util.*;

public class Maximal_Reactangle{
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] prefixSum = new int[rows][cols];
        int maxArea = 0;

        for(int j = 0; j < cols; j++) {
            int sum=0;
            for(int i = 0; i < rows; i++) {
                sum+=matrix[i][j]-'0';
                if(matrix[i][j]=='0'){
                    sum=0;
                }
                
                prefixSum[i][j]=sum;
            }
        }

        for(int i=0;i<rows;i++){
            maxArea = Math.max(maxArea,largestRectangleArea(prefixSum[i]));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int ele = stack.peek();
                stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int width = heights[ele] * (nse - pse - 1);
                maxArea = Math.max(maxArea, width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int nse = n;
            int ele = stack.peek();
            stack.pop();
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int width = heights[ele] * (nse - pse - 1);
            maxArea = Math.max(maxArea, width);
        }
        return maxArea;
    }
}