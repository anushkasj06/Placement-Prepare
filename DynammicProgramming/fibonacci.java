
import java.util.*;


public class fibonacci {

    public static int fibonacciMemoization(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        dp[n] = fibonacciMemoization(n - 1, dp) + fibonacciMemoization(n - 2, dp);
        return dp[n];
    }

    public static int fibonacciTabulation(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fibonacciOptimized(int n){
        int prev2 = 0;
        int prev1 = 1;
        if (n == 0) return prev2;
        if (n == 1) return prev1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the position of Fibonacci sequence: ");
        int n = sc.nextInt();
       int[] dp = new int[n + 1];
       int ans = fibonacciMemoization(n, dp);
       System.out.println("Fibonacci number at position " + n + " is: " + ans);
    }
}