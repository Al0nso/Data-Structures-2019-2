package FirstPeriod;
/**
*Practica N.3 sobre Pilas y Colas
*@author Claudia Osorio
*@author Alonso Amayo
*@version 2
*@date 03.04.19
*/
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Implementación de colas.
 */
public class Cola<T> implements Iterable<T>{

    // 'class to representate nodes
     private class Nodo{
     /**Attributes of the node */
     public T elemento;
     public Nodo siguiente;
     public Nodo anterior;

      public Nodo (T elemento){
       this.elemento = elemento;
      }

      public T getElemento() {
       return elemento;
      }

      public void setElemento(T ele) {
       this.elemento = ele;
      }

      public Nodo getSiguiente() {
       return siguiente;
      }

        public void setSiguiente(Nodo sig) {
            this.siguiente = sig;
        }

        public Nodo getAnterior(){
          return anterior;
        }

        public void setAnterior(Nodo ant){
          this.anterior = ant;
        }   
    }

	//Atributos de la lista
    private Nodo cabeza;
    private Nodo ultimo;
    private int longitud;

    /**
     *constructor that initializes the queue
     *we put -1 to indicate that the queue is empty
     */  
     public Cola(){
      cabeza = null;
      ultimo = null;
      longitud = -1;
	 }
    

    private class Seris{
     //Atributos de la lista
     public T elemento;
     public Nodo cabeza;
     public Nodo ultimo;
     public int longitud;
    
	     public Seris(T elemento){	
    this.elemento = elemento; 
	   }
	}
    
	//Constructor con listas
     public Cola(Lista<T> l){
	 /**int i;
	  *Iterador it = l.iterator();
     while(it.hasNext()){
     T ele  = it.next();
     this.longitud = l.getLongitud();
     }*/
     Lista <Integer> n2 = new Lista<>();
     this.longitud = n2.getLongitud(); 
  
     }

    //Constructor con arreglos
    public Cola(T[] arreglo){
	int i;
	Nodo n1 = new Nodo (arreglo[0]);
	this.cabeza = n1;
	n1.anterior = null;
	for ( i = 1; i < arreglo.length; i++)
        mete(arreglo[i]);
        this.longitud = i;}

    /**
    *Este método nos dice si la cola esta vacía
    *@return True o False
    **/
    public boolean esVacia(){
        return cabeza == null; //Check
    }

    /**
    *Este método nos muestra el siguiente elemento a salir
    *@return T siguiente elemento
    */
    public T mira(){
    if(esVacia()){
    	System.out.println("No hay nada aquí");
        }
    return cabeza.elemento;
    }

    /**
    *Este método saca el siguiente elemento en cola
    *@return T
    */
    public T saca(){
	T n1 = cabeza.elemento;
    cabeza.siguiente = cabeza;
    return n1;
    }

    /**
    *Este método agrega elementos a la cola
    *@param T 
    */
    public void mete(T t){
        if(t == null){
        throw new IllegalArgumentException();
      }
	Nodo n1 = new Nodo (t);
	if(esVacia()){
		cabeza=ultimo=n1;
	}else{
	n1.siguiente = null;
	this.ultimo.siguiente = n1;
	this.ultimo=n1;
	this.longitud++;
}
	}


	/**
	*Este método convierte la cola en un String que separa con ', '
	*Sí es vacía entonces se devuelve []
	*/
	@Override
    public String toString(){
	String lst = "";
		Nodo n1 = this.cabeza;
		int cont;
		if (!(this.cabeza == this.ultimo && this.ultimo == null))
		{				//Two '&&' cause if the head doesn't point to the tail we have nothing to do
			for (cont = 0; cont < (this.longitud - 1); cont++)
			{
				lst += n1.elemento.toString () + ", ";
				n1 = n1.siguiente;
			}
			lst += n1.siguiente;
		}
		
			return "[]";
    }


    /**
    * Método para verificar si dos objetos son iguales, este caso será si dos colas son la misma
    *@return eqls
    */
    @Override
    public boolean equals(Object o){
	Nodo n1 = this.cabeza;
		boolean eqls = true;	//eqls stands for equals
		if (o.getClass() == this.getClass())
		{				//Here we compare the class of our list and ob
			Cola<T> lob = new Cola<T>();
			Nodo n2 = lob.cabeza;	//If ob is a list we create the List l1 and then the node n2 wich is the head of ob
			while (eqls)
			{			//Here we will compare every item of both list
				if (n1.elemento.equals (n2.elemento) == false)
					eqls = false;
				else
				{
					if (n1.siguiente != null && n2.siguiente != null)
					{
						n1 = n1.siguiente;
						n2 = n2.siguiente;
					}
					else
						return eqls;
				}
			}
		}
		return eqls;
    }

    //Clase para iterar nuestra cola
     private class Iterador implements Iterator<T>{
     public Nodo siguiente;
     public Nodo anterior;

     // Iterador que empieza
     public Iterador(){
     anterior = null;
     siguiente = cabeza;
     }

     @Override
     public boolean hasNext(){
     return siguiente != null;
     }

     @Override
     public T next(){
     if(!hasNext()){
     throw new NoSuchElementException();
     }
     this.anterior = this.siguiente; // this.siguiente = this.anterior.siguiente;
     return anterior.elemento;
     }

     public void end() {
     anterior = ultimo;
     siguiente = null;
     }

     public void start() {
     anterior = null;
     siguiente = cabeza;
     }
    }

    /**
     *Método para implementar un iterador que ya usamos antes
     */
     @Override public Iterator<T> iterator(){
	 return new Iterador();
     }

    /**
     *Main method
     */
     public static void main (String[] args){   
     Cola<Integer> A2 = new Cola<>();   
     /**String[] prueba = new String[10];
     *Integer cont;
     *for (cont = 1; cont < 14; cont++){
     *System.out.println(cont);}
     *Cola<Integer> A2 = new Cola<>();  
     *A2.mete(cont);   
    */}
}
