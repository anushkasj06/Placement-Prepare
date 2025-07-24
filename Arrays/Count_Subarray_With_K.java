import java.util.HashMap;
import java.util.Map;

public class Count_Subarray_With_K {
    public int countSubarraysWithSumK(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumFrequencyMap = new HashMap<>();
        sumFrequencyMap.put(0, 1); // To handle the case when a subarray starts from index 0

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            // Check if there is a subarray (or subarrays) that sum to k
            if (sumFrequencyMap.containsKey(currentSum - k)) {
                count += sumFrequencyMap.get(currentSum - k);
            }
            // Update the frequency map with the current sum
            sumFrequencyMap.put(currentSum, sumFrequencyMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
