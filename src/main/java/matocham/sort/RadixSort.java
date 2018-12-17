package matocham.sort;

public class RadixSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        for(int i=1; i<1000; i*=10){
            coutingSort(array, i);
        }
    }

    private void coutingSort(int[] array, int i) {
        int[] count = new int[10]; // przechowuje zliczone wartości
        int posValue = (array[0]/i)%10; // w pętli array[i]
    }
}
