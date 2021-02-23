
package es.angelhuesovecina.buscaminas;

import java.util.Random;

public class Tablero {
    int [][] minas;
    int numPistas;
    int xMina;
    int yMina;
    int filas = 8;
    int columnas = 8;
    
    //Generacion de minas
    public void generarMinas (int minasGeneradas){
        
        minas = new int[filas][columnas];
        //Bucle para generar minas aleatorias
        for(int i=0; i<minasGeneradas; i++){
            do{
                xMina = getNumeroAleatorio(1,6);
                yMina = getNumeroAleatorio(1,6);
                System.out.println("x = " + xMina + "  y= " + yMina);
                //Bucle para que las minas no se pisen
            }while (minas[xMina][yMina] == 9); 
                minas[xMina][yMina] = 9;
            //generacionDePistas();
        }
        actualizarNumeroMinasCercanas();
        mostrarPorConsola(); 
    } 
    
   public void actualizarNumeroMinasCercanas(){
        for(int y=0; y<filas; y++){
            for(int x=0; x<columnas; x++){
                if (minas[x][y]== 9 && minas[x+1][y] != 9){
                    minas[x+1][y]++;
                }
                if (minas[x][y]== 9 && minas[x-1][y] != 9){
                    minas[x-1][y]++;
                }
                if (minas[x][y]== 9 && minas[x+1][y+1] != 9){
                    minas[x+1][y+1]++;
                }
                if (minas[x][y]== 9 && minas[x-1][y-1] != 9){
                    minas[x-1][y-1]++;
                }
                if (minas[x][y]== 9 && minas[x][y+1] != 9){
                    minas[x][y+1]++;
                }
                if (minas[x][y]== 9 && minas[x][y-1] != 9){
                    minas[x][y-1]++;
                }
                if (minas[x][y]== 9 && minas[x+1][y-1] != 9){
                    minas[x+1][y-1]++;
                }
                if (minas[x][y]== 9 && minas[x-1][y+1] != 9){
                    minas[x-1][y+1]++;
                }
            }
        }
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
        for(int y=0; y<filas; y++){
            //Creacion columnas
            for(int x=0; x<columnas; x++){
                //Mostrar en consola
                System.out.print(minas [x][y] + " ");
            }
            System.out.println();
        }
    }
}


