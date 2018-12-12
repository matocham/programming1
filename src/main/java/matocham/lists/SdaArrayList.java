package matocham.lists;

public class SdaArrayList implements SdaList {
    String[] data;
    int size;
    public SdaArrayList(int capacity){
        data = new String[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
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

    public void add(String value) {

    }

    public void add(String value, int index) {

    }

    public String get(int index) {
        return null;
    }

    public String remove(int index) {
        return null;
    }
}
