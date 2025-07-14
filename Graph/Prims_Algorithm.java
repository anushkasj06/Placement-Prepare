import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class Prims_Algorithm {
    static class Pair {
        int weight;
        int node;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[V + 1];
        int sum = 0;
        pq.add(new Pair(0, 0)); // Start from node 1 with weight 0
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            
            if (visited[curr.node]) {
                continue;
            }
            visited[curr.node] = true;
            sum += curr.weight;
            for (ArrayList<Integer> edge : adj.get(curr.node)) {
                int nextNode = edge.get(0);
                int weight = edge.get(1);
                if (!visited[nextNode]) {
                    pq.add(new Pair(nextNode, weight));
                }
            }
        }
        return sum;
    }
}
