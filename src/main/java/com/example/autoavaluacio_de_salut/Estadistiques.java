package com.example.autoavaluacio_de_salut;

import javafx.event.ActionEvent;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;

public class Estadistiques {
    private int cantidadDias;
    private double mediaEstadoAnimo;
    private double mediaEstadoFisico;
    private String comidaBebidaMasConsumida;
    private int diasMejorEstadoAnimo;
    private int diasMejorEstadoFisico;

    ArrayList<Dato> datos;
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


    public Estadistiques() {
        datos = new ArrayList<Dato>();
        cargarObjetos();
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

}
