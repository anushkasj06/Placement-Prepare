public class No_of_Rotation_Array {
    public int findNotimesRotation(int[] nums){
        if (nums == null || nums.length == 0) {
            return -1; // or throw an exception
        }
        
        int left = 0, right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
           if(nums[left] <= nums[right]) {
                if(nums[left] < ans) {
                    ans = nums[left];
                    index = left; // Store the index of the minimum element
                }
                break;
            }
            if (nums[left] <= nums[mid]) {
                if(nums[left] < ans) {
                    ans = nums[left];
                    index = left;
                }
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
                if(nums[mid] < ans) {
                    ans = nums[mid];
                    index = mid;
                }
            }
        }
        return index;
    }


   public int noofRotaioninRotatedArrayDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
        return -1; // or throw an exception
    }
    int left = 0, right = nums.length - 1;
    int ans = Integer.MAX_VALUE;
    int index = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
            // Check current left, mid, right for minimum
            if (nums[left] < ans) {
                ans = nums[left];
                index = left;
            }
            if (nums[mid] < ans) {
                ans = nums[mid];
                index = mid;
            }
            if (nums[right] < ans) {
                ans = nums[right];
                index = right;
            }
            // Shrink the window
            left++;
            right--;
            continue;
        }

        if (nums[left] <= nums[mid]) { // Left part is sorted
            if (nums[left] < ans) {
                ans = nums[left];
                index = left;
            }
            left = mid + 1;
        } else { // Right part is sorted
            if (nums[mid] < ans) {
                ans = nums[mid];
                index = mid;
            }
            right = mid - 1;
        }
    }

    return index; // Index of minimum element = number of rotations
}
}
