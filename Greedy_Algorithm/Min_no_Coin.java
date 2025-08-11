package Greedy_Algorithm;
import java.util.*;

public class Min_no_Coin {
    public ArrayList<Integer> findMinCoins(int V){
        int[] deno = {1,2,5,10,20,50,100,200,500,1000};
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        while(V > 0){
            if(V >= deno[index]){
                V -= deno[index];
                result.add(deno[index]);
            }else{
                index++;
            }
        }
        return result;
    }
}
