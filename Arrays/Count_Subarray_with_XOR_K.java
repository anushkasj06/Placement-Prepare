public class Count_Subarray_with_XOR_K {
    public int countSubarraysWithXORk(int[] nums, int k) {
        int count = 0;
        int xorSum = 0;
        java.util.Map<Integer, Integer> freqMap = new java.util.HashMap<>();
        freqMap.put(0, 1); // To handle the case where the subarray itself has XOR sum k

        for (int num : nums) {
            xorSum ^= num; // Calculate the XOR sum up to the current element
            // Check if (xorSum ^ k) exists in the frequency map
            // If it does, it means there's a prefix whose XOR with current xorSum equals k
            if (freqMap.containsKey(xorSum ^ k)) {
                count += freqMap.get(xorSum ^ k);
            }
            // Increment the frequency of the current xorSum
            freqMap.put(xorSum, freqMap.getOrDefault(xorSum, 0) + 1);
        }

        return count;
    }
}
