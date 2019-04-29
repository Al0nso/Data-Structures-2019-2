package SecondPeriod;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.Scanner;

 /**
 * Implementation of a search engine in flat files
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 1.0
 * @date  22/04/2019
 * javac -d Practicas/build/ Practicas/src/SecondPeriod/SeshatEngine.java
 * java -cp Practicas/build/ SecondPeriod.SeshatEngine
 */

public class SeshatEngine
 //Seshat: = Goddness of egypt, goddness of wisdom, knowledge and writing.
{

	/**Attributes*/
	public ArbolAVL<Word> tr;
        public int nArchivos;

	/**
	* We add another file to Seshat
	*/
	public void leerArchivo(String ruta)
	{
		try
		{
			String linea;
			BufferedReader lector = new BufferedReader( new FileReader ( ruta ) );
			linea = lector.readLine();
                        Word wrd = new Word();
			while( linea != null )
			{
				linea = Normalizer.normalize(linea, Normalizer.Form.NFD);
				linea = linea.replaceAll( "^[a-zA-Z0-9.\\s ]" , "" );
				linea = linea.toLowerCase();
				Scanner sc = new Scanner( linea );
				sc.useDelimiter("\\s");
				String str;
				while( sc.hasNext() )
				{
					str = sc.next();
					if( contieneStr(str)  ) //If we had the word we just update it
					{
						wrd = findStr(str);
						if( wrd instanceof Word )
                                                {
                                                        wrd.upgradeAppear();
                                                        wrd.agregaRuta(ruta);
                                                }
					}
					else //If we don't have it we just add it;
					{
                                                wrd.upgradeApper();
                                                wrd.agregaRuta(ruta);
                                                wrd.setString(str);
						tr.agrega(wrd);
					}
				}
				linea = lector.readLine();
				sc.close();
			}
			lector.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR at Seshat.leerArchivo(), exception " + e);
		}
	}

	/**
	*Here we chech if we have the word
	*@return true if we do
	*/
	public boolean contieneStr(String str)
	{
                boolean cnt = false;
		tr.bfs( ( x ) -> { if( x.getString() ==  str  ) cnt = (true || cnt);  else cnt = (false || cnt); } );
                return cnt;
	}

	/**
        *Here we chech if we have the word
        *@return Word if we have it
	*@return null if we don't
        */
        public Word findStr(String str)
        {
		Word wrd = new Word();
                if( contieneStr(str) )
		{
                        tr.bfs( ( x ) -> { if ( x.getString() == str ) wrd =  x ;} );
			return wrd;
		}
                else
                        return null;
        }

	 /**
	 * Returns string without diacritics - 7 bit approximation.
	 * found on https://stackoverflow.com/questions/3322152/is-there-a-way-to-get-rid-of-accents-and-convert-a-whole-string-to-regular-lette
	 * Proof that i understand it: first we
	 * @param source string to convert
	 * @return corresponding string without diacritics
	public static String removeDiacritic(String source)
	{
		char[] vysl = new char[source.length()];
		char one;
		for (int i = 0; i < source.length(); i++) {
			one = source.charAt(i);
			if (one >= '\u00c0' && one <= '\u017f') {
				one = tab00c0.charAt((int) one - '\u00c0');
			}
			vysl[i] = one;
		}
		return new String(vysl);
	}
	private static final String tab00c0 = "AAAAAAACEEEEIIII" +
	    "DNOOOOO\u00d7\u00d8UUUUYI\u00df" +
	    "aaaaaaaceeeeiiii" +
	    "\u00f0nooooo\u00f7\u00f8uuuuy\u00fey" +
	    "AaAaAaCcCcCcCcDd" +
	    "DdEeEeEeEeEeGgGg" +
	    "GgGgHhHhIiIiIiIi" +
	    "IiJjJjKkkLlLlLlL" +
	    "lLlNnNnNnnNnOoOo" +
	    "OoOoRrRrRrSsSsSs" +
	    "SsTtTtTtUuUuUuUu" +
	    "UuUuWwYyYZzZzZzF";
	*/

	public static void main(String[] args)
	{

	}

}
