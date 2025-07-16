import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju_Algorithm_SCC {
    private void dfs(int node, int[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, visited, stack, adj);
            }
        }
        stack.push(node);
    }
    private void dfsTranspose(int node, int[] visited, ArrayList<ArrayList<Integer>> transpose) {
        visited[node] = 1;
        for (int neighbor : transpose.get(node)) {
            if (visited[neighbor] == 0) {
                dfsTranspose(neighbor, visited, transpose);
            }
        }
    }
    public int kasaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, stack, adj);
            }
        }

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            visited[i] = 0;
            for (int j : adj.get(i)) {
                transpose.get(j).add(i);
            }
        }
        int scc =0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node] == 0) {
                scc++;
                dfsTranspose(node, visited, transpose);
            }
        }
        return scc;
    }
}
