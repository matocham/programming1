package matocham.sort;

public class QuickSort implements SortingAlghortim {
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            sort(arr, start, pivotIndex - 1);
            sort(arr, pivotIndex + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int wallIndex = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, ++wallIndex, i);
            }
        }
        swap(arr, ++wallIndex, end);
        return wallIndex;
    }
}
