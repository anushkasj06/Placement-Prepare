import java.util.*;

public class Combination_Sum{
    public void backtrack(int i ,int[] arr,int target, List<Integer> list , List<List<Integer>> result){
        if(i==arr.length){
            if(target==0){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if(arr[i]<= target){
            list.add(arr[i]);
            backtrack(i,arr, target-arr[i], list, result);
            list.remove(list.size()-1);
        }
        backtrack(i+1, arr, target, list, result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = candidates.length;
        backtrack(0,candidates,target,list, result);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target =  7;
        Combination_Sum obj = new Combination_Sum();
        List<List<Integer>> result = obj.combinationSum(arr, target);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }
}