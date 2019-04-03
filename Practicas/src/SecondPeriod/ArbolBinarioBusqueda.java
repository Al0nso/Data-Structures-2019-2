package SecondPeriod;
import FirstPeriod.Listas;
import FirstPeriod.Colas;
import java.util.function.Consumer;

 /**
 * Implementation of a Binary tree search
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 1.0
 * @date  29/03/2019
 * javac -d Practicas/build/ Practicas/src/SecondPeriod/ArbolBinarioBusqueda.java Practicas/src/FirstPeriod/Lista.java Practicas/src/FirstPeriod/Cola.java
 * java -cp Practicas/build/ SecondPeriod.ArbolBinarioBusqueda
 */

public class ArbolBinarioBusqueda<T extends Comparable<T>> extends ArbolBinario<T>{

	public ArbolBinarioBusqueda()
	{
		super();
	}

	public ArbolBinarioBusqueda(T[] a)
	{
		super(a);
	}

	/**
	* Function to add an element to our tree
	*@return void
	*/
	@Override
	public void agrega(T elemento)
	{
		Vertice v = new Vertice(elemento);
		if(this.raiz == null)
		{
			this.raiz = v;
			this.hgt = 1;
			this.elementos = 1;
		}
		else
		{
			Vertice b = new Vertice();
			b = this.raiz;
			while( b.hijos() != 0 )
			{
				if( ( b.elemento.compareTo( v.elemento ) ) >= 0  ) //Left
					if( b.hijo() == 1 || b.hijo() == 3 )
						b = b.izquierdo;
				if( ( b.elemento.compareTo( v.elemento ) ) < 0  ) //Right
                                        if( b.hijo() == 2 || b.hijo() == 3 )
                                                b = b.derecho;
			}
			if( ( b.elemento.compareTo( v.elemento ) ) >= 0  ) //Left
                       		b.izquierdo = v;
			if( ( b.elemento.compareTo( v.elemento ) ) < 0  ) //Right
                     		b.derecho = v;
		}
		this.elementos++;
		this.hgt = height(this.raiz);
	}

	/**
	* Method to known if an element is in our tree
	* @return boolean
	*/
	@Override
	public boolean contiene (T elemento)
	{
		Vertice b = new Vertice();
                b = this.raiz;
                while( height(b) >= 0 )
                {
                	if( ( b.elemento.compareTo( v.elemento ) ) > 0  )
                        	if( b.hijo() == 1 || b.hijo() == 3 )
                                	b = b.izquierdo;
			else if( ( b.elemento.compareTo( v.elemento ) ) < 0  )
                        	if( b.hijo() == 2 || b.hijo() == 3 )
                                	b = b.derecho;
			else if(( b.elemento.compareTo( v.elemento ) ) = 0)
				return true;
		}
		return false;
	}

	/**
	* Function to get an element's node from the tree
	*/
	protected Vertice find (T elemento)
	{
		Vertice b = new Vertice();
                b = this.raiz;
                if( contiene( elemento ) )
		{
			while( height(b) >= 0 )
	                {
	                        if( ( b.elemento.compareTo( elemento ) ) > 0  )
	                                if( b.hijo() == 1 || b.hijo() == 3 )
	                                        b = b.izquierdo;
	                        else if( ( b.elemento.compareTo( elemento ) ) < 0  )
	                                if( b.hijo() == 2 || b.hijo() == 3 )
	                                        b = b.derecho;
	                        else if(( b.elemento.compareTo( elemento ) ) = 0)
	                                return b;
	                }
		}
                else
			return null;
	}

	/**
	*Method to eliminate an element from the tree
	* @return boolean
	*/
	@Override
	public boolean elimina(T elemento)
	{
		if( contiene(elemento) )
		{
			Vertice v = new Vertice();
			v = find(elemnto);
			if(v == this.raiz)
			{
				if(this.raiz.hijos == 0)
				{
					limpia(); //Method of ArbolBinario
					return true;
				}
				Vertice m = new Vertice();
				m = max(v);
				if(m == v) //If our tree doesn't have a left subtree
				{
					this.raiz = v.derecho;
					this.raiz.padre = null;
					return true;
				}
				else
					if(min(v) == v) //If our tree doesn't have a right subtree
	                                {
        	                                this.raiz = v.izquierdo;
	                                        this.raiz.padre = null;
	                                        return true;
	                                }
					else //If the root have both sons
					{
						Vertice tmp = new Vertice();
						tmp = m.derecho;
						m.padre.izquierdo = tmp;
						m.derecho = this.raiz.derecho;
						m.izquierdo = this.raiz.izquierdo;
					}
			}
			else //If the node v isn't the root
			{
				if(height(v) == 0) //We just tell the father he no longer has a child ( F )
				{
					if(v.padre.izquierdo = v) v.padre.izquierdo = null;
					else v.padre.derecho = null;
				}
				else //We eliminate the node
				{

				}
			}
			this.elementos--;
		}
		else
			return false;
	}

	/**
	* Auxiliar method to switch a node with another
	* We just switch the attributes between p and h
	* @return void
	*/
	protected void swtchV (Vertice p, Vertice h)
	{
		Vertice tmp = new Vertice();
		tmp = p;
		p.derecho = h.derecho;
		p.izquierdo = h.izquierdo;
		p.padre = h.padre;
		//Second switch
		h.derecho = tmp.derecho;
                h.izquierdo = tmp.izquierdo;
                h.padre = tmp.padre;
	}

	/**
	*Auxiliar method to get the succesor of the tree with regard to the root
	* @return Vertice
	*/
	protected Vertice max(Vertice v)
	{
		if(v.hijo() == 2 | v.hijo() == 3)
		{
			v = v.derecho; //We check all the elements bigger than the node v
			while(v.hijo() == 1 | v.hijo() == 3)
			{
				v = v.izquierdo;
			}
			return v;
		}
		else
			return v;
	}

	/**
        *Auxiliar method to get the predecessor of the tree with regard to the root
        */
        protected Vertice min(Vertice v)
        {
                v = v.izquierdo; //We check all the elements smaller than the node v
                while(v.hijo() == 1 | v.hijo() == 3)
                {
                        v = v.derecho;
                }
                return v;
        }

	public static void main( Integer[] args )
	{
		ArbolBinarioBusqueda tr = new ArbolBinarioBusqueda();
		for(Integer a : args)
			tr.agrega(a);
		tr.bfs( ( x )->System.out.print(x + ",") );
	}
}

