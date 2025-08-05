public class Kth_element_Two_Sorted_Array {
    public int findKthElement(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;
        int i = 0, j = 0;
        int count = 0;
        int kthElement = 0;
        while (i < m && j < n) {
            if (a[i] < b[j]) {
                kthElement = a[i];
                i++;
            } else {
                kthElement = b[j];
                j++;
            }
            count++;
            if (count == k) {
                break;
            }
        }
        while (i < m) {
            kthElement = a[i];
            i++;
            count++;
            if (count == k) {
                break;
            }
        }
        while (j < n) {
            kthElement = b[j];
            j++;
            count++;
            if (count == k) {
                break;
            }
        }
        return kthElement;  
    }
}
