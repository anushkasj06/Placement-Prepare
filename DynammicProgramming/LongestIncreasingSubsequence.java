import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthofLISRec(int[] arr, int n) {
        return helper(arr, 0, -1);
    }

    private int helper(int[] arr, int i, int prevIndex) {
        if (i == arr.length) return 0;

        int length = 0 + helper(arr, i + 1, prevIndex);
        
        if (prevIndex == -1 || arr[i] > arr[prevIndex]) {
            length = Math.max(length, 1 + helper(arr, i + 1, i));
        }
        return length;
    }

    public int lengthOfLISDP(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lengthOfLISUtil(arr, 0, -1, dp);
    }

    private int lengthOfLISUtil(int[] arr, int i, int prevIndex, int[][] dp) {
        if (i == arr.length) return 0;
        if (dp[i][prevIndex + 1] != -1) return dp[i][prevIndex + 1];

        int length = 0 + lengthOfLISUtil(arr, i + 1, prevIndex, dp);

        if (prevIndex == -1 || arr[i] > arr[prevIndex]) {
            length = Math.max(length, 1 + lengthOfLISUtil(arr, i + 1, i, dp));
        }
        return dp[i][prevIndex + 1] = length;
    }

    public int lengthOfLISTabu(int[] arr, int n){
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int prevIndex = i - 1; prevIndex >= -1; prevIndex--){
                int length = 0 + dp[i + 1][prevIndex + 1];
                if(prevIndex == -1 || arr[i] > arr[prevIndex]){
                    length = Math.max(length, 1 + dp[i + 1][i + 1]);
                }
                dp[i][prevIndex + 1] = length;
            }
        }
        return dp[0][-1 + 1];
    }

    public int lengthOfLISSpaceOpt(int[] arr, int n){
        int[] curr = new int[n + 1];
        int[] next = new int[n + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int prevIndex = i - 1; prevIndex >= -1; prevIndex--){
                int length = 0 + next[prevIndex + 1];
                if(prevIndex == -1 || arr[i] > arr[prevIndex]){
                    length = Math.max(length, 1 + next[i + 1]);
                }
                curr[prevIndex + 1] = length;
            }
            next = curr.clone();
        }
        return next[-1 + 1];
    }

    //Type 2: 
    public int lengthOfLISBottomUp(int[] arr , int n){
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi =0;
        for(int i = 1; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(arr[i] > arr[prev]){
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }


    public void printLIS(int[] arr, int n){
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(hash, 1);
        int maxi =0;
        int lastIndex = 0;
        for(int i = 1; i < n; i++){
            hash[i] = i;
            for(int prev = 0; prev < i; prev++){
                if(arr[i] > arr[prev] && 1 + dp[prev] > dp[i]){
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                    hash[i] = prev;
                }
            }
            if(maxi < dp[i]){
                maxi = Math.max(maxi, dp[i]);
                lastIndex = i;
            }
        }
        System.out.println("Length of LIS is: " + maxi);
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            lis.add(arr[lastIndex]);
        }
        Collections.reverse(lis);
        System.out.println("LIS is: " + lis);
    }



    int lengthLISusingbinarySearch(int[] arr, int n){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        for(int i = 1; i < n; i++){
            if(arr[i] > temp.get(temp.size() - 1)){
                temp.add(arr[i]);
            } else {
                int ind = lowerBound(temp, arr[i]);
                temp.set(ind, arr[i]);
            }
        }
        return temp.size();
    }

    private int lowerBound(ArrayList<Integer> temp, int key) {
        int low = 0, high = temp.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (temp.get(mid) < key) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;

        System.out.println("Length of LIS (Recursive): " + lis.lengthofLISRec(arr, n));
        System.out.println("Length of LIS (DP with Memoization): " + lis.lengthOfLISDP(arr));
        System.out.println("Length of LIS (Tabulation): " + lis.lengthOfLISTabu(arr, n));
        System.out.println("Length of LIS (Space Optimized): " + lis.lengthOfLISSpaceOpt(arr, n));
        System.out.println("Length of LIS (Bottom-Up DP): " + lis.lengthOfLISBottomUp(arr, n));
        lis.printLIS(arr, n);
        System.out.println("Length of LIS (Using Binary Search): " + lis.lengthLISusingbinarySearch(arr, n));
    }
}
