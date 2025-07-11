import java.util.*;

public class Network_Delay {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        int[] dist = new int[n+1];
        for(int i=0; i<=n; i++){
            dist[i] = (int)1e9;
        }
        dist[k] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        while(!q.isEmpty()){
            int node = q.poll();
            for(Pair p : adj.get(node)){
                int adjnode = p.first;
                int weight = p.second;
                if(dist[node] + weight < dist[adjnode]){
                    dist[adjnode] = dist[node] + weight;
                    q.add(adjnode);
                }
                
            }
        }
        int ans = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == (int)1e9){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
