package Clase3;
import java.util.Scanner;

 /**
 * Exercise about pass by reference or pass by value
 * @author Medina Amayo D. Alonso
 * @autor: Claudia Osorio
 * @version 1.0
 * @date  06/02/2019
 */

public class ContenedorEntero {

	/** Attribute*/
	private int entero;

	public int getEntero (){

		return this.entero;
	}

	public void setEntero (int entero){

		entero = this.entero;
        }

	public static void swap (ContenedorEntero c1, ContenedorEntero c2 ){

		int temp = c1.entero;
		c1.entero = c2.entero;
		c2.entero = temp;
	}

	public static void main(String[] arg) {

		Scanner sc = new Scanner(System.in);
		int ent1, ent2;
		ContenedorEntero c1 = new ContenedorEntero();
		ContenedorEntero c2 = new ContenedorEntero();
		System.out.println("Give me the first integer");
		ent1 = sc.nextInt();
		System.out.println("Give me the second integer");
	        ent2 = sc.nextInt();
		c1.setEntero(ent1);
		c2.setEntero(ent2);
		c1.swap(c1, c2);
		ent1 = c1.getEntero();
		ent2 = c2.getEntero();
		System.out.println("First integer " + ent1);
                System.out.println("Second integer " + ent2);

	}
}
