package FirstPeriod;
import java.util.NoSuchElementException;
import java.util.Iterator;
/**
* Practica N.3 sobre Pilas y Colas
* @author Alonso Amayo
* @version 3
* @date 13.05.19
* status: online
* javac -d Practicas/build/ Practicas/src/FirstPeriod/Cola.java Practicas/src/FirstPeriod/Lista.java
*/

/**
 * Implementación de colas.
 */
public class Cola<T> implements Iterable<T>{

	/**Attributes*/
	protected Lista<T> l1;
	protected T next; //The next element

	// Interator class of our list
	private class Iterador implements Iterator < T >
	{

		public Iterator<T> itr;

		 /**
	          *Constructor of a new Iterator
	          */
		public Iterador ()
		{
			itr = l1.iterator();
		}

		 /**
		 *Method to know if the list have next node
	 	 *@return true/false
		 */
		@Override public boolean hasNext ()
		{
			return itr.hasNext();
		}

		 /**
		 *Method to return next node of our list
		 *If the list don't have next node we will return null
		 *@return temp
		 */
		@Override public T next ()
		{

			if ( hasNext () )
			{
				T elemnt = itr.next();
				return elemnt;
			}
			return null;
		}
	}

	public Cola()
	{
		Lista<T> l1 = new Lista<T>();
		this.l1 = l1;
		this.next = null;
	}

	public Cola(Lista<T> l)
	{
		this.l1 = l;
		this.next = this.l1.eliminaPrimero();
	}

	public Cola(T[] arreglo)
	{
		Lista<T> l1 = new Lista<T>(arreglo);
		this.l1 = l1;
		this.next = this.l1.eliminaPrimero();
	}

	public boolean esVacia()
	{
		return this.next == null;
	}

	public T mira()
	{
		try
		{
			if(this.next != null)
				return this.next;
			else
				if(this.l1.getPrimero() != null)
				{
					this.next = l1.eliminaPrimero();
					return this.next;
				}
				else
				return null;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("ERROR at Cola.mira, exception " + e);
		}
		return null;
	}

	public T saca()
	{
		try
                {
			T elemnt;
			if(this.next != null)
				elemnt =  this.next;
			else
                        	elemnt =  this.l1.eliminaPrimero();
			this.next = this.l1.eliminaPrimero();
                        return elemnt;
                }
                catch(NoSuchElementException e)
                {
                        System.out.println("ERROR at Cola.mira, exception " + e);
                }
		return null;
	}

	public void mete(T t)
	{
		this.l1.agregaFinal(t);
	}

	@Override
	public String toString()
	{
		String str = "";
		if(this.next != null)
			str += this.next + "\n";
		Iterator<T> itr = this.iterator();
		while( itr.hasNext() )
		{
			str +=  itr.next().toString() + "\n";
		}
		return str;
	}

	@Override
	public boolean equals(Object objeto )
	{
		if (objeto == null || this.getClass() != objeto.getClass())
                        return false;
                @SuppressWarnings("unchecked")
                Cola<T> cla = (Cola<T>)objeto;
                Iterator<T> itr1 = cla.iterator();
		Iterator<T> itr = this.iterator();
                while( itr1.hasNext() && itr.hasNext() )
                {
                        if( itr.next().equals( itr1.next() ) )
                                return false;
                }
                return true;
	}

	@Override
	public Iterator<T> iterator()
	{
		Iterator<T> I1 = new Iterador();
                return I1;
	}

	/**
        * Main method
        */
        public static void main (String[] args)
        {
                Cola<Integer> a1 = new Cola<Integer>();
                a1.mete(0);
                a1.mete(1);
		a1.mete(2);
		a1.mete(3);
		a1.mete(4);
		a1.mete(5);
		a1.mete(6);
                System.out.println( "To string \n" + a1.toString() );
                System.out.println( "Saca: " + a1.saca() );
		System.out.println( "Mira: " + a1.mira() );
                System.out.println( "Saca: " + a1.saca() );
		System.out.println( "Saca: " + a1.saca() );
                System.out.println( "To string \n" + a1.toString() );
  		a1.mete(7);
                a1.mete(8);
                a1.mete(9);
                a1.mete(10);
                a1.mete(11);
                a1.mete(12);
		System.out.println( "To string \n" + a1.toString() );
		System.out.println( "Saca: " + a1.saca() );
		for(int cont = 0; cont < 8 ; cont++)
			System.out.println( "Saca: " + a1.saca() );
		System.out.println( "Mira: " + a1.mira() );
        }

}
