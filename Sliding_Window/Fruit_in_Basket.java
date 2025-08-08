package Sliding_Window;
import java.util.*;

public class Fruit_in_Basket {
    public int maxFruit(int[] fruits, int k){
        int l =0;
        int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFruits = 0;

        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if(map.size()>k){
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            maxFruits = Math.max(maxFruits, r - l + 1);
            r++;
        }
        return maxFruits;
    }
}
