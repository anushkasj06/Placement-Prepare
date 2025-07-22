import java.util.ArrayList;

public class Max_SubArray_Kadane {
    public int maxSubArray(int[] nums) {
       int max = Integer.MIN_VALUE;
       int sum =0;
         for(int i=0; i<nums.length; i++){
              sum += nums[i];
              if(sum > max){
                max = sum;
              }
              if(sum < 0){
                sum = 0; // Reset sum if it becomes negative
              }
         }
         return max;
    }


    public ArrayList<Integer> maxSubArrayWithIndices(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                tempStart = i; // Potential start of a new subarray
            }
            sum += nums[i];

            if (sum > max) {
                max = sum;
                start = tempStart;
                end = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(nums[i]);
        }
        return result;
    }
}
