package SecondPeriod;
import FirstPeriod.Lista;
import FirstPeriod.Cola;
import FirstPeriod.*;
import java.util.function.Consumer;

 /**
 * Implementation of a Binary tree
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 1.0
 * @date  29/03/2019
 * javac -d Practicas/build/ Practicas/src/SecondPeriod/ArbolBinario.java Practicas/src/FirstPeriod/Lista.java Practicas/src/FirstPeriod/Cola.java
 * java -cp Practicas/build/ SecondPeriod.ArbolBinario
 */

public abstract class ArbolBinario < T >
{
	         /**Attributes*/
		public int hgt; //Height of the tree
		protected Vertice raiz; //Root of the tree
	        protected int elementos; //Number of elements

	protected class Vertice
	{

		 /**Attributes*/
		public T elemento; //Element
		public Vertice izquierdo; //Left son
		public Vertice derecho; //Right son
		public Vertice padre; //Father

		/**
		*
		*/
		public Vertice(T elemento)
		{
		    this.elemento = elemento;
			this.izquierdo = null;
			this.derecho = null;
		}

		public Vertice()
                {
			this.izquierdo = null;
                        this.derecho = null;
		}

		public boolean esHijo(Vertice h)
		{
			if(this.izquierdo == h ||  this.derecho == h)
				return true;
			return false;
		}

		/**
		* Function to know the sons of a node
		* if the node have two sons return 3
		* if only have the left return 1
		* if it only have the right son return 2
		* if it is a leaf we return 0
		*/
		public int hijo()
                {
			if(this.izquierdo != null && this.derecho != null)
                                return  3;
			if(this.izquierdo != null)
				return 1;
			if(this.derecho != null)
                                return 2;
			return 0;
                }

		/**
		*Method to know if the node is left or right son
		* 1 if it is left
		* 2 if it is right
		* 0 of we have no father
		* -1 if we have something weird
		*/
		public int lado()
		{
			if(this.padre == null)
				return 0;
			if(this.padre.izquierdo == this )
                                return 1;
			if(this.padre.derecho == this )
                                return 2;
			return -1;
		}
	}

	public ArbolBinario()
	{
		limpia();
	}

	public ArbolBinario(T[] arreglo)
	{
		for(T b : arreglo)
			agrega(b);
		this.hgt = height(this.raiz);
	}

	public abstract void agrega(T elemento);

	public abstract boolean elimina(T elemento);

	public abstract boolean contiene(T elemento);

	public void bfs(Consumer<T> funcion)
	{
		if(this.raiz == null) return; //We check if the tree is null
		if(height(this.raiz) == 0) //We chech if the tree have only a leaf
		{
			funcion.accept(this.raiz.elemento);
			return;
		}
		else
		{
			funcion.accept(this.raiz.elemento);
			Cola<Vertice> tl = new Cola<Vertice>(); //Create the new tail only of nodes
			if( this.raiz.hijo() == 3 || this.raiz.hijo() == 2  )
				tl.mete(this.raiz.derecho);
			if( this.raiz.hijo() == 3 || this.raiz.hijo() == 1  )
				tl.mete(this.raiz.izquierdo);
			try
			{
				Vertice v = new Vertice();
				Object o = new Object();
				while( ! ( tl.esVacia() ) )
				{
					v = tl.saca();
					funcion.accept(v.elemento);
					if( v.hijo() == 3 || v.hijo() == 2  )
						tl.mete(v.derecho);
					if( v.hijo() == 3 || v.hijo() == 1  )
		                                tl.mete(v.izquierdo);
				}
			}
			catch(Exception e)
			{
				System.out.println("Error at BFS on Arbol Binario, " + e);
			}
		}
	}

	/**
	* Method to do a function with our tree with a Depth-first search
	* 1 for inOrden
	* 2 for preOrden
	* 3 for postOrden
	* We use auxiliar methods for each Depth-first search
	*/
	public void dfs(int tipo, Consumer<T> funcion)
	{
		try
		{
			if(this.raiz != null)
			{
				switch(tipo)
				{
					//Inorden
					case 1: inOrden(funcion, this.raiz);
						break;
					//Preorden
		                        case 2: preOrden(funcion, this.raiz);
		                                break;
					//Postorden
		                        case 3: postOrden(funcion, this.raiz);
		                                break;
					//In case we get an integer different than 1,2 or 3
					default:inOrden(funcion, this.raiz);
						break;
				}
			}
			else
				System.out.println("Empty tree");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("IllegalArgumentException\n ");
		}
	}

	/**
	* The next three methods are auxiliary methods for the dfs method above
	*/
	private void inOrden(Consumer<T> funcion, Vertice v)
        {
		if(v.hijo() == 1 || v.hijo() == 3)
			inOrden(funcion, v.izquierdo);
		funcion.accept(v.elemento);
		if(v.hijo() == 1 || v.hijo() == 3)
                        inOrden(funcion, v.derecho);
	}

	private void preOrden(Consumer<T> funcion, Vertice v)
        {
		funcion.accept(v.elemento);
		if(v.hijo() == 1 || v.hijo() == 3)
                        preOrden(funcion, v.izquierdo);
		if(v.hijo() == 1 || v.hijo() == 3)
                        preOrden(funcion, v.derecho);

        }

	private void postOrden(Consumer<T> funcion, Vertice v)
        {
		if(v.hijo() == 1 || v.hijo() == 3)
                        postOrden(funcion, v.izquierdo);
                if(v.hijo() == 1 || v.hijo() == 3)
                        postOrden(funcion, v.derecho);
		funcion.accept(v.elemento);

        }

	/**Method to get the number of elements of our tree*/
	public int getElementos()
	{
		/**
		int num = 0;
		if (this.raiz == null) return 0;
		if (this.raiz.hijo == 0 ) num++;
		Cola tl = new Cola(); //Create the new tail
		if( this.raiz.hijos() == 3 || this.raiz.hijos() == 2  )
		{
                                tl.mete(this.raiz.derecho);
		}
                if( this.raiz.hijo() == 3 || this.raiz.hijo() == 1  )
		{
                                tl.mete(this.raiz.izquierdo);
		}
		while( ! ( tl.esVacia() ) )
		{
                                v = tl.saca();
				num++
                                if( v.hijo() == 3 || v.hijo() == 2  )
                                        tl.mete(v.derecho);
                                if( v.hijo() == 3 || v.hijo() == 1  )
                                        tl.mete(v.izquierdo);
		}
		*/
		return this.elementos;
	}

	/**
	*We calculate the height of a node given
	* 0 if it's a leaf
	* -1 if it is null
	*/
	public int height(Vertice v)
	{
		if (v == null) //We check if the node is null, if so the father will be a leaf
			return  -1;
		else
			if(height(v.izquierdo) < height(v.derecho))
			{
				this.hgt = height(v.derecho) + 1;
				return height(v.derecho) + 1;
			}
			else
			{
				this.hgt = height(v.izquierdo) + 1;
				return height(v.izquierdo) + 1;
			}
	}

	/**
	* Function to turn a tree
	* We will know which side to turn by the int s (side)
	*  1 to turn left
	*  2 to turn right
	*/
	public boolean girar (Vertice p, int s)
	{
		if(p != null)
		{
			if(p.hijo() != 0) //We will work as long as we have p's son(s)
				switch(s)
				{
				case 1: if(p.hijo() == 3 || p.hijo() == 1 ){
					       	girarIzquierda( p, p.derecho);
						return true;
						break;
				case 2: if(p.hijo() == 3 || p.hijo() == 2)
						girarDerecha( p, p.izquierdo);
						return true;
		                                break;
						
		   		default:System.out.println("Out of parameters");
			    		return false;
		                                break;
				}
			else
				return true;
		} else {return false;}
		return true;
	}

	/**
	* Method to turn our tree, the parameters are just the node we will move too
	* @return boolean
	* true if we could, false if we !could
	*/
	protected boolean girarIzquierda (Vertice p, Vertice h)
        {
		if( p != this.raiz )
		{
			Vertice tmp = new Vertice(); //Temporal node
			tmp = h.izquierdo;
			h.izquierdo = p;
			p.derecho = tmp;
			h.padre = p.padre;
			p.padre = h;
			if(h.padre.izquierdo == p)
                                h.padre.izquierdo = h; //Grandpa
                        else
                                h.padre.derecho = h; //Grandpa
			tmp.padre = p;
		}
		else
		{
			Vertice tmp = new Vertice(); //Temporal node
                        tmp = h.izquierdo;
                        h.izquierdo = p;
                        p.derecho = tmp;
                        h.padre = null;
                        p.padre = h;
                        tmp.padre = p;
			this.raiz = h;
			this.hgt = height(this.raiz);
		}
		return false;
        }

	protected boolean girarDerecha (Vertice p, Vertice h)
        {
		if( p != this.raiz )
                {
                        Vertice tmp = new Vertice(); //Temporal node
                        tmp = h.derecho;
                        p.izquierdo = h.derecho;
			h.derecho = p;
			h.padre = p.padre;
			p.padre = h;
			if(h.padre.izquierdo == p)
                                h.padre.izquierdo = h; //Grandpa
                        else
                                h.padre.derecho = h; //Grandpa
			tmp.padre = p;
                }
                else
                {
                        Vertice tmp = new Vertice(); //Temporal node
                        tmp = h.derecho;
                        p.izquierdo = h.derecho;
                        h.derecho = p;
                        h.padre = null;
                        p.padre = h;
                        tmp.padre = p;
                        this.raiz = h;
			this.hgt = height(this.raiz);
                }
		return false;
        }

	/**
	* We clean everything
	*/
	protected void limpia()
	{
		this.raiz = null;
		this.hgt = -1;
		this.elementos = 0;
	}

}
