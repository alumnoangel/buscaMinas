package es.angelhuesovecina.buscaminas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TableroView extends GridPane {
    
    public TableroView(Tablero tablero){
        this.setStyle("-fx-grid-lines-visible: true");
        for(int y=0; y<tablero.filas; y++){
            for(int x=0; x<tablero.filas; x++){
                int num = tablero.getPosTablero(x, y);
                String strNum = String.valueOf(num);
                Label label = new Label(strNum);
                label.setPrefWidth(80);
                label.setPrefHeight(60);
                label.setAlignment(Pos.CENTER);
                this.add(label, x, y);
                Rectangle r = new Rectangle();
                r.setWidth(80);
                r.setHeight(60);
                r.setFill(Color.GRAY);
                this.add(r, x, y);
            }
        }
        this.setMaxWidth(80*9);
        this.setMaxHeight(60*tablero.columnas);
    }
    
}
