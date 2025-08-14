package Heap;

public class MinToMaxHeap {

    // Function to heapify subtree rooted at index i
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // root index
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify affected subtree
            heapify(arr, n, largest);
        }
    }

    // Convert Min Heap to Max Heap
    public static void convertMinToMax(int[] arr) {
        int n = arr.length;

        // Start from last non-leaf node and heapify
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void main(String[] args) {
        int[] minHeap = {1, 3, 5, 7, 9, 6};

        System.out.println("Min Heap:");
        for (int num : minHeap) {
            System.out.print(num + " ");
        }

        convertMinToMax(minHeap);

        System.out.println("\nMax Heap:");
        for (int num : minHeap) {
            System.out.print(num + " ");
        }
    }
}
