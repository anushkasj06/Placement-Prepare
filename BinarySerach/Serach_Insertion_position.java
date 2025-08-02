public class Serach_Insertion_position {
    public int searchInsert(int[] nums, int target) {
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
        Serach_Insertion_position sip = new Serach_Insertion_position();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println("Insertion position for " + target + ": " + sip.searchInsert(nums, target)); // Output: 2
    }
}
