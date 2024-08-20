package tads.lista;

public interface ILista<T>{

    // Insertar al inicio de la lista
    void insertarAlInicio(T elemento);


    void insertarAlFinal(T elemento);

    // Devuelve true si existe el elemento
    boolean existe(T elemento);

    T devolver(T dato);

    T devolver(int indice);

    int largo();

    void borrar(T elemento);

    void borrar(int indice);

    void mostrar();

    void mostrarRec();

    // Override
    String toString();
}
