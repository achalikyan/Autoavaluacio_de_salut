package com.example.autoavaluacio_de_salut;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dato {

    int estado_de_animo;
    int estado_fisico;

    boolean lleit;
    boolean cereals;
    boolean pasta;
    boolean fruta;
    boolean vegetals;
    boolean llegums;
    boolean aigua;
    boolean alcohol;
    boolean sucs;

    String fase_del_dia;
    Date fecha;

    public Dato() {
    }

    public Dato(int estado_de_animo, int estado_fisico, boolean lleit, boolean cereals, boolean pasta, boolean fruta, boolean vegetals, boolean llegums, boolean aigua, boolean alcohol, boolean sucs, String fase_del_dia, Date fecha) {
        this.estado_de_animo = estado_de_animo;
        this.estado_fisico = estado_fisico;
        this.lleit = lleit;
        this.cereals = cereals;
        this.pasta = pasta;
        this.fruta = fruta;
        this.vegetals = vegetals;
        this.llegums = llegums;
        this.aigua = aigua;
        this.alcohol = alcohol;
        this.sucs = sucs;
        this.fase_del_dia = fase_del_dia;
        this.fecha = Calendar.getInstance().getTime();
    }


}
