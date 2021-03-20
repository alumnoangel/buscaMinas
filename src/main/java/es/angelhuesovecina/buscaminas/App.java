package es.angelhuesovecina.buscaminas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Angel Hueso Vecina
 * Clase donde inicia la app
 */
public class App extends Application {
    @Override
    /**
     * 
     */
    public void start(Stage stage) {
        //Creacion del escenario principal
        BorderPane paneRoot = new BorderPane();
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        // Creacion del objeto Tablero
        Tablero tablero = new Tablero();
        tablero.generarMinas(10);
        // Creacion del objeto TableroView
        TableroView tableroView = new TableroView(tablero);
        paneRoot.setCenter(tableroView);
        // Creacion del objeto BotonReinicio
        BotonReinicio botonReinicio = new BotonReinicio(tablero, tableroView);
        paneRoot.setTop(botonReinicio);
        
        tableroView.botonReinicio = botonReinicio;
    }
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch();
    }

}