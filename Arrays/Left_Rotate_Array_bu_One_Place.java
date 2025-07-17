public class Left_Rotate_Array_bu_One_Place {
    public static void leftRotate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return; // No rotation needed for null or empty array
        }
        
        int firstElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i]; // Shift elements to the left
        }
        arr[arr.length - 1] = firstElement; // Place the first element at the end
    }

    public static void leftRotatebyk(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return; // No rotation needed for null, empty array, or non-positive k
        }
        
        k = k % arr.length; // Handle cases where k is greater than array length
        int[] temp = new int[arr.length];
       for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[(i + k) % arr.length]; // Calculate new index after rotation
        }
       for(int i = 0; i < arr.length; i++) {
            arr[i] = temp[i]; // Copy back to original array
        }
    }

    public static void leftRotatebykOptimize(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return; // No rotation needed for null, empty array, or non-positive k
        }
        
        k = k % arr.length; // Handle cases where k is greater than array length
        reverse(arr, 0, arr.length - 1); // Reverse the entire array
        reverse(arr, 0, arr.length - k - 1); // Reverse the first part
        reverse(arr, arr.length - k, arr.length - 1); // Reverse the second part
    }
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
