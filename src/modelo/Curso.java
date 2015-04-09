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
public class Curso {

    private String nombre;
    private int creditos;
    private String siglas;
    private static String[] etiquetas = {"Siglas", "Nombre", "Creditos"};

    public Curso(String siglas,String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.siglas = siglas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getInformacion() {
        return this.getSiglas() + "\t" + this.getNombre() + "\t" + this.getCreditos();
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
                return siglas;
            case 1:
                return nombre;
            case 2:
                return Integer.toString(creditos);
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
