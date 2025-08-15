package Heap;
import java.util.*;

public class Replace_k_element_Rank {
    public static int[] replaceKElementRank(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }

        // Create a min heap to find the k-th largest element
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        for(int i=0;i<arr.length;i++){
            minHeap.offer(new int[]{arr[i],i});
        }
        int currRank=1;
        int[] ranks = new int[arr.length];
        while(!minHeap.isEmpty()){
            int[] pair = minHeap.poll();
            int val = pair[0];
            int ind = pair[1];
            ranks[ind] = currRank++;
        }

        return ranks;
    }
}
