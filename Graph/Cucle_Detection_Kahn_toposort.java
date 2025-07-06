import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// Kahn's Algorithm for Cycle Detection in Directed Graphs using Topological Sort

public class Cucle_Detection_Kahn_toposort {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (ArrayList<Integer> neighbors : adj) {
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
        ArrayList<Integer> topoOrder = new ArrayList<>();
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
        if(topoOrder.size() != V) {
            // Graph has a cycle
            return true; // Cycle detected
        }
        return false; // No cycle detected
    }
}
