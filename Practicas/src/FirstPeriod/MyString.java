package FirstPeriod;
 /**
 * Practice N°1 about classes, methods and data types
 * @author Medina Amayo D. Alonso
 * @autor: Claudia Osorio
 * @version 2
 * @date  11/03/2019
 */

public class MyString {

        /** Propierties, variables, constants and methods of MyString */
		private char[] str = new char[96]; //The longest word in the world is 47 characters long so we can fit two of those and a blank space
    private int indx = 0; //Here we will save the last character position

        /**
        * Constructor of a empty string
        *
        */
        public MyString(){

		for(int i = 0; i < 96; i++)
			this.str[i] = '\u00A0';

        }

        /**
        * Constructor using an string given
        * @param word
        */
        public MyString( String word ){

		int i = word.length(), cont;
		if(i <= 97)
			for(cont = 0; cont < i; cont++)
				this.str[cont] = word.charAt(cont);

        }

        /**
        * Constructor using an array of characters
        * str stands for string
	* @param str
        */
        public MyString( char str[] ){

		int i = str.length, cont;
                if(i <= 97)
                        for(cont = 0; cont < i; cont++)
                                this.str[cont] = str[cont];

        }

	/**
	*Method to return the attribute wrd as a String
	*@return str
	*/
	@Override
        public String toString (){

		String str= ""; //Here we will save the string
		int cont; //Counter
		for(cont = 0; cont < 0; cont++)
			str += this.str[cont];
		return str;
        }

	/**
        *Method to get the character at the value idx
	*idx stands for "index"
	*if idx is bigger than our array we return a blank space
	*@param idx
        */
	public char charAt (int idx){

		if(idx < MyString.length)
			return this.str[idx];
		else
			return '\u00A0';

	}

	/**
        *Method to compare an String with MyString
	*param wrd
	*return sm
	*sm stands for "same" and wrd for "word"
	*still have to check if the string is bigger than MyString
        */
	public boolean equals (String wrd){

		boolean sm;
		int cont;
		for(cont = 0; cont < this.indx; cont ++)
			if(this.str[cont] == wrd.charAt(cont))
				sm = true;
			else{
				sm = false;
				break;
			}
		return sm;
        }

	/**
        *Method to compare the string given and the last characters of MyString
	*@param sfx
	*@return tr
	*tr stands for "true" and sfx for "suffixes"
        */
	public boolean endsWith (String sfx){

	    int lgt;
	    int i = 2;
		boolean tr = true;
		lgt = sfx.length;
			//First we will subtract the length of our suffix and then we will move and compare every character
		while(i != lgt)
		{
		    if(str[ (this.indx - lgt) + i ] == sfx.charAt(i) )
				i ++;
			else
				tr = false;
		}
		return tr;
        }

	/**
        *Method to erase the blank spaces of the begining on Mystring
	*bs stands for blank spaces
	*@return nca
	*nca stands for "new character array"
        */
	public char[] trim (){
	   
		int cont, bs = 0;
		char nca = new char[this.indx];
		for(cont = 0; cont < indx; cont++)
		{
			if(str[cont] != ' ' )
				(str[cont-bs]) += str[cont];
			else
				bs++;
		}
		return nca;
        }

	/**
    *Method  to return the first appearance of a character given
	*@param car
	*@return fa
	*fa stands for "first appearance"
        */
	public int indexOf ( char car){
	    for(int fa = 0;fa > str.length -1 ;fa++){
	    	if(str[fa]!=car){
		    
		}else{
		    return fa;
		}
	    }
		return -1;
        }

	/**
        *Method to join a given MyString with our Mystring
	*@param sstr
	*@return cm
	*bms stands for "concat Mystrings"
        */
	public MyString concat ( MyString sstr ){
	    char [] bms = new char [str.length + sstr.str.length];
	    int d=0;
	    for(int i=0; i<bms.length; i++){
		bms[d] = str[i];
	    }
	    MyString cm = new MyString (bms);
		return cm;
        }

	/**
        *Method to know if MyString have something
	*@return ie
	*ie stands for "is empty?"
        */
	public boolean isEmpty (){
	    if(!(str.length ==0))
		return false;
	    else
		return true;
        }

	/**
        *Method to know the length of Mystring
	*@return lgt
        */
	public int length(){
	    int lgt = str.length -1;
		return lgt;
        }

	/**
        *Main Method
        */
        public static void main(String[] args)  {
        	String sol = "morita";
        	MyString mystring  = new MyString(sol);
        	System.out.println(sol.toString());

        	String cc = "rita";
        	MyString lis = new MyString(cc);
        	System.out.println(mystring .concat(lis));
        	System.out.println(mystring .indexOf('m'));


        }
}
