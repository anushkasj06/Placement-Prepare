import java.util.*;


public class Shortest_Path_UG_unit_weight {
    public int[] shortestPath(int[][] edges,int n,int m,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = (int)1e9;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        dist[src] = 0;
        q.add(src);
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int neighbor : adj.get(node)){
                if(dist[node] + 1 < dist[neighbor]){
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
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
