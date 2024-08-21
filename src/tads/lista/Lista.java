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

        this.inicio = nodo;

        if(esVacia()){
            this.fin = nodo;
        }

        this.cantidad++;
    }

    @Override
    public void insertarAlFinal(T elemento) {
        Nodo<T> nodo = new Nodo<>(elemento);

        fin.setSiguiente(nodo);
        this.fin = nodo;

        if(esVacia()){
            this.inicio = nodo;
        }

        this.cantidad++;
    }

    @Override
    public boolean existe(T elemento) {
        if(esVacia()){
            return false;
        }

        boolean encontrado = false;
        Nodo<T> pos = this.inicio;

        while (pos != null && !encontrado) {
            if(pos.getDato().equals(elemento)) {
                encontrado = true;
            }
            pos = pos.getSiguiente();
        }

        return encontrado;
    }

    @Override
    public T devolver(T elemento) {
        if(esVacia()){
            return null;
        }

        Nodo<T> pos = this.inicio;

        while (pos != null) {
            if(pos.getDato().equals(elemento)) {
                return pos.getDato();
            }
            pos = pos.getSiguiente();
        }

        return null;
    }

    @Override
    public T devolver(int indice) {
        if(esVacia()){
            return null;
        }

        int indice_pos = 1;
        Nodo<T> pos = this.inicio;

        while (pos != null) {
            if(indice_pos == indice) {
                return pos.getDato();
            }
            pos = pos.getSiguiente();
            indice_pos++;
        }

        // No habian suficientes elementos en la lista para llegar al indice
        return null;
    }

    @Override
    public int largo() {
        //return this.cantidad;
        if(esVacia()){
            return 0;
        }

        int indice = 0;
        Nodo<T> pos = this.inicio;

        while (pos != null) {
            pos = pos.getSiguiente();
            indice++;
        }

        // No habian suficientes elementos en la lista para llegar al indice
        return indice;
    }

    @Override
    public void borrar(T elemento) {
        if(esVacia()){
            return;
        }

        if(this.inicio.getDato() == elemento) {
            this.inicio = null;
            this.fin = null;
        }

        Nodo<T> pos = this.inicio;

        while (pos != null && pos.getSiguiente() != null && !pos.getSiguiente().getDato().equals(elemento)) {
            pos = pos.getSiguiente();
        }


        if(pos != null && pos.getSiguiente() != null && pos.getSiguiente().getDato().equals(elemento)) {
            Nodo<T> a_borrar = pos.getSiguiente();

            pos.setSiguiente(a_borrar.getSiguiente());

            if(this.fin == a_borrar){
                this.fin = pos;
            }

            a_borrar.setSiguiente(null);
            this.cantidad--;
        }
    }

    @Override
    public void borrar(int indice) {
        //TODO: Implement function
    }

    @Override
    public void mostrar() {
        Nodo<T> pos = this.inicio;

        while (pos != null && this.fin != pos) {
            System.out.println(pos.getDato() + ",");
            pos = pos.getSiguiente();
        }

        if(this.fin != null) {
            System.out.println(this.fin.getDato() + ".");
        }

    }

    @Override
    public void mostrarRec() {
        //TODO: Implement function
    }

    public boolean esVacia(){
        return inicio == null && fin == null;
    }
}
