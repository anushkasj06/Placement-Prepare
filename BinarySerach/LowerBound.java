public class LowerBound {
    public int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int ans = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LowerBound lowerBound = new LowerBound();
        int[] nums = {1, 2, 4, 4, 5};
        int target = 4;
        int result = lowerBound.lowerBound(nums, target);
        System.out.println("Lower bound index of target: " + result); // Output: Lower bound index of target: 2
    }
}