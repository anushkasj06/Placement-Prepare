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
    public boolean unionbyRank(int x, int y) {
        int ulpx = findPar(x);
        int ulpy = findPar(y);
        if (ulpx == ulpy) {
            return false; // They are already in the same set
        }
        // Union by rank
        if (rank.get(ulpx) < rank.get(ulpy)) {
            parent.set(ulpx, ulpy);
        } else if (rank.get(ulpx) > rank.get(ulpy)) {
            parent.set(ulpy, ulpx);
        } else {
            parent.set(ulpy, ulpx);
            rank.set(ulpx, rank.get(ulpx) + 1);
        }
        return true;
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
    public int getSize(int x) {
        return size.get(findPar(x));
    }
    public boolean isConnected(int x, int y) {
        return findPar(x) == findPar(y);
    }
    public void printSets() {
        Map<Integer, List<Integer>> sets = new HashMap<>();
        for (int i = 0; i < parent.size(); i++) {
            int root = findPar(i);
            sets.putIfAbsent(root, new ArrayList<>());
            sets.get(root).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> entry : sets.entrySet()) {
            System.out.println("Set with root " + entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        Disjoint_Set ds = new Disjoint_Set(10);
        ds.unionbyRank(1, 2);
        ds.unionbyRank(2, 3);
        ds.unionbySize(4, 5);
        ds.unionbySize(5, 6);
        ds.unionbyRank(1, 4);
        
        ds.printSets();
        
        System.out.println("Size of set containing 1: " + ds.getSize(1));
        System.out.println("Are 1 and 3 connected? " + ds.isConnected(1, 3));
        System.out.println("Are 4 and 6 connected? " + ds.isConnected(4, 6));
    }
}
