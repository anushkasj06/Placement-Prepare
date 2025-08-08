package Sliding_Window;

import java.util.Arrays;

public class Longest_Substring_without_reapeating_character {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l =0;
        int r=0;
        int maxLength = 0;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        while(r<n){
            if(hash[s.charAt(r)]!=-1){
                if(hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }
            hash[s.charAt(r)] = r;
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}
