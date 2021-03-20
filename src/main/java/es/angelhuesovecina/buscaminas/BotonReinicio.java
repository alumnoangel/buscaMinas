package es.angelhuesovecina.buscaminas;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Creacion de la clase BotonReinicio
 * @author Angel
 */
public class BotonReinicio extends HBox {
    Circle boton;
    Tablero tablero;
    /**
     * Metodo del boton de reinicio
     * @param tablero
     * @param tableroView 
     */
    public BotonReinicio(Tablero tablero, TableroView tableroView){
        this.tablero = tablero;
        this.setStyle("-fx-border-color: black");
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        boton = new Circle();
        boton.setOnMouseClicked((MouseEvent mouseEvent) -> {
                if (mouseEvent.getButton() == MouseButton.PRIMARY){
                    boton.setFill(Color.YELLOW);
                    if (tableroView.ganado == true){
                        boton.setFill(Color.YELLOW);
                    }
                    tablero.generarMinas(10);
                    tableroView.reinicioVista();   
                }
                    });
        boton.setFill(Color.YELLOW);
        boton.setRadius(20);
        boton.setStroke(Color.BLACK);
        this.getChildren().add(boton);  
    }
}
