public class find_duplicate {
    public int findduplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Finding the intersection point
        do {
            slow = nums[slow]; // Move slow by 1 step
            fast = nums[nums[fast]]; // Move fast by 2 steps
        } while (slow != fast);

        // Phase 2: Finding the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // The duplicate number
    }


    
}
