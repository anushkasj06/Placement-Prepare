import java.lang.reflect.Array;
import java.util.ArrayList;

public class Reaarange_Pos_neg {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }
       for(int i=0; i<n/2;i++){
           result[i*2] = pos.get(i);
           result[i*2+1] = neg.get(i);
       }
       return result;
    }

    public int[] rearrangeArraynotequaldiffernce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }
        if(pos.size()>neg.size()){
            for(int i=0; i<neg.size(); i++){
                result[i*2] = pos.get(i);
                result[i*2+1] = neg.get(i);
            }
            for(int i=neg.size(); i<pos.size(); i++){
                result[i+neg.size()] = pos.get(i);
            }
        }else{
            for(int i=0; i<pos.size(); i++){
                result[i*2] = pos.get(i);
                result[i*2+1] = neg.get(i);
            }
            for(int i=pos.size(); i<neg.size(); i++){
                result[i+pos.size()] = neg.get(i);
            }
        }
        return result;
    }
}
