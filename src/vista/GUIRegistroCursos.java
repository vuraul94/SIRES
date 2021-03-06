/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlCurso;
import javax.swing.JOptionPane;
import modelo.RegistroCurso;

/**
 *
 * @author Raul
 */
public class GUIRegistroCursos extends javax.swing.JDialog {

    /**
     * Creates new form GUIRegistroCursos
     */
    public GUIRegistroCursos(java.awt.Frame parent, boolean modal,RegistroCurso registroCurso,GUITablaCursos guiTablaCur) {
        super(parent, modal);
        initComponents();
        ControlCurso control;
        control = new ControlCurso(panelCurso1,botonesCurso1,this,registroCurso,guiTablaCur);
        botonesCurso1.escuchar(control);
        panelCurso1.escuchar(control);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonesEstudiante1 = new vista.BotonesEstudiante();
        panelCurso1 = new vista.PanelCurso();
        botonesCurso1 = new vista.BotonesCurso();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(botonesCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonesCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.BotonesCurso botonesCurso1;
    private vista.BotonesEstudiante botonesEstudiante1;
    private vista.PanelCurso panelCurso1;
    // End of variables declaration//GEN-END:variables

    public BotonesCurso getBotonesCurso() {
        return this.botonesCurso1;
    }

    public PanelCurso getPanelE() {
        return this.panelCurso1;
    }

    public static void mensaje(String data) {
        JOptionPane.showMessageDialog(null, data);
    }
    public static int mensajeConfirmar(String data) {
      return  JOptionPane.showConfirmDialog(null, data);
    }
}
