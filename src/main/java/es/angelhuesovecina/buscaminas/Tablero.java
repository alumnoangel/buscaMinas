
package es.angelhuesovecina.buscaminas;

import java.util.Random;


public class Tablero {
    int [][] minas;
    int numPistas;
    int xMina;
    int yMina;
    
    //Generacion de minas
    public void generarMinas (int minasGeneradas){
        
        minas = new int[8][8];
        //Bucle para generar minas aleatorias
        for(int i=0; i<minasGeneradas; i++){
            do{
                xMina = getNumeroAleatorio(0,7);
                yMina = getNumeroAleatorio(0,7);
                System.out.println("x = " + xMina + "  y= " + yMina);
                //Bucle para que las minas no se pisen
            }while (minas[xMina][yMina] != 0); 
                minas[xMina][yMina] = 9;
            generacionDePistas();
        }
        mostrarPorConsola(); 
    } 
    
    public void generacionDePistas(){

            if (minas[xMina+1][yMina]==0){
                minas[xMina+1][yMina]=numPistas;
            }
            if (minas[xMina-1][yMina]==0){
                minas[xMina+1][yMina]=numPistas;
            }
            if (minas[xMina][yMina+1]==0){
                minas[xMina+1][yMina]=numPistas;
            }
            if (minas[xMina][yMina-1]==0){
                minas[xMina+1][yMina]=numPistas;
            }
            if (minas[xMina+1][yMina+1]==0){
                minas[xMina+1][yMina]=numPistas;
            }
            if (minas[xMina-1][yMina-1]==0){
                minas[xMina+1][yMina]=numPistas;
            }
            if (minas[xMina-1][yMina+1]==0){
                minas[xMina+1][yMina]=numPistas;
            }
            if (minas[xMina+1][yMina-1]==0){
                minas[xMina+1][yMina]=numPistas;
            }
    }
    
    public void actualizarNumeroMinasCercanas(){
        for(int y=0; y<8; y++){
            for(int x=0; x<8; x++){
                for(int j = y-1; j<y+1; j++){
                    for(int l = y-1; l<y+1; l++){
                        if(minas [x][y] == 9 && minas [j][l] != 9){
                            numPistas ++;
                        }
                    }
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
