package tads.lista;

import tads.Nodo;

public class Lista<T> implements ILista<T>  {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantidad;

    // ---------------------------------------------------------------------- Getters and setters
    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    public Nodo<T> getFin() {
        return fin;
    }

    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // ---------------------------------------------------------------------- Constructors
    public Lista(Nodo<T> inicio, Nodo<T> fin, int cantidad) {
        this.inicio = inicio;
        this.fin = fin;
        this.cantidad = cantidad;
    }

    public Lista(Nodo<T> inicio) {
        this.inicio = inicio;
        this.fin = inicio;
        this.cantidad = 1;
    }

    // ---------------------------------------------------------------------- Methods
    @Override
    public void insertarAlInicio(T elemento) {
        Nodo<T> nodo = new Nodo<>(elemento, inicio);
        this.cantidad++;
    }

    @Override
    public void insertarAlFinal(T elemento) {
        Nodo<T> nodo = new Nodo<>(elemento);
        fin.setNext(nodo);
        this.fin = nodo;
        this.cantidad++;
    }

    @Override
    public boolean existe(T elemento) {
        return false;
    }

    @Override
    public T devolver(T elemento) {
        return null;
    }

    @Override
    public T devolver(int indice) {
        return null;
    }

    @Override
    public int largo() {
        return 0;
    }

    @Override
    public void borrar(T elemento) {

    }

    @Override
    public void borrar(int indice) {

    }

    @Override
    public void mostrar() {

    }

    @Override
    public void mostrarRec() {

    }
}
