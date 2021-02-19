
package es.angelhuesovecina.buscaminas;

import java.util.Random;


public class Tablero {
    int [][] minas;
    int numMinasCercanas;
    
    //Generacion de minas
    public void generarMinas (int minasGeneradas){
        
        minas = new int[8][8];
        int xMina;
        int yMina;
        //Bucle para generar minas aleatorias
        for(int i=0; i<minasGeneradas; i++){
            do{
                xMina = getNumeroAleatorio(0,7);
                yMina = getNumeroAleatorio(0,7);
                System.out.println("x = " + xMina + "  y= " + yMina);
                //Bucle para que las minas no se pisen
            }while (minas[xMina][yMina] != 0); 
                minas[xMina][yMina] = 9;
        }  
        mostrarPorConsola(); 
    } 
    
    private void actualizarNumeroMinasCercanas(){
       
    }
    
    //Generar numero aleatorio
    public int getNumeroAleatorio(int min, int max){
        Random random = new Random ();
        int num = random.nextInt(max-min+1) + min;
        return num;
     }
    
    // Muestra los números
    public void mostrarPorConsola(){
        //Creacion filas
        for(int y=0; y<8; y++){
            //Creacion columnas
            for(int x=0; x<8; x++){
                //Mostrar en consola
                System.out.print(minas [x][y] + " ");
            }
            System.out.println();
        }
    }
}
