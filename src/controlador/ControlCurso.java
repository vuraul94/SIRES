/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Curso;
import modelo.RegistroCurso;
import vista.BotonesCurso;
import vista.GUIRegistroCursos;
import vista.GUITablaCursos;
import vista.PanelCurso;

/**
 *
 * @author Raul
 */
public class ControlCurso implements ActionListener{
    
     private PanelCurso panelCurso;
    private BotonesCurso panelB;
    GUIRegistroCursos registro;
    RegistroCurso registroCurso;
    GUITablaCursos guiTablaCur;

    public ControlCurso(PanelCurso panelCurso, BotonesCurso panelB, GUIRegistroCursos registro, RegistroCurso registroCurso, GUITablaCursos guiTablaCur) {
        this.panelCurso = panelCurso;
        this.panelB = panelB;
        this.registro = registro;
        this.registroCurso = registroCurso;
        this.guiTablaCur = guiTablaCur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equalsIgnoreCase(PanelCurso.BTN_BUSCAR)) {
            Curso curso = registroCurso.consultar(panelCurso.getTxtSiglas());
            if (curso != null) {
                panelCurso.setTxtSiglas(curso.getSiglas());
                panelCurso.setTxtNombre(curso.getNombre());
                panelCurso.setTxtCreditos(curso.getCreditos());
                panelB.enableEliMod(true);
            } else {
                GUIRegistroCursos.mensaje("El curso no se encuentra registrado!");
                panelCurso.limpiar();
            }
        }//Fin de buscar

        if (e.getActionCommand().equalsIgnoreCase(BotonesCurso.BTN_AGREGAR)) {
            if (panelCurso.getTxtSiglas().equalsIgnoreCase("")) {
                GUIRegistroCursos.mensaje("Debe ingresar las siglas del curso");
            } else if (panelCurso.getTxtNombre().equalsIgnoreCase("")) {
                GUIRegistroCursos.mensaje("Debe ingresar el nombre del curso.");
            } else if (panelCurso.getTxtCreditos() == 0) {
                GUIRegistroCursos.mensaje("Debe ingresar los creditos del curso.");
            } else {
                GUIRegistroCursos.mensaje(registroCurso.addCurso(new Curso(panelCurso.getTxtSiglas(), panelCurso.getTxtNombre(), panelCurso.getTxtCreditos())));
                panelCurso.limpiar();
                guiTablaCur.setValores(registroCurso.getMatrizCursos(), Curso.getEtiquetas());
                if (GUIRegistroCursos.mensajeConfirmar("Desea agregar otro curso?") == 1) {
                    registro.dispose();
                }
            }
        }//fin de agregar

        if (e.getActionCommand().equalsIgnoreCase(BotonesCurso.BTN_MODIFICAR)) {
            if (registroCurso.consultar(panelCurso.getTxtSiglas()) != null) {
                if (panelCurso.getTxtSiglas().equalsIgnoreCase("") || panelCurso.getTxtNombre().equalsIgnoreCase("") || panelCurso.getTxtCreditos() == 0) {
                    GUIRegistroCursos.mensaje("No borre los datos");
                } else {
                    GUIRegistroCursos.mensaje(registroCurso.modCurso(registroCurso.consultar(panelCurso.getTxtSiglas()), panelCurso.getTxtNombre(), panelCurso.getTxtCreditos()));
                    guiTablaCur.setValores(registroCurso.getMatrizCursos(), Curso.getEtiquetas());
                    panelCurso.limpiar();
                    panelB.enableEliMod(false);
                }
            } else {
                GUIRegistroCursos.mensaje("No existe curso al que correspondan esas siglas");
            }
        }//fin de modificar
        
        if (e.getActionCommand().equalsIgnoreCase(BotonesCurso.BTN_ELIMINAR)) {
            Curso cursoEliminar = new Curso(panelCurso.getTxtSiglas(), panelCurso.getTxtNombre(), panelCurso.getTxtCreditos());
            GUIRegistroCursos.mensaje(registroCurso.delCurso(cursoEliminar));
            panelCurso.limpiar();
            guiTablaCur.setValores(registroCurso.getMatrizCursos(), Curso.getEtiquetas());
            panelB.enableEliMod(false);
            registro.dispose();
        }//fin de eliminar
    }
    
}
