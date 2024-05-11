package com.example.autoavaluacio_de_salut;

import javafx.event.ActionEvent;

public class Estadistiques {
    private int cantidadDias;
    private double mediaEstadoAnimo;
    private double mediaEstadoFisico;
    private String comidaBebidaMasConsumida;
    private int diasMejorEstadoAnimo;
    private int diasMejorEstadoFisico;

    public Estadistiques(int cantidadDias, double mediaEstadoAnimo, double mediaEstadoFisico, String comidaBebidaMasConsumida, int diasMejorEstadoAnimo, int diasMejorEstadoFisico) {
        this.cantidadDias = cantidadDias;
        this.mediaEstadoAnimo = mediaEstadoAnimo;
        this.mediaEstadoFisico = mediaEstadoFisico;
        this.comidaBebidaMasConsumida = comidaBebidaMasConsumida;
        this.diasMejorEstadoAnimo = diasMejorEstadoAnimo;
        this.diasMejorEstadoFisico = diasMejorEstadoFisico;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public double getMediaEstadoAnimo() {
        return mediaEstadoAnimo;
    }

    public void setMediaEstadoAnimo(double mediaEstadoAnimo) {
        this.mediaEstadoAnimo = mediaEstadoAnimo;
    }

    public double getMediaEstadoFisico() {
        return mediaEstadoFisico;
    }

    public void setMediaEstadoFisico(double mediaEstadoFisico) {
        this.mediaEstadoFisico = mediaEstadoFisico;
    }

    public String getComidaBebidaMasConsumida() {
        return comidaBebidaMasConsumida;
    }

    public void setComidaBebidaMasConsumida(String comidaBebidaMasConsumida) {
        this.comidaBebidaMasConsumida = comidaBebidaMasConsumida;
    }

    public int getDiasMejorEstadoAnimo() {
        return diasMejorEstadoAnimo;
    }

    public void setDiasMejorEstadoAnimo(int diasMejorEstadoAnimo) {
        this.diasMejorEstadoAnimo = diasMejorEstadoAnimo;
    }

    public int getDiasMejorEstadoFisico() {
        return diasMejorEstadoFisico;
    }

    public void setDiasMejorEstadoFisico(int diasMejorEstadoFisico) {
        this.diasMejorEstadoFisico = diasMejorEstadoFisico;
    }
}
