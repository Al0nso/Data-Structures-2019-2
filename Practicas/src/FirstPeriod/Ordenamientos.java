package FirstPeriod;
import FirstPeriod.Lista;

 /**
 * Class to sort arrays and linked list
 * @autor: Claudia Osorio
 * @author Medina Amayo D. Alonso
 * @version 1.0
 * @date  13/03/2019
 */

public class Ordenamientos{

	public static <T extends Comparable<T>> void quickSort(T[] a)
	{
		quickSort(a,0, a.length());
	}

	public static <T extends Comparable<T>>  void quicksort(T[] a, int lo, int hi)
	{
		if(hi <= lo) return;
		private index = partition(a,lo, hi);
		quickSort(a, lo, index - 1);
		quickSort(a, index + 1, hi );
	}

	public static <T extends Comparable<T>>  void partition(T[] a, int lo, int hi)
        {
	}

	public static <T extends Comparable<T>> Lista<T> mergeSort(Lista<T> l)
	{
		if(hi<=0) return;
		middle = lo + ((hi-lo)/2);
		mergeSort(l, middle + 1, hi);
		mergeSort(l, middle + 1, hi);
		merge(l, lo, middle, hi);

	}

	public static <T extends Comparable<T>>  void merge(Lista<T> a, int lo,int middle, int hi)
        {
		 /**Here we will get the length of the linked list divide by 2*/
		int s1 = middle - lo + 1;
		int s2 = hi - middle;
		int cont;
		 /**Create temporal double linked list with a node for each one*/
		Lista l1 = new Lista();
		Lista l2 = new Lista();
		Nodo n1 = a.cabeza;
		 /**We move the node till the start we need*/
		for(int cont1 = 0; cont1 <= lo; cont1++)
			n1 = n1.siguiente;
		 /**Here we copy the data to merge in Lista l1 and Lista l2*/
		for(cont = 0; cont < s1; cont++)
		{
			l1.agregaFinal(n1.elemento);
			n1 = n1.siguiente;
		}
	        for (int j = cont; j < s2; ++j)
		{
			l2.agregaFinal(n1.elemento);
                        n1 = n1.siguiente;
		}


	}

	public static <T extends Comparable<T>> int busquedaBinaria(T[] a, T elemento){
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] a)
        {
                int cont1,cont2; //Stands for counters
                T temp;
                for(cont1 = 0; cont1 < a.length; cont1++)
                        for(cont2 = 0; cont2 < a.length - 1; cont2++)
                                if( a[cont2].compareTo( a[cont2 + 1]) > 0) //If the first elemento is bigger than the other we will get a velue > 0
	                                {
                                        temp = a[cont2];
                                        a[cont2] = a[cont2 + 1];
                                        a[cont2] = temp;
                                }

	}


	public static <T extends Comparable<T>> void selectionSort(T[] a)
        {
                int cont,cont1; //Stands for counters
                int min; //The smallest element
                T temp; //Generic data to save an element of the array
                for(cont1 = 0; cont1 < a.length; cont1 ++)
                {
                        min = cont1;
                        for(cont = cont1 + 1; cont < a.length; cont++)
                                if((a[cont].compareTo(a[min]) > 0)) //If the first elemento is bigger than the other we will get a value > 0)
                                        min = cont;
                        temp = a[cont1]; //Swap starts here
                        a[cont1] = a[min];
                        a[min] = temp; //Swap ends here

                }
        }

	/**
        *Function to make an array with 4 options long and random numbers
        *(1-100,2-10,000, 3-100,000 or 4-300,000)
        */
        public static Integer[] Enteros(int lng)
        {
                int count; //Stands for counter
                Integer[] prueba; //Here we will save the random numbers
                switch(lng)
                {
                        case 1:
                                prueba = new Integer[100];
                                break;
                        case 2:
                                prueba = new Integer[10000];
                                break;
                        case 3:
                                prueba = new Integer[100000];
                                break;
                        case 4:
                                prueba = new Integer[300000];
                                break;

                        default:
                                prueba = new Integer[100000];
                                break;
                }
                for(count = 0; count < prueba.length; count ++)
                {
                        prueba[count] = (int)Math.random()*1000000;
                }
                return prueba;

        }


	public static void main(String args[])
	{
                long ahora, despues, total = 0, individual;
                int cont;
                for(cont = 1; cont <=4; cont++)
                {
                        ahora = System.currentTimeMillis();
                        selectionSort(Enteros(cont));
                        despues = System.currentTimeMillis();
                        individual = (despues - ahora)/1000;
                        System.out.println("SelectionSort took " + individual + " to sort an array in " + cont);
                        total += individual;
                }
                System.out.println("SelectionSort took " + total + " to complete the task");

                ahora = despues = total = individual = 0;
                for(cont = 1; cont <=4; cont++)
                {
                        ahora = System.currentTimeMillis();
                        bubbleSort(Enteros(cont));
			despues = System.currentTimeMillis();
                        individual = (despues - ahora)/1000;
                        System.out.println("BubbleSort took " + individual + " to sort an array in " + cont);
                        total += individual;
                }
                System.out.println("BubbleSort took " + total + " to complete the task");


        }


}
