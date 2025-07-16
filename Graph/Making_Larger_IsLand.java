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

public class Making_Larger_IsLand {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Disjoint_Set ds = new Disjoint_Set(n * n);
        int maxSize = 0;
        for(int r= 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 0) {
                    continue; // Skip water cells
                }
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};
                for(int ind = 0; ind < 4; ind++) {
                    int nr = r + dr[ind];
                    int nc = c + dc[ind];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        ds.unionbySize(r * n + c, nr * n + nc);
                    }
                }
            }
        }

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 1) {
                    continue; // Skip land cells
                }
                Set<Integer> uniqueParents = new HashSet<>();
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};
                for(int ind = 0; ind < 4; ind++) {
                    int nr = r + dr[ind];
                    int nc = c + dc[ind];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        uniqueParents.add(ds.findPar(nr * n + nc));
                    }
                }
                int size =0;
                for(int parent : uniqueParents) {
                    size += ds.size.get(parent);
                }
                maxSize = Math.max(maxSize, size + 1); // +1 for the current water cell
            }
        }

        for(int i = 0; i < n * n; i++) {
            maxSize = Math.max(maxSize, ds.size.get(ds.findPar(i)));
        }
        return maxSize;
    }
}
