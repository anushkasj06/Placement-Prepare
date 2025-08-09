package Sliding_Window;

public class Longest_Reapeating_Character_Replacement {
    public int characterReplacement(String s, int k){
        int l =0;
        int r=0;
        int maxlen =0;
        int maxfreq  =0;
        int[] freq = new int[26];
        while(r<s.length()){
            freq[s.charAt(r)-'A']++;
            maxfreq = Math.max(maxfreq, freq[s.charAt(r)-'A']);
            if(r-l+1-maxfreq>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
           if(r-l+1-maxfreq<=k){
            maxlen = Math.max(maxlen, r-l+1);
           }
           r++;
        }
        return maxlen;
    }
}
