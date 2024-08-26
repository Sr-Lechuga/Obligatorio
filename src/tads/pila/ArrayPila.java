package tads.pila;

import tads.Nodo;

public class ArrayPila<T> implements IPila<T>{
    private T[] array;
    private int largo;
    private int tope;

    // ---------------------------------------------------------------------- Getters and Setters
    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    // ---------------------------------------------------------------------- Constructors


    public ArrayPila() {
        this.array = (T[]) new Object[Integer.MAX_VALUE-1];
        this.tope = 0;
        this.largo = 0;
    }

    public ArrayPila(int tope) {
        this.tope = tope;
        this.array = (T[]) new Object[tope];
        this.largo = 0;
    }

    /**
     * Devuelve el dato que está en la cima de la pila.
     * @return Dato de tipo T. En caso de que la pila este vacia devuelve null.
     */
    @Override
    public T top() {
        if(esVacia()){
            return null;
        }

        return this.array[this.largo-1];
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

        T top = this.array[this.largo - 1];
        this.array[this.largo - 1] = null;
        this.largo--;

        return top;
    }

    /**
     * @param elem Dato de cualquier tipo.
     * Agrega un nuevo nodo en el tope de la pila creando un nuevo nodo en el proceso con el valor que se envia en el parametro elem.
     */
    @Override
    public void push(T elem) {
        this.array[largo] = elem;
        largo++;
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
        return largo == 0 && this.array[0] == null;
    }

    /**
     * Elimina todos los elementos de la pila.
     */
    @Override
    public void vaciar() {
        for (int i = largo - 1; i >= 0; i--) {
            this.array[i] = null;
        }
        this.largo = 0;
    }

    /**
     * Muestra por consola los valores de la pila.
     */
    @Override
    public void imprimirPila() {
        System.out.println("- Inicio Pila -");
        for (int i = 0; i < this.largo -1; i++) {
            System.out.println(this.array[i]);
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
        contenido = "- Inicio Pila -";
        for (int i = 0; i < this.largo -1; i++) {
            contenido.concat(this.array[i].toString());
        }
        contenido.concat("- Fin Pila -");
        return contenido;
    }
}
