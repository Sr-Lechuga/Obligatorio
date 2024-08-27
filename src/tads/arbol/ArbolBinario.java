package tads.arbol;

import tads.NodoAB;

public class ArbolBinario<T> implements IArbolBinario<T>{
    private final NodoAB<T> raiz;

    public ArbolBinario(NodoAB<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * @return
     */
    @Override
    public int cantidadNodos() {
        return this.cantidadNodosRec(this.raiz);
    }

    private int cantidadNodosRec(NodoAB<T> nodo){
        if (nodo != null)
            return 1 + cantidadNodosRec(nodo.getIzq()) + cantidadNodosRec(nodo.getDer());
        else
            return 0;
    }

    /**
     * @return
     */
    @Override
    public int cantidadHojas() {
        return cantidadHojasRec(this.raiz);
    }

    private int cantidadHojasRec(NodoAB<T> nodo){
        if (nodo != null){
            if(nodo.getIzq() == null && nodo.getDer() == null){
                return 1;
            }
            else {
                return cantidadNodosRec(nodo.getIzq()) + cantidadNodosRec(nodo.getDer());
            }
        }
        return 0;
    }

    /**
     * @return
     */
    @Override
    public int altura() {
        return alturaRec(this.raiz);
    }

    private int alturaRec(NodoAB<T> nodo){
        if (nodo != null){
            return 1 + Math.max(alturaRec(nodo.getIzq()), alturaRec(nodo.getDer()));
        }else
            return -1;
    }

    /**
     * @return
     */
    @Override
    public boolean estaBalanceado() {
        return estaBalanceadoRec(this.raiz);
    }

    private boolean estaBalanceadoRec(NodoAB<T> nodo){
        if (nodo != null){
            boolean nodoEstaBalanceado = this.alturaRec(nodo.getIzq()) - this.alturaRec(nodo.getDer()) <= 1;
            return estaBalanceadoRec(nodo.getIzq()) && estaBalanceadoRec(nodo.getDer())  && nodoEstaBalanceado;
        }
        return true;
    }

    /**
     * @param otroArbol
     * @return
     */
    @Override
    public boolean sonIguales(ArbolBinario otroArbol) {
        return false;
    }

    /**
     * @param dato
     * @return
     */
    @Override
    public boolean pertenece(Object dato) {
        return false;
    }
}
