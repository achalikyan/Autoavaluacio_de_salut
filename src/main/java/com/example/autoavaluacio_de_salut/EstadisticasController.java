package com.example.autoavaluacio_de_salut;


import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
    @FXML
    private BarChart<String, Number> estadoAnimoChart;


    private Estadistiques estadisticas = new Estadistiques(); // Suponiendo que tengas un objeto Estadisticas

    public void initialize() {
        actualizarEtiquetas();
        // Configurar el gráfico de barras
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        estadoAnimoChart.setTitle("Estado de Ánimo");
        xAxis.setLabel("Categoría");
        yAxis.setLabel("Cantidad de Días");

        // Crear una serie de datos para el gráfico
        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
        dataSeries.setName("Estado de Ánimo");

// Obtener los datos del estado de ánimo y agregarlos a la serie de datos
        int[] cantidadPorEstado = obtenerCantidadPorEstado();
        dataSeries.getData().add(new XYChart.Data<>("Muy mal", cantidadPorEstado[0]));
        dataSeries.getData().add(new XYChart.Data<>("Mal", cantidadPorEstado[1]));
        dataSeries.getData().add(new XYChart.Data<>("Neutral", cantidadPorEstado[2]));
        dataSeries.getData().add(new XYChart.Data<>("Bien", cantidadPorEstado[3]));
        dataSeries.getData().add(new XYChart.Data<>("Muy bien", cantidadPorEstado[4]));

// Agregar la serie de datos al gráfico
        estadoAnimoChart.getData().add(dataSeries);

    }

    // Método para obtener la cantidad de días por cada estado de ánimo
    private int[] obtenerCantidadPorEstado() {
        int[] cantidadPorEstado = new int[5]; // 5 estados de ánimo: muy mal, mal, neutral, bien, muy bien

        // Iterar sobre los datos y contar la cantidad de días por cada estado de ánimo
        for (Dato dato : estadisticas.datos) {
            int estadoAnimo = dato.estado_de_animo;
            cantidadPorEstado[estadoAnimo - 1]++; // Los estados van de 1 a 5, mientras que el array va de 0 a 4
        }

        return cantidadPorEstado;
    }


    // Método para actualizar el texto de las etiquetas con los datos de estadísticas
    private void actualizarEtiquetas() {
        cantidadDiasLabel.setText("Quantitat de dies introduïts: " + estadisticas.getCantidadDias());
        mediaEstadoAnimoLabel.setText("Mitjana de l'estat d'ànim: " + estadisticas.getMediaEstadoAnimo());
        mediaEstadoFisicoLabel.setText("Mitjana de l'estat físic: " + estadisticas.getMediaEstadoFisico());
        comidaBebidaMasConsumidaLabel.setText("Menjar y beguda més consumida: " + estadisticas.getComidaBebidaMasConsumida());
        diasMejorEstadoAnimoLabel.setText("Dies amb millor estat d'ànim: " + estadisticas.getDiasMejorEstadoAnimo());
        diasMejorEstadoFisicoLabel.setText("Dies amb millor estat físic: " + estadisticas.getDiasMejorEstadoFisico());
    }

}
