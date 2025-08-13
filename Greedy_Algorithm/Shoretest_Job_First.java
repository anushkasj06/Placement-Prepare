package Greedy_Algorithm;
import java.util.*;

public class Shoretest_Job_First {
    public int shortestJobFirst(int[] arr){
        Arrays.sort(arr);
        int totalWaitingTime = 0;
        int t =0;
        for (int i = 0; i < arr.length; i++) {
            totalWaitingTime += t;
            t += arr[i];
        }
        return totalWaitingTime/arr.length;
    }
}
