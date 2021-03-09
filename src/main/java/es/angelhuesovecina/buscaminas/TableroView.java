package es.angelhuesovecina.buscaminas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TableroView extends GridPane {
    
    Rectangle rec = new Rectangle();
    
    Rectangle [][] rectangulos = new Rectangle[8][8];
    
    boolean vivo = true;
    int num;
    
    public TableroView(Tablero tablero){
        this.setStyle("-fx-grid-lines-visible: true");
        for(int y=0; y<tablero.filas; y++){
            for(int x=0; x<tablero.filas; x++){
                num = tablero.getPosTablero(x, y);
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
                rec.setFill(Color.GRAY);
                this.add(rec, x, y);
            }
        }
        this.setMaxWidth(80*9);
        this.setMaxHeight(60*tablero.columnas);
        this.controlRaton(tablero);
    }
    private void controlRaton(Tablero tablero) {
            this.setOnMouseClicked((MouseEvent mouseEvent) -> {
                if(vivo == true){
                    int clicColum = (int)(mouseEvent.getX() / 80);
                    int clicFila = (int)(mouseEvent.getY() / 60);
                    num = tablero.getPosTablero(clicColum, clicFila);
                    System.out.println("Numero: " + num);
                    rectangulos[clicColum][clicFila].setVisible(false);
                    if (num == 9){
                        vivo = false;
                    }
                    if (num == 0){
                        try{
                            rectangulos[clicColum + 1][clicFila + 1].setVisible(false);
                        }catch (Exception ex) {}
                        try{
                            rectangulos[clicColum][clicFila + 1].setVisible(false);
                        }catch (Exception ex) {}
                        try{
                            rectangulos[clicColum + 1][clicFila].setVisible(false);
                        }catch (Exception ex) {}
                        try{
                            rectangulos[clicColum - 1][clicFila - 1].setVisible(false);
                        }catch (Exception ex) {}
                        try{
                            rectangulos[clicColum - 1][clicFila].setVisible(false);
                        }catch (Exception ex) {}
                        try{
                            rectangulos[clicColum][clicFila - 1].setVisible(false);
                        }catch (Exception ex) {}
                        try{
                            rectangulos[clicColum + 1][clicFila - 1].setVisible(false);
                        }catch (Exception ex) {}
                        try{
                            rectangulos[clicColum - 1][clicFila + 1].setVisible(false);
                        }catch (Exception ex) {}
                    }
                }
                
            }); 
    }
    
    /** public void RecPrueba (){
        Rectangle rec1 = new Rectangle(80, 60, Color.AQUAMARINE);
        add
    }
    */
}
