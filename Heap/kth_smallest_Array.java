package Heap;
import java.util.*;

public class kth_smallest_Array {
    public int findKthSmallest(int[] nums, int k) {
        if (k < 1 || k > nums.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }

        // Use a max heap to find the k-th smallest element
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public int findKthSmallestOptimized(int[] nums, int k) {
        if (k < 1 || k > nums.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
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

        int countIndex = k;
        for (int i = 0; i < count.length; i++) {
            countIndex -= count[i];
            if (countIndex <= 0) {
                return i + min;
            }
        }

        throw new IllegalArgumentException("Unreachable");
    }
}
