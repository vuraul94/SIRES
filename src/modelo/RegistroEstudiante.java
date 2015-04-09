/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public class RegistroEstudiante {

    ArrayList<Estudiante> listaEstudiante;

    public RegistroEstudiante() {
        listaEstudiante = new ArrayList<Estudiante>();
    }
    

    public String addEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            if (verificarCarnet(estudiante.getCarnet())) {
                listaEstudiante.add(estudiante);
                return "El estudiante fue agregado correctamente";
            } else {
                return "El estudiante se encuentra registrado!";
            }
        }
        return "El objeto estudiante es null";
    }//Fin de addEstudiante

    
    public boolean verificarCarnet(String carnet) {
        if (!carnet.equalsIgnoreCase("")) {
            if (listaEstudiante.size() != 0){
                for (int index = 0; index < listaEstudiante.size(); index++) {
                    if (listaEstudiante.get(index).getCarnet().equals(carnet)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }//Fin de verificar carnet

    public String modEstudiante(Estudiante estudiante, String nombre, int edad) {
        estudiante.setEdad(edad);
        estudiante.setNombre(nombre);
        return "El estudiante ha sido modificado";
    }//Fin de modEstudiante

    public String delEstudiante(Estudiante estudiante) {
        for (int i = 0; i < listaEstudiante.size(); i++) {
            if (listaEstudiante.get(i).getCarnet().equalsIgnoreCase(estudiante.getCarnet())) {
                listaEstudiante.remove(i);
                return "El estudiante ha sido eliminado correctamente!";
            }
        }

        return "El estudiante no ha podido ser eliminado o no existe";
    }//Fin de delEstudiante
    
    public Estudiante consultar(String carnet){
        for (Estudiante estudiante : listaEstudiante) {
            if (estudiante.getCarnet().equalsIgnoreCase(carnet)) {

                return estudiante;
            }
        }
        return null;
    }
    
     public String[][] getMatrizEstudiantes() {
        String[][] matriz = new String[listaEstudiante.size()][Estudiante.getNumeroAtributos()];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = listaEstudiante.get(fila).getAtributo(columna);
            }
        }
        return matriz;
    }

    public String[][] getMatrizBuscar(String datos, int tipoBusqueda) {

        ArrayList<Estudiante> listaBusqueda = new ArrayList<Estudiante>();
        for(int i = 0; i < listaEstudiante.size(); i++) {
            if (tipoBusqueda == 1) {
                if (listaEstudiante.get(i).getCarnet().equalsIgnoreCase(datos)) {
                    listaBusqueda.add(listaEstudiante.get(i));
                }
            }
            else if (tipoBusqueda == 2) {
                if (listaEstudiante.get(i).getNombre().equalsIgnoreCase(datos)) {
                    listaBusqueda.add(listaEstudiante.get(i));
                }
            }
            else {

                if (Integer.toString(listaEstudiante.get(i).getEdad()).equalsIgnoreCase(datos)) {
                    listaBusqueda.add(listaEstudiante.get(i));
                }
            }
        }
        String[][] matriz = new String[listaBusqueda.size()][Estudiante.getNumeroAtributos()];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = listaBusqueda.get(fila).getAtributo(columna);
            }
        }
        return matriz;
    }
}
