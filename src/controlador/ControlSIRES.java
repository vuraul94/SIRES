/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.RegistroCurso;
import modelo.RegistroEstudiante;
import vista.GUISIRES;
import vista.GUITablaCursos;
import vista.GUITablaEstudiante;

/**
 *
 * @author Raul
 */
public class ControlSIRES implements ActionListener{
    
    private GUISIRES guiSIRES;
    private RegistroEstudiante registroEst;
    private RegistroCurso registroCur;

    public ControlSIRES(GUISIRES guiSIRES) {
        this.guiSIRES = guiSIRES;
        this.registroEst = new RegistroEstudiante();
        this.registroCur = new RegistroCurso();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equalsIgnoreCase(GUISIRES.MENU_ESTUDIANTE)){
            GUITablaEstudiante guiEstudiante=new GUITablaEstudiante(registroEst);
            guiEstudiante.setVisible(true);
        }
    if(e.getActionCommand().equalsIgnoreCase(GUISIRES.MENU_CURSO)){
            GUITablaCursos guiCurso=new GUITablaCursos(registroCur);
            guiCurso.setVisible(true);
        }
        if(e.getActionCommand().equalsIgnoreCase(GUISIRES.MENU_SALIR)){
            System.exit(0);
        }
    }
    
}
