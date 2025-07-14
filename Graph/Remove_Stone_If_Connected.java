import java.util.*;
class Disjoint_Set {
    List<Integer> parent;
    List<Integer> size;

    public Disjoint_Set(int n) {
        parent = new ArrayList<>(n);
        size = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            parent.add(i);
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

public class Remove_Stone_If_Connected {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            int row = stones[i][0];
            int col = stones[i][1];
            maxRow = Math.max(maxRow, row);
            maxCol = Math.max(maxCol, col);
        }
        Disjoint_Set ds = new Disjoint_Set(maxRow + maxCol + 2); // +2 for offset
        // Union rows and columns
        // Using offset to differentiate between rows and columns
        HashMap<Integer, Integer> stone = new HashMap<>();
        for(int i=0;i<n;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1; // Offset
            ds.unionbySize(nodeRow, nodeCol);
            stone.put(nodeRow, 1);
            stone.put(nodeCol, 1);
        }
        int components = 0;
        for(Map.Entry<Integer, Integer> entry : stone.entrySet()) {
            int key = entry.getKey();
            if (ds.parent.get(key) == key) {
                components++;
            }
        }
        return n - components;

    }
}
