public class Sqrt_of_BS {
    public static void main(String[] args) {
        int number = 16;
        System.out.println("Square root of " + number + " is: " + sqrt(number));
    }

    public static int sqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Negative input");
        }
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
