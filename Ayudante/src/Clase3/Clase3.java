package Clase3;

 /**
 * Exercise about pass by reference or pass by value
 * @author Medina Amayo D. Alonso
 * @autor: Claudia Osorio
 * @version 1.0
 * @date  06/02/2019
 */

public class Clase3 {

        /** Propierties, variables, constants and methods of Clase3*/

	public Clase3 (){

	}

	public void swap(int i1, int i2){

		int temp = i1;
		i1 = i2;
		i2 = temp;
		System.out.println("New i1 " + i1);
		System.out.println("New i2 " + i2);

	}

	public static void main(String[] args)

		Clase3 c3 = new Clase3();
		swap( 2, 3);

	}
}
