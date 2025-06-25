import java.util.*;

public class Subset_Sum_I{
    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        ArrayList<Integer> sums = new ArrayList<>();
        findSubsets(0, arr, 0, sums);
        Collections.sort(sums);
        System.out.println(sums);
    }

    public static void findSubsets(int index, int[] arr, int sum, ArrayList<Integer> sums) {
        if (index == arr.length) {
            sums.add(sum);
            return;
        }

        // Pick the element
        findSubsets(index + 1, arr, sum + arr[index], sums);

        // Do not pick the element
        findSubsets(index + 1, arr, sum, sums);
    }
}