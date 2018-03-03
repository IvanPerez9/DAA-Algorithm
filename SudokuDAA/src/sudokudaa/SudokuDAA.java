
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
    
    public static int Operacion (int posicion){
	return (int) (posicion/3)*3;
    }
	
    // Prueba las distintas cajas 3x3 que se crean.
    public static boolean caja3x3 (int [][] tablero3 , int cajaCol , int cajaFila, int n){
        int fila33,col33;
        fila33 = Operacion(cajaFila);
        col33 = Operacion(cajaCol);
	// Desde la columna o fila que empieza haga un cuadrado de 3x3.
	for (int i = fila33; i<fila33+3 ; i++){
            for (int j = col33; j<col33+3 ; j++){
                if (tablero3[i][j] == n)
                    return false;
            }
        }
        return true;
    }
    
    // Metodo comprobar. Combina los 3. Comprueba si se puede meter un numero en esa posición.
    public static boolean Comprobar (int [][] tablero, int fila , int col , int n, int longitud){
        return (columnaTest (tablero ,col,n, longitud) && filaTest (tablero, fila, n, longitud) && caja3x3(tablero, col, fila, n)) ;
    }
    
    
    public static int Resolver (int [][] tablero, int col , int fila, int N){
        
        int contadorSoluciones = 0; 
        int auxFila , auxCol;
		
        // Cuando una casilla no está vacia.
        if (tablero[fila][col] !=0) {
            if ((fila==N-1) && (col==N-1)) { // Es el final
                contadorSoluciones ++; 
            }else {
                if (col==N-1) { // Final columnas. Pasa a la siguiente fila y reinicia las columnas
                    auxCol = 0;
                    auxFila = fila +1;
                }else {         // Sino es el final de las columnas, pasar a la siguiente columna.
                    auxCol = col +1;
                    auxFila = fila;
                }
                contadorSoluciones = contadorSoluciones + Resolver(tablero, auxCol, auxFila, N);
            }
        }else { // Cuando es vacia la casilla, probar si se puede el valor 1 hasta 9
            for (int i=1; i<=9; i++) {
                if (Comprobar(tablero, fila, col, i, N)) {
                    tablero[fila][col] = i;
                    // Mismo if de antes, si final ... sino pues miro columnas...
                    if ((fila==N-1) && (col==N-1)) {
                        contadorSoluciones++;
                        
                    }else {
                        
                        if (col==N-1) {
                            
                            auxCol = 0;
                            auxFila = fila+1;
                            
                        }else {
                            
                            auxCol = col+1;
                            auxFila = fila;
                        }
                        contadorSoluciones = contadorSoluciones + Resolver (tablero, auxCol, auxFila, N);
                    }
                    tablero [fila][col] = 0; // Desmarcar. No puede resolverlo ahora, lo marco otra vez como vacio o 0.
                }

            }
        }
        return contadorSoluciones;
    }
    
    
}
