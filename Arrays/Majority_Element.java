import java.util.HashMap;

public class Majority_Element {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        int cnt1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == candidate){
                cnt1++;
            }
        }
        if(cnt1 > nums.length/2){
            return candidate;
        }
        return -1;
    }

    public int majorityElementbyhash(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }
}
