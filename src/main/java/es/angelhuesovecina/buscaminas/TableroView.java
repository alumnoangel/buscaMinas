package es.angelhuesovecina.buscaminas;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TableroView extends GridPane {
    
    public TableroView(Tablero tablero){
        for(int y=0; y<tablero.filas; y++){
            for(int x=0; x<tablero.filas; x++){
                int num = tablero.getPosTablero(x, y);
                String strNum = String.valueOf(num);
                Label label = new Label(strNum);
                this.add(label, x, y);
            }
        }      
    }
    
}
