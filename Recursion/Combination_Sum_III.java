import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
     public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        PossibleCombinations(k, n, 1, ans, cur);
        return ans;
    }

    public void PossibleCombinations(int k, int target, int n, 
                                   List<List<Integer>> ans, List<Integer> cur) {
        // Base case: found valid combination
        if (k == 0 && target == 0) {
            ans.add(new ArrayList<>(cur));  // Important: create copy!
            return;
        }
        
        // Early termination cases
        if (k == 0) return;           // Used all k numbers but wrong sum
        if (n > 9) return;            // Exceeded available digits (1-9)
        if (n > target) return;       // Current number > remaining target
        
        // Choice 1: Include current number n
        cur.add(n);
        PossibleCombinations(k - 1, target - n, n + 1, ans, cur);
        cur.remove(cur.size() - 1);   // Backtrack
        
        // Choice 2: Skip current number n
        PossibleCombinations(k, target, n + 1, ans, cur);
    }

}
