public class Linear_Serach {
    public static int linearSearch(int[] arr, int target) {
        if (arr == null) {
            return -1; // Array is null, return -1
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found the target, return its index
            }
        }
        
        return -1; // Target not found, return -1
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 6, 2};
        int target = 6;
        int result = linearSearch(array, target);
        
        if (result != -1) {
            System.out.println("Element found at index: " + result); // Should print the index of the target
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
