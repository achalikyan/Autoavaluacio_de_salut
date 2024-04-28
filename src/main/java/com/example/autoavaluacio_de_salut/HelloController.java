package com.example.autoavaluacio_de_salut;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private void addDataAction(ActionEvent event) {
        // Aquí puedes implementar la lógica para agregar datos
        System.out.println("Has seleccionado Afegir dades");
    }

    @FXML
    private void viewStatsAction(ActionEvent event) {
        // Aquí puedes implementar la lógica para ver estadísticas
        System.out.println("Has seleccionado Veure estadístiques");
    }
}
