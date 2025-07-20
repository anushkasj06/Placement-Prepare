public class Number_That_Apper_Once {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num; // XOR operation
        }
        return ans;
    }

    public static void main(String[] args) {
        Number_That_Apper_Once solution = new Number_That_Apper_Once();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(solution.singleNumber(nums)); // Output: 4
    }
}
