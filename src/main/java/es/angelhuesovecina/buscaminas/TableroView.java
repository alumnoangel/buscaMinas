package es.angelhuesovecina.buscaminas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TableroView extends GridPane {
    
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
    
    public TableroView(Tablero tablero){
        this.tablero = tablero;
        this.reinicioVista();
    }
    private void controlRaton() {
            this.setOnMouseClicked((MouseEvent mouseEvent) -> {
                if(mouseEvent.getButton() == MouseButton.PRIMARY){
                    if(vivo == true){
                        clicColum = (int)(mouseEvent.getX() / 80);
                        clicFila = (int)(mouseEvent.getY() / 54);
                        destapadoCasillas(clicColum, clicFila);
                        partidaGanada();
                    }
                }
                if(mouseEvent.getButton() == MouseButton.SECONDARY){
                   if (vivo == true){
                       clicColum = (int)(mouseEvent.getX() / 80);
                       clicFila = (int)(mouseEvent.getY() / 54);
                       marcarCasilla(clicColum, clicFila);
                   } 
                }
            });
    }
    
    private void marcarCasilla (int clicColum, int clicFila){
        if (ganado == false){
            if (tablero.control[clicColum][clicFila] == 0){
                tablero.control[clicColum][clicFila] = 2;
                rectangulos[clicColum][clicFila].setFill(Color.RED);  
            }
            else if (tablero.control[clicColum][clicFila] == 2){
                tablero.control[clicColum][clicFila] = 0;
                rectangulos[clicColum][clicFila].setFill(Color.CADETBLUE);
            }
        }
    }
    
    private void destapadoCasillas (int clicColum, int clicFila){
        if (tablero.control[clicColum][clicFila] == 0){
            casillaDestapada ++;
            numComprobacion = tablero.getPosTablero(clicColum, clicFila);
            rectangulos[clicColum][clicFila].setVisible(false);
            tablero.control[clicColum][clicFila] = 1;
            if (numComprobacion == 9){
                vivo = false;
            }
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
    
    private void destaparMinasMuerto(){
        if (vivo == false){
            for(int y=0; y<tablero.filas; y++){
                for(int x=0; x<tablero.columnas; x++){
                    if (tablero.getPosTablero(x, y) == 9){
                    rectangulos[x][y].setVisible(false);
                    }
                }
            }
        }
    }
    
    public void partidaGanada(){
        if (casillaDestapada >= (tablero.filas * tablero.columnas) - numMinas){
            ganado = true;
            botonReinicio.boton.setFill(Color.GREEN);
            System.out.println("Has GANADO");
        }
    }
    
    public void reinicioVista(){
        this.setStyle("-fx-grid-lines-visible: true");
        for(int y=0; y<tablero.filas; y++){
            for(int x=0; x<tablero.filas; x++){
                int num = tablero.getPosTablero(x, y);
                String strNum = String.valueOf(num);
                Label numTablero = new Label(strNum);
                numTablero.setPrefWidth(80);
                numTablero.setPrefHeight(54);
                numTablero.setAlignment(Pos.CENTER);
                this.add(numTablero, x, y);
                rec = new Rectangle();
                rectangulos[x][y] = rec;
                rec.setWidth(80);
                rec.setHeight(54);
                rec.setFill(Color.CADETBLUE);
                this.add(rec, x, y);
            }
        }
        this.setMaxWidth(80*tablero.filas);
        this.setMaxHeight(54*tablero.columnas);
        this.controlRaton();
    }
}
