/* DESARROLLO III (12/enero/2020) - Tarea 1. Procesamiento de archivos CSV (archivos secuenciales de texto)
   Erica Jazmín Guzmán Silvas

1. Desarrollar un programa para agregar los datos de los vendedores a un archivo de datos CSV. 
   Los campos que debe incluir el registro son: clave del vendedor (entero), nombre del vendedor 
   (máximo 35 caracteres), fecha de nacimiento (DD/MM/AAAA), y zona (máximo 15 caracteres).
2. Desarrollar un programa que genere un reporte a partir del archivo CSV creado en el punto anterior.
   El reporte debe mostrar el listado de todos los empleados con su edad actual. Puedes probar el programa
   con el archivo vendors.csv
3. Desarrollar un programa que genere un reporte con la edad promedio para cada una de las zonas.
 */
package archivoscsv;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Erica Guzmán
 */
public class Principal extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form Principal
     */
    public Principal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        // Asignar restricciones inputs
        RestrictedTextField restrictedClave = new RestrictedTextField(jTextFieldClave);
        restrictedClave.setOnlyNums(true);
        
        RestrictedTextField restrictedNombre = new RestrictedTextField(jTextFieldNombre);
        restrictedNombre.setLimit(35);
        
        RestrictedTextField restrictedZona = new RestrictedTextField(jTextFieldZona);
        restrictedZona.setLimit(15);
        restrictedZona.setOnlyText(true);

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guardarButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        jLabelClave = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelZona = new javax.swing.JLabel();
        jTextFieldClave = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldFecha = new javax.swing.JTextField();
        jTextFieldZona = new javax.swing.JTextField();
        jButtonReporte1 = new javax.swing.JButton();
        jButtonReporte2 = new javax.swing.JButton();

        setTitle("Vendedores");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        jLabelClave.setText("Clave");

        jLabelNombre.setText("Nombre");

        jLabelFecha.setText("Fecha");

        jLabelZona.setText("Zona");

        jTextFieldClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldClaveActionPerformed(evt);
            }
        });

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldFecha.setText("DD/MM/AAAA");

        jButtonReporte1.setText("Reporte 1");

        jButtonReporte2.setText("Reporte 2");
        jButtonReporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporte2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(guardarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salirButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelClave)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelFecha)
                            .addComponent(jLabelZona))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldZona)
                                    .addComponent(jTextFieldFecha)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonReporte1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonReporte2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClave)
                    .addComponent(jTextFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReporte1))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReporte2))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFecha)
                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelZona)
                    .addComponent(jTextFieldZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirButton)
                    .addComponent(guardarButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(guardarButton);

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed

        if ((jTextFieldClave.getText().isEmpty()) || (jTextFieldNombre.getText().isEmpty())
                || (jTextFieldFecha.getText().isEmpty()) || (jTextFieldZona.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "No puede haber campos vacíos.");
            
        } else {
            // Tomar los datos ingresados en los inputs
            int clave = Integer.parseInt(jTextFieldClave.getText());
            String nombre = jTextFieldNombre.getText();
            String fecha = jTextFieldFecha.getText();
            String zona = jTextFieldZona.getText();
            String linea = clave + "," + nombre + "," + fecha + "," + zona;
            
            // Escribir en el archivo la línea con los datos
            try {
                File archivo = new File("vendors.csv");

                FileWriter fw;
                if (archivo.exists()) {
                    fw = new FileWriter(archivo, true);
                } else {
                    fw = new FileWriter(archivo);
                }

                BufferedWriter bw = new BufferedWriter(fw);  // Al bw se le manda el fw que es el archivo que creó o escribió algo nuevo en uno ya existente (para que funcione el bw)

                bw.write(linea);                             // Escribir la línea en el archivo
                bw.newLine();

                bw.flush();
                fw.close();
                bw.close();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            // Limpiar inputs
            jTextFieldClave.setText("");
            jTextFieldNombre.setText("");
            jTextFieldFecha.setText("");
            jTextFieldZona.setText("");
        }
        
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void jTextFieldClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldClaveActionPerformed
        
    }//GEN-LAST:event_jTextFieldClaveActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButtonReporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporte2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReporte2ActionPerformed
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal dialog = new Principal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });

                // Características de la ventana
                dialog.setResizable(false);
                dialog.setLayout(null);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarButton;
    private javax.swing.JButton jButtonReporte1;
    private javax.swing.JButton jButtonReporte2;
    private javax.swing.JLabel jLabelClave;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelZona;
    private javax.swing.JTextField jTextFieldClave;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldZona;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}