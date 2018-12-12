package matocham.trees;

import java.util.NoSuchElementException;

public class TreeTable {
    String[] data = new String[100];
    int size = 0;

    public void add(String value) {
        data[size] = value;
        size++;
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
