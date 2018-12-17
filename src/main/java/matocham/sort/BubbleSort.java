package matocham.sort;

import com.sun.istack.internal.NotNull;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public void sort(@NotNull int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
