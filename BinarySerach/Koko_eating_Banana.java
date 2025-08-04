public class Koko_eating_Banana {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0 || h <= 0) {
            return 0; // Invalid input
        }
        int low = 1, high = findMax(piles);
        while (low <=high) {
            int mid = low + (high - low) / 2;
            int TotalH = calculateTotalH(piles, mid);
            if (TotalH <= h) {
                high = mid-1; // Try a smaller speed
            } else {
                low = mid + 1; // Increase speed
            }
        }
        return low;
    }

    public int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        return max;
    }
    public int calculateTotalH(int[] piles, int speed) {
        int totalH = 0;
        for(int i=0;i<piles.length;i++) {
            totalH += Math.ceil((double)piles[i] / (double)speed);
        }
        return totalH;
    }
    public static void main(String[] args) {
        Koko_eating_Banana koko = new Koko_eating_Banana();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(koko.minEatingSpeed(piles, h)); // Output: 4
    }
}
