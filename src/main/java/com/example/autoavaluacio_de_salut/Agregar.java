package com.example.autoavaluacio_de_salut;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

public class Agregar {

    @FXML private CheckBox lecheCheckbox;
    @FXML private CheckBox cerealesCheckbox;
    @FXML private CheckBox pastaCheckbox;
    @FXML private CheckBox frutaCheckbox;
    @FXML private CheckBox vegetalesCheckbox;
    @FXML private CheckBox legumbresCheckbox;
    @FXML private CheckBox aguaCheckbox;
    @FXML private CheckBox zumoCheckbox;

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
        boolean lleit = lecheCheckbox.isSelected();
        boolean cereals = cerealesCheckbox.isSelected();
        boolean pasta = pastaCheckbox.isSelected();
        boolean fruta = frutaCheckbox.isSelected();
        boolean vegetals = vegetalesCheckbox.isSelected();
        boolean llegums = legumbresCheckbox.isSelected();
        boolean aigua = aguaCheckbox.isSelected();
        boolean alcohol = zumoCheckbox.isSelected();
        boolean sucs = zumoCheckbox.isSelected();

        Dato dato = new Dato(estadoDeAnimoValue,estadoFisicoValue,lleit,cereals,pasta,fruta,vegetals,llegums,aigua,alcohol,sucs,faseDelDiaValue);
        System.out.print(dato);
    }
}
