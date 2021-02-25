package es.angelhuesovecina.buscaminas;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TableroView extends GridPane {
    
    public TableroView(Tablero tablero){
        int num=tablero.minas(0, 0);
        Label label = new Label(num);
        this.add(label, 0, 0);    
    }
    
}
