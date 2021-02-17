
package es.angelhuesovecina.buscaminas;

import java.util.Random;

/**
 *
 * @author Angel
 */

public class Tablero {
    int [][] numsTablero;
    int numeroMinas;
    int xMinaPrueba;
    int yMinaPrueba;
    
    public void generar() {
        numsTablero = new int[6][6];
        xMinaPrueba = generarMinasX (1, 5);
        yMinaPrueba = generarMinasY (1, 5);
        numsTablero [xMinaPrueba][yMinaPrueba] = 9;
        this.mostrarPorConsola();    
    }
    
    public void mostrarPorConsola(){
        for (int y=0; y<6; y++){
            for(int x=0; x<6; x++){
                System.out.print(numsTablero[x][y]+" ");
            }
            System.out.println();
        }  
        System.out.println("xMina "+ xMinaPrueba);
        System.out.println("yMina "+ yMinaPrueba);
    }
    
    public int generarMinasX(int min, int max){
        int minasGeneradasX = 0;
        Random xMinaRandom = new Random();
        while (minasGeneradasX != 5){
          xMinaPrueba = xMinaRandom.nextInt(max-min+1) + 1;
          minasGeneradasX ++;
        }
        return xMinaPrueba;
        
    }
    public int generarMinasY(int min, int max){
        int minasGeneradasY = 0;
        Random yMinaRandom = new Random();
        while (minasGeneradasY != 5){
          yMinaPrueba = yMinaRandom.nextInt(max-min+1) + 1;
          minasGeneradasY ++;
        }
        return yMinaPrueba;
    }
}
