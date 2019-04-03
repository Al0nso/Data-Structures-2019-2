package SecondPeriod;
import FirstPeriod.Listas;
import FirstPeriod.Colas;
 /**
 * Implementation of a Binary red-black tree
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 1.0
 * @date  03/03/2019
 * javac -d Practicas/build/ Practicas/src/SecondPeriod/ArbolRojinegro.java Practicas/src/FirstPeriod/Lista.java Practicas/src/FirstPeriod/Cola.java
 * java -cp Practicas/build/ SecondPeriod.ArbolRojinegro
 */

public class ArbolRojinegro<T extends Comparable<T>> extends ArbolBinarioBusqueda<T>{

	protected class VerticeRojinegro extends Vertice
	{

		/**Attributes*/
		public Color color;

		public VerticeRojinegro(T elemento)
		{
			super();
			this.color = Color.ROJO;
		}

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

	public ArbolRojinegro( ArbolBinario tr )
	{
        	tr.bfs( (x) -> agrega( x.elemento ) );
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
                        else
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
		
	}



	@Override
	public boolean elimina(T elemento)
	{
		// Aquí va su código.
	}
}
