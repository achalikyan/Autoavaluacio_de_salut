package com.example.autoavaluacio_de_salut;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class EstadisticasController {
    @FXML
    private Label cantidadDiasLabel;

    @FXML
    private Label mediaEstadoAnimoLabel;

    @FXML
    private Label mediaEstadoFisicoLabel;

    @FXML
    private Label comidaBebidaMasConsumidaLabel;

    @FXML
    private Label diasMejorEstadoAnimoLabel;

    @FXML
    private Label diasMejorEstadoFisicoLabel;

    private Estadistiques estadisticas = new Estadistiques(); // Suponiendo que tengas un objeto Estadisticas

    public void initialize() {
        actualizarEtiquetas();
    }

    // Método para actualizar el texto de las etiquetas con los datos de estadísticas
    private void actualizarEtiquetas() {
        cantidadDiasLabel.setText("Quantitat de dies introduïts: " + estadisticas.getCantidadDias());
        mediaEstadoAnimoLabel.setText("Mitjana de l'estat d'ànim: " + estadisticas.getMediaEstadoAnimo());
        mediaEstadoFisicoLabel.setText("Mitjana de l'estat físic: " + estadisticas.getMediaEstadoFisico());
        comidaBebidaMasConsumidaLabel.setText("Menjar o beguda més consumida: " + estadisticas.getComidaBebidaMasConsumida());
        diasMejorEstadoAnimoLabel.setText("Dies amb millor estat d'ànim: " + estadisticas.getDiasMejorEstadoAnimo());
        diasMejorEstadoFisicoLabel.setText("Dies amb millor estat físic: " + estadisticas.getDiasMejorEstadoFisico());
    }

}
