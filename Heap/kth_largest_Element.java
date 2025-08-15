package Heap;
import java.util.*;

public class kth_largest_Element {
    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || k > nums.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }

        // Use a min heap to find the k-th largest element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public int findKthLargestoptimized(int[] nums, int k) {
        if (k < 1 || k > nums.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for(int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }

        int countindex  = k;
        for (int i = count.length - 1; i >= 0; i--) {
            countindex -= count[i];
            if (countindex <= 0) {
                return i + min;
            }
        }

        throw new IllegalArgumentException("Unreachable");
    }
}
