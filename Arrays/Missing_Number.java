public class Missing_Number {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public int missingNumberXOR(int[] nums) {
        int n = nums.length;
        int xor = 0;
        int xor2 = 0;
        for (int i = 0; i <n-1; i++) {
            xor ^= nums[i];
            xor2 ^= i + 1; // i+1 because we are considering numbers from 1 to n
        }
        xor2 ^= n; // XOR the last number n
        return xor ^ xor2; // The result is the missing number
    }
}
