package com.example.autoavaluacio_de_salut;

import javafx.event.ActionEvent;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estadistiques {
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
        String date = "00/00/0000";
        int dias = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        for(int i = 0;i < datos.size();i++){
            if (!formato.format(datos.get(i).fecha).equals(date)){
                date = formato.format(datos.get(i).fecha);
                dias++;
            }
        }
        return dias;
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

    public String getDiasMejorEstadoAnimo() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        List<String> fechasFormateadas = new ArrayList<>();
        for (int i = 0;i < datos.size();i++) {
            if (datos.get(i).estado_de_animo >= 4) {
                String fechaFormateada = formato.format(datos.get(i).fecha);
                fechasFormateadas.add(fechaFormateada);
            }
        }

        // Convertir la lista de cadenas a un array de cadenas
        String fechasConcatenadasanimo = String.join(", ", fechasFormateadas);

        // Imprimir las fechas (opcional)
        for (String fecha : fechasFormateadas) {
            System.out.println(fecha);
        }

        // Devolver la cadena de fechas concatenadas
        return fechasConcatenadasanimo;
    }


    public String getDiasMejorEstadoFisico() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        List<String> fechasFormateadas = new ArrayList<>();
        for (int i = 0;i < datos.size();i++) {
            if (datos.get(i).estado_fisico >= 4) {
                String fechaFormateada = formato.format(datos.get(i).fecha);
                fechasFormateadas.add(fechaFormateada);
            }
        }

        // Convertir la lista de cadenas a un array de cadenas
        String fechasConcatenadas = String.join(", ", fechasFormateadas);

        // Imprimir las fechas (opcional)
        for (String fecha : fechasFormateadas) {
            System.out.println(fecha);
        }

        // Devolver la cadena de fechas concatenadas
        return fechasConcatenadas;

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
