public class Nth_root_BS {
    public int nthRoot(int n, int m) {
        if (n <= 0 || m < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (m == 0 || m == 1) {
            return m;
        }

        int left = 1, right = m;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midPower = power(mid, n, m);
            if (midPower == 1) {
                return mid;
            } else if (midPower == 2) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    int power(int base, int exp, int m) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
            if (result > m) {
                return 2; // Return 2 to indicate overflow
            }
        }
        if (result == m) {
            return 1; // Return 1 to indicate exact match
        }
        return 0; // Return 0 to indicate less than m
    }
    
}
