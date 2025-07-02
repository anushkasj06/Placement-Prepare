import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Detect_Cycle_using_BFS {

    public class Pair {
        int first; // Node
        int second; // Parent

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }  
    }

    public boolean canFinish(int V, int[][] adjmatrix) {
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
                if (CheckCycle(i,V, adj, visited)) {
                    return true; // Cycle detected
                }
                
            }
        }
        return false;
    }


    public boolean CheckCycle(int node, int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        while (!q.isEmpty()) {
            int currNode = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for(int adjnode : adj.get(currNode)) {
                if (!visited[adjnode]) {
                    visited[adjnode] = true;
                    q.add(new Pair(adjnode, currNode));
                } else if (adjnode != parent) {
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }

}