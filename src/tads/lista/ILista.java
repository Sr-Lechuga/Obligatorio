package tads.lista;

public interface ILista<T>{
    // Insertar al incio de la lista
    public void insertAtBegining(T elemento);

    public void insertAtEnd(T elemento);

    // Devuelve true si existe el elemnto
    public boolean exists(T elemento);

    public T retrieve(T dato);

    public T retrieve(int indice);

    public int getLength();

    public void delete(T elemento);

    public void delete(int indice);

    public void printList();

    public void printListRec();

    // Override
    public String toString();
}
