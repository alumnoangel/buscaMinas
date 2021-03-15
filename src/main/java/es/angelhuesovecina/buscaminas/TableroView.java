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
    Rectangle rec = new Rectangle();
    Rectangle [][] rectangulos = new Rectangle[8][8];
    boolean vivo = true;
    int clicColum;
    int clicFila;
    int numComprobacion;
    
    public TableroView(Tablero tablero){
        this.tablero = tablero;
        this.setStyle("-fx-grid-lines-visible: true");
        for(int y=0; y<tablero.filas; y++){
            for(int x=0; x<tablero.filas; x++){
                int num = tablero.getPosTablero(x, y);
                String strNum = String.valueOf(num);
                Label numTablero = new Label(strNum);
                numTablero.setPrefWidth(80);
                numTablero.setPrefHeight(60);
                numTablero.setAlignment(Pos.CENTER);
                this.add(numTablero, x, y);
                rec = new Rectangle();
                rectangulos[x][y] = rec;
                rec.setWidth(80);
                rec.setHeight(60);
                rec.setFill(Color.CADETBLUE);
                this.add(rec, x, y);
            }
        }
        this.setMaxWidth(80*9);
        this.setMaxHeight(60*tablero.columnas);
        this.controlRaton();
    }
    private void controlRaton() {
            this.setOnMouseClicked((MouseEvent mouseEvent) -> {
                if(mouseEvent.getButton() == MouseButton.PRIMARY){
                    if(vivo == true){
                        clicColum = (int)(mouseEvent.getX() / 80);
                        clicFila = (int)(mouseEvent.getY() / 60);
                        destapadoCasillas(clicColum, clicFila);    
                    }
                }
                if(mouseEvent.getButton() == MouseButton.SECONDARY){
                   if (vivo == true){
                       clicColum = (int)(mouseEvent.getX() / 80);
                       clicFila = (int)(mouseEvent.getY() / 60);
                       marcaCasilla(clicColum, clicFila);
                   } 
                }
            });
    }
    
    private void marcaCasilla (int clicColum, int clicFila){
        if (tablero.control[clicColum][clicFila] == 0){
            tablero.control[clicColum][clicFila] = 2;
            rectangulos[clicColum][clicFila].setFill(Color.RED);  
        }
        else if (tablero.control[clicColum][clicFila] == 2){
            tablero.control[clicColum][clicFila] = 0;
            rectangulos[clicColum][clicFila].setFill(Color.CADETBLUE);
        }
    }
    
    private void destapadoCasillas (int clicColum, int clicFila){
        if (tablero.control[clicColum][clicFila] == 0){
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
        } 
    }
}
