package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.utils.SceneManager;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Initialisation du gestionnaire de scène
            SceneManager.setPrimaryStage(primaryStage);

            // Charger et afficher le premier écran (importMembres.fxml)
            SceneManager.loadScene("importMembres", "/importMembres.fxml");

            primaryStage.setTitle("Gestion des Membres");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
