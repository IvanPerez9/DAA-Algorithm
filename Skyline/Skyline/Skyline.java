package Skyline;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Iván
 * 
 * Skyline 
 * 
 */
public class Skyline {
    
    public static class Edificio {
        int x; // inicio
        int y; // fin
        int altura;
        
        public Edificio (int x, int y , int altura){
            this.x = x ;
            this.y = y;
            this.altura = altura;
        }
        
        public Edificio(){}

    }
    
    public static class Imagen {
        int x;
        int altura;
        
        // Inicializar en el 1,1
        public Imagen(){
            this.x = 1;
            this.altura = 1;
        }
        public Imagen(int x , int altura){
            this.x = x;
            this.altura=altura;
        }
    }
    
    /**
     *
     * @author ivan1
     *
     * Ejemplo: 6
	 *			1 3 4
	 *			2 9 7
	 *			4 12 4
	 *			6 8 9
	 *			11 13 6
	 *			14 15 2
     *
     */
    
    public static class AlgoritmoSkyline {
        public void Algoritmo_Skyline ( ArrayList<Edificio> Edificios , ArrayList<Imagen> Silueta){

            // Caso Base
            if(Edificios.size() == 1){
                Edificio edAux = Edificios.get(0);
                Imagen dib1 = new Imagen (edAux.x , edAux.altura);
                Imagen dib2 = new Imagen (edAux.y,0);
                Silueta.add(dib1);
                Silueta.add(dib2);
            } else {
                int mitad = Edificios.size()/2;
                ArrayList <Edificio> trozo1 = new ArrayList <Edificio>();
                ArrayList <Edificio> trozo2 = new ArrayList <Edificio>();

                // Relleno de Edificios los trozos
                for (int i=0; i<mitad; i++){
                    trozo1.add(Edificios.get(i));
                }
                for (int i=mitad; i<Edificios.size(); i++){
                    trozo2.add(Edificios.get(i));
                }

                // llamada recursiva a los 2 trozos.
                ArrayList<Imagen> silueta1 = new ArrayList <Imagen>();
                ArrayList <Imagen> silueta2 = new ArrayList <Imagen>();
                Algoritmo_Skyline(trozo1 , silueta1);
                Algoritmo_Skyline(trozo2, silueta2);

                // Juntar los dos trozos
                Juntar_Todo (silueta1,silueta2, Silueta);
            }

        }

        public void Juntar_Todo (ArrayList <Imagen> silueta1 , ArrayList<Imagen> silueta2 , ArrayList<Imagen> Silueta){
            int alturaPrevia = -1;  // Altura previa general
            int alturaAnterior1 = -1; // Alturas de silueta1 y 2 , anterior
            int alturaAnterior2 = -1;

            Imagen aux; // Auxiliares e inicio 
            Imagen dibujo1 = new Imagen();
            Imagen dibujo2 = new Imagen();

            while ((!silueta1.isEmpty()) && (!silueta2.isEmpty())){

                aux = new Imagen();
                dibujo1 = silueta1.get(0);
                dibujo2 = silueta2.get(0);

                if (dibujo1.x < dibujo2.x){
                    aux.x = dibujo1.x;
                    aux.altura=(Math.max(dibujo1.altura, alturaAnterior2));
                    if (aux.altura != alturaPrevia ){
                        Silueta.add(aux);
                        alturaPrevia = aux.altura;
                    }
                    alturaAnterior1 = dibujo1.altura;
                    silueta1.remove(0);
                } else if (dibujo1.x > dibujo2.x){
                   aux.x = dibujo2.x;
                   aux.altura = ( Math.max(dibujo2.altura, alturaAnterior1));
                   if(aux.altura != alturaPrevia){
                       Silueta.add(aux);
                       alturaPrevia = aux.altura;
                   }
                   alturaAnterior2 = dibujo2.altura;
                   silueta2.remove(0);
                } else {                                                // si tienen igual x ambas siluetas.
                    if ((dibujo1.altura > dibujo2.altura) && (dibujo1.altura != alturaPrevia)){
                        Silueta.add(dibujo1);
                        alturaPrevia = dibujo1.altura;
                    } else if ((dibujo1.altura <= dibujo2.altura) && (dibujo2.altura != alturaPrevia)) {
                        Silueta.add(dibujo2);
                        alturaPrevia = dibujo2.altura;
                    }

                    alturaAnterior1 = dibujo1.altura;
                    alturaAnterior2 = dibujo2.altura;
                    silueta1.remove(0);
                    silueta2.remove(0);
                }
            }
            while (!silueta1.isEmpty()){
                    aux = silueta1.get(0);
                    if(aux.altura != alturaPrevia){
                        Silueta.add(aux);
                        alturaPrevia = aux.altura;
                    }
                    silueta1.remove(0);
            }
            while (!silueta2.isEmpty()){
                    aux= silueta2.get(0);
                    if(aux.altura != alturaPrevia){
                        Silueta.add(aux);
                        alturaPrevia = aux.altura;
                    }
                    silueta2.remove(0);
            }
            
        }
    }
    
    public static void main (String [] args){
        
        ArrayList <Edificio> Edificios = new ArrayList <Edificio>();
        ArrayList <Imagen> SiluetaSkyline = new ArrayList <Imagen>();
        
        // Primera linea tiene que se el numero de edificios.
        @SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
        String leer = entrada.nextLine();
        int numeroEdificio = Integer.parseInt(leer);
        
        for ( int i=0; i<numeroEdificio; i++){ // Los edificios representados por 3 variables, separadas por hueco en blanco. Luego salto de linea
                leer = entrada.nextLine();
                String argumentoEdificio[] = leer.split(" "); // Los separa por el huevo en blanco.
                
                int x = Integer.parseInt(argumentoEdificio[0]);
                int y = Integer.parseInt(argumentoEdificio[1]);
                int altura = Integer.parseInt(argumentoEdificio[2]);
                
                Edificio Edificio = new Edificio(x, y, altura); // Almaceno todos los edificios con sus variables respectivamente.
                Edificios.add(Edificio);
        
        }
        
        // Inicializo el algoritmo...
        
        AlgoritmoSkyline algortimo = new AlgoritmoSkyline();
        algortimo.Algoritmo_Skyline(Edificios, SiluetaSkyline);
        
        // Hacer a salidad... Recorrer SiluetaSkyline.
        System.out.println();
        
        for(int i=0; i< SiluetaSkyline.size(); i++){
              Imagen figura = SiluetaSkyline.get(i); // Recorro la silueta que me ha sacado el algoritmo
              System.out.println(figura.x+" "+figura.altura); // Los muestre con un hueco en blanco de por medio.
        }
    }
}
