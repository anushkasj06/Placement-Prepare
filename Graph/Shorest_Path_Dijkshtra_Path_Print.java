import java.util.*;

public class Shorest_Path_Dijkshtra_Path_Print {
    static class Pair {
        int first;
        int second;

        public Pair(int distance, int node) {
            this.first = distance;
            this.second = node;
        }
    }

    public static List<Integer> shortestPath(int n, int m, int[][] edge) {
        // Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }

        // Dijkstra's algorithm using a priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.second);
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1]; // To reconstruct the path

        for (int i = 0; i <= n; i++) {
            dist[i] = (int) 1e9;
            parent[i] = i; // Initialize parent of each node to itself
        }

        dist[1] = 0;
        pq.add(new Pair(0,1)); // (node, distance)

        while(pq.size()!=0){
            Pair it = pq.peek();
            int node = it.second;
            int distance = it.first;
            pq.remove();
            for (Pair p : adj.get(node)) {
                int adjnode = p.first;
                int adjdist = p.second;
                if(dist[node]+adjdist<dist[adjnode]){
                    dist[adjnode] = dist[node]+adjdist;
                    pq.add(new Pair(dist[adjnode], adjnode));
                    parent[adjnode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int node = n;
        if (dist[n] == (int) 1e9) {
            path.add(-1);
            return path;
        }
        while (node != 1) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
