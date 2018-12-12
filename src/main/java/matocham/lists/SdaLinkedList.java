package matocham.lists;

import java.util.NoSuchElementException;

public class SdaLinkedList implements SdaList {
    Element head;
    Element tail;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return false;
    }

    public void add(String value) {
        Element newEelement = new Element(value);
        if (size == 0) {
            head = tail = newEelement;
        } else {
            tail.setNext(newEelement);
            tail = newEelement;
        }
        size++;
    }

    public void add(String value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(value);
            return;
        } else if (index == 0) {
            Element e = new Element(value);
            e.setNext(head);
            head = e;
            size++;
        } else {
            Element temp = head;
            int counter = 0;
            while (counter != index - 1) {
                temp = temp.getNext();
                counter++;
            }
            Element e = new Element(value);
            e.setNext(temp.getNext());
            temp.setNext(e);
            size++;
        }
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Element pod indeksem " + index + " nie istnieje");
        }
        Element temp = head;
        int counter = 0;
        while (counter != index) {
            temp = temp.getNext();
            counter++;
        }
        return temp.getVale();
    }

    public String remove(int index) {
        if(index < 0 || index >= size){
            throw new NoSuchElementException();
        }
        Element deleted;
        if(index ==0 ){
           deleted = head;
           head = head.getNext();
        } else if(index == size -1){
            Element temp = head;
            int counter = 0;
            while (counter != index) {
                temp = temp.getNext();
                counter++;
            }
            deleted = tail;
            tail = temp;
            tail.setNext(null);
        } else {
            Element temp = head;
            int counter = 0;
            while (counter != index) {
                temp = temp.getNext();
                counter++;
            }
            deleted = temp.getNext();
            temp.setNext(temp.getNext().getNext());
        }
        size--;
        return deleted.getVale();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Element tmp = head;
        while (tmp != null) {
            result.append(tmp.getVale()).append(", ");
            tmp = tmp.getNext();
        }
        result.append("]");
        return result.toString();
    }
}
