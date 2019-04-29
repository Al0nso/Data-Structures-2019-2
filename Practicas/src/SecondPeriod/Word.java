package SecondPeriod;
import FirstPeriod.Lista;
 /**
 * Object where we will save the word for Sesha Engine, so the number of times the word appear on the text
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 1.0
 * @date  24/04/2019
 * javac -d Practicas/build/ Practicas/src/SecondPeriod/Word.java
 * java -cp Practicas/build/ SecondPeriod.Word
 */

public class Word <T extends Comparable<T>>
{
	/**Attributes*/
	public int appear;
	public String str;
	public Lista<String> lt;
	public int nDocumentos;

	/**
	*Default Constructor, we just initialize the attributes
	*/
	public Word()
	{
		setAppear(0);
		setString("");
		Lista<String> lt = new Lista();
		this.lt = lt;
		setNDocumentos(0);
	}

	/**
        *Constructor with a string input
        */
	public Word(String str, String ruta)
	{
		setString(str);
		setAppear(0);
		upgradeAppear();
		Lista<String> lt = new Lista();
		lt.agregaFinal(ruta);
		setNDocumentos(1);
	}

	/**
	*Override of the methos compare to so the tree can properly work
	*@return 1 if this is bigger than the argument
	*@return 0 if they are the same
	*@return -1 if this is smaller than the argument
	*/
	public int compareTo ( Word wrd)
	{
		if( this.getAppear() > wrd.getAppear() )
			return 1;
		else if(this.getAppear() == wrd.getAppear())
			return 0;
		else if( this.getAppear() == wrd.getAppear() )
			return -1;
		return 1;
	}

	/**
        *Method to save from where they come
        *@return null
        */
        public void agregaRuta( String ruta )
        {
                if( !this.lt.contiene(ruta) )
                        this.lt.agregaFinal(ruta);
        }

	/**
        *Method to get as a string the files from where we came
        *@return String
        */
        public String getRuta()
        {
                return this.lt.toString();
        }

	/**
        *Method to set the attributes of number of documents where the word appear
        *@return null
        */
        public void setNDocumentos( int i )
        {
                this.nDocumentos = i;
        }

	/**
	*Method to set the string attribute of the object
	*@return null
	*/
	public void setString( String str )
	{
		this.str = str;
	}

	/**
        *Method to get the string attribute of the object
        *@return String
        */
	public String getString()
	{
		return null;
	}

	/**
        *Method to set the appear of the string in the files attribute of the object
        *@return null
        */
	private void setAppear( int i )
        {
		this.appear = i;
        }

	/**
        *Method to get the appear of the string in the files attribute of the object
        *@return int
        */
        public int getAppear()
        {
                return this.appear;
        }

	/**
        *Method to add one to the appear, we will do this every time we have the same word
        *@return null
        */
	public void upgradeAppear()
	{
		this.appear++;
	}

	//Main method
	public static void main(String[] args)
        {

        }

}
