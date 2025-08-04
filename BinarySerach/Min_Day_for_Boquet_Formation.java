public class Min_Day_for_Boquet_Formation {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay == null || bloomDay.length == 0 || m <= 0 || k <= 0) {
            return -1; // Invalid input
        }
        long totalFlowers = (long) m * k;
        if (bloomDay.length < totalFlowers) {
            return -1; // Not enough flowers to form bouquets
        }
        int low = findMin(bloomDay);
        int high = findMax(bloomDay);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canFormBouquets(bloomDay, mid, m, k)) {
                high = mid; // Try to form bouquets with fewer days
            } else {
                low = mid + 1; // Increase days
            }
        }
        return low;
    }

    public int findMin(int[] bloomDay) {
        int min = Integer.MAX_VALUE;
        for (int day : bloomDay) {
            if (day < min) {
                min = day;
            }
        }
        return min;
    }
    public int findMax(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            if (day > max) {
                max = day;
            }
        }
        return max;
    }

    public boolean canFormBouquets(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int cnt = 0;
        for (int day : bloomDay) {
            if(day <= days) {
                cnt++; // Count consecutive flowers that can bloom within 'days'
            } else {
                bouquets += cnt / k; // Form bouquets from counted flowers
                cnt = 0; // Reset count if flower cannot bloom within 'days'
            }
        }
        bouquets += cnt / k; // Form bouquets from any remaining flowers
        return bouquets >= m; // Check if we can form at least m bouquets
    }
}
