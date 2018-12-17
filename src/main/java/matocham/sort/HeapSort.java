package matocham.sort;

import matocham.trees.Heap;

public class HeapSort implements SortingAlgorithm {
    private Heap heap;

    @Override
    public void sort(int[] array) {
        heap = new Heap(array);
        heap.createHeap2();
        heap.sort();
    }
}
