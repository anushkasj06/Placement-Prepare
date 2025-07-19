public class Array_isSorted_Rotated {
    public static boolean isSortedRotated(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true; // An empty array or null is considered sorted
        }

        int count = 0; // Count of times the array is rotated
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1]> arr[i]) {
                count++; // Found a point where the order breaks
            }
        }
        // Check the last element with the first element
        if (arr[arr.length - 1] > arr[0]) {
            count++; // If the last element is greater than the first, it counts as a rotation
        }

        // If the array is rotated more than once, it cannot be sorted
        return count <= 1;
    }

    public static void main(String[] args) {
        int[] sortedRotatedArray = {4, 5, 1, 2, 3};
        int[] unsortedRotatedArray = {3, 4, 5, 1, 2};

        System.out.println("Is sorted and rotated: " + isSortedRotated(sortedRotatedArray)); // Should print true
        System.out.println("Is sorted and rotated: " + isSortedRotated(unsortedRotatedArray)); // Should print false
    }
}
