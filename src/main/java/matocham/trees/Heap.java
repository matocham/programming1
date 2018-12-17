package matocham.trees;

import java.util.NoSuchElementException;

public class Heap {
    int[] data;
    int size = 0;

    public Heap(int[] array) {
        this.data = array;
        size = 1;
    }

    public void add(int value) {
        int i = size;
        size++;
        int j = (i - 1) / 2;

        while (i > 0 && data[j] < value) {
            data[i] = data[j];
            i = j;
            j = (i - 1) / 2;
        }
        data[i] = value;
    }

    public int remove() {
        if (size == 0) {
            //return null;
            //throw new IndexOutOfBoundsException();
            return -1;
        }
        int valueToReturn = data[0];
        size--;
        int value = data[size];
        int i = 0;
        int j = 1;
        while (j < size) {
            if (j + 1 < size && data[j + 1] > data[j]) {
                j++;
            }
            if (value >= data[j]) {
                break;
            }
            data[i] = data[j];
            i = j;
            j = 2 * j + 1;
        }
        data[i] = value;
        return valueToReturn;
    }

    public void sort() {
        for (int i = size - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            int j = 0;
            int k = 1;
            while (k < i) {
                int m;
                if (k + 1 < i && data[k + 1] > data[k]) {
                    m = k + 1;
                } else {
                    m = k;
                }
                if (data[m] <= data[j]) {
                    break;
                }
                temp = data[m];
                data[m] = data[j];
                data[j] = temp;
                j = m;
                k = 2 * j + 1;
            }
        }
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        return data[index];
    }

    public int getLeftChild(int index) {
        int left = 2 * index + 1;
        if (left >= size) {
            throw new NoSuchElementException();
        }
        return data[left];
    }

    public int getRightChild(int index) {
        int right = 2 * index + 2;
        if (right >= size) {
            throw new NoSuchElementException();
        }
        return data[right];
    }

    public int getParentValue(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        return data[(index - 1) / 2];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]).append(", ");
        }

        result.append("]");
        return result.toString();
    }

    public void createHeap() {
        for (int k = 1; k < data.length; k++) {
            int i = size;
            int value = data[size];
            size++;
            int j = (i - 1) / 2;

            while (i > 0 && data[j] < value) {
                data[i] = data[j];
                i = j;
                j = (i - 1) / 2;
            }
            data[i] = value;
        }
    }

    public void createHeap2() {
        size = data.length;
        for (int k = data.length / 2 - 1; k >= 0; k--) {
            int value = data[k];
            int i = k;
            int j = 2*k+1;
            while (j < size) {
                if (j + 1 < size && data[j + 1] > data[j]) {
                    j++;
                }
                if (value >= data[j]) {
                    break;
                }
                data[i] = data[j];
                i = j;
                j = 2 * j + 1;
            }
            data[i] = value;
        }
    }
}
