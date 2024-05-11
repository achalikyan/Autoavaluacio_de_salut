package com.example.autoavaluacio_de_salut;

import javafx.event.ActionEvent;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estadistiques {
    private int cantidadDias;
    private double mediaEstadoAnimo;
    private double mediaEstadoFisico;
    private String comidaBebidaMasConsumida;
    private int diasMejorEstadoAnimo;
    private int diasMejorEstadoFisico;

    List<Dato> datos;

    public Estadistiques() {
        datos = cargarObjetos();
    }

    public int getCantidadDias() {
        Date date = new Date();
        int dias = 0;
        for(int i = 0;i < datos.size();i++){
            if (datos.get(i).fecha != date){
                date = datos.get(i).fecha;
                dias++;
            }
        }
        return cantidadDias;
    }

    public double getMediaEstadoAnimo() {
        return mediaEstadoAnimo;
    }

    public double getMediaEstadoFisico() {
        return mediaEstadoFisico;
    }

    public String getComidaBebidaMasConsumida() {
        return comidaBebidaMasConsumida;
    }

    public int getDiasMejorEstadoAnimo() {
        return diasMejorEstadoAnimo;
    }


    public int getDiasMejorEstadoFisico() {
        return diasMejorEstadoFisico;
    }


    public static List<Dato> cargarObjetos() {
        List<Dato> listaDatos = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(".//datos.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Object objeto = objectIn.readObject();
            // Verificar si el objeto es una lista de Dato
            if (objeto instanceof List) {
                listaDatos = (List<Dato>) objeto;
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaDatos;
    }
}
