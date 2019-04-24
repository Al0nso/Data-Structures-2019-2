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

	//Atributos de la lista
    private Nodo cabeza;
    private Nodo ultimo;
    private int longitud;

    /**
     *constructor that initializes the queue
     *@param n 
     *we put -1 to indicate that the queue is empty
     */  
    public Cola(int n){
        cabeza = null;
        ultimo = null;
        longitud = -1;
	   }
    

    private class Lista{
    //Atributos de la lista
     public T elemento;
     public Nodo cabeza;
     public Nodo ultimo;
     public int longitud;
    
      public Lista(T elemento){
        this.elemento = elemento; 
      }
    }

    // Listas'class to representate nodes
	private class Nodo
	{
	/**Attributes of the node */
		public T elemento;
		public Nodo siguiente;
		public Nodo anterior;

		public Nodo (T elemento)
		{
			this.elemento = elemento;
		}

		/**Empty constructor */
		public Nodo ()
        {
        }		
	}

	//Constructor con listas
    public Cola(Lista<T> l){
     	int i; 
    	Nodo n1 = new Nodo(l);//Nodo n1 = new Nodo(l);
    	this.cabeza = n1;
    	n1.anterior = null;
    	for(i= 1; i < l.length; i++)
    		mete( l.get( i )  );
    	this.longitud=i;
    }
    

    //Constructor con arreglos
    public Cola(T[] arreglo){
	int i;
	Nodo n1 = new Nodo (arreglo[0]);
	this.cabeza = n1;
	n1.anterior = null;
	for ( i = 1; i < arreglo.length; i++)
        mete(arreglo[i]);
        this.longitud = i;

    }


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
			Cola<T> lob = new Cola<T>(o);
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

    /**
    *Método para implementar un iterador que ya usamos antes
    */
    @Override public Iterator<T> iterator(){
	//Iterator<T> I1 = new Iterador();
		return new iterator<Integer>();
    }

    /**
     *Main method
     */
    public static void main (String[] args){     
        String[] prueba = new String[10];
        Integer cont;
    for (cont = 1; cont < 14; cont++){
    System.out.println(cont);
    }
    Cola<Integer> A2 = new Cola<Integer>(19);  
    A2.mete(cont);   
    }
}
