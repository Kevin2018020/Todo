/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeminarioForms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import net.sf.jcarrierpigeon.Notification;
import net.sf.jcarrierpigeon.NotificationQueue;
import net.sf.jcarrierpigeon.WindowPosition;

/**
 *
 * @author Dylan
 */
public class Menu_administrador extends javax.swing.JFrame {
     Clase  com = new Clase();
    Connection cc=com.conector();

    /**
     * Creates new form Menu_administrador
     */
    public Menu_administrador() 
    {
         initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Estadisticas = new javax.swing.JButton();
        Ventas = new javax.swing.JButton();
        Bodega = new javax.swing.JButton();
        Recetas = new javax.swing.JButton();
        Compra = new javax.swing.JButton();
        Eventos = new javax.swing.JButton();
        Opciones = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Estadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Estadisticas.png"))); // NOI18N
        Estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadisticasActionPerformed(evt);
            }
        });

        Ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vendedor.png"))); // NOI18N
        Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasActionPerformed(evt);
            }
        });

        Bodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bodega.png"))); // NOI18N
        Bodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BodegaActionPerformed(evt);
            }
        });

        Recetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recetas.png"))); // NOI18N
        Recetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecetasActionPerformed(evt);
            }
        });

        Compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Compras.png"))); // NOI18N
        Compra.setToolTipText("");
        Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompraActionPerformed(evt);
            }
        });

        Eventos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eventos.png"))); // NOI18N
        Eventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventosActionPerformed(evt);
            }
        });

        Opciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Opciones.png"))); // NOI18N
        Opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jLabel2.setForeground(java.awt.SystemColor.controlHighlight);
        jLabel2.setText("Estadisticas");

        jLabel3.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jLabel3.setForeground(java.awt.SystemColor.controlHighlight);
        jLabel3.setText("Ventas");

        jLabel4.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.controlHighlight);
        jLabel4.setText("Bodega");

        jLabel5.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jLabel5.setForeground(java.awt.SystemColor.controlHighlight);
        jLabel5.setText("Eventos");

        jLabel6.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jLabel6.setForeground(java.awt.SystemColor.controlHighlight);
        jLabel6.setText("Compras");

        jLabel7.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jLabel7.setForeground(java.awt.SystemColor.controlHighlight);
        jLabel7.setText("Platillos");

        jLabel8.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jLabel8.setForeground(java.awt.SystemColor.controlHighlight);
        jLabel8.setText("Opciones");

        jButton1.setFont(new java.awt.Font("Mercedes-Serial DB", 0, 36)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu_general12.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(570, 570, 570)
                .addComponent(jLabel4)
                .addGap(130, 130, 130)
                .addComponent(jLabel7))
            .addGroup(layout.createSequentialGroup()
                .addGap(770, 770, 770)
                .addComponent(Recetas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(Bodega, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(Estadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(860, 860, 860)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(Eventos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(560, 560, 560)
                .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(600, 600, 600)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Compra, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel9)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(Recetas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(Bodega, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(Estadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(630, 630, 630)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(Eventos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(Ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(Compra, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel9)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BodegaActionPerformed
        // TODO add your handling code here:
        SeminarioForms.Inventario prin = new SeminarioForms.Inventario();
            prin.setVisible(true);
            this.hide();  
    }//GEN-LAST:event_BodegaActionPerformed

    private void VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasActionPerformed
        // TODO add your handling code here:
        Registro_Venta prin = new Registro_Venta();
            prin.setVisible(true);
            this.hide();  
    }//GEN-LAST:event_VentasActionPerformed

    private void CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompraActionPerformed
        // TODO add your handling code here:
        SeminarioForms.Registro_Venta prin = new SeminarioForms.Registro_Venta();
            prin.setVisible(true);
            this.hide();         
    }//GEN-LAST:event_CompraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
SeminarioForms.Menu_Cargo prin = new SeminarioForms.Menu_Cargo();
            prin.setVisible(true);
            this.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void OpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionesActionPerformed
     opciones_administrador prin = new  opciones_administrador();
            prin.setVisible(true);
            this.hide();  
    }//GEN-LAST:event_OpcionesActionPerformed

    private void EventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventosActionPerformed
        // TODO add your handling code here:
         Eventos prin = new  Eventos();
        prin.setVisible(true);
        this.hide();
    }//GEN-LAST:event_EventosActionPerformed

    private void RecetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecetasActionPerformed
         Platillos prin = new Platillos();
            prin.setVisible(true);
            this.hide();  
    }//GEN-LAST:event_RecetasActionPerformed

    private void EstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadisticasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadisticasActionPerformed
  public void transparenciaButton(){
         Estadisticas.setOpaque (false);
         Estadisticas.setContentAreaFilled(false);
         Estadisticas.setBorderPainted(false);
         Compra.setOpaque (false);
         Compra.setContentAreaFilled(false);
         Compra.setBorderPainted(false);
         Ventas.setOpaque (false);
         Ventas.setContentAreaFilled(false);
         Ventas.setBorderPainted(false);
         Recetas.setOpaque (false);
         Recetas.setContentAreaFilled(false);
         Recetas.setBorderPainted(false);
         Eventos.setOpaque (false);
         Eventos.setContentAreaFilled(false);
         Eventos.setBorderPainted(false);
           Bodega.setOpaque (false);
         Bodega.setContentAreaFilled(false);
         Bodega.setBorderPainted(false);
           Opciones.setOpaque (false);
         Opciones.setContentAreaFilled(false);
         Opciones.setBorderPainted(false);
   
    
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
            java.util.logging.Logger.getLogger(Menu_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bodega;
    private javax.swing.JButton Compra;
    private javax.swing.JButton Estadisticas;
    private javax.swing.JButton Eventos;
    private javax.swing.JButton Opciones;
    private javax.swing.JButton Recetas;
    private javax.swing.JButton Ventas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
