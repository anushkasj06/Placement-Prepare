import java.util.ArrayList;
import java.util.Arrays;    
    

public class Detect_Cycle_Directed_graph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        Arrays.fill(visited, 0);
        Arrays.fill(pathVisited, 0);
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, visited, pathVisited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int node, int[] visited, int[] pathVisited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        pathVisited[node] = 1;
        for (int it : adj.get(node)) {
            if (visited[it] == 0) {
                if (dfs(it, visited, pathVisited, adj)) {
                    return true;
                }
            } else if (pathVisited[it] == 1) {
                return true;
            }
        }
        pathVisited[node] = 0;
        return false;
    }
}
