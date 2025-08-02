public class Simple_BinarySerch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int searchRec(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchRec(nums, target, mid + 1, right);
        } else {
            return searchRec(nums, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        Simple_BinarySerch searcher = new Simple_BinarySerch();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        int result = searcher.search(nums, target);
        System.out.println("Index of target: " + result); // Output: Index of target: 2
    }
}
