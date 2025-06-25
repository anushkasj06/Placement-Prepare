import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;



public class Subset_Sum_II {
    public void backtrack(int index, int[] nums, List<Integer> ds, List<List<Integer>> result) {
        result.add(new ArrayList<>(ds));
        for(int i=index; i < nums.length; i++) {
            if(i!= index && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }
            ds.add(nums[i]);
            backtrack(i + 1, nums, ds, result);
            ds.remove(ds.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, ds, result);
        return result;
    }
}
