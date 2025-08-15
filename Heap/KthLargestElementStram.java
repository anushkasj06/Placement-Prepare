package Heap;

import java.util.PriorityQueue;

public class KthLargestElementStram {
    class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if(minHeap.size()<k || minHeap.peek()<val){
            minHeap.add(val);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}

}