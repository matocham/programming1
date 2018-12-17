package matocham.sort;


import java.util.Arrays;

public class CountingSort implements SortingAlgorithm {
    int[] count = new int[1000];

    @Override
    public void sort(int[] array) {
        Arrays.fill(count, 0);
        int[] output = new int[array.length];
        for (int i : array) {
            count[i]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int summedUpPosition = count[array[i]];
            output[summedUpPosition - 1] = array[i];
            --count[array[i]];
        }
        System.arraycopy(output, 0, array, 0, array.length);
    }
}
