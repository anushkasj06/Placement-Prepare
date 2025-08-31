import java.util.ArrayList;
import java.util.Collections;

public class MinimumCutsToRode {
    public int minCost(int l, int[] arr) {
        int n = arr.length;

        ArrayList<Integer> cuts = new ArrayList<>();
        cuts.add(0);
        for (int x : arr) {
            cuts.add(x);
        }
        cuts.add(l);

        Collections.sort(cuts);

        int[][] dp = new int[cuts.size()][cuts.size()];

        return solve(cuts, 1, cuts.size() - 2, dp); 
    }

    private int solve(ArrayList<Integer> cuts, int i, int j, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        int minCost = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int cost = cuts.get(j + 1) - cuts.get(i - 1) 
                       + solve(cuts, i, k - 1, dp) 
                       + solve(cuts, k + 1, j, dp);

            minCost = Math.min(minCost, cost);
        }

        return dp[i][j] = minCost;
    }
}
