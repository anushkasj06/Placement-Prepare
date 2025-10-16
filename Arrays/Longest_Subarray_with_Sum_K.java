import java.util.HashMap;
import java.util.Map;

public class Longest_Subarray_with_Sum_K {
    public int longestSubarrayWithSumKworkforbothposandneg(int[] nums, int k) {
        int maxLength = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1); // To handle the case when the subarray starts from index 0

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int res = currentSum - k;
            // If currentSum is equal to k, update maxLength
            if (currentSum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }
            // If currentSum - k exists in the map, update maxLength
            if (sumIndexMap.containsKey(res)) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(res));
            }
            

            // Store the first occurrence of currentSum
            if (!sumIndexMap.containsKey(currentSum)) {
                sumIndexMap.put(currentSum, i);
            }
        }

        return maxLength;
    }

    public int longestsubarraysumkwithtwopointer(int[] nums, int k) {
        int maxLength = 0;
        int left = 0;
        int currentSum = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            while (currentSum > k && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            if (currentSum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
            if( right < n) {
                currentSum += nums[right];
            }
        }

        return maxLength;
    }


    public int longestsubarraywithsumK_usingprefixsum(int[] a, long k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        long sum = 0;
        int maxLength = 0;
        for(int i =0;i<a.length;i++){
            sum += a[i];
            if(sum==k){
                maxLength = Math.max(maxLength, i + 1);
            }
            int res = (int)(sum -k);
            if(map.containsKey(res)){
                maxLength = Math.max(maxLength, i- map.get(res));
            }
            if(!map.containsKey(res)){
                map.put(res, i);
            }
        }

        return maxLength;
    }

    public int countsubarraywirthsumk(int[] a, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum =0;
        int count =0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
            if(sum==k){
                count++;
            }
            int res = (int)(sum -k);
            if(map.containsKey(res)){
                count += map.get(res);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public int countsubarrayWithsumK(int[] a, int k){
        int left =0;
        int right =0;
        int sum = a[0];
        int n = a.length;
        int count =0;
        while(right<n){
            if(sum==k){
                count++;
            }
            right++;
            if(right<n){
                sum += a[right];
            }
            if(sum>k){
                left++;
                sum -= a[left];
            }
        }

    }


}
