package com.example.autoavaluacio_de_salut;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button Agregar;

    @FXML
    private void Agregar(ActionEvent event) {
        // Cargar la escena de Agregar.fxml
        loadFXMLScene("Agregar.fxml");
    }

    @FXML
    private void viewStatsAction(ActionEvent event) {
        // Aquí puedes implementar la lógica para ver estadísticas
        loadFXMLScene("Estadistiques.fxml");
    }

    private void loadFXMLScene(String fxmlFileName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
