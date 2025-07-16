import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Critical_Connection {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        // Build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> conn : connections) {
            graph.get(conn.get(0)).add(conn.get(1));
            graph.get(conn.get(1)).add(conn.get(0));
        }
        // Find bridges
        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int timer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, tin, low, graph, result, timer);
            }
        }
        return result;
    }

    private void dfs(int u, int parent, boolean[] visited, int[] tin, int[] low,
                     List<List<Integer>> graph, List<List<Integer>> result, int timer) {
        visited[u] = true;
        tin[u] = low[u] = timer++;

        for (int v : graph.get(u)) {
            if (v == parent) continue;

            if (visited[v]) {
                low[u] = Math.min(low[u], tin[v]);
            } else {
                dfs(v, u, visited, tin, low, graph, result, timer);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > tin[u]) {
                    result.add(Arrays.asList(u, v));
                }
            }
        }
    }
}
