import java.util.ArrayList;

public class Detect_Cycle_using_DFS {
    public boolean canFinish(int V, int[][] adjmatrix) {
        // Create an adjacency list from the adjacency matrix
        if(V == 0 || adjmatrix == null || adjmatrix.length == 0|| adjmatrix[0].length == 0) {
            return false; // No vertices or empty matrix
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }   
        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjmatrix[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if (visited[i] == false) {
                if (CheckCycle(i,-1, adj, visited)) {
                    return true; // Cycle detected
                }
                
            }
        }
        return false;
    }

    public boolean CheckCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for(int adjnode : adj.get(node)) {
            if (!visited[adjnode]) {
                if (CheckCycle(adjnode, node, adj, visited)) {
                    return true; // Cycle detected in the recursive call
                }
            } else if (adjnode != parent) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle found
    }
}
