package Sliding_Window;
import java.util.*;

public class Count_Subarray_with_k_distinct_integer {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtMostK(nums, k) - countAtMostK(nums, k - 1);
    }

    private int countAtMostK(int[] nums, int k) {
        int left = 0, right = 0, count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        while (right < nums.length) {
            // Add current element
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            // Shrink window if more than k distinct
            while(freqMap.size() > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }

            // Count subarrays ending at 'right' with at most k distinct
            count += right - left + 1;
            right++;
        }

        return count;
    }
}
