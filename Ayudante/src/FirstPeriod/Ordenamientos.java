package Laboratorio;

/**
 * Clase con varios métodos para ordenar arreglos y listas.
 *@author Alonso Amayo
 *@author Claudia Osorio
 *@date 11.03.19
 */
public class Ordenamientos{

    int i;
    int j;
    /**
        *Function to make an array with 4 options long and random numbers
        *(1-100,2-10,000, 3-100,000 or 4-300,000)
        */
        public static int[] Enteros(int lng)
        {
                int count; //Stands for counter
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
                {
                        prueba[count] = (int)Math.random()*1000000;
                }
                return prueba;

        }

       

    public static <T extends Comparable<T>> void bubbleSort(T[] a){
	if (i<j){
	    if(compareTo(j)<0){
		System.currentTimeMillis();//Tiempo en milisegundos
	    }
	}
    }
    
    public static <T extends Comparable<T>> void selectionSort(T[] a){
	if(Math.random(i)>0){
	}
	
    }
        
    public static void main(String args[]){
	System.currentTimeMillis();
	
    }    
}
