
package es.angelhuesovecina.buscaminas;
import java.util.Random;
/**
 * Creacion del tablero
 * @author Angel
 */
public class Tablero {
    //Variables y constantes de la clase Tablero
    int [][] minas;
    int [][] control;
    int xMina;
    int yMina;
    final int FILAS = 8;
    final int COLUMNAS = 8;
    int minasGeneradas;
    
    /**
     * Generacion de minas
     * @param minasGeneradas 
     */
    public void generarMinas (int minasGeneradas){
        control = new int [FILAS][COLUMNAS];
        minas = new int [FILAS][COLUMNAS];
        //Bucle para generar minas aleatorias
        for(int i=0; i<minasGeneradas; i++){
            do{
                xMina = getNumeroAleatorio(0,7);
                yMina = getNumeroAleatorio(0,7);
                System.out.println("x = " + xMina + "  y= " + yMina);
            //Bucle para que las minas no se pisen
            }while (minas[xMina][yMina] == 9);
                minas[xMina][yMina] = 9;
        }
        actualizarNumeroMinasCercanas();
        mostrarPorConsola(); 
    }

   //Generacion de pistas
    /**
     * Metodo para la creacion de pistas al rededor de las minas
     */
   public void actualizarNumeroMinasCercanas(){
       //Bucle para recorrer el array e ir generando el numero de minas cercanas
        for(int y=0; y<FILAS; y++){
            for(int x=0; x<COLUMNAS; x++){
                try{
                    if (minas[x][y]== 9 && minas[x+1][y] != 9){
                        minas[x+1][y]++;
                    }
                }catch (Exception ex) {}
                try{
                    if (minas[x][y]== 9 && minas[x-1][y] != 9){
                        minas[x-1][y]++;
                    }
                }catch (Exception ex) {}
                try{
                    if (minas[x][y]== 9 && minas[x+1][y+1] != 9){
                        minas[x+1][y+1]++;
                    }
                }catch (Exception ex) {}
                try{
                    if (minas[x][y]== 9 && minas[x-1][y-1] != 9){
                        minas[x-1][y-1]++;
                    }
                }catch (Exception ex) {}
                try{
                    if (minas[x][y]== 9 && minas[x][y+1] != 9){
                        minas[x][y+1]++;
                    }
                }catch (Exception ex) {}
                try{
                    if (minas[x][y]== 9 && minas[x][y-1] != 9){
                        minas[x][y-1]++;
                    }
                }catch (Exception ex) {}
                try{
                    if (minas[x][y]== 9 && minas[x+1][y-1] != 9){
                        minas[x+1][y-1]++;
                    }
                }catch (Exception ex) {}
                try{
                    if (minas[x][y]== 9 && minas[x-1][y+1] != 9){
                        minas[x-1][y+1]++;
                    }
                }catch (Exception ex) {}
            }
        }
    }

   /**
    * Generacion de un numero aleatorio
    * @param min
    * @param max
    * @return 
    */
    public int getNumeroAleatorio(int min, int max){
        Random random = new Random ();
        int num = random.nextInt(max-min+1) + min;
        return num;
     }
    
    /**
     * Mostrar los numeros de la arry por consola
     */
    public void mostrarPorConsola(){
        //Creacion filas
        for(int y=0; y<FILAS; y++){
            //Creacion columnas
            for(int x=0; x<COLUMNAS; x++){
                //Mostrar en consola
                System.out.print(minas [x][y] + " ");
            }
            System.out.println();
        }
    }
    /**
     * Metodo para retornar la posicion de las minas
     * @param posx
     * @param posy
     * @return 
     */
    public int getPosTablero(int posx, int posy) {          
        return minas[posx][posy];
    }
    /**
     * Metodo para la creacion de un array para controlar los clicks realizados
     * en el tablero
     */
    public void controlTablero(){
       for (int yControl=0; yControl<FILAS; yControl++){
          for (int xControl=0; xControl<COLUMNAS; xControl++){
              control[xControl][yControl] = 0;
          } 
       }
    }
}