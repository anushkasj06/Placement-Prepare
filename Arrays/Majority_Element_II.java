import java.util.ArrayList;
import java.util.List;

public class Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;

        // Apply Boyer-Moore Voting Algorithm
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Verify the candidates
        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) { // Use else if to handle cases where candidate1 == candidate2
                count2++;
            }
        }

        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            // Add candidate2 only if it's different from candidate1
            if (candidate1 != candidate2) {
                result.add(candidate2);
            }
        }
        return result;
    }
    
}
