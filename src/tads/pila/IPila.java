package tads.pila;

public interface IPila<T>{

    T top();

    T pop();

    void push(T elem);

    int largo();

    boolean esVacia();

    void vaciar();

    void imprimirPila();

    String valoresPila();
}
