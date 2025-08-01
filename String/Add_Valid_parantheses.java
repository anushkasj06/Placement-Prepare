package String;

public class Add_Valid_parantheses {
        public int minAddToMakeValid(String s) {
            int open = 0;   // Count of unmatched '('
            int close = 0;  // Count of unmatched ')'
    
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    open++;  // We need a ')' later
                } else { // c == ')'
                    if (open > 0) {
                        open--; // Match found for a previous '('
                    } else {
                        close++; // Extra ')' found
                    }
                }
            }
    
            // Total insertions needed = unmatched '(' + unmatched ')'
            return open + close;
        }    
}
