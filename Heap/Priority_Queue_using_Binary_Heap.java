package Heap;

public class Priority_Queue_using_Binary_Heap {

    private int[] heap;
    private int size;
    private int capacity;

    public Priority_Queue_using_Binary_Heap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private int getParent(int index) { return (index - 1) / 2; }
    private int getLeftChild(int index) { return 2 * index + 1; }
    private int getRightChild(int index) { return 2 * index + 2; }

    private boolean hasLeftChild(int index) { return getLeftChild(index) < size; }
    private boolean hasRightChild(int index) { return getRightChild(index) < size; }
    private boolean hasParent(int index) { return getParent(index) >= 0; }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert element into heap
    public void insert(int value) {
        if (size == capacity) throw new IllegalStateException("Heap is full");
        heap[size] = value;
        size++;
        heapifyUp();
    }

    // Remove max element (root)
    public int poll() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int rootValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return rootValue;
    }

    // Heapify up after insert
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && heap[getParent(index)] < heap[index]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    // Heapify down after removal
    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int largerChildIndex = getLeftChild(index);
            if (hasRightChild(index) && heap[getRightChild(index)] > heap[largerChildIndex]) {
                largerChildIndex = getRightChild(index);
            }
            if (heap[index] > heap[largerChildIndex]) {
                break;
            } else {
                swap(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        Priority_Queue_using_Binary_Heap pq = new Priority_Queue_using_Binary_Heap(10);

        pq.insert(15);
        pq.insert(10);
        pq.insert(30);
        pq.insert(5);

        System.out.println("Polling elements in priority order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

