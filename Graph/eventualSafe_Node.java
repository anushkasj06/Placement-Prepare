import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class eventualSafe_Node {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                adj.get(neighbor).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                safeNodes.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                    safeNodes.add(neighbor);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
