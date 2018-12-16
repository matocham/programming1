package matocham.sort;

import matocham.trees.Heap;
import matocham.trees.TreeTable;

public class HeapSort implements SortingAlghortim {
    Heap heap;

    @Override
    public void sort(int[] array) {
        heap = new Heap(array);
        heap.createHeap(); // tworzy kopiec z tablicy
        heap.sort();
    }
}
