package SecondPeriod;
import FirstPeriod.Lista;
import FirstPeriod.Cola;
import FirstPeriod.*;
 /**
 * Implementation of AVL Trees
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 1.0
 * @date  20/04/2019
 * javac -d Practicas/build/ Practicas/src/SecondPeriod/ArbolAVL.java Practicas/src/FirstPeriod/Lista.java Practicas/src/FirstPeriod/Cola.java
 * java -cp Practicas/build/ SecondPeriod.ArbolAVL
 */

public class ArbolAVL<T extends Comparable<T>> extends ArbolBinarioBusqueda<T>
{

	protected class VerticeAVL extends Vertice
	{

		public int altura;

		/**Main constructor*/
		public VerticeAVL(T elemento)
		{
		    super(elemento);
			this.altura = 0;
		}

		public VerticeAVL()
		{
			this.altura = -1;
			this.padre = this.izquierdo = this.derecho = null;
		}
	}

	public ArbolAVL()
	{
		super();
	}

	public ArbolAVL(T[] elementos)
	{
		super(elementos);
	}


	protected int getAltura(Vertice v)
	{
		if(v instanceof ArbolAVL.VerticeAVL)
		{
			VerticeAVL vavl = new VerticeAVL();
			vavl = ( ArbolAVL.VerticeAVL ) v;
			return vavl.altura;
		}
		else if( v == null )
			return -1;
		else
		{
			System.out.println("No es un vertice AVL");
			return height(v); //Method from ArbolBinario
		}
	}

	protected void actualizaAltura(Vertice v)
	{
		if(v instanceof ArbolAVL.VerticeAVL)
		{
			VerticeAVL vavl = new VerticeAVL();
                        vavl = ( ArbolAVL.VerticeAVL ) v;
			if( getAltura( vavl.derecho ) >=  getAltura( vavl.izquierdo ) )
				vavl.altura = getAltura(vavl.derecho) + 1;
			else
				vavl.altura = getAltura(vavl.izquierdo) + 1;
		}
	}

	protected int getBalance(Vertice v)
	{
		if( v instanceof ArbolAVL.VerticeAVL )
		{
			if( v == null )
                                return 0;
			VerticeAVL vavl = new VerticeAVL();
                        vavl = ( ArbolAVL.VerticeAVL ) v;
			if(getAltura( vavl.derecho ) >=  getAltura( vavl.izquierdo ) )
				return getAltura( vavl.derecho ) - getAltura( vavl.izquierdo );
			else
				return getAltura( vavl.izquierdo ) - getAltura( vavl.derecho );
		}
		else
		{
			System.out.println("No es un vertice AVL");
			return -1;
		}
	}

	@Override
	public void agrega(T elemento)
	{
		VerticeAVL v = new VerticeAVL(elemento);
		Vertice b = new Vertice();
                if(this.raiz == null)
                {
                        this.raiz = v;
                        this.hgt = 1;
                        this.elementos = 1;
                }
                else
                {
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
                this.hgt = getAltura(this.raiz);
                this.ultimoAgregado = v;
		if( v.padre instanceof ArbolAVL.VerticeAVL )
		{
			VerticeAVL vp = new VerticeAVL();
			vp = ( ArbolAVL.VerticeAVL ) v.padre;
			vp.altura ++;
		}
		rebalanceo(v);
	}

	@Override
	public boolean elimina(T elemento)
	{
		 if( contiene(elemento) )
                {
                        VerticeAVL v = new VerticeAVL(); //Main node to eliminate
                        VerticeAVL tmp = new VerticeAVL(); //Node to save a node that we will use later
                        VerticeAVL m = new VerticeAVL(); // Node to save the max of a tree compare to the node thata we want to eliminate
                        if( max(v) instanceof ArbolAVL.VerticeAVL )
				m = ( ArbolAVL.VerticeAVL )max(v);
			if( find(elemento) instanceof ArbolAVL.VerticeAVL )
	                        v = ( ArbolAVL.VerticeAVL )find(elemento);
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
                                                        if( v.derecho instanceof ArbolAVL.VerticeAVL )
								tmp = ( ArbolAVL.VerticeAVL )v.derecho;
                                                        tmp.padre = v.padre;
                                                        v.derecho = null;
                                                }
                                                else
                                                {
							if( v.izquierdo instanceof ArbolAVL.VerticeAVL )
                                                                tmp = ( ArbolAVL.VerticeAVL )v.izquierdo;
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
			if( v.derecho instanceof ArbolAVL.VerticeAVL )
				rebalanceo( ( ArbolAVL.VerticeAVL )v.derecho);
		}
		 else{
		     return false;}
		 return false;

	}

	protected void giraIzquierda(Vertice p, Vertice h )
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
		if(p instanceof ArbolAVL.VerticeAVL && h instanceof ArbolAVL.VerticeAVL )
                {
                        VerticeAVL pavl = new VerticeAVL();
                        pavl = ( ArbolAVL.VerticeAVL ) p;
			VerticeAVL havl = new VerticeAVL();
                        havl = ( ArbolAVL.VerticeAVL ) h;
			actualizaAltura(pavl);
	                actualizaAltura(havl);
		}
	}

	protected void giraDerecha(VerticeAVL p, VerticeAVL h )
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
                if(p instanceof ArbolAVL.VerticeAVL && h instanceof ArbolAVL.VerticeAVL )
                {
                        VerticeAVL pavl = new VerticeAVL();
                        pavl = ( ArbolAVL.VerticeAVL ) p;
                        VerticeAVL havl = new VerticeAVL();
                        havl = ( ArbolAVL.VerticeAVL ) h;
                        actualizaAltura(pavl);
                        actualizaAltura(havl);
                }
	}

	protected void rebalanceo(VerticeAVL v)
	{
		int balance = getBalance( v );
		if( v.padre != null )
		{
			if(balance >= 2)
			{
				if( getAltura(v.izquierdo) - getAltura( v.derecho ) > 1  )
				{
					if( getAltura( v.izquierdo.izquierdo ) - getAltura( v.izquierdo.derecho ) >= 1 )
						girar(v, 2 ); //Turn right
					else if( getAltura( v.izquierdo.derecho ) - getAltura( v.izquierdo.izquierdo ) >= 1 )
					{
						girar(v.izquierdo, 1); //Turn left
						girar(v, 2);//Turn right
					}
				}
				else
				{
					if( getAltura( v.derecho.izquierdo ) - getAltura( v.derecho.derecho ) >= 1 )
                                                girar(v, 1 ); //Turn left
                                        else if( getAltura( v.derecho.derecho ) - getAltura( v.derecho.izquierdo ) >= 1 )
                                        {
                                                girar(v.derecho, 2); //Turn right
                                                girar(v, 1);//Turn left
                                        }
				}
			}
				if(v.padre instanceof ArbolAVL.VerticeAVL  )
					rebalanceo( ( ArbolAVL.VerticeAVL )v.padre );
		}
	}
}
