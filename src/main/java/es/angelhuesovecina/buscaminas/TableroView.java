package es.angelhuesovecina.buscaminas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * Creacion del TableroView
 * @author Angel
 */
public class TableroView extends GridPane {
    // Creacion de variables
    Tablero tablero;
    public BotonReinicio botonReinicio;
    Rectangle rec = new Rectangle();
    Rectangle [][] rectangulos = new Rectangle[8][8];
    boolean vivo = true;
    boolean ganado = false;
    int clicColum;
    int clicFila;
    int numComprobacion;
    int casillaDestapada;
    int numMinas = 10;
    final int ANCHO = 80;
    final int LARGO = 54;
    /**
     * 
     * @param tablero 
     */
    public TableroView(Tablero tablero){
        this.tablero = tablero;
        this.reinicioVista();
    }
    /**
     * Metodo para ejercutar los clics del ratón
     */
    private void controlRaton() {
            this.setOnMouseClicked((MouseEvent mouseEvent) -> {
                //Acciones con el boton izquiero del ratón
                if(mouseEvent.getButton() == MouseButton.PRIMARY){
                    if(vivo == true){
                        clicColum = (int)(mouseEvent.getX() / ANCHO);
                        clicFila = (int)(mouseEvent.getY() / LARGO);
                        destapadoCasillas(clicColum, clicFila);
                        partidaGanada();
                    }
                }
                // Acciones con el boton derecho del ratón
                if(mouseEvent.getButton() == MouseButton.SECONDARY){
                   if (vivo == true){
                       clicColum = (int)(mouseEvent.getX() / ANCHO);
                       clicFila = (int)(mouseEvent.getY() / LARGO);
                       marcarCasilla(clicColum, clicFila);
                   } 
                }
            });
    }
    /**
     * Metodo para marcar y desmarcar las casillas de color rojo
     * @param clicColum
     * @param clicFila 
     */
    private void marcarCasilla (int clicColum, int clicFila){
        if (ganado == false){
            // Marcar casillas
            if (tablero.control[clicColum][clicFila] == 0){
                tablero.control[clicColum][clicFila] = 2;
                rectangulos[clicColum][clicFila].setFill(Color.RED);  
            }
            // Desmarcar casillas
            else if (tablero.control[clicColum][clicFila] == 2){
                tablero.control[clicColum][clicFila] = 0;
                rectangulos[clicColum][clicFila].setFill(Color.CADETBLUE);
            }
        }
    }
    /**
     * Metodo para volver invisibles los rectangulos de las casillas y los de 
     * su alrededor siempre que este sea 0
     * @param clicColum
     * @param clicFila 
     */
    private void destapadoCasillas (int clicColum, int clicFila){
        if (tablero.control[clicColum][clicFila] == 0){
            // Contador de casillas destapadas
            casillaDestapada ++;
            numComprobacion = tablero.getPosTablero(clicColum, clicFila);
            // Volver los rectangulos invisibles
            rectangulos[clicColum][clicFila].setVisible(false);
            tablero.control[clicColum][clicFila] = 1;
            if (numComprobacion == 9){
                vivo = false;
            }
                /**
                 * Si la casilla destapada es 0 destapar las casillas de alrededor
                 * de esta, si alguna de las de su alrededor tambien fuese 0 destapar
                 * tambien las casillas de alredor de estas ultimas
                 */
                if (numComprobacion == 0){
                    try{
                        if (tablero.control[clicColum + 1][clicFila + 1] == 0){
                            rectangulos[clicColum + 1][clicFila + 1].setVisible(false);
                            destapadoCasillas(clicColum + 1, clicFila + 1);
                        }
                    }catch (Exception ex) {}
                    try{
                        if (tablero.control[clicColum][clicFila + 1] == 0){
                            rectangulos[clicColum][clicFila + 1].setVisible(false);
                            destapadoCasillas(clicColum, clicFila + 1);
                        }
                    }catch (Exception ex) {}
                    try{
                        if (tablero.control[clicColum + 1][clicFila] == 0){
                            rectangulos[clicColum + 1][clicFila].setVisible(false);
                            destapadoCasillas(clicColum + 1, clicFila);
                        }
                    }catch (Exception ex) {}
                    try{
                        if (tablero.control[clicColum - 1][clicFila - 1] == 0){
                            rectangulos[clicColum - 1][clicFila - 1].setVisible(false);
                            destapadoCasillas(clicColum - 1, clicFila - 1);
                        }
                    }catch (Exception ex) {}
                    try{
                        if (tablero.control[clicColum - 1][clicFila] == 0){
                            rectangulos[clicColum - 1][clicFila].setVisible(false);
                            destapadoCasillas(clicColum - 1, clicFila);
                        }
                    }catch (Exception ex) {}
                    try{
                        if (tablero.control[clicColum][clicFila - 1] == 0){
                            rectangulos[clicColum][clicFila - 1].setVisible(false);
                            destapadoCasillas(clicColum, clicFila - 1);
                        }
                    }catch (Exception ex) {}
                    try{
                        if (tablero.control[clicColum + 1][clicFila - 1] == 0){
                            rectangulos[clicColum + 1][clicFila - 1].setVisible(false);
                            destapadoCasillas(clicColum + 1, clicFila - 1);
                        }
                    }catch (Exception ex) {}
                    try{
                        if (tablero.control[clicColum - 1][clicFila + 1] == 0){
                            rectangulos[clicColum - 1][clicFila + 1].setVisible(false);
                            destapadoCasillas(clicColum - 1, clicFila + 1);
                        }
                    }catch (Exception ex) {}
                }
            destaparMinasMuerto();
        } 
    }
    /**
     * Metodo para controlar la muerte del jugador
     */
    private void destaparMinasMuerto(){
        if (vivo == false){
            botonReinicio.boton.setFill(Color.RED);
            /** Una vez muerto recorrer el array y destapar todas las casillas que
             * tengan un valor 9 (mina)
             */
            for(int y=0; y<tablero.FILAS; y++){
                for(int x=0; x<tablero.COLUMNAS; x++){
                    if (tablero.getPosTablero(x, y) == 9){
                    rectangulos[x][y].setVisible(false);
                    }
                }
            }
        }
    }
    /**
     * Metodo para controlar que el jugador ha ganado la partida
     */
    public void partidaGanada(){
        // Comprobacion de que se ha ganado la partida
        if (casillaDestapada >= (tablero.FILAS * tablero.COLUMNAS) - numMinas){
            ganado = true;
            botonReinicio.boton.setFill(Color.GREEN);
            System.out.println("Has GANADO");
        }
    }
    /**
     * Metodo para reiniciar la vista del tablero una vez se ha pulsado el boton
     */
    public void reinicioVista(){
        // Volver todo al valor por "defecto"
        this.getChildren().clear();
        ganado = false;
        casillaDestapada = 0;
        numComprobacion = 0;
        vivo = true;
        this.setStyle("-fx-grid-lines-visible: false");
        // Recorer el array para la creacion de la vista del tablero
        for(int y=0; y<tablero.FILAS; y++){
            for(int x=0; x<tablero.COLUMNAS; x++){
                int num = tablero.getPosTablero(x, y);
                String strNum = String.valueOf(num);
                Label numTablero = new Label(strNum);
                numTablero.setPrefWidth(ANCHO);
                numTablero.setPrefHeight(LARGO);
                numTablero.setAlignment(Pos.CENTER);
                this.add(numTablero, x, y);
                rec = new Rectangle();
                rectangulos[x][y] = rec;
                rec.setWidth(ANCHO);
                rec.setHeight(LARGO);
                rec.setFill(Color.CADETBLUE);
                this.add(rec, x, y);  
            }
        }
        this.setStyle("-fx-grid-lines-visible: true");
        this.setMaxWidth(ANCHO*tablero.FILAS);
        this.setMaxHeight(LARGO*tablero.COLUMNAS);
        this.controlRaton();
    }
}
