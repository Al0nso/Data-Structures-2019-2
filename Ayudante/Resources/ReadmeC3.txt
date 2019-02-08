Laboratorio Sesion 3

Ejercicio:
Parte 1: Copiar el método swap a una clase y probar que tipo de paso de parámetro usa y responder

¿Java tiene paso por valor o paso por referencia y por qué?
Tiene Paso por valor.
*Se realizan una copia de la variable (Si es primitiva)  y se pasa a la memoria despues esta se pasa al método.
Si no es primitiva se crea una nueva referencia y esta se pasa al método.
 

De acuerdo al código que acaban de escribir, ¿Java tiene paso por valor o paso por referencia? ¿Esto coincide con el resultado del ejercicio 1?
Tiene Paso por Valor.



INTRODUCCIÓN A GENERICOS
Parte 2:

Aprender de las Estructuras

Par Ordenado
public class Par{			public class Vectores{

private Object x;		       public static double sumaX(Par p1, Par p2);

private Object y;		       public static double sumaY(Par p1, Par p2);

public Object getX();

public Object getY();
}	       					       }


¿Qué pasa cuando llamo a double sumaX con pares enteros?
Compila muy bien pero al momento de ejecutar genera un error.
