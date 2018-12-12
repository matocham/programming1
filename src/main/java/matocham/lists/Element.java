package matocham.lists;

public class Element {
    private String vale;
    private Element next;

    public Element(String vale) {
        this.vale = vale;
    }

    public String getVale() {
        return vale;
    }

    public void setVale(String vale) {
        this.vale = vale;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}
