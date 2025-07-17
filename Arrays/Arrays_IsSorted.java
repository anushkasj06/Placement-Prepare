public class Arrays_IsSorted {
    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true; // An empty array or null is considered sorted
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false; // Found an element that is less than the previous one
            }
        }
        
        return true; // All elements are in non-decreasing order
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] unsortedArray = {5, 3, 4, 1, 2};

        System.out.println("Is sorted: " + isSorted(sortedArray)); // Should print true
        System.out.println("Is sorted: " + isSorted(unsortedArray)); // Should print false
    }
}
