package com.example.autoavaluacio_de_salut;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Agregar {


    public CheckBox checkBoxLeche;
    public CheckBox checkBoxCereales;
    public CheckBox checkBoxPasta;
    public CheckBox checkBoxFruta;
    public CheckBox checkBoxVegetales;
    public CheckBox checkBoxLegumbres;
    public CheckBox checkBoxAgua;
    public CheckBox checkBoxAlcohol;
    public CheckBox checkBoxZumo;
    @FXML private ComboBox<Integer> estado_de_animo;
    @FXML private ComboBox<Integer> estado_fisico;
    @FXML private ComboBox<String> Fase_del_dia;

    @FXML private SplitMenuButton faseDelDiaSplitMenuButton;

    public void initialize() {

    }

    public void guardar_datos(ActionEvent actionEvent) {
        int estadoDeAnimoValue = (int) estado_de_animo.getValue();
        int estadoFisicoValue = (int) estado_fisico.getValue();
        String faseDelDiaValue = (String) Fase_del_dia.getValue();

        boolean lleit = checkBoxLeche.isSelected();
        boolean cereals = checkBoxCereales.isSelected();
        boolean pasta = checkBoxPasta.isSelected();
        boolean fruta = checkBoxFruta.isSelected();
        boolean vegetals = checkBoxVegetales.isSelected();
        boolean llegums = checkBoxLegumbres.isSelected();
        boolean aigua = checkBoxAgua.isSelected();
        boolean alcohol = checkBoxAlcohol.isSelected();
        boolean sucs = checkBoxZumo.isSelected();

        Dato dato = new Dato(estadoDeAnimoValue, estadoFisicoValue, lleit, cereals, pasta, fruta, vegetals, llegums, aigua, alcohol, sucs, faseDelDiaValue);

        guardarObjeto(dato);
    }

    public static void guardarObjeto(Dato dato) {
        try (FileOutputStream fileOut = new FileOutputStream(".//datos.txt", true);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(dato);
            System.out.println("Objeto Dato guardado correctamente en " + ".//datos.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
