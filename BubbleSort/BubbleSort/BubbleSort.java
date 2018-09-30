package BubbleSort;

import java.util.Scanner;

/**
 * 
 * @author ivan1
 *
 *
 *	Se compara cada elemento con su siguiente y se ordena
 *
 */

public class BubbleSort {
	
	public static void main(String[] args) {
		
		System.out.println("Cuantos elementos tendrá su array: ");
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
		int elem = console.nextInt();
		int [] array = new int [elem];
		
		for (int x=0; x<elem; x++) {
		    System.out.println("Introduzca el elemento [" + x + "]");
		    array[x] = console.nextInt();
		}
		
		BubbleSort sort = new BubbleSort();
		sort.bubble(array);
		
		System.out.println();
		System.out.println("El array ordenado es: ");
		sort.mostrar(array);
	}
	
	public void bubble (int [] entrada) {
		
		int aux;
		int n = entrada.length;
		
		for (int i = 0; i< n ; i++) {
			for (int j = 1; j< n-i; j++) {
				if (entrada[j-1]> entrada[j]) {
					aux = entrada[j-1];
					entrada[j-1] = entrada[j];
					entrada[j] = aux;
				}
			}
		}	
	}
	
	public void mostrar (int [] arrayMuestra) {
		
		int n = arrayMuestra.length;
		for (int i=0; i<= n-1; i++) {
			System.out.print(arrayMuestra[i] + " ");
		}
	}
	
}