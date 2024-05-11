package com.example.autoavaluacio_de_salut;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        ArrayList<String> fechasContadas = new ArrayList<>();
        int dias = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        for(int i = 0;i < datos.size();i++){
            if(!fechasContadas.contains(formato.format(datos.get(i).fecha)))
            {
                fechasContadas.add(formato.format(datos.get(i).fecha));
                dias++;
            }
        }
        return dias;
    }

    public String getMediaEstadoAnimo() {
        int totalAnimo = 0;
        for (Dato dato : datos) {
            totalAnimo += dato.estado_de_animo;
        }
        DecimalFormat formato = new DecimalFormat("#.##");
        return formato.format((float)totalAnimo / datos.size());
    }

    public String getMediaEstadoFisico() {
        int totalFisico = 0;
        for (Dato dato : datos) {
            totalFisico += dato.estado_fisico;
        }
        DecimalFormat formato = new DecimalFormat("#.##");
        return formato.format((float)totalFisico / datos.size());
    }

    public String getComidaBebidaMasConsumida() {
        int cereals = 0;
        int pasta = 0;
        int fruta = 0;
        int vegetals = 0;
        int llegums = 0;

        int lleit = 0;
        int aigua = 0;
        int alcohol = 0;
        int sucs = 0;

        String liquido_mas_consumida = "";
        String comida_mas_consumida = "";

        for (Dato dato : datos) {
            cereals += bool_parse(dato.cereals);
            pasta += bool_parse(dato.pasta);
            fruta += bool_parse(dato.fruta);
            vegetals += bool_parse(dato.vegetals);
            llegums += bool_parse(dato.llegums);

            lleit += bool_parse(dato.lleit);
            aigua += bool_parse(dato.aigua);
            alcohol += bool_parse(dato.alcohol);
            sucs += bool_parse(dato.sucs);
        }

        if (cereals == 0){
            cereals = -100;
        }
        if (pasta == 0){
            pasta = -100;
        }
        if (fruta == 0){
            fruta = -100;
        }
        if (vegetals == 0){
            vegetals = -100;
        }
        if (llegums == 0){
            llegums = -100;
        }

        if (lleit == 0){
            lleit = -100;
        }
        if (aigua == 0){
            aigua = -100;
        }
        if (alcohol == 0){
            alcohol = -100;
        }
        if (sucs == 0){
            sucs = -100;
        }

        if(lleit >= aigua && lleit >= alcohol && lleit >= sucs){
            liquido_mas_consumida = "Lleit";
        }else if(aigua >= lleit && aigua >= alcohol && aigua >= sucs){
            liquido_mas_consumida = "Aigua";
        }else if(alcohol >= aigua && alcohol >= sucs){
            liquido_mas_consumida = "Alcohol";
        }else if (sucs >= aigua && sucs >= alcohol){
            liquido_mas_consumida = "Sucs";
        }
        if (lleit + aigua + alcohol + sucs == -400){
            liquido_mas_consumida = "null";
        }

        if(cereals >= pasta && cereals >= fruta && cereals >= vegetals && cereals >= llegums){
            comida_mas_consumida = "Cereals";
        } else if (pasta >= cereals && pasta >= fruta && pasta >= vegetals && pasta >= llegums) {
            comida_mas_consumida = "Pasta";
        } else if (fruta >= cereals && fruta >= pasta && fruta >= vegetals && fruta >= llegums) {
            comida_mas_consumida = "Fruta";
        } else if (vegetals >= cereals && vegetals >= pasta && vegetals >= fruta && vegetals >= llegums) {
            comida_mas_consumida = "Vegetals";
        } else if (llegums >= fruta){
            comida_mas_consumida = "Llegums";
        }
        if (cereals + pasta + fruta + vegetals + llegums == -500){
            comida_mas_consumida = "null";
        }

        return comida_mas_consumida + " y " + liquido_mas_consumida;
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

    public static int bool_parse(boolean bool) {
        int res = 0;
        if (bool) {
            res = 1;
        }
        return res;
    }

}