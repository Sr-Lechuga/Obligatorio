package tads.pila;

import tads.Nodo;

public class Pila<T> implements IPila<T>{
    private Nodo<T> top;
    private int largo;

    // ---------------------------------------------------------------------- Getters and Setters
    public Nodo<T> getTop() {
        return top;
    }

    public void setTop(Nodo<T> top) {
        this.top = top;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public Pila(Nodo<T> top) {
        this.top = top;
        this.largo = 1;
    }

    // ---------------------------------------------------------------------- Constructors
    public Pila(){
        this.largo = 0;
    }

    public Nodo<T> nodoTop(){
        return this.top;
    }

    // ---------------------------------------------------------------------- Overrided methods

    /**
     * Devuelve el dato que está en la cima de la pila.
     * @return Dato de tipo T. En caso de que la pila este vacia devuelve null.
     */
    @Override
    public T top() {
        if(esVacia()){
            return null;
        }
        return this.top.getDato();
    }

    /**
     * Elimina el dato que está en la cima de la pila.
     * @return Dato de tipo T que está en la cima. En caso de que la pila este vacia, devuelve null.
     */
    @Override
    public T pop() {
        if(esVacia()){
            return null;
        }

        Nodo<T> aux = this.top;
        this.top = top.getSiguiente();
        return aux.getDato();
    }

    /**
     * @param elem Dato de cualquier tipo.
     * Agrega un nuevo nodo en el tope de la pila creando un nuevo nodo en el proceso con el valor que se envia en el parametro elem.
     */
    @Override
    public void push(T elem) {
        Nodo<T> nuevo_nodo = new Nodo<T>(elem);

        nuevo_nodo.setSiguiente(this.top);
        this.top = nuevo_nodo;
        this.largo++;
    }

    /** Devuelve la cantidad de elementos que están presentes en la pila.
     * @return Devuelve un valor entero con la cantidad de elementos que están en la pila. Por defecto, una pila tiene 0 elementos.
     */
    @Override
    public int largo() {
        return this.largo;
    }

    /** Devuelve <c>true</c> si la pila no contiene elementos.
     * @return Un dato booleano, true si esta vacia, false si al menos hay un elemento.
     */
    @Override
    public boolean esVacia() {
        return largo == 0 && this.top == null;
    }

    /**
     * Elimina todos los elementos de la pila.
     */
    @Override
    public void vaciar() {
        if(this.esVacia()){
            return;
        }

        while (!this.esVacia()){
            this.pop();
        }
    }

    /**
     * Muestra por consola los valores de la pila.
     */
    @Override
    public void imprimirPila() {
        Nodo<T> aux = this.top;

        System.out.println("- Inicio Pila -");
        while (aux != null && aux.getSiguiente() != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
        if(aux != null){
            System.out.println(aux.getDato());
        }
        System.out.println("- Fin Pila -");
    }

    /**
     * Devulve un String con los valores de la pila
     * @return String con el contenido de la pila.
     */
    @Override
    public String valoresPila() {
        String contenido = "";
        Nodo<T> aux = this.top;

        contenido.concat("- Inicio Pila -\n");
        while (aux != null) {
            contenido.concat(aux.getDato().toString());
            aux = aux.getSiguiente();
        }
        contenido.concat("- Fin Pila -\n");

        return contenido;
    }

}
