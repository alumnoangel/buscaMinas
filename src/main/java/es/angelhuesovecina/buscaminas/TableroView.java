package es.angelhuesovecina.buscaminas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
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
                if(vivo == true){
                    clicColum = (int)(mouseEvent.getX() / 80);
                    clicFila = (int)(mouseEvent.getY() / 60);
                    destapadoCasillas(clicFila, clicColum);
                }
                
            }); 
    }
    
    private void destapadoCasillas (int clicFila, int clicColum){
        numComprobacion = tablero.getPosTablero(clicColum, clicFila);
        rectangulos[clicColum][clicFila].setVisible(false);
        if (numComprobacion == 9){
            vivo = false;
        }
        if (numComprobacion == 0){
            try{
                rectangulos[clicColum + 1][clicFila + 1].setVisible(false);
                destapadoCasillas(clicColum + 1, clicColum + 1);
            }catch (Exception ex) {}
            try{
                rectangulos[clicColum][clicFila + 1].setVisible(false);
                destapadoCasillas(clicColum, clicColum + 1);
            }catch (Exception ex) {}
            try{
                rectangulos[clicColum + 1][clicFila].setVisible(false);
                destapadoCasillas(clicColum + 1, clicColum);
            }catch (Exception ex) {}
            try{
                rectangulos[clicColum - 1][clicFila - 1].setVisible(false);
                destapadoCasillas(clicColum - 1, clicColum - 1);
            }catch (Exception ex) {}
            try{
                rectangulos[clicColum - 1][clicFila].setVisible(false);
                destapadoCasillas(clicColum - 1, clicColum);
            }catch (Exception ex) {}
            try{
                rectangulos[clicColum][clicFila - 1].setVisible(false);
                destapadoCasillas(clicColum, clicColum - 1);
            }catch (Exception ex) {}
            try{
                rectangulos[clicColum + 1][clicFila - 1].setVisible(false);
                destapadoCasillas(clicColum + 1, clicColum - 1);
            }catch (Exception ex) {}
            try{
                rectangulos[clicColum - 1][clicFila + 1].setVisible(false);
                destapadoCasillas(clicColum - 1, clicColum + 1);
            }catch (Exception ex) {}
        }
    }
    
    
}
