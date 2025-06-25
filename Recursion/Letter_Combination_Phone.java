import java.util.ArrayList;
import java.util.List;

public class Letter_Combination_Phone {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<String> ans = padRet("", digits);
        return ans;
    }

    ArrayList<String> padRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0'; 
        
        String[] mapping = {
            "",     // 0 - no mapping
            "",     // 1 - no mapping
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        ArrayList<String> list = new ArrayList<>();
        String letters = mapping[digit];

        for (char ch : letters.toCharArray()) {
            list.addAll(padRet(p + ch, up.substring(1)));
        }
        return list;
    }
}
