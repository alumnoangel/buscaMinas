
package es.angelhuesovecina.buscaminas;

import java.util.Random;

/**
 *
 * @author Angel
 */

public class Tablero {
    int [][] numsTablero;
    int xMina;
    int yMina;
    
    public void generar() {
        numsTablero = new int[5][5];
        xMina = getXMinaAleatoria (0, 5);
        yMina = getYMinaAleatoria (0, 4);
        numsTablero [xMina][yMina] = 9;
        this.mostrarPorConsola();  
        
    }
    
    public void mostrarPorConsola(){
        for (int y=0; y<5; y++){
            for(int x=0; x<5; x++){
                System.out.print(numsTablero[x][y]+" ");
            }
            System.out.println();
        }  
        System.out.println("xMina "+ xMina);
        System.out.println("yMina "+ yMina);
    }
    
    public int getXMinaAleatoria(int min, int max) {
        Random xMinaRandom = new Random();
        xMina = xMinaRandom.nextInt(max-min+1) + 1;
        return xMina;
    }
    public int getYMinaAleatoria(int min, int max) {
        Random yMinaRandom = new Random();
        yMina = yMinaRandom.nextInt(max-min+1) + min;
        return yMina;
    }
}
