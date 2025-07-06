import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// Kahn's Algorithm for Topological Sort in Directed Acyclic Graphs (DAG)

public class Course_Schedule_II {
    public static int[] canFinish(int numCourses, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[0];
            int v = prerequisite[1];
            adj.get(u).add(v);
        }
        int[] inDegree = new int[numCourses];
        for (ArrayList<Integer> neighbors : adj) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] topoOrder = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder[index++] = node;
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return index == numCourses ? topoOrder : new int[0];
    }
}
