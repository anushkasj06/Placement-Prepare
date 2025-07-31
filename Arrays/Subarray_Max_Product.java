public class Subarray_Max_Product {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int pre = 1;
        int suf = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            pre = pre * nums[i];
            suf = suf * nums[n - i - 1];
            max = Math.max(max, Math.max(pre, suf));
            if (pre == 0) {
                pre = 1; // reset pre product if it becomes zero
            }
            if (suf == 0) {
                suf = 1; // reset suf product if it becomes zero
            }
        }
        return max;
    }

}
