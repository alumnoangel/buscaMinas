package es.angelhuesovecina.buscaminas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Pane paneRoot = new Pane();
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Tablero tablero = new Tablero();
        tablero.generarMinas(10);
        
    }

    public static void main(String[] args) {
        launch();
    }

}