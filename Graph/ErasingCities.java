import java.util.*;

public class ErasingCities {

    static class DSU {
        private int[] parent;
        private int[] rank;
        private int components;

        public DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            components = n;
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ) {
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else {
                    parent[rootJ] = rootI;
                    rank[rootI]++;
                }
                components--;
            }
        }

        public int getComponents() {
            return components;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[]{u, v});
        }

        int[] erasedCities = new int[N];
        for (int i = 0; i < N; i++) {
            erasedCities[i] = scanner.nextInt();
        }
        scanner.close();

        DSU dsu = new DSU(N);

        boolean[] present = new boolean[N + 1];

        List<Integer> result = new ArrayList<>();
        
        result.add(0);

        for (int i = N - 1; i >= 0; i--) {
            int cityToAdd = erasedCities[i];
            
            present[cityToAdd] = true;
            
            int currentComponents = dsu.getComponents();
            
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                if ((u == cityToAdd && present[v]) || (v == cityToAdd && present[u])) {
                    dsu.union(u, v);
                }
            }

            Set<Integer> roots = new HashSet<>();
            int presentCityCount = 0;
            for (int j = 1; j <= N; j++) {
                if (present[j]) {
                    roots.add(dsu.find(j));
                    presentCityCount++;
                }
            }
            
            int componentsAmongPresent = roots.size();
            
            result.add(componentsAmongPresent);
        }

        Collections.reverse(result);
        
        for (int i = 0; i < N; i++) {
            System.out.println(result.get(i));
        }
    }
}