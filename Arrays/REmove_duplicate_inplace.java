import java.util.Arrays;

public class REmove_duplicate_inplace {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(arr);
        System.out.println("Array after removing duplicates: " + Arrays.toString(Arrays.copyOf(arr, newLength)));
    }

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int i=0;
        for(int j=0;i<arr.length && j<arr.length; j++) {
            if(arr[j]!= arr[i]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1; // Return the new length of the array
    }
}