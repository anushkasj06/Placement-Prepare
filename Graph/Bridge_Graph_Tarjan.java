import java.util.*;

public class Bridge_Graph_Tarjan {
    public List<List<Integer>> findBridges(int V, List<List<Integer>> adj) {
        int[] tin = new int[V]; // discovery time
        int[] low = new int[V]; // lowest discovery time reachable
        boolean[] visited = new boolean[V];
        List<List<Integer>> bridges = new ArrayList<>();
        int timer = 0;

        dfs(0, -1, tin, low, visited, adj, bridges, timer);
        return bridges;
    }

    private void dfs(int u, int parent, int[] tin, int[] low, boolean[] visited,
                     List<List<Integer>> adj, List<List<Integer>> bridges, int timer) {
        visited[u] = true;
        tin[u] = low[u] = timer++;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (visited[v]) {
                low[u] = Math.min(low[u], tin[v]);
            } else {
                dfs(v, u, tin, low, visited, adj, bridges, timer);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > tin[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            }
        }
    }
    public static void main(String[] args) {
        // Example usage
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);

        Bridge_Graph_Tarjan bg = new Bridge_Graph_Tarjan();
        List<List<Integer>> bridges = bg.findBridges(5, adj);
        System.out.println("Bridges in the graph: " + bridges);
    }
}
