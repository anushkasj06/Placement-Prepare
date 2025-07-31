import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to use two-pointer technique
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicates
                    
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSumbetter(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1; j<nums.length; j++){
                int complement = -nums[i] - nums[j];
                if(set.contains(complement)){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet); // Sort to avoid duplicates
                    if(!result.contains(triplet)){
                        result.add(triplet);
                    }
                }
                set.add(nums[j]);
            }
        }
        return result;
    }
}
