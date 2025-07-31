package String;
import java.util.*;

public class Isomorphism {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        
        Arrays.fill(mapS, -1);
        Arrays.fill(mapT, -1);
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(mapS[cs] != mapT[ct]) {
                return false;
            }
            mapS[cs] = mapT[ct] = i + 1;
        }
        return true;
    }
}