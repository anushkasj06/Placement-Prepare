import java.util.*;

public class LongestDivisibleSubset {
    public List<Integer> longestDivisibleSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        int maxi = 1;
        int lastIndex = 0;

        for (int i = 1; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] % arr[prev] == 0 && dp[i] < dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(arr[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            result.add(arr[lastIndex]);
        }
        Collections.reverse(result);
        return result;
    }

}
