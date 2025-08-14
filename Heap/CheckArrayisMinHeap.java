package Heap;

public class CheckArrayisMinHeap {
    public boolean isMinHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            if (leftChild < array.length && array[i] > array[leftChild]) return false;
            if (rightChild < array.length && array[i] > array[rightChild]) return false;
        }
        return true;
    }
}
