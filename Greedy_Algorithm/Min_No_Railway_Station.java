package Greedy_Algorithm;
import java.util.*;

public class Min_No_Railway_Station {
    public int findplatform(int[] arr, int[] dept, int n){
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        Arrays.sort(arr);
        Arrays.sort(dept);

        while (i < n && j < n) {
            if (arr[i] <= dept[j]) {
                plat_needed++;
                i++;
            } else {
                plat_needed--;
                j++;
            }
            if (plat_needed > result) {
                result = plat_needed;
            }
        }
        return result;
    }
}
