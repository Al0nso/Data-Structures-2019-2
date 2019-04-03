import java.util.EmptyStackException;
import java.util.Iterator;
package FirstPeriod;
/**
 * Implementación de pilas.
 * Practice N°3 about Queues, list in sudokus
 * @author Medina Amayo D. Alonso
 * @author Osorio López Claudia Y.
 * @version 1
 * @date  03/04/2019
 */
public class Pila<T> implements Iterable<T>{

    //Atributos de la pila
    private Nodo cabeza;
    private Nodo ultimo;
    private int longitud;

    private class Nodo{

        /**Attributes of the node */
        public T elemento;
        public Nodo siguiente;
        public Nodo anterior;

        public Nodo (T elemento){
            this.elemento = elemento;}

        /**Empty constructor */
        public Nodo (){}       
    }

   //Constructor que inicializa la pila
    public Pila(){
    }
    
    
  //  public Pila(Lista<T> l){
	//Aquí va su código.
    //}


    public Pila(T[] arreglo){
        int i;
        Nodo n1 = new Nodo (arreglo[0]);
        this.ultimo = n1;
        n1.anterior = null;
        for ( i = 1; i < arreglo.length; i++)
        mete (arreglo[i]); 
        this.longitud = i;
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
