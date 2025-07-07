import java.util.*;

public class Dijkshtra_using_PriorityQueue {
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

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<Node>> adj, int source) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node u = pq.poll();
            int uVertex = u.vertex;
            int uWeight = u.weight;

            if (uWeight > dist[uVertex]) {
                continue;
            }

            for (Node v : adj.get(uVertex)) {
                if (dist[uVertex] + v.weight < dist[v.vertex]) {
                    dist[v.vertex] = dist[uVertex] + v.weight;
                    pq.add(new Node(v.vertex, dist[v.vertex]));
                }
            }
        } 
        return dist;
    }

}
