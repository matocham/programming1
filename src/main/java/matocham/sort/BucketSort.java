package matocham.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        ArrayList<Integer>[] buckets = new ArrayList[10];
        Arrays.setAll(buckets, value -> new ArrayList<>());
        for (int i : array) {
            int index = (i + 50) / 100;
            buckets[index].add(i);
        }
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int counter = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (Integer integer : bucket) {
                array[counter++] = integer;
            }
        }
    }
}
