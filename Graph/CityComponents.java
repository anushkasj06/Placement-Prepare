import java.util.*;

public class CityComponents {

    static int[] parent;
    static int[] rank;

    static void makeSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[py] < rank[px]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of cities
        int m = sc.nextInt(); // number of roads

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        makeSet(n);

        boolean[] active = new boolean[n + 1];
        int[] ans = new int[n];
        int components = 0;

        for (int i = n; i >= 1; i--) {
            active[i] = true;
            components++;

            for (int neighbor : graph.get(i)) {
                if (active[neighbor]) {
                    if (union(i, neighbor)) {
                        components--;
                    }
                }
            }

            ans[i - 1] = components;
        }

        for (int val : ans) {
            System.out.println(val);
        }

        sc.close();
    }
}
