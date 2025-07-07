import java.util.*;

public class Shortest_path_DAG_Toposort {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj){
        vis[node] = 1;
        for(Pair it : adj.get(node)){
            if(vis[it.first] == 0){
                dfs(it.first, vis, st, adj);
            }
        }
        st.push(node);
    }
    
    public static int[] shortestPath(int n, int m, int src, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }

        for(int i=0; i<m; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                dfs(i, vis, st, adj);
            }   
        }
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = (int)1e9;
        }
        dist[src] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            for(Pair it : adj.get(node)){
                if(dist[node] + it.second < dist[it.first]){
                    dist[it.first] = dist[node] + it.second;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        return dist;
        
    }
}
