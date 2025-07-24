import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Longest_Consectative {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        int n = nums.length;
        if (n == 0) return 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : numSet) {
            // Only start counting if it's the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }

    public int longestConsecutivebetter(int[] nums) {
       int n = nums.length;
        if (n == 0) return 0;
       Arrays.sort(nums);
       
        int longest = 1;
       int cnt = 0;
       int lastsmall = Integer.MIN_VALUE;
       for (int i = 0; i < n; i++) {   
           if (nums[i]-1 == lastsmall) {
               cnt++;
               lastsmall = nums[i];
           } else if (nums[i] != lastsmall) {
               cnt = 1; // Reset count for a new number
               lastsmall = nums[i];
           }
           longest = Math.max(longest, cnt);
       }
       return longest;
   }
}
