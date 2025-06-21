import java.util.Stack;

public class Largest_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
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
