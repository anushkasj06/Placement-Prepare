public class Capacity_Ship_toCarray_Load {
    public int shipWithinDays(int[] weights, int days) {
       int low = findMax(weights);
        int high = findSum(weights);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (daysShip(weights, mid)<= days) {
                high = mid; // Try to ship with a smaller capacity
            } else {
                low = mid + 1; // Increase capacity
            }
        }
        return low; // The minimum capacity needed to ship within 'days' 
    }

    public int findMax(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int weight : weights) {
            if (weight > max) {
                max = weight;
            }
        }
        return max;
    }

    public int findSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }

    public int daysShip(int[] weights, int capacity) {
        int currWeight = 0;
        int dayCount = 1;
        for (int weight : weights) {
            if (weight + currWeight > capacity) {
                dayCount++; // Need a new day for this weight
                currWeight = weight; // Start new day with current weight
            } else {
                currWeight += weight; // Add weight to current day's load
            }
        }
        return dayCount;
    }
}