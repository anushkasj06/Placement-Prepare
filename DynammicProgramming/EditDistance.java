public class EditDistance {
    public int editdistancememo(int i, int j, String s, String t, int[][] dp){
        if(i == 0) return j;
        if(j == 0) return i;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i - 1) == t.charAt(j - 1)){
            dp[i][j] = editdistancememo(i - 1, j - 1, s, t, dp);
        }else{
            dp[i][j] = 1 + Math.min(editdistancememo(i - 1, j, s, t, dp),
                                     Math.min(editdistancememo(i, j - 1, s, t, dp),
                                              editdistancememo(i - 1, j - 1, s, t, dp)));
        }
        return dp[i][j];
    }

    public int editdistancetabu(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[n][m];
    }

    public int editdistanceSO(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(prev[j], Math.min(curr[j - 1], prev[j - 1]));
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}