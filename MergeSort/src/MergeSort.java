import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner consola = new Scanner(System.in);
		System.out.println("Cuantos elementos tendrá su array: " );
		int elem = consola.nextInt();
		int [] array = new int [elem];
		
		for (int x=0; x <elem; x++) {
		    System.out.println("Introduzca el elemento [" + x + "]");
		    array[x] = consola.nextInt();
		}
		
		System.out.println("Continuamos con el algoritmo. Su array inicial es: " + Arrays.toString(array) + " Lo vamos a ordenar. " );
	}
	
	
}
