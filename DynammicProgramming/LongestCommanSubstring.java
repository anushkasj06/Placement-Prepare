public class LongestCommanSubstring {
    public int LongestCommanSubstringmemo(int i, int j, String s, String t, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j]; 
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 1 + LongestCommanSubstringmemo(i-1, j-1, s, t, dp);
        }else{
            return dp[i][j] = 0 + Math.max(LongestCommanSubstringmemo(i-1, j, s, t, dp), LongestCommanSubstringmemo(i, j-1, s, t, dp));
        }
    }


    public int LongestCommanSubstringTabu(String s, String t ){
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0] = 0;
        for(int j=0;j<=m;j++) dp[0][j] = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public int LongestCommanSubstringSpaceOptimization(String s, String t){
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        for(int i=0;i<=m;i++) prev[i] = 0;
        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = 0 + Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
