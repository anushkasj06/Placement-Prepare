package Sliding_Window;

public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        if(s.length()==0 || t.length()==0) return "";
        int[] hash = new int[256];
        int r=0;
        int l=0;
        int minlen=Integer.MAX_VALUE;
        int sInd = -1;
        for (char c : t.toCharArray()) {
            hash[c]++;
        }
        while (r < s.length()) {
            if(hash[s.charAt(r)] > 0) sInd++;
            hash[s.charAt(r)]--;
            while (sInd == t.length()) {
                if (r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    sInd = l;
                }
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) sInd--;
                l++;
            }
            r++;
        }
        return sInd == -1 ? "" : s.substring(sInd, sInd + minlen);
    }
}
