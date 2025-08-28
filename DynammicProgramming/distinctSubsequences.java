import java.util.*;

class distinctSubsequences {
    public static int distinctSubseqmemo(String s, String t) {
       int n = s.length();
       int m = t.length();
       int[][] memo = new int[n + 1][m + 1];
       for (int i = 0; i <= n; i++) {
           Arrays.fill(memo[i], -1);
       }
       return distinctSubseqUtil(s, t, n, m, memo);
    }

    private static int distinctSubseqUtil(String s, String t, int i, int j, int[][] memo) {
       if (j == 0) return 1;
       if (i == 0) return 0;
       if (memo[i][j] != -1) return memo[i][j];

       if (s.charAt(i - 1) == t.charAt(j - 1)) {
           memo[i][j] = (distinctSubseqUtil(s, t, i - 1, j - 1, memo) + distinctSubseqUtil(s, t, i - 1, j, memo)) % 1000000007;
       } else {
           memo[i][j] = distinctSubseqUtil(s, t, i - 1, j, memo);
       }
       return memo[i][j];
    }


    public int distinctSubseqtabu(String s, String t) {
       int n = s.length();
       int m = t.length();
       int[][] dp = new int[n + 1][m + 1];

       for (int i = 0; i <= n; i++) {
           dp[i][0] = 1;
       }

       for (int i = 1; i <= n; i++) {
           for (int j = 1; j <= m; j++) {
               if (s.charAt(i - 1) == t.charAt(j - 1)) {
                   dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 1000000007;
               } else {
                   dp[i][j] = dp[i - 1][j];
               }
           }
       }
       return dp[n][m];
    }


    public int distinctSubseqSO(String s, String t) {
       int n = s.length();
       int m = t.length();
       int[] prev = new int[m + 1];
       prev[0] = 1;

       for (int i = 1; i <= n; i++) {
           int[] curr = new int[m + 1];
           curr[0] = 1;
           for (int j = 1; j <= m; j++) {
               if (s.charAt(i - 1) == t.charAt(j - 1)) {
                   curr[j] = (prev[j - 1] + prev[j]) % 1000000007;
               } else {
                   curr[j] = prev[j];
               }
           }
           prev = curr;
       }
       return prev[m];
    }


    public int distinctSubseqSOP(String s, String t) {
       int n = s.length();
       int m = t.length();
       int[] dp = new int[m + 1];
       dp[0] = 1;

       for (int i = 1; i <= n; i++) {
           for (int j = m; j >= 1; j--) {
               if (s.charAt(i - 1) == t.charAt(j - 1)) {
                   dp[j] = (dp[j - 1] + dp[j]) % 1000000007;
               }
           }
       }
       return dp[m];
    }
}