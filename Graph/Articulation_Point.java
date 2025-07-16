import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Articulation_Point {
    public List<Integer> articulationPoints(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> conn : connections) {
            graph.get(conn.get(0)).add(conn.get(1));
            graph.get(conn.get(1)).add(conn.get(0));
        }

        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] isArticulation = new boolean[n];
        int timer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, tin, low, graph, isArticulation, timer);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isArticulation[i]) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }

    private void dfs(int u, int parent, boolean[] visited, int[] tin, int[] low,
                     List<List<Integer>> graph, boolean[] isArticulation, int timer) {
        visited[u] = true;
        tin[u] = low[u] = timer++;

        int children = 0;
        for (int v : graph.get(u)) {
            if (v == parent) continue;

            if (visited[v]) {
                low[u] = Math.min(low[u], tin[v]);
            } else {
                dfs(v, u, visited, tin, low, graph, isArticulation, timer);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] >= tin[u] && parent != -1) {
                    isArticulation[u] = true;
                }
                children++;
            }
        }

        if (parent == -1 && children > 1) {
            isArticulation[u] = true;
        }
    }
}
