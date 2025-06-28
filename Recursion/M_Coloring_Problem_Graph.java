import java.util.List;

public class M_Coloring_Problem_Graph {
    public boolean graphColoring(List<Integer> [] graph, int N, int m) {
        int[] color = new int[N];
        return canColor(0, graph, color, m);
    }

    private boolean canColor(int node, List<Integer>[] graph, int[] color, int m) {
        if (node == graph.length) { 
            return true; // All nodes colored successfully
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, graph, color, c)) {
                color[node] = c;
                if (canColor(node + 1, graph, color, m)) {
                    return true;
                }
                color[node] = 0; // Backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int node, List<Integer>[] graph, int[] color, int c) {
        for (int neighbor : graph[node]) {
            if (color[neighbor] == c) {
                return false; // Adjacent node has the same color
            }
        }
        return true;
    }
}
