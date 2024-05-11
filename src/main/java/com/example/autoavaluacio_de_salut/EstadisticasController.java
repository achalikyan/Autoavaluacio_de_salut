package com.example.autoavaluacio_de_salut;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

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

    private Estadistiques estadisticas; // Suponiendo que tengas un objeto Estadisticas

    // Método para inicializar los datos de las estadísticas
    public void initData(Estadistiques estadisticas) {
        this.estadisticas = estadisticas;
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
