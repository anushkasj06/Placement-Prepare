package String;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram anagramChecker = new IsAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(anagramChecker.isAnagram(s, t)); // Output: true
    }
}
