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
    static int numeroSoluciones;
    
    public static void main(String[] args) {
        tablero = new int [9][9];
        // inicializar tablero aqui. 9 lineas con digitos del 0 al 9. Despues del noveno salto de linea
        tablero = inicializarTablero();
        numeroSoluciones = Resolver(tablero,0,0,9);
        System.out.println(numeroSoluciones);
    }
    
    //Rellenar el tablero por teclado.
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
    
    //Fijar la Fila. Puede hacerse con While.
    public static boolean filaTest (int [][] tablero1 , int fila, int n, int longitud){
        for (int columna=0; columna < longitud; columna++){
            if(tablero1[fila][columna] == n){
                return false;
            }
        }
        return true;
    }
    
    //Fijar columna.
    public static boolean columnaTest (int [][] tablero2, int columna, int n, int longitud){
        for (int fila = 0; fila <longitud ; fila++){
            if(tablero2 [fila][columna] == n){
                return false;
            }
        }
        return true;
    }
    
    // Prueba las distintas cajas 3x3 que se crean.
    public static boolean caja3x3 (int [][] tablero3 , int cajaCol , int cajaFila, int n){
        for (int fila = 0; fila<3 ; fila++){
            for (int col = 0; col<3 ; col++){
                if (tablero3[cajaFila + fila][cajaCol + col] == n)
                    return false;
            }
        }
        return true;
    }
    
    // Metodo comprobar. Combina los 3. Comprueba si se puede meter un numero en esa posición.
    public static boolean Comprobar (int [][] tablero, int fila , int col , int n, int longitud){
        return (!columnaTest (tablero ,col,n, longitud) && !filaTest (tablero, fila, n, longitud) && !caja3x3(tablero, col, fila, n)) ;
    }
    
    
    public static int Resolver (int [][] tablero, int col , int fila, int N){
        
        int contadorSoluciones = 0; 
        int auxFila , auxCol;
		
        if (tablero[fila][col] !=0) {
            if ((fila==N-1) && (col==N-1)) { // Es el final
                contadorSoluciones ++;
                
            }else {
                if (col==N-1) { // Final columnas
                    auxCol = 0;
                    auxFila = fila +1;
                }else {         // Final filas
                    auxCol = col +1;
                    auxFila = fila;
                }
                contadorSoluciones = contadorSoluciones + Resolver(tablero, auxCol, auxFila, N);
            }
        }else {
            for (int i=1; i<=9; i++) {
                if (Comprobar(tablero, fila, col, i, N)) {
                    tablero[fila][col] = i;
                    if ((fila==N-1) && (col==N-1)) {
                        contadorSoluciones++;
                        
                    }else {
                        if (col==N-1) {
                            
                            auxFila = fila++;
                            auxCol = 0;
                            
                        }else {
                            auxCol = col++;
                            auxFila = fila;
                        }
                        contadorSoluciones = contadorSoluciones + Resolver (tablero, auxCol, auxFila, N);
                    }
                    tablero [fila][col] = 0;
                }

            }
        }
        return contadorSoluciones;
    }
    
    
}
