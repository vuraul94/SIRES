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
public class RegistroCurso {

    ArrayList<Curso> listaCurso;

    public RegistroCurso() {
        this.listaCurso = new ArrayList<Curso>();
    }

    public String addCurso(Curso curso){
        if(curso!=null){
            if(verificarCurso(curso.getSiglas())){
                listaCurso.add(curso);
                return "El curso ha sigo agregado";
            }
        }else{
            return "El curso no ha sido agregado";
        }
        return "El objeto es null";
    }
    
    public boolean verificarCurso(String siglas) {
        if (!siglas.equalsIgnoreCase("")) {
            if (listaCurso.size() != 0) {
                for (int i = 0; i < listaCurso.size(); i++) {
                    if (listaCurso.get(i).getSiglas().equals(siglas)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public Curso consultar(String siglas){
        for(Curso curso: listaCurso){
            if(curso.getSiglas().equalsIgnoreCase(siglas)){
                return curso;
            }
        }
        return null;
    }
    
    public String consultarAll(){
        String salida = "Siglas\t" + "Nombre\t" + "Creditos\n";
        for (Curso curso : listaCurso) {
            salida += curso.getInformacion()+"\n";
        }
        return salida;
    }
    
    public String modCurso(Curso curso,String nombre, int creditos){
        curso.setCreditos(creditos);
        curso.setNombre(nombre);
        return "El curso ha sido modificado";
    }
    
    public String delCurso(Curso curso){
        if(listaCurso.remove(curso)){
            return "El curso ha sido eliminado";
        }
        return "El curso no ha sido eliminado o no existe";
    }
    
    public String[][] getMatrizCursos(){
        String[][] matriz = new String[listaCurso.size()][Estudiante.getNumeroAtributos()];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna]=listaCurso.get(fila).getAtributo(columna);   
            } 
        }
        return matriz;
    }

        public String[][] getMatrizBuscar(String datos, int tipoBusqueda) {

        ArrayList<Curso> listaBusqueda = new ArrayList<Curso>();
        for(int i = 0; i < listaCurso.size(); i++) {
            if (tipoBusqueda == 1) {
                if (listaCurso.get(i).getSiglas().equalsIgnoreCase(datos)) {
                    listaBusqueda.add(listaCurso.get(i));
                }
            }
            else if (tipoBusqueda == 2) {
                if (listaCurso.get(i).getNombre().equalsIgnoreCase(datos)) {
                    listaBusqueda.add(listaCurso.get(i));
                }
            }
            else {

                if (Integer.toString(listaCurso.get(i).getCreditos()).equalsIgnoreCase(datos)) {
                    listaBusqueda.add(listaCurso.get(i));
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
