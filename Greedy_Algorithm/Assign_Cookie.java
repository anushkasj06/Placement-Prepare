package Greedy_Algorithm;
import java.util.*;

public class Assign_Cookie {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0;
        int r=0;
        int n=g.length;
        int m = s.length;
        while(l<m && r<n){
            if(g[r] <= s[l]){
                r++;
            }
            l++;
        }
        return r;
    }
}