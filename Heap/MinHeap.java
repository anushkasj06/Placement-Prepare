package Heap;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private int getParent(int i) { return (i - 1) / 2; }
    private int getLeftChild(int i) { return 2 * i + 1; }
    private int getRightChild(int i) { return 2 * i + 2; }

    private boolean hasParent(int i) { return getParent(i) >= 0; }
    private boolean hasLeftChild(int i) { return getLeftChild(i) < size; }
    private boolean hasRightChild(int i) { return getRightChild(i) < size; }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int value) {
        if (size == capacity) throw new IllegalStateException("Heap is full");
        heap[size] = value;
        size++;
        heapifyUp();
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return root;
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && heap[getParent(index)] > heap[index]) {
            swap(getParent(index), index);
            index = getParent(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChild = getLeftChild(index);
            if (hasRightChild(index) && heap[getRightChild(index)] < heap[smallerChild]) {
                smallerChild = getRightChild(index);
            }
            if (heap[index] < heap[smallerChild]) break;
            else swap(index, smallerChild);
            index = smallerChild;
        }
    }

    public boolean isEmpty() { return size == 0; }

}
