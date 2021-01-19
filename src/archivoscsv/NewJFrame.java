/* DESARROLLO III (12/enero/2020) - Tarea 1. Procesamiento de archivos CSV (archivos secuenciales de texto)

 ------------------------------------
|  Guzmán Silvas Erica Jazmín        |
|  Cruz Ruiz José Ricardo            |
|  Cossio Mondragon Karla Alexandria |
|  Valencia Valenzuela Alfredo       |
 ------------------------------------

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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class NewJFrame extends javax.swing.JFrame {

    public NewJFrame() {
        initComponents();
        
        // Asignar restricciones inputs
        RestrictedTextField restrictedClave = new RestrictedTextField(jTextFieldClave);
        restrictedClave.setOnlyNums(true);
        
        RestrictedTextField restrictedNombre = new RestrictedTextField(jTextFieldNombre);
        restrictedNombre.setLimit(35);
        restrictedNombre.setAcceptSpace(true);
        restrictedNombre.setOnlyText(true);
        
        RestrictedTextField restrictedZona = new RestrictedTextField(jTextFieldZona);
        restrictedZona.setLimit(15);
        restrictedZona.setAcceptSpace(false);
        restrictedZona.setOnlyText(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelZona = new javax.swing.JLabel();
        jTextFieldClave = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldZona = new javax.swing.JTextField();
        jButtonReporte1 = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        jLabelClave = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabelNombre = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jButtonReporte2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendedores");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

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

        jButtonReporte1.setText("Reporte 1");
        jButtonReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporte1ActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salirButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelClave)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelFecha)
                            .addComponent(jLabelZona))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldZona)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonReporte1)
                            .addComponent(jButtonReporte2))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabelFecha))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldClaveActionPerformed

    }//GEN-LAST:event_jTextFieldClaveActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        // Verificar que todos los campos estén llenos
        if ((jTextFieldClave.getText().isEmpty()) || (jTextFieldNombre.getText().isEmpty())
            || (jDateChooser1.getDate() == null) || (jTextFieldZona.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Verifique los campos por favor");

        } else {
            // Tomar la fecha ingresada y darle formato
            String dia = Integer.toString(jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(jDateChooser1.getCalendar().get(Calendar.MONTH) + 1);
            String anio = Integer.toString(jDateChooser1.getCalendar().get(Calendar.YEAR));
            String fecha = dia + "/" + mes + "/" + anio;

            // Tomar los datos ingresados en los inputs
            int clave = Integer.parseInt(jTextFieldClave.getText());
            String nombre = jTextFieldNombre.getText();
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

                BufferedWriter bw = new BufferedWriter(fw);  

                bw.write(linea);   // Escribir la línea en el archivo
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
            jTextFieldZona.setText("");
            jDateChooser1.setDateFormatString("");
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirButtonActionPerformed

    private void jButtonReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporte1ActionPerformed
        try {
            File f = new File("vendors.csv");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String registro;
            String[] cad;
            System.out.println("\n ********* REPORTE #1: EDAD DE VENDEDORES ********** \n");
            long lNumeroLineas = 0; //contador de lineas

            while ((registro = br.readLine()) != null) {

                lNumeroLineas++;
                cad = registro.split(",");

                if (lNumeroLineas == 1) {      // Si es la primera línea (los nombres de las columnas)
                    System.out.println(cad[0] + " || " + (cad[1]) + " || " + (cad[2]) + " || " + (cad[3]));
                }

                if (lNumeroLineas >= 2) {     // Para las demás líneas con los datos
                    System.out.println(cad[0] + " || " + (cad[1]) + " || " + (edad(cad)) + " años" + " || " + (cad[3]));
                }
            } // End while 
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonReporte1ActionPerformed

    // Para el punto 2
    static ArrayList<String> zonasEdad = new ArrayList<>();
    static Hashtable<String,Integer> zonasEdadLista = new Hashtable<>();
    
    private void jButtonReporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporte2ActionPerformed
        edadTotal();
        System.out.println("\n***** REPORTE #2: PROMEDIO DE EDADES POR ZONA ***** \n");
        for (String zona : zonasEdad) {
            int edadTotal = zonasEdadLista.get(zona);
            int cantidad = contar(zona);
            int promedio = edadTotal/cantidad;
            
            System.out.println(zona + " -> " + promedio);
        }
    }//GEN-LAST:event_jButtonReporte2ActionPerformed

    // Funciones para el Reporte 2: Promedio de edades con respecto a la zona
    public static int contar(String ciudad) {
        int divisor = 0;
        try {
            Scanner scan = new Scanner(new File("vendors.csv"));
            while (scan.hasNextLine()) {
                String renglon = scan.nextLine();
                String[] zona = renglon.split(",");
                if (zona[3].equals("Vermont")) {
                    divisor++;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return divisor;
    }

    public static int edad(String[] cad) {
        String fecha = cad[2];                                           // Variable con la fecha
        SimpleDateFormat fechaHora = new SimpleDateFormat("dd/mm/yyyy"); 
        Date convertido = null;
        try {
            convertido = fechaHora.parse(fecha);                         // Convierte del formato anterior a una fecha tipo Date para extraer el año
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
        }

        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.setTime(convertido);                             // Tiempo transcurrido desde el 1 de enero de 1970 a las 00:00:00 GMT. hasta esa fecha "convertido"
        Calendar fechaActual = Calendar.getInstance();
        int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        return edad;
    }

    public static void edadTotal() {
        int edad;
        try {
            Scanner scan = new Scanner(new File("vendors.csv"));
            scan.nextLine();
            while (scan.hasNextLine()) {
                String palabra = scan.nextLine();
                String[] palabras = palabra.split(",");
                boolean encontrado = false;
                if (!zonasEdad.isEmpty()) {
                    for (String zona : zonasEdad) {
                        if (palabras[3].equals(zona)) {
                            encontrado = true;
                        }
                    }

                    if (encontrado == true) {
                        int edad1 = zonasEdadLista.get(palabras[3]);
                        edad = edad(palabras);
                        edad1 = edad + edad1;
                        zonasEdadLista.replace(palabras[3], edad1);
                    } else {
                        zonasEdad.add(palabras[3]);
                        edad = edad(palabras);
                        zonasEdadLista.put(palabras[3], edad);
                    }
                } else {
                    zonasEdad.add(palabras[3]);
                    edad = edad(palabras);
                    zonasEdadLista.put(palabras[3], edad);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int promedio(int sumaedades, int contador) {
        int promedio;
        promedio = sumaedades / contador;
        return promedio;
    }
    
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                // Características de la ventana
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarButton;
    private javax.swing.JButton jButtonReporte1;
    private javax.swing.JButton jButtonReporte2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabelClave;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelZona;
    private javax.swing.JTextField jTextFieldClave;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldZona;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables
}
