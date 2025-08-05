public class Split_Larget_SubArray_Partitions {
    public int splitArray(int[] nums, int k) {
        int low = findmax(nums); // minimum largest subarray sum
        int high = findsum(nums); // maximum largest subarray sum
        while (low<=high) {
            int mid = (low + high) / 2;
            if (canSplit(nums, k, mid)) {
                high = mid - 1; // try for a smaller maximum
            } else {
                low = mid + 1; // increase the maximum
            }   
        }
        return low; // return the minimum largest subarray sum
    
    }

    private int findmax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max; // maximum element in the array
    }
    private int findsum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num; // total sum of the array
        }
        return sum; // total sum of the array
    }


    private boolean canSplit(int[] nums, int k, int max) {
        int count = 1; // start with one partition
        int currentSum = 0; // current sum of the partition

        for (int num : nums) {
            if (currentSum + num > max) {
                count++; // need a new partition
                currentSum = num; // start new partition with this number
                if (count > k) return false; // too many partitions needed
            } else {
                currentSum += num; // add to current partition
            }
        }
        return true; // successful split within the limit
    }
}