package String;

public class Count_Max_Substring {
    public int countMaxSubstring(String s, String sub) {
        int count = 0;
        int index = 0;

        while ((index = s.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length(); // Move index forward to avoid counting the same substring again
        }

        return count;
    }

    public int countTotalSubstring(String s, String sub) {
        int count = 0;
        for(int i = 0; i <= s.length() - sub.length(); i++) {
           for(int j = i; j < s.length(); j++) {
                count++;
            }
        }
        return count;
    }

    public int countSubstring(String s, String sub) {
        int n = s.length();
        return n *(n+1)/2;
    }
}
