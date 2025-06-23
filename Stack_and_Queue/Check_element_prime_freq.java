public class Check_element_prime_freq {
    public boolean checkPrimeFrequency(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }
        for (int i = 0; i < 101; i++) {
            if (freq[i] > 0) {
                if (isPrime(freq[i])) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
