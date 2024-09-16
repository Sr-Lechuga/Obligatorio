package tads.arbol;

import tads.NodoAB;

public class ArbolBinario<T> implements IArbolBinario<T>{
    private NodoAB<T> raiz;

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
     * @param nodo
     * @return
     */
    @Override
    public boolean todosPares(NodoAB nodo) {
        return todosParesRec(nodo);
    }

    private boolean todosParesRec(NodoAB raiz){
        if(raiz == null){
            return true;
        }else{
            if((int)raiz.getDato() % 2 != 0){
                return false;
            }else{
                return(todosParesRec(raiz.getDer()) && todosParesRec(raiz.getIzq()));
            }
        }

    }


    /**
     * @param otroArbol
     * @return
     */
    @Override
    public boolean Iguales(ArbolBinario<T> otroArbol) {
        if (otroArbol == null)
            return false;
        else
            return igualesRec(this.raiz,otroArbol.raiz);
    }

    private boolean igualesRec(NodoAB<T> nodo, NodoAB<T> otroNodo){
        if(nodo != null && otroNodo != null){
            return nodo.getDato() == otroNodo.getDato()
                    && igualesRec(nodo.getIzq(),otroNodo.getIzq())
                    && igualesRec(nodo.getDer(),otroNodo.getDer());
        }else{
            return nodo == null && otroNodo == null;
        }
    }

    /**
     * @return
     */
    @Override
    public boolean equilibrado() {
        return equilibradoRec(this.raiz);
    }

    private boolean equilibradoRec(NodoAB<T> nodo){
        if (nodo != null){
            boolean nodoEstaBalanceado = this.alturaRec(nodo.getIzq()) - this.alturaRec(nodo.getDer()) <= 1;
            return equilibradoRec(nodo.getIzq()) && equilibradoRec(nodo.getDer())  && nodoEstaBalanceado;
        }
        return true;
    }

    /**
     * @param dato
     * @return
     */
    @Override
    public boolean pertenece(T dato) {
        return perteneceRec(this.raiz, dato);
    }

    private boolean perteneceRec(NodoAB<T> nodo, T dato){
        if(nodo != null){
            return nodo.getDato().equals(dato) || perteneceRec(nodo.getIzq(), dato) || perteneceRec(nodo.getDer(), dato);
        }
        return false;
    }

    public ArbolBinario<T> clon(){
        ArbolBinario<T> nuevoArbol = new ArbolBinario<>(new NodoAB<>(this.raiz.getDato()));
        clonRec(this.raiz,nuevoArbol.raiz);
        return nuevoArbol;
    }

    private void clonRec(NodoAB<T> nodo, NodoAB<T> copia){
        if(nodo != null){
            if(nodo.getIzq() != null){
                copia.setIzq(new NodoAB<>(nodo.getIzq().getDato()));
                clonRec(nodo.getIzq(),copia);
            } else if (nodo.getDer() != null) {
                copia.setDer(new NodoAB<>(nodo.getDer().getDato()));
                clonRec(nodo.getDer(),copia);
            }
            //Else, nodo es una hoja, nada que hacer
        }
    }
}
