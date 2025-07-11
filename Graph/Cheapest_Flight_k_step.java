import java.util.*;

public class Cheapest_Flight_k_step {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static class tuple{
        int first;
        int second;
        int third;
        tuple(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public static int cheapestFlight(int n, int[][] flights, int src, int dst, int k){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = (int)1e9;
        }
        dist[src] = 0;
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0,src,0));
        while(!q.isEmpty()){
            tuple t = q.poll();
            int step = t.first;
            int node = t.second;
            int cost = t.third;
            if(step>k){
                continue;
            }
            for(Pair p : adj.get(node)){
                int adjnode = p.first;
                int weight = p.second;
                if(cost+weight<dist[adjnode] && step<=k){
                    dist[adjnode] = cost+weight;
                    q.add(new tuple(step+1, adjnode, cost+weight));
                }

            }
        }
        if(dist[dst] == (int)1e9){
            return -1;
        }
        return dist[dst];
    }
}
