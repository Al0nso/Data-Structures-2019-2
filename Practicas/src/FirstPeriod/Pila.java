import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Implementación de pilas.
 * Practice N°3 about Queues, list in sudokus
 * @author Medina Amayo D. Alonso
 * @author Osorio López Claudia Y.
 * @version 1
 * @date  16/03/2019
 */
public class Pila<T> implements Iterable<T>{

     private int[] acomodo;
     private int primero;
     private int ultimo;
    /**
     *constructor that initializes the queue
     *@param n 
     *we put -1 to indicate that the queue is empty
     */
    public Pila(int n){
       for(int i=0; i<n; i++)
       acomodo[i] = -1;
    }
    }
    
    public Pila(Lista<T> l){
	//Aquí va su código.
    }

    public Pila(T[] arreglo){
        this.primero=0;
        this.ultimo=0;
	//Aquí va su código.
    }

    public boolean esVacia(){
	//Aquí va su código.
    }

    public T mira(){
	//Aquí va su código.
    }

    public T saca(){
	//Aquí va su código.
    }

    public void mete(T t){
	//Aquí va su código.
    }

    @Override
    public String toString(){
	//Aquí va su código.
    }

    @Override
    public boolean equals(Object o){
	//Aquí va su código.
    }

    @Override
    public Iterator<T> iterator(){
	//Aquí va su código.
    }
}
