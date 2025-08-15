package Heap;

import java.util.PriorityQueue;

public class MinCostToConnectRopes {
     public static long minCost(int[] ropes) {
        if (ropes == null || ropes.length <= 1) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int r : ropes) pq.offer(r);

        long cost = 0;
        while (pq.size() > 1) {
            int a = pq.poll();          // smallest
            int b = pq.poll();          // second smallest
            int merged = a + b;         // cost to connect these two
            cost += merged;             // accumulate total cost
            pq.offer(merged);           // push back the combined rope
        }
        return cost;
    }

    // Demo
    public static void main(String[] args) {
        int[] ropes1 = {4, 3, 2, 6};   // expected cost = 29
        int[] ropes2 = {1, 2, 5, 10, 35, 89}; // expected cost = 224
        int[] ropes3 = {2, 2, 3, 3};   // expected cost = 20

        System.out.println(minCost(ropes1));
        System.out.println(minCost(ropes2));
        System.out.println(minCost(ropes3));
    }
}
