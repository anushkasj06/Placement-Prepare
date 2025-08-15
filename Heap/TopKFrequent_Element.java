package Heap;
import java.util.*;


public class TopKFrequent_Element {
    public int[] topKFrequent(int[] nums, int k) {
        if(k<nums.length && k<1){
            return new int[]{};
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = maxHeap.poll()[0];
        }
        return result;
    }

    public int[] topKFrequentOptimized(int[] nums, int k) {
        if(k<nums.length && k<1){
            return new int[]{};
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if(minHeap.size()>k){
                minHeap.poll();
            }
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        if(minHeap.size()>k){
            minHeap.poll();
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}
