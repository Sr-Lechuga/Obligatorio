package tads;

public class Nodo <T>{
    private T value;
    private Nodo<T> next;

    // ---------------------------------------------------------------------- Getters and setters
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    // ---------------------------------------------------------------------- Constructors
    public Nodo(T value){
        this.value = value;
        this.next = null;
    }

    public Nodo(T value, Nodo<T> next){
        this.value = value;
        this.next = next;
    }

    // ---------------------------------------------------------------------- Override Methods
    @Override
    public String toString() {
        return value.toString();
    }
}
