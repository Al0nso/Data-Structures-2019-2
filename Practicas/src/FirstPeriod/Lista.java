package FirstPeriod;
 /**
 * Practice NB02 about linked list and Iterators
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 0.2
 * @date  20/02/2019
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


 /**
 * Linked list implementation
 */
public class Lista < T > implements Iterable < T >
{

	/**Attributes of the list */
	 private Nodo cabeza;
	 private Nodo ultimo;
	 private int longitud;

	 /**
         * Constructor of an empty list
         * We do literally nothing
         */
	public Lista ()
	{
	}

	 /**
         * Constructor of a list with nodes for each element of the array T
         * The order we will follow will be the one of the array
         */
	public Lista (T[] arreglo)
	{
		int i; //counter
		Nodo n1 = new Nodo (arreglo[0]);
		this.cabeza = n1;
		n1.anterior = null;
		for (i = 1; i < arreglo.length; i++)	//i starts from 1 because we already used the first element of T on the head
			agregaFinal (arreglo[i]);
		this.longitud = i;
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
			this.elemento = elemento;
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
		}
 	}

         /**
         *Method to get the first element of the list
         *if we have an empty list we will return null
         *@return elemento
         */
	public T getPrimero ()
	{
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
	public T getUltimo ()
	{
		try
	        {
	            return this.ultimo.elemento;
	        }
	        catch(NoSuchElementException e)
	        {
	            System.out.println("Void list");
	            throw e; // rethrowing the exception
	        }

	  }

	/**
        *Method to delete the first element of the list and return it one last time
        *@return elemnt
        */
	public T eliminaPrimero ()
	{
		T elemnt;
		if (this.cabeza != null)
		{
			elemnt = cabeza.elemento;
			this.cabeza = cabeza.siguiente;
			this.cabeza.anterior = null;
			if (this.longitud == 1)
				ultimo = null;
			else
				this.longitud--;
			return elemnt;
		}
		else
			return null;
	}

	 /**
         *Method to delete the last element of the list
         *@return elemnt
         */
	public T eliminaUltimo ()
	{
		T elemnt;
		if (this.cabeza != null)
		{
			elemnt = ultimo.elemento;
			this.ultimo = ultimo.anterior;
			this.ultimo.siguiente = null;
			if (this.longitud == 1)
				ultimo = null;
			else
				this.longitud--;
			return elemnt;
		}
		else
			return null;
	}

	 /**
       	 *Method to add at the head of the list
         */
	public void agregaInicio (T t)
	{
		Nodo n1 = new Nodo (t);
		n1.siguiente = this.cabeza;
		this.cabeza.anterior = n1;
		this.cabeza = n1;
		n1.anterior = null;
	}

	 /**
         *Method to add at the end of the list
         */
	public void agregaFinal (T t)
	{
		Nodo n1 = new Nodo (t);
		n1.siguiente = null;
		this.ultimo.siguiente = n1;
		n1.anterior = this.ultimo;
		this.ultimo = n1;
	}

	 /**
         *Method to search if our list contains an specific element
	 *@return true/false
         */
	public boolean contiene (T t)
	{
		boolean ctn = false;	//Stands for contains
		int cont;
		Nodo n1 = this.cabeza;
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
		else
			return false;
	  }

	 /**
         *Regret so many things so we act like the list never had nothing
         */
	public void limpia ()
	{
		this.cabeza = this.ultimo = null;
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
		}
		else
		{
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

		Lista l1 = new Lista ();
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
		Lista l1 = new Lista ();
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
		else
			return "[]";
	}

	/**
	*Method to check if two objects are the same, this case will be if two list are the same node by node
	*@return eqls
	*/
	@Override public boolean equals (Object ob)
	{
		Nodo n1 = this.cabeza;
		boolean eqls = true;	//eqls stands for equals
		if (ob.getClass() == this.getClass())
		{				//Here we compare the class of our list and ob
			Lista lob = (Lista)ob;
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
	 *Method to return a Iterator that we already implement before
	 */
	@Override public Iterator<T> iterator()
	{
		Iterator<T> I1 = new Iterador();
		return I1;
	}

	/**Main method*/
	public void main (Integer args[])
	{
		Integer[] prueba = new Integer[10];
		int cont;
		for (cont = 0; cont < prueba.length && cont < args.length; cont++)
			prueba[cont] = args[cont];
		Lista l1 = new Lista (prueba);
	 }
}

