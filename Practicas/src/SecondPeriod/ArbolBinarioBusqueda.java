package SecondPeriod;
//import FirstPeriod.Listas;
//import FirstPeriod.Colas;
import FirstPeriod.*;
import java.util.function.Consumer;

 /**
 * Implementation of a Binary tree search
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 1.0
 * @date  29/03/2019
 * javac -d Practicas/build/ Practicas/src/SecondPeriod/ArbolBinarioBusqueda.java Practicas/src/FirstPeriod/Lista.java Practicas/src/FirstPeriod/Cola.java
 * Practicas/src/SecondPeriod/ArbolBinario.java
 * java -cp Practicas/build/ SecondPeriod.ArbolBinarioBusqueda
 */

public class ArbolBinarioBusqueda< T extends Comparable < T > > extends ArbolBinario < T >
{

	/**Attributes*/
	protected Vertice ultimoAgregado;

	/**
        *Default Constructor
        */
	public ArbolBinarioBusqueda()
	{
		super();
	}

	/**
	*Constructor since an array
	*/
	public ArbolBinarioBusqueda(T[] a)
	{
		super(a);
	}

	/**
        *Constructor since a List
        */
	public ArbolBinarioBusqueda(Lista<T> a)
        {
                for(int cont = 0; cont < a.getLongitud(); cont++)
		{
			agrega( a.get(cont) );
		}
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
			while( b.hijo() != 0 )
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
		this.ultimoAgregado = v;
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
                	if( ( b.elemento.compareTo( elemento ) ) > 0  )
                        	if( b.hijo() == 1 || b.hijo() == 3 )
                                	b = b.izquierdo;
			else if( ( b.elemento.compareTo( elemento ) ) < 0  )
                        	if( b.hijo() == 2 || b.hijo() == 3 )
                                	b = b.derecho;
			else if( ( b.elemento.compareTo( elemento ) ) == 0)
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
	                        else if(( b.elemento.compareTo( elemento ) ) == 0)
	                                return b;
	                }
		}
                else{
		    return null;}
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
			Vertice v = new Vertice(); //Main node to eliminate
			Vertice tmp = new Vertice(); //Node to save a node that we will use later
			Vertice m = new Vertice(); // Node to save the max of a tree compare to the node thata we want to eliminate
			m = max(v);
			v = find(elemento);
			if(v == this.raiz)
			{
				if(this.raiz.hijo() == 0)
				{
					limpia(); //Method of ArbolBinario
					return true;
				}
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
						swtchV(this.raiz, m);
						v.padre.izquierdo = v.derecho;
						v.padre = null;
						this.raiz = m;
					}
			}
			else //If the node v isn't the root
			{
				if(height(v) == 0) //We just tell the father he no longer has a child ( F )
				{
					if(v.padre.izquierdo == v) v.padre.izquierdo = null;
					else v.padre.derecho = null;
				}
				else //We eliminate the node that is not a leaf or the root i.e. it is an internal node
				{
					if(v.hijo() != 3) //Here we check if the node has only one tree son
					{
						if(v.hijo() == 2)
						{
							tmp = v.derecho;
							tmp.padre = v.padre;
							v.derecho = null;
						}
						else
						{
                                                        tmp = v.izquierdo;
                                                        tmp.padre = v.padre;
                                                        v.izquierdo = null;
						}
					}
					else
					{
						swtchV(v, m); //Switch with the max node to make it easier to delete
						/**Because v has now the position of the one that use to be the max, v doesn't have a left son,
						so we just make the father of v become father of the sons of v. Now v doesn't exist*/
						if(v.padre.derecho == v)
							v.padre.derecho = v.derecho;
						else
                                                        v.padre.izquierdo = v.derecho;
						v.padre = null; //v has no pointers now
					}
				}
			}
			this.elementos--;
		}
		else{
		    return false;}
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
		int lp, lh;
		lp = ladoVertice(p);
		lh = ladoVertice(h);
		if(lp == 1)
			p.padre.izquierdo = h;
		else if(lp == 2)
			p.padre.izquierdo = h;
		if(lh == 1)
                        h.padre.izquierdo = p;
                else if(lh == 2)
                        h.padre.izquierdo = p;
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
        * Method to get the side of the node v view ass the father
        * @return 1 if the node v is left
        * @return 2 if the node v is right
        * @return 0 if the node has no father
        */
        protected int ladoVertice(Vertice v)
        {
                if(v.padre == null)
                        return 0;
                if(v.padre.izquierdo == v)
                        return 1;
                else
                        return 2;
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
