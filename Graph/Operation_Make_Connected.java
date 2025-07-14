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
public class Operation_Make_Connected {
    public int makeConnected(int n, int[][] connections) {
        Disjoint_Set ds = new Disjoint_Set(n);
        int extraEdges = 0;
        for(int i=0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findPar(v)==ds.findPar(u)) {
                extraEdges++;
            } else {
                ds.unionbySize(u, v);
            }
        }
        int components = 0;
        for(int i=0; i < n; i++) {
            if(ds.parent.get(i) == i) {
                components++;
            }
        }
        if(extraEdges >= components - 1) {
            return components - 1;
        }
        return -1;
    }
}
