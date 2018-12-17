package matocham.sort;

public class InsertionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int value = array[j];
            while (j > 0 && value < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = value;
        }
    }
}
