import java.lang.reflect.Array;
import java.util.ArrayList;

public class number_of_Proviences {
    public static void main(String[] args) {
        int V = 3; // Number of vertices
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println("Number of provinces: " + numProv(isConnected, V));
        System.out.println("Number of provinces: " + numProv2(isConnected, 3));
    }

    public static int numProv(int[][] isConnected, int V){
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, visited, i, V);
            }
        }
        return count;

    }
    public static void dfs(int[][] isConnected, boolean[] visited, int i, int V) {
        visited[i] = true;
        for (int j = 0; j < V; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j, V);
            }
        }
    }

    public static int numProv2(int[][] isConnected, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs2(adj, visited, i, V);
            }
        }
        return count;
    }

    public static void dfs2(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i, int V) {
        visited[i] = true;
        for (int j : adj.get(i)) {
            if (!visited[j]) {
                dfs2(adj, visited, j, V);
            }
        }
    }

}
