import java.util.*;

public class Print_only1_Subseq_sum_k {
    public static boolean printSub(int ind, ArrayList<Integer> ds, int s, int sum, int[] arr, int n){
        if(ind == n){
            if(s == sum){
                for(int list : ds){
                    System.out.print(list + " ");
                }
                System.out.println();
                return true;
            }
            return false;
        }

        ds.add(arr[ind]);
        s += arr[ind];
        if(printSub(ind+1, ds, s, sum, arr, n)) return true;

        s -= arr[ind];
        ds.remove(ds.size()-1);
        if(printSub(ind+1, ds, s, sum, arr, n)) return true;

        return false;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int sum = 2;
        int n = 3;
        ArrayList<Integer> ds = new ArrayList<>();
        printSub(0,ds,0,sum, arr,n);
    }
}
