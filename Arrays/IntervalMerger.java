import java.util.*;

public class IntervalMerger {
    public static List<List<Integer>> mergeOverlappingIntervals(List<List<Integer>> intervals) {
        // Sort the intervals based on the start time
        intervals.sort(Comparator.comparingInt(a -> a.get(0)));

        List<List<Integer>> ans = new ArrayList<>();

        for (List<Integer> interval : intervals) {
            // If ans is empty or there is no overlap, add the interval
            if (ans.isEmpty() || interval.get(0) > ans.get(ans.size() - 1).get(1)) {
                ans.add(interval);
            } else {
                // Overlapping interval, merge it
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), interval.get(1)));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> intervals = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(2, 6),
            Arrays.asList(8, 10),
            Arrays.asList(15, 18)
        );

        List<List<Integer>> merged = mergeOverlappingIntervals(intervals);
        for (List<Integer> interval : merged) {
            System.out.println(interval);
        }
    }
}
