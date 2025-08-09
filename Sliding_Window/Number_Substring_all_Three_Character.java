package Sliding_Window;

public class Number_Substring_all_Three_Character {
    public int numberOfSubstrings(String s) {
        int count =0;
        int[] lastseen = {-1,-1,-1};
        for(int r=0; r<s.length(); r++){
            lastseen[s.charAt(r) - 'a'] = r;
            if(lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1) {
                int minIndex = Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));
                count += minIndex + 1;
            }
        }
        return count;
    }
}
