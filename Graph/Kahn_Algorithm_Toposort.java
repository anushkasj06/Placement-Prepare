import java.util.*;

public class Kahn_Algorithm_Toposort {
    public static List<Integer> topologicalSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        for (List<Integer> neighbors : adj) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (topoOrder.size() != V) {
            // Graph has a cycle
            return Collections.emptyList();
        }
        return topoOrder;
    }
}
