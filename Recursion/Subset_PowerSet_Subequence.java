import java.util.ArrayList;
import java.util.List;

public class Subset_PowerSet_Subequence {
    List<List<Integer>> result;
    public void solution(int[] nums, int index, List<Integer> asf) {
        if(index == nums.length) {
            result.add(new ArrayList<>(asf));
            return;
        }

        asf.add(nums[index]);
        solution(nums, index+1, asf);
        asf.remove(asf.size()-1);
        solution(nums, index+1, asf);
    }
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        solution(nums, 0, new ArrayList<>());
        return result;
    }
    

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subset_PowerSet_Subequence obj = new Subset_PowerSet_Subequence();
        List<List<Integer>> result = obj.subsets(nums);
        for(List<Integer> list : result) {
            System.out.println(list);
        }
        
    }
}
