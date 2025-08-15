package Heap;
import java.util.*;

public class Sort_K_SortedArray {
    public static void sortKSortedArray(int[] arr, int k) {
        // Create a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first k+1 elements to the min heap
        for (int i = 0; i <= k && i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }

        // Index for sorted elements
        int index = 0;

        // Process the remaining elements
        for (int i = k + 1; i < arr.length; i++) {
            // Extract the minimum element from the heap
            arr[index++] = minHeap.poll();
            // Add the next element from the array to the heap
            minHeap.offer(arr[i]);
        }

        // Extract remaining elements from the heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}
