package SecondPeriod;
import FirstPeriod.Lista;
import FirstPeriod.Cola;
 /**
 * Implementation of a Binary red-black tree
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 1.0
 * @date  20/04/2019
 * javac -d Practicas/build/ Practicas/src/SecondPeriod/ArbolRojinegro.java Practicas/src/FirstPeriod/Lista.java Practicas/src/FirstPeriod/Cola.java
 * Practicas/src/SecondPeriod/ArbolBinarioBusqueda.java Practicas/src/SecondPeriod/ArbolBinario.java
 * java -cp Practicas/build/ SecondPeriod.ArbolRojinegro
 */

public class ArbolRojinegro<T extends Comparable<T>> extends ArbolBinarioBusqueda<T>
{

	protected class VerticeRojinegro extends Vertice
	{

		/**Attributes*/
		public Color color;

		/**
		*Default Constructor
		*/
		public VerticeRojinegro(T elemento)
		{
			super();
			this.color = Color.ROJO;
		}

		/**
		*Constructor since a normal node
		public VerticeRojinegro(Vertice b)
                {
			VerticeRojinegro v = new  VerticeRojinegro(b.elemento);
			v.izquierdo = b.izquierdo;
			v.derecho = b.derecho;
			v.padre = b.padre;
                }
		*/

		@Override
		public boolean equals (Object o)
		{
			if(o == null || this.getClass() != o.getClass() )
				return false;
			@SuppressWarnings( "unchecked" )
			VerticeRojinegro vr = ( VerticeRojinegro ) o ;
			return ( color == vr.color && super.equals( o ) );
		}
    	}

	public ArbolRojinegro()
	{
		super();
	}

	public ArbolRojinegro( T[] a )
	{
		super(a);
		this.color = ROJO;
	}

	/**
        *Constructor since a Binary tree
        */
	public ArbolRojinegro( ArbolBinario tr )
	{
        	tr.bfs( (x) -> agrega( x.elemento ) );
	}

	/**
        *Constructor since a List
        */
        public ArbolRojinegro( Lista<T> l )
        {
                super(l);
        }

	protected Color getColor(Vertice v)
	{
		try
		{
			if( v instanceof ArbolRojinegro.VerticeRojinegro )
			{
				VerticeRojinegro b = new VerticeRojinegro();
				b = ( VerticeRojinegro ) v;
				return b.color;
			}
                        else if(v == null)
				return NEGRO; //Rule of red-black trees, if it is null -> is black
                        return null;
		}
                catch(IllegalArgumentException e)
                {
                        System.out.println("ArbolRojinegro setColor error, IllegalArgumentException");
                }

	}

	protected void setColor(Vertice v, Color c)
	{
		try
		{
			if( v instanceof ArbolRojinegro.VerticeRojinegro )
			{
				VerticeRojinegro b = new VerticeRojinegro();
	                        b = ( VerticeRojinegro ) v;
	                        b.color = c;
	                }
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("ArbolRojinegro setColor error, IllegalArgumentException");
		}

	}

	@Override
	public void agrega(T elemento)
	{
		super(elemento);
		VerticeRojinegro v = new VerticeRojinegro();
		v = ( VerticeRojinegro )this.ultimoAgregado;
		setColor( v, ROJO );
		rebalanceoRojo(v);
	}



	/**
	*Method to delete a node from our tree without screw it up
	*@return true if we made it
	*@return false if we have an error or we don't have the element
	*/
	@Override
	public boolean elimina(T elemento)
	{
		VerticeRojinegro v = new VerticeRojinegro(); //The max node of the tree
		VerticeRojinegro p = new VerticeRojinegro(); //The father
		VerticeRojinegro tmp = new VerticeRojinegro(); //The node yhat we are going to eliminate
		VerticeRojinegro h = new VerticeRojinegro(); //The son of tmp, maybe a ghost
		tmp = find(elemento); //The node that we will delete
		v = max(tmp);
		if( tmp == null ) //The element doesn't exist
			return false;
		if( esRojo( tmp ) ) //If the node is red we just erase it
		{
			super(elemento);
			return true;
		}
		swtchV(tmp, v); //We change it with the max or the tree
		if( tmp.hijo() != 3) //It means we have no right tree
		{
				b.elemento = null;
				tmp.derecho = v;
				b.padre = tmp;
				b.derecho = null;
				b.izquierdo = null;
		}
		else
		{
			b = tmp.derecho;
		}
		swtchV(tmp, b);
		b.derecho = null;
		tmp.padre = null;
		//we erased tmp

		/**Here we start the cases of rebalance*/
		if(b.padre == null)
		{
			eliminaFantasma(b);
			return;
		}
		else if( getColor(b) == Color.ROJO && getColor(tmp) == Color.NEGRO )
		{
			setColor(b, Color.ROJO);
			eliminaFantasma(b);
			return;
		}
		else if(getColor(b) == Color.NEGRO && getColor(tmp) == Color.NEGRO)
		{
			rebalanceaNegro(b);
			eliminaFantasma(b);
		}
	}

	private void eliminaFantasma ( VerticeRojinegro v )
	{
		if(v.elemento == null)
		{
			if(b.izquierdo != null)
			{
				int lb = LadoVertice(b);
				if(lb == 1)
					b.padre.izquierdo = b.izquierdo;
				else if(lb == 2)
					b.padre.derecho = b.izquierdo;
				lb.derecho.padre = b.padre;
				lb.derecho = null;
			}
		}
	}

	/**
        * Function to get an element's node from the tree
	* We override the method from BST to return a redblack node
        */
	@Override
        protected VerticeRojinegro find (T elemento)
        {
                VerticeRojinegro b = new VerticeRojinegro();
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
                else
                        return null;
        }

	/**
        * Method to known if an element is in our tree
        * @return boolean
        */
        @Override
        public boolean contiene (T elemento)
        {
                VerticeRojinegro b = new VerticeRojinegro();
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

	private void rebalanceoRojo (VerticeRojinegro v)
	{
		try
		{
			if( getColor( v ) == ROJO )
			{
				if(v.padre == null) //First case
                                {
                                        setColor(v, NEGRO);
                                        return;
                                }
				else if( getColor(v.padre) == NEGRO ) //Second case
					return;
				else if ( ( getColor(v.padre.padre) == Color.NEGRO ) && ( getColor(v.padre.padre.izquierdo ) == Color.ROJO && getColor(v.padre.padre.derecho ) == Color.ROJO  )  )//Third case

				{
					rRC3(v);
					return;
				}
				else if( ( v.padre.padre != null ) & ( v.lado() != v.padre.lado() ) ) //Fourth case
				{
					rRC4(v);
                                        return;
				}
				else if( v.lado() == v.padre.lado() )
				{
					rRC5(v);
					return;
				}
			}
			else
				System.out.println("We can't rebalance from a black node at method rebalanceoRojo()");
		}
		catch(Exception e)
		{
			System.out.println("ERROR at rebalanceoRojo, " + e);
		}
	}

	/**
	* Case of rebalance were the grandpa is black, the father and the uncle are red
	*/
	private void rRC3 (VerticeRojinegro v)
        {
		setColor( v.padre.padre, ROJO );
		setColor( v.padre.padre.izquierdo, NEGRO );
		setColor( v.padre.padre.derecho, NEGRO );
		rebalanceoRojo( v.padre.padre );
        }

	/**
        * Case of rebalance the father and the son are cross
        */
	private void rRC4 (VerticeRojinegro v)
        {
		VerticeRojinegro tmp = new VerticeRojinegro();
		boolean t;
		tmp = v.padre;
		if(v.lado() == 1 && v.padre.lado() == 2 )
			t = girar(v.padre, 2);
		else
			t = girar(v.padre, 1);
		rRC5(tmp);
        }

	/**
	*Case where v and the father are not cross
	*/
	private void rRC5 (VerticeRojinegro v)
        {
		setColor( v.padre, NEGRO );
		setColor( v.padre.padre, ROJO );
		if(v.lado() == 1) //v is left
			girar(v.padre.padre, 2);
		else
			girar(v.padre.padre, 1);
        }

	protected void rebalanceoNegro (VerticeRojinegro v)
        {
		try
                {
			VerticeRojinegro b = new VerticeRojinegro();
	                b = getHermano(v);
                        if( getColor( v ) == NEGRO )
                        {
				if(v.padre == null) //First case
				{
					return;
				}
                                else if( getColor(b) == Color.ROJO ) //Second case
				{
					rNC2(v);
                                	rNC3(v);
				       return;
				}
                                else if(getColor(b) == Color.NEGRO && getColor(b.izquierdo) == Color.NEGRO && getColor(b.derecho) == Color.NEGRO && getColor(v.padre) == Color.NEGRO ) //Third case
                                {
					rNC3(v);
                                        return;
                                }
                                else if(getColor(b) == Color.NEGRO && getColor(b.izquierdo) == Color.NEGRO && getColor(b.derecho) == Color.NEGRO &&  getColor(v.padre) == Color.ROJO ) //Fourth case
                                {
					rNC4(v);
                                        return;
                                }
                                else if( ( ladoVertice(v) == 1 && getColor(b.izquierdo) == Color.ROJO && getColor(b.derecho) == Color.NEGRO ) || (ladoVertice(v) == 2 && getColor(b.derecho) == Color.ROJO && getColor(b.izquierdo) == Color.NEGRO ) ) //Fifth case
                                {
					rNC5(v);
					rNC6(v);
                                        return;
                                }
				else if( ( ladoVertice(v) == 1 && getColor(b.derecho) == Color.ROJO ) || ladoVertice(v) == 2 && getColor(b.izquierdo) == Color.ROJO ) //Sixth case
				{
					rNC6(v);
					return;
				}
                        }
                        else
                                System.out.println("We can't rebalance from a black node at method rebalanceoNegro()");
                }
                catch(Exception e)
                {
                        System.out.println("ERROR at rebalanceoNegro, " + e);
                }

        }

	/**
        * The next 4 methods are the cases of rebalance from a black node
        */

	/**CAse where v is not the root and his brother is red*/
	private void rNC2 (VerticeRojinegro v)
        {
		setColor(v.padre, Color.ROJO);
		VerticeRojinegro b = new VerticeRojinegro();
		b = getHermano(v);
		setColor(b, Color.NEGRO);
		girar(v.padre, ladoVertice(v) );
        }

	/**Case where the sons of the brother are black, so is the father and the brother*/
        private void rNC3 (VerticeRojinegro v)
        {
		VerticeRojinegro b = new VerticeRojinegro();
                b = getHermano(v);
		setColor(b, Color.ROJO);
		rebalanceoNegro(v.padre);
        }

	/**Case where the sons of the brother and the brother are black,the father is red */
        private void rNC4 (VerticeRojinegro v)
        {
		VerticeRojinegro b = new VerticeRojinegro();
                b = getHermano(v);
		setColor(b, Color.ROJO);
		setColor(v.padre, Color.NEGRO);
		return;
        }

	/**Case where v is left, the left son of the brother is red, the right son of the brother is black or
	v is right, the left son of the brother is black, the right son of the brother is red*/
        private void rNC5 (VerticeRojinegro v)
        {
		VerticeRojinegro b = new VerticeRojinegro();
                b = getHermano(v);
		setColor(b, Color.ROJO);
		if( getLado(v) == 1 )
		{
			setColor( b.izquierdo, Color.ROJO );
			girar(b, 2);
		}
		else
		{
			setColor( b.derecho, Color.ROJO );
                        girar(b, 1);
		}
		return;
        }

	 /**Case where v is left, the right son of the brother is red or v is right, the left son of the brother is black*/
	private void rNC6 (VerticeRojinegro v)
        {
		VerticeRojinegro b = new VerticeRojinegro();
                b = getHermano(v);
		setColor(b, getColor(b.padre) );
		setColor( v.padre, Color.NEGRO );
		if( getLado(v) == 1 )
                {
                        setColor( b.derecho, Color.NEGRO );
			girar(v.padre, 1);
                }
                else
                {
                        setColor( b.izquierdo, Color.Negro );
			girar(v.padre, 2);
                }
		return;
        }

	/**
	*Method to know if a node is red
	*@return boolean
	*/
	private boolean esRojo (VerticeRojinegro v)
	{
		try{
			return (v != null && getColor(v) == Color.ROJO);
		}
		catch(Exception e)
		{
			System.out.println("ERROR at esRojo, exception " + e);
		}
	}

	/**
        * Method to get the brother
        * @return null if the node has no father or the brother is null
        */
	private VerticeRojinegro getHermano(VerticeRojinegro v)
	{
		if(v.padre == null)
                        return null;
                if(v.padre.izquierdo == v)
                        return v.padre.derecho;
                else
                        return v.padre.izquierdo;
	}

}
