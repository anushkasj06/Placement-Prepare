package Greedy_Algorithm;
import java.util.*;

public class Job_Scheduling {
    class jobs{
        int id;
        int deadline;
        int profit;
        jobs(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public int[] jobScheduling(jobs[] jobArray, int n) {
        Arrays.sort(jobArray, (a, b) -> b.profit - a.profit);
        int maxdeadline =0;
        for(jobs j : jobArray){
            maxdeadline = Math.max(maxdeadline, j.deadline);
        }
        int[] result = new int[maxdeadline + 1];
        Arrays.fill(result, -1);
        int  jobprofit = 0;
        int jobcount =0;

        for (jobs j : jobArray) {
            for (int i = Math.min(n - 1, j.deadline); i > 0; i--) {
                if(result[i] == -1){
                    result[i] = j.id;
                    jobcount++;
                    jobprofit += j.profit;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = jobcount;
        ans[1] = jobprofit;
        return ans;
    }
}
