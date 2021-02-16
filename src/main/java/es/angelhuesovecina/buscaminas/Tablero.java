
package es.angelhuesovecina.buscaminas;

/**
 *
 * @author Angel
 */

public class Tablero {
    
    int [][] numsTablero;

    public void generar() {
        numsTablero = new int[5][5];
        for (int y=0; y<5; y++){
            for(int x=0; x<5; x++){
                numsTablero [x][y] = ;
            }
        }
        
        this.mostrarPorConsola();    
    }
    
    public void mostrarPorConsola(){
        for (int y=0; y<5; y++){
            for(int x=0; x<5; x++){
                System.out.print(numsTablero[x][y]+" ");
            }
            System.out.println();
        }    
    }
    
    public int getNumsTablero(int min, int max){
        
    }
    
}
