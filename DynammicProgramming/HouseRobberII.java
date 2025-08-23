import java.util.ArrayList;

public class HouseRobberII {
     public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0){
                list1.add(nums[i]);
            }
            if(i!=n-1){
                list2.add(nums[i]);
            }
        }
        return Math.max(f(list1), f(list2));
    }

    public int f(ArrayList<Integer> list){
        int prev = list.get(0);
        int prev2 = 0;
        for(int i=1;i<list.size();i++){
            int take = list.get(i);
            if(i>1) take += prev2;
            int untake = prev;
            int curr = Math.max(take, untake);
            prev2 = prev;
            prev = curr;
        }
        return prev;

    }
}
