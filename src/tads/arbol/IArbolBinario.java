package tads.arbol;

import tads.NodoAB;

public interface IArbolBinario<T> {

    int cantidadNodos();

    int cantidadHojas();

    int altura();

    boolean equilibrado();

    boolean Iguales(ArbolBinario<T> otroArbol);

    boolean pertenece(T dato);

    boolean todosPares(NodoAB<T> raiz);

}
