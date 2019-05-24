//Chech rebalanceoAbajo y elimina
package ThirdPeriod;
import java.util.Comparator;


/**
 * Implementation of a heap, if we dont get a compare method we will do a min heap with compareTo
 * Practica 8
 * @author Medina Amayo D. Alonso
 * @version 1.0
 * @date  20/05/2019
 * javac -d Practicas/build/ Practicas/src/ThirdPeriod/Monticulo.java
 * java -cp Practicas/build/ SecondPeriod.
 */

public class Monticulo{


	/**Attributes*/
	private int[] elementos;
	private Comparator<Integer> comparador;
	private int ultimoIndice;

	/**Constructors*/

	/**Empty Constructor*/
	public Monticulo()
	{
		int[] elementos = new int[100];
		this.elementos = elementos;
		this.ultimoIndice = -1;
		this.comparador = (a, b) -> a.compareTo(b);
	}

	/**Constructor with a compare method*/
	public Monticulo(Comparator<Integer> comparador)
	{
		int[] elementos = new int[100];
                this.elementos = elementos;
                this.ultimoIndice = -1;
                this.comparador = comparador;
	}

	/**Constructor with a given array*/
	public Monticulo( int[] elemntos )
	{
		this.comparador = (a, b) -> a.compareTo(b);
		this.elementos = elemntos;
		this.ultimoIndice = this.elementos.length - 1;
		rebalanceoArriba( (this.ultimoIndice - 1) / 2 );
	}

	/**Constructor with an array given and a way to compaire the elements*/
	public Monticulo(int[] elementos, Comparator<Integer> comparador)
	{
		this.comparador = comparador;
                this.ultimoIndice = elementos.length - 1;
                rebalanceoArriba( (this.ultimoIndice - 1) / 2 );
                this.elementos = elementos;
	}

	public int elimina()
	{
		try
		{
			int tmp = this.elementos[0];
			swtch( 0, this.ultimoIndice );
			this.ultimoIndice--;
			rebalanceoAbajo( 0 );
			return tmp;
		}
		catch( IllegalStateException e )
		{
			System.out.println("ERROR at elimina in Monticulos, exception " + e);
		}
		return -404;
	}

	public boolean contiene(int elemento)
	{
		for(int i = 0; i <= this.ultimoIndice; i++)
		{
			if( this.elementos[i] == elemento )
				return true;
		}
		return false;
	}

	public boolean esVacio()
	{
		if(this.ultimoIndice == -1)
			 return true;
		return false;
	}

	public int getTamano()
	{
		return this.ultimoIndice;
	}

	//In case we have to create a new array it's O(n), otherwise it's O(log n)
	public void agrega(int i)
	{
		if( this.ultimoIndice == this.elementos.length - 1 )
		{
			int[] narry = new int[ ( this.ultimoIndice * 2 ) ]; // new array - n array - narry
			for( int cont = 0; cont <= this.ultimoIndice; cont++ )
				narry[ cont ] = this.elementos[ cont ];
			this.elementos = narry;
		}
		this.ultimoIndice++;
		this.elementos[ this.ultimoIndice ] = i;
		rebalanceoArriba( this.ultimoIndice );
	}

	private void  rebalanceoArriba ( int indx ) //Goes from down -> up
	{
		if( indx == 0 ) return; //Has no father
		float fatherf = ( indx - 1 )/ 2;
		int father = (int)fatherf;
		if( this.comparador.compare( this.elementos[ father ], this.elementos[ indx ] ) <= 0 ) return; //The father is smaller than the son
		else
		{
			swtch( indx,  father );
			rebalanceoArriba( father);
		}
	}

	private void rebalanceoAbajo (int indx ) //Goes from up -> down, we will use it on 'elimina'
	{

                int sonLeft = (2*indx) + 1;
		int sonRight = (2*indx) + 2;
		int minValue; //Here we will save the index of the smallest element
		if( sonRight >  this.ultimoIndice ) //Out of the elements we care
		{
			if(sonLeft > this.ultimoIndice )
				 return; //It is a leaf
			else
				minValue = sonLeft;
		}
		else
		{
			if(this.comparador.compare(this.elementos[ sonLeft ],  this.elementos[ sonRight ] ) <= 0 ) //Left is smaller than right
				minValue = sonLeft;
			else
				minValue = sonRight;
		}
		if( this.comparador.compare( this.elementos[minValue], this.elementos[indx] ) < 0)
		{
			swtch(minValue, indx);
			rebalanceoAbajo(minValue);
		}
	}

	/**
	CompareTo output
	this.compareTo(that)
	returns:
	a negative int if this < that
	0 if this == that
	a positive int if this > that
	*/

	/**
	* Here we switch two elements using them position
	*/
	public void swtch(int e1, int e2 )
	{
		int tmp = this.elementos[ e1 ];
        	this.elementos[ e1 ] = this.elementos[ e2 ] ;
                this.elementos[ e2 ] = tmp;

	}
}
