package matocham.sort;

public class QuickSort2 implements SortingAlghortim{
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int leftWall = low;
        int rightWall = high;
        int pivotIndex = low + (high - low) / 2;
        int pivot = arr[pivotIndex];
        while (leftWall <= rightWall) {
            while (arr[leftWall] < pivot) {
                leftWall++;
            }
            while (arr[rightWall] > pivot) {
                rightWall--;
            }
            if (leftWall <= rightWall) {
                swap(arr, leftWall, rightWall);
                leftWall++;
                rightWall--;
            }
        }
        sort(arr, low, rightWall);
        sort(arr, leftWall, high);
    }
}
