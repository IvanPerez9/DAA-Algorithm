import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner consola = new Scanner(System.in);
		System.out.println("Cuantos elementos tendrá su array: " );
		
		int elem = consola.nextInt();
		int [] array = new int [elem];
		int last = array.length;
		
		for (int x=0; x <elem; x++) {
		    System.out.println("Introduzca el elemento [" + x + "]");
		    array[x] = consola.nextInt();
		}
		
		System.out.println("Continuamos con el algoritmo. Su array inicial es: " + Arrays.toString(array) + " Lo vamos a ordenar. " );
		
		MergeSort ejercicio = new MergeSort();
		ejercicio.sort(array, 0, last);
		
		System.out.println("Su algoritmo ordenado");
		
	}
	
	public void merge (int [] array, int ini, int mitad , int last) { // Ordena las dos mitades 
		
		
		
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
