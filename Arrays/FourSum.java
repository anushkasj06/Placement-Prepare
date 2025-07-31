import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new java.util.ArrayList<>();
        java.util.Arrays.sort(nums); // Sort the array to use two-pointer technique

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for first number
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates for second number

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(java.util.Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++; // Skip duplicates
                        while (left < right && nums[right] == nums[right + 1]) right--; // Skip duplicates
                    }
                }
            }
        }

        return result;
    }


    public List<List<Integer>> fourSumbetter(int[] nums, int target) {
        List<List<Integer>> result = new java.util.ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                HashSet<Integer> seen = new HashSet<>();
                for(int k=j+1; k<nums.length; k++){
                    int complement = target - nums[i] - nums[j] - nums[k];
                    if(seen.contains(complement)){
                        List<Integer> quadruplet = java.util.Arrays.asList(nums[i], nums[j], nums[k], complement);
                        Collections.sort(quadruplet); // Sort to avoid duplicates
                        set.add(quadruplet);
                    }
                    seen.add(nums[k]);
                }
            }
        }
        for(List<Integer> quadruplet : set){
            result.add(quadruplet);
        }
        return result;
    }
}
