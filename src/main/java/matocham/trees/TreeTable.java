package matocham.trees;

import java.util.NoSuchElementException;
import java.util.Optional;

public class TreeTable {
    String[] data = new String[100];
    int size = 0;

    public void add(String value) {
        int i = size;
        size++;
        int j = (i - 1) / 2;

        while (i > 0 && data[j].compareTo(value) < 0) {
            data[i] = data[j];
            i = j;
            j = (i - 1) / 2;
        }
        data[i] = value;
    }

    public Optional<String> remove() {
        if (size == 0) {
            //return null;
            //throw new IndexOutOfBoundsException();
            return Optional.empty();
        }
        String valueToReturn = data[0];
        size--;
        String value = data[size];
        int i = 0;
        int j = 1;
        while (j < size) {
            if (j + 1 < size && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            if (value.compareTo(data[j]) >= 0) {
                break;
            }
            data[i] = data[j];
            i = j;
            j = 2 * j + 1;
        }
        data[i] = value;
        return Optional.ofNullable(valueToReturn);
    }

    public void sort() {
        for (int i = size - 1; i > 0; i--) {
            String temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            int j = 0;
            int k = 1;
            while (k < i) {
                int m;
                if (k + 1 < i && data[k + 1].compareTo(data[k]) > 0) {
                    m = k + 1;
                } else {
                    m = k;
                }
                if (data[m].compareTo(data[j]) <= 0) {
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

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        return data[index];
    }

    public String getLeftChild(int index) {
        int left = 2 * index + 1;
        if (left >= size) {
            throw new NoSuchElementException();
        }
        return data[left];
    }

    public String getRightChild(int index) {
        int right = 2 * index + 2;
        if (right >= size) {
            throw new NoSuchElementException();
        }
        return data[right];
    }

    public String getParentValue(int index) {
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
}
