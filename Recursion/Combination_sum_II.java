import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_sum_II {
    public static void backtrack(int ind, int[] arr, int target, List<Integer> list, List<List<Integer>> result){
       if(target==0){
        result.add(new ArrayList<>(list));
        return;
       }

       for(int i=ind;i<arr.length;i++){
        if(i>ind && arr[i]==arr[i-1]){
            continue;
        }
        if(arr[i]>target){
            break;
        }
        list.add(arr[i]);
        backtrack(i+1, arr, target-arr[i], list, result);
        list.remove(list.size()-1);
       }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(0,arr, target, list, result);
        return result;
    }
}
