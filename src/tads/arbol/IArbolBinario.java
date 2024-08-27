package tads.arbol;

public interface IArbolBinario<T> {

    int cantidadNodos();

    int cantidadHojas();

    int altura();

    boolean estaBalanceado();

    boolean sonIguales(ArbolBinario otroArbol);

    boolean pertenece(T dato);
}
