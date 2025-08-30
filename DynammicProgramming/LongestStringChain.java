import java.util.*;;

public class LongestStringChain {
    public int longestStringChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (isPredecessor(words[prev], words[i]) && dp[i] < dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }

    private boolean isPredecessor(String shorter, String longer) {
        if (longer.length() != shorter.length() + 1) return false;

        int i = 0, j = 0;
        boolean foundDifference = false;

        while(j<longer.length()){
            if(shorter.charAt(i) == longer.charAt(j)){
                i++;
                j++;
            } else {
                j++;
            }
        }
        if(i == shorter.length() && j == longer.length()) return true;
        return false;
    }
}
