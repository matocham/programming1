package matocham.lists;

public interface SdaList {
    int size();
    boolean isEmpty();
    boolean isFull();
    void add(String value); //dodaje na koniec listy
    void add(String value, int index);
    String get(int index);
    String remove(int index);
}
