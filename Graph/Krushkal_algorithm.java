import java.util.*;

class Disjoint_Set {
    List<Integer> parent;
    List<Integer> rank;
    List<Integer> size;

    public Disjoint_Set(int n) {
        parent = new ArrayList<>(n);
        rank = new ArrayList<>(n);
        size = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findPar(int x) {
       if(x== parent.get(x)) {
            return x;
        }
        int ulp = findPar(parent.get(x));
        parent.set(x, ulp); // Path compression
        return ulp;
    }

    public boolean unionbySize(int x, int y) {
        int ulpx = findPar(x);
        int ulpy = findPar(y);
        if (ulpx == ulpy) {
            return false; // They are already in the same set
        }
        // Union by size
        if (size.get(ulpx) < size.get(ulpy)) {
            parent.set(ulpx, ulpy);
            size.set(ulpy, size.get(ulpy) + size.get(ulpx));
        } else {
            parent.set(ulpy, ulpx);
            size.set(ulpx, size.get(ulpx) + size.get(ulpy));
        }
        return true;
    }
}

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}
public class Krushkal_algorithm {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                int dest = adj.get(i).get(j).get(0);
                int weight = adj.get(i).get(j).get(1);
                edges.add(new Edge(i, dest, weight));
            }
        }
        Collections.sort(edges);
        Disjoint_Set ds = new Disjoint_Set(V);
        int mstWeight = 0;
        for(int i=0;i<edges.size();i++){
            int src = edges.get(i).src;
            int dest = edges.get(i).dest;
            int weight = edges.get(i).weight;
            if(ds.findPar(weight) != ds.findPar(dest)) {
                ds.unionbySize(src, dest);
                mstWeight += weight;
            }
        }
        return mstWeight;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Adding edges
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 10)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 6)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(3, 5)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 15)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 4)));
        int mstWeight = spanningTree(V, adj);
        System.out.println("Weight of MST is: " + mstWeight);
    }
}
