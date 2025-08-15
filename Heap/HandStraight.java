package Heap;
import java.util.*;

public class HandStraight {
    public boolean isHandStraight(int[] hand, int groupSize) {
        int handsize = hand.length;
        if(handsize%groupSize!=0){
            return false;
        }

        Map<Integer,Integer> cardcount = new TreeMap<>();
        for(int i=0;i<handsize;i++){
            cardcount.put(hand[i], cardcount.getOrDefault(hand[i], 0) + 1);
        }

        while(cardcount.size()>0){
            int currentcard = cardcount.entrySet().iterator().next().getKey();
            for(int i=0;i<groupSize;i++){
                if(!cardcount.containsKey(currentcard + i)){
                    return false;
                }
                cardcount.put(currentcard + i, cardcount.get(currentcard + i) - 1);
                if(cardcount.get(currentcard + i) == 0){
                    cardcount.remove(currentcard + i);
                }
            }
        }

        return true;
    }
}
