

public class Recursive_atoi {
     public int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        int idx = 0;
        long ans = 0;

        if(s.length() == 0) return 0;

        if(s.charAt(0) == '-'){
            sign = -1;
            idx++;
        }
        else if(s.charAt(0) == '+'){
            idx++;            
        }

        return (int) (helper(s, sign, idx, ans));
    }   

    private long helper(String s, int sign, int idx, long ans){
        if(idx >= s.length() || !Character.isDigit(s.charAt(idx))){
            return ans*sign;
        }

        ans = ans*10 + (s.charAt(idx) - '0');

        if(sign == 1 && ans > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(sign == -1 && (sign * ans) < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return helper(s, sign, idx+1, ans);
    } 
}
