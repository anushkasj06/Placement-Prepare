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
public class Account_Merge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        HashMap<String, Integer> emailToId = new HashMap<>();
        Disjoint_Set ds = new Disjoint_Set(n);
        for(int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if(emailToId.containsKey(mail)== false) {
                    emailToId.put(mail, i);
                } else {
                    ds.unionbySize(i, emailToId.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedAccounts = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            mergedAccounts[i] = new ArrayList<>();
        }
        for(Map.Entry<String, Integer> entry : emailToId.entrySet()) {
            String email = entry.getKey();
            int id = ds.findPar(entry.getValue());
            mergedAccounts[id].add(email);
        }
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
           if(mergedAccounts[i].size()==0) continue;
           Collections.sort(mergedAccounts[i]);
           List<String> temp = new ArrayList<>();
           temp.add(accounts.get(i).get(0)); // Add the name
           for(String it :mergedAccounts[i]){
                temp.add(it);
           }

           result.add(temp);
        }
        return result;
    }
}
