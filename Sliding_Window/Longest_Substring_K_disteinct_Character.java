package Sliding_Window;
import java.util.*;

public class Longest_Substring_K_disteinct_Character {
    public int findLongestSubstring(String s, int k) {
        int maxLength = 0;
        int l=0;
        int r=0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            char currentChar = s.charAt(r);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                l++;
            }

            if(map.size()<=k){
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r++;
        }

        return maxLength;
    }
}
