package matocham.sort;

public interface SortingAlghortim {
    void sort(int[] array);

    default void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
