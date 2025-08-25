import java.util.*;

public class KnapSnack01 {
    public int KnapSnack01max(int[] val, int[] weight, int maxw){
        int n = val.length;
        return func(n-1, weight, val, maxw);
    }

    public static int func(int i,int[] weight, int[] val, int maxw){
        if(i==0){
            if(weight[0] <= maxw) return val[0];
            else return 0;
        }
        int untake = 0 + func(i-1, weight, val, maxw);
        int take = Integer.MIN_VALUE;
        if(maxw>=weight[i]) take = val[i] + func(i-1, weight, val, maxw-weight[i]);
        return Math.max(take, untake);
    }


    public int KnapSnack01maxTabulation(int[] val, int[] weight, int maxw) {
        int n = val.length;
        int[][] dp = new int[n][maxw + 1];
        for (int w = 0; w <= maxw; w++) {
            if (weight[0] <= w) dp[0][w] = val[0];
        }
        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= maxw; w++) {
                int untake = dp[i - 1][w];
                int take = Integer.MIN_VALUE;
                if (w >= weight[i]) take = val[i] + dp[i - 1][w - weight[i]];
                dp[i][w] = Math.max(take, untake);
            }
        }
        return dp[n - 1][maxw];
    }


    public int KnapSnack01maxSpaceOpti(int[] val, int[] weight, int maxw) {
        int n = val.length;
        int[] prev = new int[maxw + 1];
        for (int w = 0; w <= maxw; w++) {
            if (weight[0] <= w) prev[w] = val[0];
        }
        for (int i = 1; i < n; i++) {
            for (int w = maxw; w >= 0; w--) {
                int untake = prev[w];
                int take = Integer.MIN_VALUE;
                if (w >= weight[i]) take = val[i] + prev[w - weight[i]];
                prev[w] = Math.max(take, untake);
            }
        }
        return prev[maxw];
    }
}
