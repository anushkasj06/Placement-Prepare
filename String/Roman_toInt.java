package String;

import java.util.HashMap;
import java.util.Map;

public class Roman_toInt {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);
        int ans =0;
        for(int i=0; i<s.length();i++){
            if(i<s.length()-1&&m.get(s.charAt(i))<m.get(s.charAt(i+1))){
                ans-=m.get(s.charAt(i));
            }else{
                ans +=m.get(s.charAt(i));
            }
        }   
        return ans;
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
