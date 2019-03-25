package FirstPeriod;
/**
 *Excercise about the Queen's in the tab the chess
 * @author Medina Amayo D. Alonso
 * @autor: Claudia Osorio
 * @version A
 * @date 27.02.19
 */
public class Reinas{

    private int[] acomodo;

    /**
     * Constructor.
     * Inicializa el arreglo de reinas con todas sus entradas en -1 para representar que están vacías.
     * @param n El número de reinas a acomodar.
     */
    public Reinas(int n){
	if(n == 2 || n == 3)
	    throw new IllegalArgumentException("El problema de las n reinas no tiene solución para " + n);
	acomodo = new int[n];
       	for(int i = 0; i < n; ++i)
	    acomodo[i] = -1;
    }

    /**
     * Algoritmo principal.
     * Acomoda las reinas utilizando backtrack.
     */
    public void acomodaReinas(){
	if(acomodo.length == 1){
	    acomodo[0] = 0;
	    return;
	}
      
	int indice = 0; // Índice para contar en qué reina vamos.
	while(indice < acomodo.length){

	    acomodo[indice]++;
	    while(acomodo[indice] < acomodo.length && seAtacan()) // Movemos a la reina hasta que no haya conflictos.
		acomodo[indice]++;
	    if(acomodo[indice] == acomodo.length){ // Nos salimos de la columna
		acomodo[indice] = -1;
		indice--;
	    }
	    else
		indice++;
	}
    }
    

    /**
     * Nos dice si las reinas de nuestro acomodo se atacan.
     * @return <code>true</code> si hay dos reinas que se atacan y <code>false</code> en otro caso.
     */
    public boolean seAtacan(){
	for(int i = 0; i < acomodo.length; ++i)
	    for(int j = i+1; j < acomodo.length; ++j){
		if(acomodo[i] == -1 || acomodo[j] == -1)
		    continue;
		if(acomodo[i] == acomodo[j])
		    return true;
		if(Math.abs(acomodo[i] - acomodo[j]) == Math.abs(i - j))
		    return true;
	    }
	return false;
    }
    

    /**
     * Main para probar el programa.
     * @param args Argumentos de línea de comandos. En este caso, los usaremos para saber cuántas reinas acomodar.
     */
    public static void main(String args[]){
	int i = Integer.parseInt(args[0]); // Cuántas reinas acomodar.
	Reinas r = new Reinas(i);
	r.acomodaReinas();
	System.out.println(java.util.Arrays.toString(r.acomodo));
    }
}
