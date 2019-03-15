package Clase5;

 /**
 * We have to fit n queens on a chessboard somehow they don't kill each other
 * "The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other"
 * @author Medina Amayo D. Alonso
 * @autor: Claudia Osorio
 * @version 0.1
 * @date  25/02/2019
 */

public class Reinas{

	/**Attributes*/
	private int[] acomodo;
	private int nreinas;

	/**
        * Constructor of an array of n length but we know it have 0<=j<n values with one queen per column and row
	* This problem have no solution with 2 or 3 so we skip them
        * @param n
        */
	public Reinas(int n){

		if(n != 2 & n!= 3 | n > 0){ //Only one | cause we will check both anyway
			int[] acomodo = new int[n];
			this. acomodo = acomodo;
			for(int i = 0; i < n; i++)
				this. acomodo[i] = null;
			this.nreinas = n - 1;
		}
		else
			System.out.println("You deserve no queens");

	}

	/**
        * Method about suit the n number of queens on the chess board
        * This problem have no solution with 2 or 3
	* Somehow it works... or at least it acts well
        * @param int
        */
	public void acomodaReinas(){

		int n = this.nrinas;
		while(this.nreinas >= 0){
			this.acomodo[this.nreinas - 1] = 0; //this.nreinas - 1 because arrays start at 0
			while(seAtacan){
				if((this.acomodo[this.nreinas] + 1) < n)
					this.acomodo[this.nreinas -1]++;
				else{
					this.acomodo[this.nreinas - 1] = null;
					this.nreinas++;
					if((this.acomodo[this.nreinas - 1] + 1)< n)
						this.acomodo[this.nreinas - 1]++;
					else {
						System.out.println("God has left the server \nNo solution");
						return null;
					}
				}
			}
			this.nreinas--;
		}
	}

	/**
        * Function see if two queens kill each other
	* We will check every queen
	* @param int q1
	* @param int q2
        * @return boolean
        */
	public boolean seAtacan(){

		int cont; //counter
		for(cont = 0; cont < this.acomodo.length(); cont ++){ //Here we check every queen
			if(this.acomodo[cont] = 0){
				for(int num = 0; num < this.acomodo length; num++){ //Here we compare
					if(num != cont && (num != this.acomodo[cont] )
				}
			}
		}
	}
}
