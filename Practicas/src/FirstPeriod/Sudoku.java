package Practica3;
/**
 *
 * @author Sarurai
 */
public class Sudoku {

    public static final int DIMENSION = 9; // constante

    public void imprimir(int[][] tablero) {
        for (int i = 0; i < DIMENSION; i++) {
            if (i % 3 == 0) {
                System.out.println();
            }
            for (int j = 0; j < DIMENSION; j++) {
                if (j % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    public boolean resuelve(int[][] tablero) {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (tablero[i][j] != 0) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (isSave(tablero, i, j, k)) {
                        tablero[i][j] = k;
                        boolean b = resuelve(tablero);
                        if (b) {
                            return true;
                        }
                        tablero[i][j] = 0;
                    }
                }
                return false;
            }
        }
        System.out.println("Solución hallada:");
        imprimir(tablero);
        return true;
    }

    public boolean isSave(int[][] tablero, int i, int j, int valor) {
//Comprueba columna
        for (int a = 0; a < DIMENSION; a++) {
            if (a != i && tablero[a][j] == valor) {
                return false;
            }
        }
//Comprueba fila
        for (int a = 0; a < DIMENSION; a++) {
            if (a != j && tablero[i][a] == valor) {
                return false;
            }
        }
//Comprueba cuadardo
        int y = (i / 3) * 3;
        int x = (j / 3) * 3;
        for (int a = 0; a < DIMENSION / 3; a++) {
            for (int b = 0; b < DIMENSION / 3; b++) {
                if (a != i && b != j && tablero[y + a][x + b] == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] generarSudoku() {

        int[][] sudok = new int[9][9];
        for (int i = 0; i < sudok.length; i++) {
            for (int j = 0; j < sudok[1].length; j++) {
                int ale = (int) (Math.random() * 10);
                if (ale == 5) {
                    sudok[i][j] = (int) (Math.random() * 9) + 1;
                } else {
                    sudok[i][j] = 0;
                }
            }

        }
        return sudok;
    }

    public static void main(String[] args) {
        Sudoku miSudoku = new Sudoku();

        System.out.println("Sudoku generado");
        int[][] sudoku = miSudoku.generarSudoku();
        miSudoku.imprimir(sudoku);
        System.out.println("Buscando una solución");
        if (!miSudoku.resuelve(sudoku)) {
            System.out.println("No hay solución");
        }


    }
}
