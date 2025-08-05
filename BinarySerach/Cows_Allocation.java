import java.util.*;

public class Cows_Allocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of stalls
        int c = sc.nextInt(); // number of cows
        int[] stalls = new int[n];

        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        Arrays.sort(stalls);
        System.out.println(maxDistance(stalls, c));
    }

    private static int maxDistance(int[] stalls, int c) {
        int low = 1; // minimum distance
        int high = stalls[stalls.length - 1] - stalls[0]; // maximum distance
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlaceCows(stalls, c, mid)) {
                low = mid + 1; // try for a larger distance
            } else {
                high = mid - 1; // try for a smaller distance
            }
        }
        return high; // high will be the largest minimum distance found
    }

    private static boolean canPlaceCows(int[] stalls, int c, int minDist) {
        int count = 1; // place the first cow in the first stall
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                count++;
                lastPosition = stalls[i];
            }
            if (count >= c) {
                return true; // all cows placed successfully
            }
        }
        return false; // not enough cows placed
    }
}