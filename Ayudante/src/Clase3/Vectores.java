package Clase3;
import Clase3.Par;
import java.util.Scanner;

 /**
 * Exercise about Structures
 * @author Medina Amayo D. Alonso
 * @autor: Claudia Osorio
 * @version 1.0
 * @date  06/02/2019
 */

public class Vectores {

	/**Attributes*/
	//Par p = new Par();

	public static double sumaX (Par p1, Par p2){

		return (double)p1.getX() + (double)p2.getX();

	}

	public static double sumaY (Par p1, Par p2){

		return (double)p1.getY() + (double)p2.getY();

	}

	public static void main(String[] args) {

	double x,y;
	Par p1 = new Par();
	Par p2 = new Par();
	Vectores vc = new Vectores();
	Scanner sc = new Scanner(System.in);
	System.out.println("Hi, give me the x value of the first pair");
	p1.setX((Object)sc.nextDouble());
	System.out.println("Now give me the x value of the second pair");
        p2.setX((Object)sc.nextDouble());
	System.out.println("Give me the y value of the first pair");
        p1.setY((Object)sc.nextDouble());
        System.out.println("Now give me the y value of the second pair");
        p2.setY((Object)sc.nextDouble());
	x = vc.sumaX(p1, p2);
	y = vc.sumaY(p1, p2);
	System.out.println("x value: " + x);
	System.out.println("Y value: " + y);
	}
}
