package MergeSort;
import java.util.Arrays;


import java.util.Scanner;

/**
 * 
 * @author ivan1
 * 
 * 
 * 	Divide el array en dos, los ordena por separado y los vuelve a mezclar
 * 
 */

public class MergeSort {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner consola = new Scanner(System.in);
		System.out.print("Cuantos elementos tendrá su array: " );
		
		int elem = consola.nextInt();
		int [] array = new int [elem];
		int length = array.length;
		
		for (int x=0; x<elem; x++) {
		    System.out.print("Introduzca el elemento [" + x + "] : ");
		    array[x] = consola.nextInt();
		}
		
		System.out.println("Continuamos con el algoritmo. Su array inicial es: " + Arrays.toString(array) + " Lo vamos a ordenar. " );
		
		MergeSort ejercicio = new MergeSort();
		ejercicio.sort(array, 0, length-1);
		
		System.out.println();
		System.out.println("Su array ordenado es: ");
		System.out.println(Arrays.toString(array));
		
	}
	
	public void merge (int [] array, int ini, int mitad , int last) { // Ordena las dos mitades 
		
		int [] arrayAux = new int [array.length]; // Array auxiliar que va almacenando
		for (int i = ini; i <= last; i++) {
			arrayAux[i] = array[i];
		}
		
		// Variables para recorrer
		int i = ini;
		int j = mitad +1 ;
		int k = ini;
		
		while (i <= mitad && j <= last) {
			if (arrayAux[i] <= arrayAux[j]) {
				array[k] = arrayAux[i];
				i++;
			} else {
				array[k] = arrayAux[j];
				j++;
			}
			k++;
		}
		while(i<= mitad) {
			array[k] = arrayAux[i];
			k++;
			i++;
		}
		while(j<= last) {
			array[k] = arrayAux[j];
			k++;
			j++;
		}
		
	}
	
	public void sort (int [] array , int ini, int last) { // Divide la mitad y ordena 
		
		int mitad = (ini+last)/2;
		
		if (ini < last) {
			sort(array, ini, mitad);
			sort(array, mitad+1, last);
			merge(array, ini, mitad, last);
		}
	}
}
