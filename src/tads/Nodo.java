package tads;

public class Nodo <T>{
    private T dato;
    private Nodo<T> siguiente;

    // ---------------------------------------------------------------------- Getters and setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    // ---------------------------------------------------------------------- Constructors
    public Nodo(T value){
        this.dato = value;
        this.siguiente = null;
    }

    public Nodo(T value, Nodo<T> next){
        this.dato = value;
        this.siguiente = next;
    }

    // ---------------------------------------------------------------------- Override Methods
    @Override
    public String toString() {
        return dato.toString();
    }
}
