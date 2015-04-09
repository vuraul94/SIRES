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
public class ControlTablaEstudiante implements ActionListener, ItemListener, MouseListener {

    private RegistroEstudiante registroEstudiante;
    private GUITablaEstudiante guiTablaEst;
    private int controlBusca = 0;
    private BotonesEstudiante BotonesEst;

    public ControlTablaEstudiante(RegistroEstudiante registroEstudiante, GUITablaEstudiante guiTablaEst) {
        this.registroEstudiante = registroEstudiante;
        this.guiTablaEst = guiTablaEst;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(GUITablaEstudiante.BTN_REGISTRO)) {
            GUIRegistroEstudiantes registro = new GUIRegistroEstudiantes(null, true, registroEstudiante, guiTablaEst);
            BotonesEst = registro.getBotonesEstudiante();
            BotonesEst.enableEliMod(false);
            registro.setVisible(true);
        }
        
        if (e.getActionCommand().equalsIgnoreCase(GUITablaEstudiante.BTN_BUSCAR)) {
            if (controlBusca == 1) {
                guiTablaEst.setValores(
                        registroEstudiante.getMatrizBuscar(guiTablaEst.getTxtBuscar(), 1),
                        Estudiante.getEtiquetas());
                guiTablaEst.limpiar();
            }
            if (controlBusca == 2) {
                guiTablaEst.setValores(
                        registroEstudiante.getMatrizBuscar(guiTablaEst.getTxtBuscar(), 2),
                        Estudiante.getEtiquetas());
                guiTablaEst.limpiar();
            }
            if (controlBusca == 3) {
                guiTablaEst.setValores(
                        registroEstudiante.getMatrizBuscar(guiTablaEst.getTxtBuscar(), 3),
                        Estudiante.getEtiquetas());
                guiTablaEst.limpiar();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            System.err.println(ie.getItem().toString());

            if (ie.getItem().toString().equalsIgnoreCase("All")) {
//                Agregar.mensaje("All");
                guiTablaEst.enableCampoBuscar(false);

                guiTablaEst.setValores(registroEstudiante.getMatrizEstudiantes(), Estudiante.getEtiquetas());
            }
            if (this.guiTablaEst.getCboxCategoria().equalsIgnoreCase("Carnet")) {
                guiTablaEst.setLbCategoria("Carnet:");
                guiTablaEst.enableCampoBuscar(true);
                controlBusca = 1;

            }
            if (this.guiTablaEst.getCboxCategoria().equalsIgnoreCase("Nombre")) {
                guiTablaEst.setLbCategoria("Nombre:");
                guiTablaEst.enableCampoBuscar(true);
                controlBusca = 2;
            }
            if (this.guiTablaEst.getCboxCategoria().equalsIgnoreCase("Edad")) {
                guiTablaEst.setLbCategoria("Edad:");
                guiTablaEst.enableCampoBuscar(true);
                controlBusca = 3;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String[] datosFila = guiTablaEst.getdatosFila();
        GUIRegistroEstudiantes registro = new GUIRegistroEstudiantes(null, true, registroEstudiante, guiTablaEst);
        PanelEstudiante panelE = registro.getPanelE();
        panelE.setTxtCarnet(datosFila[0]);
        panelE.setTxtNombre(datosFila[1]);
        panelE.setTxtEdad(Integer.parseInt(datosFila[2]));
        BotonesEstudiante panelB = registro.getBotonesEstudiante();
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
