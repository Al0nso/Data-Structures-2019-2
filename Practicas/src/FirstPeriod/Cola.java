package Practica3;

import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Implementación de colas.
 */
public class Cola<T> implements Iterable<T>{

    private Nodo cabeza;
     private Nodo ultimo;
     private int longitud;

    /**
     *constructor that initializes the queue
     *@param n 
     *we put -1 to indicate that the queue is empty
     */  
    public Cola(){
        cabeza = null;
        ultimo = null;
        longitud = 0;
	   }
    
    public Cola(Lista<T> l){
         Iterador ite = (Iterador)l.iterator();
         Iterador rad = (Iterador)iterator();
         while(ite.hasNext()){

         }
    }
    
    public Cola(T[] arreglo){
	//Aquí va su código.
    }


    /**
    *Este método nos dice si la cola esta vacía
    *@return True o False
    **/
    public boolean esVacia(){
        return head == null;
    }

    /**
    *Este método nos muestra el siguiente elemento a salir
    *@return T siguiente elemento
    */
    public T mira(){
        if(esVacia()){
        }
        return cabeza.elemento;
    }

    /**
    *Este método saca el siguiente elemento en cola
    *@return T
    */
    public T saca(){
	T pop = cabeza.elemento;
    cabeza.siguiente = cabeza;
    return pop;
    }

    /**
    *Este método agrega elementos a la cola
    *@param T 
    */
    public void mete(T t){
	if(t == null){
       throw new IllegalArgumentException(); // Elemento nulo
    }
    }

    /**
    *@return String 
    *
    */
    @Override
    public String toString(){
	String strr = " ";
    Nodo left;
    for(left= cabeza; left!=null; left= left.getSiguiente){
        strr= strr + left.getElemento();
    if(left.getSiguiente()!=null){
                    str = str + ", ";
    }
    }
            str = str + "]";
            return str;
}

    @Override
    public boolean equals(Object o){
         if (o == null || getClass() != o.getClass()){
          return false;
        }
        @SuppressWarnings("unchecked") Cola<T> cola = (Cola<T>)objeto;
       if(getLongitud() != cola.getLongitud())
            return false;
        Nodo his = cabeza;
        Nodo mos = cola.cabeza;
        while(his != null && mos != null){
          if(!(his.elemento.equals(mos.elemento)))
            return false;
          his = his.siguiente;
          mos = mos.siguiente;
            }
          return true;
    }

    @Override
    public Iterator<T> iterator(){
        return wen Iterador();
    }
}
