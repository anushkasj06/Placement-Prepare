import java.util.*;

public class UpperBound {
    public static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        int ans = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid]> target) {
                ans = mid; // Update ans to the current mid
                right = mid; // Move right to mid to find a potentially smaller index
            } else {
                left = mid + 1; // Move left to mid + 1 to find a greater element
            }
        }
        return ans; // This is the index of the first element greater than target
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5, 6};
        int target = 4;
        System.out.println("Upper bound index for " + target + ": " + upperBound(arr, target));
    }
}