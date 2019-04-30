package FirstPeriod;
/**
* Practice NB02 about linked list and Iterators
* @author: Claudia Osorio
* @author Medina Amayo D. Alonso
* @version 1
* @date 08/04/2019
*/

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
* Linked list implementation
*/
public class Lista < T > implements Iterable < T >{

	//Attributes of the list 
	 private Nodo cabeza;
	 private Nodo ultimo;
	 private int longitud;

	 /**
      *Constructor of an empty list
      * We do literally nothing
      */
	  public Lista ()
	  {
	 }

		/**
         * Constructor of a list with nodes for each element of the array T
         * The order we will follow will be the one of the array
         */
    public Lista (T[] arreglo){
         try{
         int i;
         Nodo n1 = new Nodo (arreglo[0]);
         this.ultimo = n1; 
         n1.anterior = null;
         for ( i = 1; i < arreglo.length; i++) //i starts from 1 because we already used the first element of T on the head
         agregaFinal (arreglo[i]); 
         this.longitud = i;
     	 } catch(Exception e){
            System.out.println(":,C " + e);}
        }

	// Listas' class to representate nodes
	private class Nodo
	{

		/**Attributes of the node */
		public T elemento;
		public Nodo siguiente;
		public Nodo anterior;

		public Nodo (T elemento)
		{
			elemento = this.elemento;
		}

		/**Empty constructor */
		public Nodo ()
                {
                }		
	}

	 // Interator class of our list
	private class Iterador implements Iterator < T >
	{

		public Nodo actual = cabeza;

		 /**
	          *Constructor of a new Iterator
	          */
		public Iterador ()
		{
		}

		 /**
		 *Method to know if the list have next node
	 	 *@return true/false
		 */
		@Override public boolean hasNext ()
		{
			return actual != null ? true : false;
		}

		 /**
		 *Method to return next node of our list
		 *If the list don't have next node we will return null
		 *@return temp
		 */
		@Override public T next ()
		{

			Nodo temp = this.actual;
			if (hasNext ())
			{
				this.actual = this.actual.siguiente;
				return temp.elemento;
			}
			return null; 
		}
 	
	}
         /**
         *Method to get the first element of the list
         *if we have an empty list we will return null
         *@return elemnt
         */
    	public T getPrimero ()	{
	      try
	        {
	            return this.cabeza.elemento;
	        }
	        catch(NoSuchElementException e)
	        {
	            System.out.println("Void list");
	            throw e; // rethrowing the exception
	        }
	}

	 /**
         *Method to get the last element of the list
         *if we have an empty list we will return null
         *@return elemento
         */
	public T getUltimo () {
	    T elemento = ultimo.elemento;
	   try{
		    if (ultimo.elemento != null){
			return ultimo.elemento;
		    }else {
			return null;
		    }
	        } catch(NoSuchElementException e){
	            System.out.println("Void list");
	            throw e; // rethrowing the exception
	        }
	}

    /**
         *Method to delete the last element of the list
         *@return elemnt
         */
    public T eliminaUltimo (){
	T elemento = ultimo.elemento;
		try{
		if (ultimo.elemento != null)
		{
			elemento = ultimo.elemento;
			this.ultimo = null;
			this.ultimo.anterior = this.ultimo; 
			if (this.longitud == 1)
				this.ultimo = null; 
			else
				this.longitud--;
			return elemento;
		}else{
			return null;   
		}

	} catch(NoSuchElementException e)
	        {
	            System.out.println("Void list");
	            throw e; // rethrowing the exception
	        }
	  }

	/**
        *Method to delete the first element of the list and return it one last time
        *@return elemnt
        */
	public T eliminaPrimero (){
		T elemnt;
			if (cabeza != null){
			elemnt = cabeza.elemento;
			  cabeza.siguiente = this.cabeza;
			if (this.longitud == 1){
				cabeza = null;
				return null;
			}else{
				this.longitud--;
				return elemnt;
				}
		} else{
			    elemnt = null;
			return elemnt;
		
	}
	}

	 /**
       	 *Method to add at the head of the list
         */
	public void agregaInicio (T t)
	{

		if(t == null){
        throw new NoSuchElementException (); 
		}else{
		Nodo n1 = new Nodo (t);
		if(esVacia()){
        cabeza = n1;
        }else{
		n1.siguiente = this.cabeza;
		this.cabeza.anterior = n1;
		this.cabeza = n1;
		n1.anterior = null;
		this.longitud++;
		}
	}
	}

	 /**
         *Method to add at the end of the list
         */
	public void agregaFinal (T t)
	{
		 if(t == null){
        throw new NoSuchElementException (); 
		 }else{
      Nodo n1 = new Nodo (t);
        if(esVacia()){
        cabeza  = n1;
        }else{
           n1.siguiente = null;
		this.ultimo.siguiente = n1;
		n1.anterior = this.ultimo;
		this.ultimo = n1;
		this.longitud++;
            }
		 }
	}

	 /**
         *Method to search if our list contains an specific element
	 *@return true/false
         */
	public boolean contiene (T t)
	{
		boolean ctn = false;	//Stands for contains
		int cont;
		Nodo n1 = new Nodo(t);
		n1 = this.cabeza;
		for (cont = 0; cont < this.longitud; cont++)
		{
			if(n1.elemento == t)
				ctn = true;	//Here he compaire element by element
			if (ctn)
			  return ctn;
			n1 = n1.siguiente;
		}
		return ctn;
	  }


/***Método para saber si es esVacia
 **@return boolean: true si es vacía y false en caso contrario
 **/
   public boolean esVacia(){
     return cabeza == null;
   }


	 /**
         *Method to return the long of the list
         */
	public int getLongitud ()
	{
		return this.longitud;
	}

 	 /**
         *Method to delete the first appearance of t in our list
 	 *@return true if we could delete
	 *@return false if we couldn't compare, delete or isn't in our list
         */
	public boolean elimina (T t)
	{
		Nodo n1 = this.cabeza;
		if (contiene (t))
		{
			if (this.cabeza.elemento.equals (t))
			{
				eliminaPrimero ();
				return true;
			}
			else
				while (n1.elemento.equals (t) == false)
					n1 = n1.siguiente;
			if (n1.elemento.equals (t))
				if (n1 != this.ultimo)
				{
					n1.siguiente.anterior = n1.anterior;
					n1.anterior.siguiente = n1.siguiente;
					return true;
				}
				else
				{
					eliminaUltimo ();
					return true;
				}
		}
			return false;
	  }

	 /**
         *Regret so many things so we act like the list never had nothing
         */
	public void limpia ()
	{
		this.cabeza = this.ultimo = null;
		this.longitud=0;
	}

	 /**
         *Method to return the element of the list at the position indx
	 *We count from 0
	 *If the index is bigger than our index we return null
	 *@return n1.elemento
         */
	public T get (int indx)
	{
		if (indx <= this.longitud)
		{
			int cont;
			Nodo n1 = this.cabeza;
			for (cont = 0; cont <= indx; cont++)
				n1 = n1.siguiente;
			return n1.elemento;
		}
		else
			return null;
	}

	 /**
	 * We will insert a node and we will approche from the shortest way
	 */
	public void inserta (int indx, T t)
	{
		int cont;
		Nodo n1 = new Nodo (t);
		Nodo n2;
		if ((this.longitud + 1) / 2 >= indx)
		{
			n2 = cabeza;
			for (cont = 0; cont < indx; cont++)
			n2 = n2.siguiente;
		}else{
			n2 = ultimo;
			for (cont = this.longitud; cont > indx; cont--)
			n2 = n2.anterior;
		}
		n1.siguiente = n2.siguiente;
		n2.siguiente = n1;
		n1.siguiente.anterior = n1;
		n1.anterior = n2;
	}

	 /**
	 *Function to cast our list into an array
	 *@return Object listArray
	 */
	public Object[] toArray ()
	{
		Object[]listArray = new Object[this.longitud];
		int cont;			//Counter
		Nodo n1 = this.cabeza;
		for (cont = 0; cont < this.longitud; cont++)
		{
			listArray[cont] = n1.elemento;
			n1 = n1.siguiente;
		}
		return listArray;
	}

	 /**
         *Function create a new list with head on the tail and the tail on the head, revert the list
         *@return Lista l1
         */
	public Lista < T > reversa ()
	{

		Lista <T> l1 = new Lista <T> ();
		Nodo n1 = this.ultimo;
		int cont;//Counter
		Nodo n2 = l1.cabeza;
		n2 = n1;
		for (cont = 0; cont < this.longitud; cont++)
		n2.siguiente = n1.anterior;
		return l1;
	}

	 /**
         *Function create a new list as a copy of our list
         *@return Lista l1
         */
	public Lista < T > copia ()
	{
		int cont;//Counter
		Lista <T> l1 = new Lista <T> ();
		Nodo n1 = this.cabeza;
		Nodo n2 = l1.cabeza;
		n2 = n1;
		for (cont = 0; cont < this.longitud; cont++)
		      n2.siguiente = n1.siguiente;
		return l1;
	}

	@Override
	 /**
         *Function cast the list into an string separate with ','
	 * if the list is empty we return []
         * @return String lst
         */
	public String toString ()
	{
		String lst = "";
		Nodo n1 = this.cabeza;
		int cont;
		if (!(this.cabeza == this.ultimo && this.ultimo == null))
		{				//Two '&&' cause if the head doesn't point to the tail we have nothing to do
			for (cont = 0; cont < (this.longitud - 1); cont++)
			{
				lst += n1.elemento.toString () + ",";
				n1 = n1.siguiente;
			}
			lst += n1.siguiente;
		}
		
			return "[]";
	}

	/**
	*Method to check if two objects are the same, this case will be if two list are the same node by node
	*@return eqls
	*/
	@Override public boolean equals (Object objeto)
	{
	if (objeto == null || getClass() != objeto.getClass()){
          return false;
        }
        @SuppressWarnings("unchecked") Lista<T> lista = (Lista<T>)objeto;
       if(getLongitud() != lista.getLongitud())
            return false;
        Nodo esta = cabeza;
        Nodo aquella = lista.cabeza;
        while(esta != null && aquella != null){
          if(!(esta.elemento.equals(aquella.elemento)))
            return false;
          esta = esta.siguiente;
          aquella = aquella.siguiente;
            }
          return true;
	
	  }
	

	 /**
	 *Method to return a Iterator that we already implement before
	 */
	@Override public Iterator<T> iterator()
	{
		Iterator<T> I1 = new Iterador();
		return I1;
	}

		/**
        * Fuction to get the index of an element
	*/	
	public int getindiceElemento (T t)
	{
		Nodo n1 = new Nodo();
            n1 = this.cabeza;
            int cont;
            if( contiene( t ) )
                for(cont = 1; cont <= getLongitud(); cont ++)
                {
                if(n1.elemento == t)
                return cont;
                n1 = n1.siguiente;
                }
		return -1;	
	}

    /**
	 *Main method
	 */
	 public static void main (String[] args){
	 Lista<Integer> A1 = new Lista<>();
	  Lista<Integer> A2 = new Lista<>(); 
	  String[] prueba = new String[11];
	  String[] prueba2 = new String[15];
	 Integer cont;
	 Integer cont2;
	  for (cont = 1; cont < prueba.length; cont++){
	      //System.out.println(cont);
	  }
	  for (cont2 = 2; cont2 < prueba2.length; cont2++){
	      // System.out.println(cont2);
	  }
	  A1.agregaFinal(cont);
	  A1.agregaInicio(cont2);
	  A1.getPrimero();
	  A1.getUltimo(); // ERRROOOOORR
	  //A1.eliminaUltimo(); //ERROOOOORR
	  // A1.eliminaPrimero();
	  //	  //  A1.contiene(cont2); //
	  // A1.elimina(11);
	 }
}
