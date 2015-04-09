/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Estudiante;
import modelo.RegistroEstudiante;
import vista.BotonesEstudiante;
import vista.GUIRegistroEstudiantes;
import vista.GUITablaEstudiante;
import vista.PanelEstudiante;

/**
 *
 * @author Raul
 */
public class ControlEstudiante implements ActionListener {

    private PanelEstudiante panelEstudiante;
    private BotonesEstudiante panelB;
    GUIRegistroEstudiantes registro;
    RegistroEstudiante registroEstudiante;
    GUITablaEstudiante guiTablaEst;

    public ControlEstudiante(PanelEstudiante panelEstudiante,BotonesEstudiante panelB, GUIRegistroEstudiantes registro, RegistroEstudiante registroEstudiante, GUITablaEstudiante guiTablaEst) {
        this.panelEstudiante = panelEstudiante;
        this.panelB= panelB;
        this.registro = registro;
        this.registroEstudiante = registroEstudiante;
        this.guiTablaEst = guiTablaEst;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equalsIgnoreCase(PanelEstudiante.BTN_BUSCAR)) {
            Estudiante estudiante = registroEstudiante.consultar(panelEstudiante.getTxtCarnet());
            if (estudiante != null) {
                panelEstudiante.setTxtCarnet(estudiante.getCarnet());
                panelEstudiante.setTxtNombre(estudiante.getNombre());
                panelEstudiante.setTxtEdad(estudiante.getEdad());
                panelB.enableEliMod(true);
            } else {
                GUIRegistroEstudiantes.mensaje("El estudiante no se encuentra registrado!");
                panelEstudiante.limpiar();
            }
        }//Fin de buscar

        if (e.getActionCommand().equalsIgnoreCase(BotonesEstudiante.BTN_AGREGAR)) {
            if (panelEstudiante.getTxtCarnet().equalsIgnoreCase("")) {
                GUIRegistroEstudiantes.mensaje("Debe ingresar el carnet del estudiante");
            } else if (panelEstudiante.getTxtNombre().equalsIgnoreCase("")) {
                GUIRegistroEstudiantes.mensaje("Debe ingresar el nombre del estudiante.");
            } else if (panelEstudiante.getTxtEdad() == 0) {
                GUIRegistroEstudiantes.mensaje("Debe ingresar la edad del estudiante.");
            } else {
                GUIRegistroEstudiantes.mensaje(registroEstudiante.addEstudiante(new Estudiante(panelEstudiante.getTxtCarnet(), panelEstudiante.getTxtNombre(), panelEstudiante.getTxtEdad())));
                panelEstudiante.limpiar();
                guiTablaEst.setValores(registroEstudiante.getMatrizEstudiantes(), Estudiante.getEtiquetas());
                if (GUIRegistroEstudiantes.mensajeConfirmar("Desea agregar otro estudiante?") == 1) {
                    registro.dispose();
                }
            }
        }//fin de agregar

        if (e.getActionCommand().equalsIgnoreCase(BotonesEstudiante.BTN_MODIFICAR)) {
            if (registroEstudiante.consultar(panelEstudiante.getTxtCarnet()) != null) {
                if (panelEstudiante.getTxtCarnet().equalsIgnoreCase("") || panelEstudiante.getTxtNombre().equalsIgnoreCase("") || panelEstudiante.getTxtEdad() == 0) {
                    GUIRegistroEstudiantes.mensaje("No borre los datos");
                } else {
                    GUIRegistroEstudiantes.mensaje(registroEstudiante.modEstudiante(registroEstudiante.consultar(panelEstudiante.getTxtCarnet()), panelEstudiante.getTxtNombre(), panelEstudiante.getTxtEdad()));
                    guiTablaEst.setValores(registroEstudiante.getMatrizEstudiantes(), Estudiante.getEtiquetas());
                    panelEstudiante.limpiar();
                    panelB.enableEliMod(false);
                }
            } else {
                GUIRegistroEstudiantes.mensaje("Ese carnet no existe");
            }
        }//fin de modificar
        
        if (e.getActionCommand().equalsIgnoreCase(BotonesEstudiante.BTN_ELIMINAR)) {
            Estudiante estudianteEliminar = new Estudiante(panelEstudiante.getTxtCarnet(), panelEstudiante.getTxtNombre(), panelEstudiante.getTxtEdad());
            GUIRegistroEstudiantes.mensaje(registroEstudiante.delEstudiante(estudianteEliminar));
            panelEstudiante.limpiar();
            guiTablaEst.setValores(registroEstudiante.getMatrizEstudiantes(), Estudiante.getEtiquetas());
            panelB.enableEliMod(false);
            registro.dispose();
        }//fin de eliminar

    }
}
