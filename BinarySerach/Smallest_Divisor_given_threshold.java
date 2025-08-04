public class Smallest_Divisor_given_threshold {
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums == null || nums.length == 0 || threshold <= 0) {
            return -1; // Invalid input
        }
        if(nums.length > threshold) {
            return -1; // Not enough elements to satisfy the threshold
        }

        int low = 1, high = findMax(nums);
        while (low <=high) {
            int mid = low + (high - low) / 2;
            if (calculateSum(nums, mid) <= threshold) {
                high = mid-1; // Try a smaller divisor
            } else {
                low = mid + 1; // Increase divisor
            }
        }
        return low; // The smallest divisor that meets the threshold
    }
    public int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    public int calculateSum(int[] nums, int divisor) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum += Math.ceil((double)nums[i] / (double)divisor);
        }
        return sum;
    }
}
