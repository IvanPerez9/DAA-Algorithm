/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudaa;

import java.util.Scanner;

/**
 *
 * @author Iván
 * 
 * Sudoku por Backtraking
 * 
 */
public class SudokuDAA {

    static int [][] tablero;
    
    public static void main(String[] args) {
        tablero = new int [9][9];
        // inicializar tablero aqui. 9 lineas con digitos del 0 al 9. Despues del noveno salto de linea
        tablero = inicializarTablero();
    }
    
    public static int [][] inicializarTablero(){
        int [][] tableroPpal = new int [9][9];
        Scanner entrada = new Scanner (System.in);
        // Rellenar filas y columnas del tablero
        for(int i = 0; i<9 ; i++){
            for(int j = 0 ; j<9; j++){
                tableroPpal[i][j] = entrada.nextInt();
            }
        }
        return tableroPpal;
    }
    
    // Comprobar columnas, filas y los cuadrados 3x3. Mirar PDF.
    
    //Fijar la Fila
    public static boolean filaTest (int [][] tablero1 , int fila, int n){
        boolean aux = false;
        int contador = 0;
        while ((aux != true) && (contador < 9)){
           aux = (tablero1[fila][contador] == n); 
           contador++;
        }
        return !aux ;
    }
    
    //Fijar columna
    public static boolean columnaTest (int [][] tablero2, int columna, int n){
        boolean aux = false;
        int contador = 0;
        while ((aux!= true) && (contador <9)){
            aux = (tablero2[columna][contador] == n);
            contador ++;
        }
        return !aux;
    }
    
    
    
}
