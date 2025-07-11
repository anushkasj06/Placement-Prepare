import java.util.*;

public class Number_Way_Arrive_Destination {
     static class Pair {
        long first; // use long for distance
        int second;

        Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], wt = road[2];
            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        int mod = (int) 1e9 + 7;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.first, b.first));
        pq.add(new Pair(0L, 0)); // distance 0 to node 0

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            long d = current.first;
            int node = current.second;

            if (d > dist[node]) continue;

            for (Pair neighbor : adj.get(node)) {
                long edgeWeight = neighbor.first;
                int adjNode = neighbor.second;

                if (d + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = d + edgeWeight;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(dist[adjNode], adjNode));
                } else if (d + edgeWeight == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}
