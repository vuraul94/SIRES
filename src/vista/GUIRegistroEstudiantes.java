/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlEstudiante;
import javax.swing.JOptionPane;
import modelo.RegistroEstudiante;

/**
 *
 * @author Raul
 */
public class GUIRegistroEstudiantes extends javax.swing.JDialog {

    /**
     * Creates new form GUIRegistroEstudiante
     */
    public GUIRegistroEstudiantes (java.awt.Frame parent, boolean modal,RegistroEstudiante registroEstudiante,GUITablaEstudiante guiTablaEst) {
        super(parent, modal);
        initComponents();
        ControlEstudiante control;
        control = new ControlEstudiante(panelEstudiante1,botonesEstudiante1,this,registroEstudiante,guiTablaEst);
        botonesEstudiante1.escuchar(control);
        panelEstudiante1.escuchar(control);
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
        panelEstudiante1 = new vista.PanelEstudiante();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonesEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonesEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.BotonesEstudiante botonesEstudiante1;
    private vista.PanelEstudiante panelEstudiante1;
    // End of variables declaration//GEN-END:variables

     public BotonesEstudiante getBotonesEstudiante() {
        return this.botonesEstudiante1;
    }

    public PanelEstudiante getPanelE() {
        return this.panelEstudiante1;
    }

    public static void mensaje(String data) {
        JOptionPane.showMessageDialog(null, data);
    }
    public static int mensajeConfirmar(String data) {
      return  JOptionPane.showConfirmDialog(null, data);
    }
}
