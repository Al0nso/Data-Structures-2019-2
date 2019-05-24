package ThirdPeriod;
import java.util.Iterator;
import java.util.Random;

 /**
 * Class to sort arrays and linked list
 * Sorting methods: QuickSort, Mergesort, BubbleSort, SelectionSort and Heapsort
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 2.0
 * @date  20/05/2019
 * javac -d Practicas/build/ Practicas/src/ThirdPeriod/Ordenamientos.java Practicas/src/ThirdPeriod/Monticulo.java
 * java -cp Practicas/build/ ThirdPeriod.Ordenamientos
 */

public class Ordenamientos{

	/**
        *Function to make an array with 4 options long and random numbers
        *(1-100,2-10,000, 3-100,000 or 4-300,000)
        */
        public static int[] Enteros(int lng)
        {
                int count; //Stands for counter
		int elmt;
                int[] prueba; //Here we will save the random numbers
                switch(lng)
                {
                        case 1:
                                prueba = new int[100];
                                break;
                        case 2:
                                prueba = new int[10000];
                                break;
                        case 3:
                                prueba = new int[100000];
                                break;
                        case 4:
                                prueba = new int[300000];
                                break;

                        default:
                                prueba = new int[100000];
                                break;
                }
                for(count = 0; count < prueba.length; count ++)
                        prueba[count] = getRandomInt( random, 0, 10000000);
                return prueba;

        }

	private static Random random = new Random();

	public static int getRandomInt(Random random, int min, int max)
	{
		return random.nextInt(max - min + 1) + min;
	}

	public static void heapSort(int[] a)
	{
		Monticulo mnt = new Monticulo(a);
		for(int cont = 0; cont < a.length; cont ++)
			a[cont] = mnt.elimina();
    	}

	public static void main(String args[])
	{
                long ahora, despues, total = 0, individual;
                int cont;
		/**HeapSort test*/
		for(cont = 1; cont <= 4; cont++)
       	        {
                        ahora = System.currentTimeMillis();
			int[] x = Enteros(cont);
                        heapSort( x );
                        despues = System.currentTimeMillis();
       	                individual = (despues - ahora)/1000;
                        System.out.println("heapSort took " + individual + " to sort an array in " + cont);
			System.out.println("The element 5 is  " + x[4]);
			System.out.println("The element 10 is " + x[9]);
			System.out.println("The element 50 is " + x[49]);
			System.out.println("The element 60 is " + x[59]);
                        total += individual;
                }
		System.out.println("heapSort took " + total + " to sort an array everything");
        }


}
