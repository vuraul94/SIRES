/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class ControlTablaCurso implements ActionListener, ItemListener, MouseListener {

    private RegistroCurso registroCurso;
    private GUITablaCursos guiTablaCur;
    private int controlBusca = 0;
    private BotonesCurso BotonesCur;

    public ControlTablaCurso(RegistroCurso registroCurso, GUITablaCursos guiTablaCur) {
        this.registroCurso = registroCurso;
        this.guiTablaCur = guiTablaCur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(GUITablaCursos.BTN_REGISTRO)) {
            GUIRegistroCursos registro = new GUIRegistroCursos(null, true, registroCurso, guiTablaCur);
            BotonesCur = registro.getBotonesCurso();
            BotonesCur.enableEliMod(false);
            registro.setVisible(true);
        }

        if (e.getActionCommand().equalsIgnoreCase(GUITablaCursos.BTN_BUSCAR)) {
            if (controlBusca == 1) {
                guiTablaCur.setValores(
                        registroCurso.getMatrizBuscar(guiTablaCur.getTxtBuscar(), 1),
                        Curso.getEtiquetas());
                guiTablaCur.limpiar();
            }
            if (controlBusca == 2) {
                guiTablaCur.setValores(
                        registroCurso.getMatrizBuscar(guiTablaCur.getTxtBuscar(), 2),
                        Curso.getEtiquetas());
                guiTablaCur.limpiar();
            }
            if (controlBusca == 3) {
                guiTablaCur.setValores(
                        registroCurso.getMatrizBuscar(guiTablaCur.getTxtBuscar(), 3),
                        Curso.getEtiquetas());
                guiTablaCur.limpiar();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String[] datosFila = guiTablaCur.getdatosFila();
        GUIRegistroCursos registro = new GUIRegistroCursos(null, true, registroCurso, guiTablaCur);
        PanelCurso panelC = registro.getPanelE();
        panelC.setTxtSiglas(datosFila[0]);
        panelC.setTxtNombre(datosFila[1]);
        panelC.setTxtCreditos(Integer.parseInt(datosFila[2]));
        BotonesCurso panelB = registro.getBotonesCurso();
        panelB.enableAgregar(false);
        panelB.enableEliMod(true);
        registro.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
