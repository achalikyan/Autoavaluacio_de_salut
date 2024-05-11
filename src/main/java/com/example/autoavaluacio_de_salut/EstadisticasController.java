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

    private Estadistiques estadisticas; // Suponiendo que tengas un objeto Estadisticas
    ArrayList<Dato> datos = new ArrayList<Dato>();


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




    public void cargarObjetos() {
        try (FileInputStream fileIn = new FileInputStream(".//datos.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Object objeto;
            while ((objeto = objectIn.readObject()) != null) {
                // Verificar si el objeto es de tipo Dato
                if (objeto instanceof Dato) {
                    // Procesar el objeto Dato leído
                    Dato dato = (Dato) objeto;
                    datos.add(dato);
                }
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
