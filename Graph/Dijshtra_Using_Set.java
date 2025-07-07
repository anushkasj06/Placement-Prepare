import java.util.*;

public class Dijshtra_Using_Set {
    public static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new Node(1, 2));
        adj.get(0).add(new Node(4, 1));
        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 6));
        adj.get(4).add(new Node(2, 2));
        adj.get(4).add(new Node(5, 4));
        adj.get(5).add(new Node(3, 1));

        dijkstra(V, adj, 0);

    }
    public static int[] dijkstra(int V, ArrayList<ArrayList<Node>> adj, int source) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;

        Set<Pair> set = new HashSet<>();
        set.add(new Pair(source, 0));
        while (!set.isEmpty()) {
            Pair p = set.iterator().next();
            set.remove(p);
            int u = p.first;
            int uWeight = p.second; 
            for (Node v : adj.get(u)) {
                if (dist[u] + v.weight < dist[v.vertex]) {
                    dist[v.vertex] = dist[u] + v.weight;
                    if (set.contains(v.vertex)) {
                        set.remove(v.vertex);
                    }
                    set.add(new Pair(v.vertex, dist[v.vertex]));
                }
            }
        }
        return dist;
    }
}
