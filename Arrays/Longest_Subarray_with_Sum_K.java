import java.util.HashMap;
import java.util.Map;

public class Longest_Subarray_with_Sum_K {
    public int longestSubarrayWithSumKworkforbothposandneg(int[] nums, int k) {
        int maxLength = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1); // To handle the case when the subarray starts from index 0

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int res = currentSum - k;
            // If currentSum is equal to k, update maxLength
            if (currentSum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }
            // If currentSum - k exists in the map, update maxLength
            if (sumIndexMap.containsKey(res)) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(res));
            }
            

            // Store the first occurrence of currentSum
            if (!sumIndexMap.containsKey(currentSum)) {
                sumIndexMap.put(currentSum, i);
            }
        }

        return maxLength;
    }

    public int longestsubarraysumkwithtwopointer(int[] nums, int k) {
        int maxLength = 0;
        int left = 0;
        int currentSum = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            while (currentSum > k && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            if (currentSum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
            if( right < n) {
                currentSum += nums[right];
            }
        }

        return maxLength;
    }


}
