/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Raul
 */
public class Estudiante {
    
    private String carnet;
    private String nombre;
    private int edad;
    private static String[] etiquetas = {"Carnet", "Nombre", "Edad"};

    public Estudiante(String carnet, String nombre, int edad) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    /**
     * **********************************Tablas
     * dinamicas*****************************
     */
    public static String[] getEtiquetas() {
        return etiquetas;
    }

    public String getAtributo(int numeroAtributo) {
        switch (numeroAtributo) {
            case 0:
                return carnet;
            case 1:
                return nombre;
            case 2:
                return Integer.toString(edad);
            default:
                return null;
        }
    }

    public static int getNumeroAtributos() {
        return etiquetas.length;
    }

    /**
     * *********************************************************************
     */
    
    
}
