package matocham.sort;

public class MergeSort implements SortingAlghortim {
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    void mergeSort(int[] array, int l, int r) {
        if (r > l) {
            int middle = (r + l) / 2;
            mergeSort(array, l, middle);
            mergeSort(array, middle + 1, r);
            merge(array, l, middle, r);
        }
    }

    private void merge(int[] array, int l, int middle, int r) {
        int[] temp = new int[r - l + 1];
        int left = l;
        int right = middle + 1;
        int index = 0;

        while (left <= middle && right <= r) {
            if (array[left] < array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        while (left <= middle){
            temp[index] = array[left];
            index++;
            left++;
        }
        while (right <= r){
            temp[index] = array[right];
            index++;
            right++;
        }
        System.arraycopy(temp, 0, array, l, temp.length);
    }
}
