import java.util.*;

public class Complete_Graph {
    private int vertices;
    private List<List<Integer>> adj;
    private int[][] matrix;


    public Complete_Graph() {
        this.vertices = 0;
        this.adj = new ArrayList<>();
        this.matrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                matrix[i][j] = 0; // Initialize the adjacency matrix
            }
        }
    }
    public void addEdge(int u, int v) {
        while (Math.max(u, v) >= adj.size()) {
            adj.add(new ArrayList<>());
        }
        adj.get(u).add(v);
        adj.get(v).add(u);
        vertices = Math.max(vertices, Math.max(u, v) + 1);
        System.out.println("Edge added between " + u + " and " + v);
    }

    public void addedgematrix(int u, int v) {
        while (Math.max(u, v) >= matrix.length) {
            int[][] newMatrix = new int[matrix.length + 1][matrix.length + 1];
            for (int i = 0; i < matrix.length; i++) {
                System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix.length);
            }
            matrix = newMatrix;
        }
        matrix[u][v] = 1;
        matrix[v][u] = 1; // Since it's an undirected graph
        System.out.println("Edge added in adjacency matrix between " + u + " and " + v);        
    }


    void printAdjacencyList() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getVertices() {
        return vertices;
    }

    void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adj.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    void dfsGraph(int start) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(start, visited);
        System.out.println();
    }
    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adj.get(vertex)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }
    void dfsMatrix(int start) {
        boolean[] visited = new boolean[vertices];
        dfsMatrixUtil(start, visited);
        System.out.println();
    }
    private void dfsMatrixUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < vertices; i++) {
            if (matrix[vertex][i] == 1 && !visited[i]) {
                dfsMatrixUtil(i, visited);
            }
        }
    }
    void bfsMatrix(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < vertices; i++) {
                if (matrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    void addVertex() {
        adj.add(new ArrayList<>());
        int[][] newMatrix = new int[vertices + 1][vertices + 1];
        for (int i = 0; i < vertices; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, vertices);
        }
        matrix = newMatrix;
        vertices++;
    }
    public static boolean isComplete(Complete_Graph graph) {
        int v = graph.getVertices();
        if (v < 2) {
            return true; // A graph with less than 2 vertices is trivially complete
        }
        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                if (graph.matrix[i][j] == 0) {
                    return false; // If any edge is missing, the graph is not complete
                }
            }
        }
        return true; // All edges are present, the graph is complete
    }

    public static void main(String[] args) {
        Complete_Graph graph = new Complete_Graph();

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);  
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
            
        graph.addedgematrix(1,2);
        graph.addedgematrix(2,3);
        graph.addedgematrix(3,4);
        graph.addedgematrix(4,5);
        graph.addedgematrix(5,6);
        graph.printAdjacencyList();
        graph.printAdjacencyMatrix();
        System.out.println("BFS starting from vertex 1:");
        graph.bfs(1);
        System.out.println("\nDFS starting from vertex 1:");
        graph.dfsGraph(1);
        System.out.println("DFS using adjacency matrix starting from vertex 1:");

        graph.dfsMatrix(1);
        System.out.println("BFS using adjacency matrix starting from vertex 1:");
        graph.bfsMatrix(1);
        System.out.println("Total vertices in the graph: " + graph.getVertices());
        System.out.println("Graph created successfully.");
        System.out.println("Graph is complete: " + isComplete(graph));
    }
}