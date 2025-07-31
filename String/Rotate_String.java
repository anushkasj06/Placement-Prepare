package String;

public class Rotate_String {
    public boolean rotateStringOptimized(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String doubled = s + s;
        return doubled.contains(goal);
    }
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int n = s.length();
        int indexoss0 = -1;
        int firsts = s.charAt(0);
        for (int i = 0; i < goal.length(); i++) {
            if (goal.charAt(i) == firsts) {
                indexoss0 = i;
                break;
            }
        }
        if (indexoss0 == -1) {
            return false;
        }
        for(int i=indexoss0, j=0; j<n; i++, j++) {
            if(s.charAt(j) != goal.charAt(i%n)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Rotate_String rs = new Rotate_String();
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rs.rotateString(s, goal)); // Output: true
        System.out.println(rs.rotateStringOptimized(s, goal)); // Output: true
    }
        
}
