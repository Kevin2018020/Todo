/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeminarioForms;

import Servicios.ClienteServicio;
import Servicios.Conexion;
import com.sun.glass.events.KeyEvent;
import entidades.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import entidades.Platillo;
import java.util.ArrayList;
import entidades.Venta;
import Servicios.VentaServicio;
import java.awt.Frame;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
/**
 *
 * @author Mario
 */
public class Registro_Venta extends javax.swing.JFrame {

    ArrayList<Platillo> platillos; 
    DefaultTableModel tb = new DefaultTableModel();
    double suma = 0;
    double sumaIva = 0;
    double sumaSub = 0;
  
    /**
     * Creates new form Registro_Venta
     */
    public Registro_Venta() {
        platillos = new ArrayList<Platillo>();
        initComponents();
      Cargar_cliente.setVisible(false);
      txtNo.setVisible(false);
  this.setLocationRelativeTo(null);
      tb.addColumn("Codigo");
      tb.addColumn("Descripcion");
      tb.addColumn("Precio Unitario");
      tb.addColumn("Cantidad");
      tb.addColumn("Sub Total");
      jTable1.setModel(tb);
      Cargar();
      CargarPlatillos();
      jPanel4.setVisible(false);
    }
    public static String cantidadConLetra(String s) {
        StringBuilder result = new StringBuilder();
        BigDecimal totalBigDecimal = new BigDecimal(s).setScale(2, BigDecimal.ROUND_DOWN);
        long parteEntera = totalBigDecimal.toBigInteger().longValue();
        int triUnidades      = (int)((parteEntera % 1000));
        int triMiles         = (int)((parteEntera / 1000) % 1000);
        int triMillones      = (int)((parteEntera / 1000000) % 1000);
        int triMilMillones   = (int)((parteEntera / 1000000000) % 1000);

        if (parteEntera == 0) {
            result.append("Cero ");
            return result.toString();
        }
 
        if (triMilMillones > 0) result.append(triTexto(triMilMillones).toString() + "Mil ");
        if (triMillones > 0)    result.append(triTexto(triMillones).toString());
 
        if (triMilMillones == 0 && triMillones == 1) result.append("Millón ");
        else if (triMilMillones > 0 || triMillones > 0) result.append("Millones ");
 
        if (triMiles > 0)       result.append(triTexto(triMiles).toString() + "Mil ");
        if (triUnidades > 0)    result.append(triTexto(triUnidades).toString());
 
        return result.toString();
    }
    
    private static StringBuilder triTexto(int n) {
        StringBuilder result = new StringBuilder();
        int centenas = n / 100;
        int decenas  = (n % 100) / 10;
        int unidades = (n % 10);
 
        switch (centenas) {
            case 0: break;
            case 1:
                if (decenas == 0 && unidades == 0) {
                    result.append("Cien ");
                    return result;
                }
                else result.append("Ciento ");
                break;
            case 2: result.append("Doscientos "); break;
            case 3: result.append("Trescientos "); break;
            case 4: result.append("Cuatrocientos "); break;
            case 5: result.append("Quinientos "); break;
            case 6: result.append("Seiscientos "); break;
            case 7: result.append("Setecientos "); break;
            case 8: result.append("Ochocientos "); break;
            case 9: result.append("Novecientos "); break;
        }
 
        switch (decenas) {
            case 0: break;
            case 1:
                if (unidades == 0) { result.append("Diez "); return result; }
                else if (unidades == 1) { result.append("Once "); return result; }
                else if (unidades == 2) { result.append("Doce "); return result; }
                else if (unidades == 3) { result.append("Trece "); return result; }
                else if (unidades == 4) { result.append("Catorce "); return result; }
                else if (unidades == 5) { result.append("Quince "); return result; }
                else result.append("Dieci");
                break;
            case 2:
                if (unidades == 0) { result.append("Veinte "); return result; }
                else result.append("Veinti");
                break;
            case 3: result.append("Treinta "); break;
            case 4: result.append("Cuarenta "); break;
            case 5: result.append("Cincuenta "); break;
            case 6: result.append("Sesenta "); break;
            case 7: result.append("Setenta "); break;
            case 8: result.append("Ochenta "); break;
            case 9: result.append("Noventa "); break;
        }
 
        if (decenas > 2 && unidades > 0)
            result.append("y ");
 
        switch (unidades) {
            case 0: break;
            case 1: result.append("Un "); break;
            case 2: result.append("Dos "); break;
            case 3: result.append("Tres "); break;
            case 4: result.append("Cuatro "); break;
            case 5: result.append("Cinco "); break;
            case 6: result.append("Seis "); break;
            case 7: result.append("Siete "); break;
            case 8: result.append("Ocho "); break;
            case 9: result.append("Nueve "); break;
        }
 
        return result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtnit = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        cmbvendedores = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        nuevo1 = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtefectivo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtiva = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtcambio = new javax.swing.JTextField();
        guardar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Cargar_cliente = new javax.swing.JButton();
        btncargar = new javax.swing.JButton();
        txtapellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtNo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        cmbplatillos = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        agregarCompra = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 153), 2), "Ventas"));
        jPanel2.setLayout(null);

        jLabel10.setText("Cliente* :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(86, 116, 46, 14);

        jLabel11.setText("Direccion* :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(86, 146, 56, 14);

        jLabel12.setText("Nit* :");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(106, 176, 26, 14);

        jLabel13.setText("Telefono* :");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(316, 186, 55, 14);
        jPanel2.add(txtnombre);
        txtnombre.setBounds(156, 106, 180, 30);
        jPanel2.add(txtdireccion);
        txtdireccion.setBounds(156, 146, 360, 30);

        txtnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnitActionPerformed(evt);
            }
        });
        txtnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnitKeyTyped(evt);
            }
        });
        jPanel2.add(txtnit);
        txtnit.setBounds(156, 186, 143, 30);
        jPanel2.add(txttelefono);
        txttelefono.setBounds(376, 186, 134, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel14.setText("Registro de Ventas");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(152, 50, 360, 60);

        jLabel15.setText("Fecha de Emision* : ");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(518, 50, 129, 39);

        jLabel16.setText("Vendedo* :");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(130, 270, 55, 14);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Precio_Unitario", "Cantidad", "Sub_Total"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(98, 303, 625, 99);

        jLabel17.setText("Observacion");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(92, 441, 90, 14);

        cmbvendedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre del vendedor", " " }));
        jPanel2.add(cmbvendedores);
        cmbvendedores.setBounds(200, 260, 470, 30);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(92, 476, 336, 71);

        nuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono_nuevo.png"))); // NOI18N
        nuevo1.setText("Nuevo");
        nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo1ActionPerformed(evt);
            }
        });
        jPanel2.add(nuevo1);
        nuevo1.setBounds(92, 553, 100, 40);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel2.add(cancelar);
        cancelar.setBounds(210, 553, 100, 40);

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel2.add(guardar);
        guardar.setBounds(328, 553, 100, 40);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel2.add(salir);
        salir.setBounds(446, 553, 100, 40);

        jLabel18.setText("Efectivo* :");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(455, 441, 52, 14);

        txtefectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtefectivoActionPerformed(evt);
            }
        });
        txtefectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtefectivoKeyTyped(evt);
            }
        });
        jPanel2.add(txtefectivo);
        txtefectivo.setBounds(506, 424, 140, 30);

        jLabel19.setText("Subtotal* :");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(669, 432, 53, 14);

        txtsubtotal.setFocusable(false);
        jPanel2.add(txtsubtotal);
        txtsubtotal.setBounds(732, 438, 140, 40);

        jLabel20.setText("Iva* :");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(465, 487, 29, 14);

        txtiva.setFocusable(false);
        jPanel2.add(txtiva);
        txtiva.setBounds(506, 476, 140, 30);

        jLabel21.setText("Total :");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(669, 475, 31, 14);

        txtTotal.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        txtTotal.setFocusable(false);
        jPanel2.add(txtTotal);
        txtTotal.setBounds(736, 486, 230, 60);

        jLabel22.setText("Cambio :");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(465, 525, 42, 14);

        txtcambio.setFocusable(false);
        jPanel2.add(txtcambio);
        txtcambio.setBounds(506, 516, 140, 30);

        guardar1.setText("Realizar venta");
        guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar1ActionPerformed(evt);
            }
        });
        jPanel2.add(guardar1);
        guardar1.setBounds(570, 560, 101, 40);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(729, 303, 95, 36);

        Cargar_cliente.setText("Agregar");
        Cargar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cargar_clienteActionPerformed(evt);
            }
        });
        jPanel2.add(Cargar_cliente);
        Cargar_cliente.setBounds(280, 220, 81, 23);

        btncargar.setText("cargar");
        btncargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarActionPerformed(evt);
            }
        });
        jPanel2.add(btncargar);
        btncargar.setBounds(120, 220, 125, 23);

        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });
        jPanel2.add(txtapellido);
        txtapellido.setBounds(336, 106, 200, 30);

        jLabel3.setText("id_Venta");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(556, 116, 42, 14);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(636, 106, 150, 30);

        jButton3.setText("agregar a la tabla la venta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(1100, 693, 159, 23);
        jPanel2.add(txtNo);
        txtNo.setBounds(718, 522, 6, 20);

        jButton5.setText("cambiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtc.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcFocusGained(evt);
            }
        });
        txtc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcActionPerformed(evt);
            }
        });
        txtc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcKeyTyped(evt);
            }
        });

        jLabel4.setText("Cambiar la cantidad");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtc, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(530, 140, 490, 110);

        jTabbedPane1.addTab("Venta", jPanel2);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Menu");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(419, 21, 58, 45);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayunos", "Almuerzos" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(42, 60, 78, 20);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Ensaladas Francesas", "Ensaladas dulces" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(42, 124, 125, 291);

        cmbplatillos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Almuerzos", "bebidas frias", "bebidas calientes`", "postres" }));
        jPanel1.add(cmbplatillos);
        cmbplatillos.setBounds(42, 93, 125, 20);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(230, 100, 490, 0);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList2);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(820, 124, 151, 169);

        jLabel2.setText("Camtidad");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(582, 457, 53, 23);

        txtcantidad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });
        jPanel1.add(txtcantidad);
        txtcantidad.setBounds(645, 458, 130, 40);

        agregarCompra.setText("Agregar a la Compra");
        agregarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCompraActionPerformed(evt);
            }
        });
        jPanel1.add(agregarCompra);
        agregarCompra.setBounds(811, 449, 160, 38);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(218, 59, 73, 23);

        jTabbedPane1.addTab("Agregar Producto", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void Cargar()
    {
        Connection con=null;
       try {           
                Class.forName("com.mysql.jdbc.Driver");
                 con=DriverManager.getConnection("jdbc:mysql://localhost/reysolbase","root","12345678");
                 Statement st=con.createStatement();
                 String sql="select * from empleados"; 
            ResultSet rs=st.executeQuery(sql);
            cmbvendedores.removeAllItems();
            while(rs.next())
            {       
               entidades.Vendedores campos=new entidades.Vendedores();
                int genero=campos.getGenero(), 
               activo=campos.getActivo();
                 String codigo=campos.getCodigo(), 
              nombre=campos.getNombre(), 
              apellido=campos.getApellido(),
              telefono=campos.getTelefono();
              String correo=campos.getCorreo(),
              direccion=campos.getDireccion(), 
              dpi=campos.getDpi(), 
              idsede=campos.getIdsede(),c1="";              
              codigo=rs.getString("Codigo");
              nombre=rs.getString("Nombre");
              apellido=rs.getString("Apellido");
              genero=rs.getInt("Genero");
              telefono=rs.getString("Telefono");
              correo=rs.getString("Correo");
              direccion=rs.getString("Direccion");
              dpi=rs.getString("DPI");
              activo=rs.getInt("Activo");
              idsede=rs.getString("Idsede");
              c1+=codigo+" "+" "+nombre+" "+apellido;
                cmbvendedores.addItem(c1);
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Registro_Venta.class.getName()).log(Level.SEVERE, null, ex);
            } 
        catch (SQLException ex) {
            Logger.getLogger(Registro_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void CargarPlatillos(){
            Connection cont=null;
       try {
            
             Class.forName("com.mysql.jdbc.Driver");
                 cont=DriverManager.getConnection("jdbc:mysql://localhost/reysolbase","root","12345678");
                 Statement st=cont.createStatement();
                 String sql="select * from platillo"; 
            ResultSet rs=st.executeQuery(sql);
            cmbplatillos.removeAllItems();
            while(rs.next())
            {       
               entidades.Platillo campos=new entidades.Platillo();
               
                String idproducto=campos.getIdProducto(),id_receta=campos.getIdReceta(),nombre=campos.getNombre(),c1="";
                double precio=campos.getPrecio();
                
                
              idproducto =rs.getString("IdProducto");
              nombre=rs.getString("Nombre");
              precio=rs.getDouble("Precio");
              id_receta=rs.getString("IdReceta");
                c1+=nombre+" ";
                cmbplatillos.addItem(c1);
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Registro_Venta.class.getName()).log(Level.SEVERE, null, ex);
            } 
        catch (SQLException ex) {
            Logger.getLogger(Registro_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    private void nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevo1ActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed

    }//GEN-LAST:event_cancelarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        Menu_administrador prin = new  Menu_administrador();
        prin.setVisible(true);
        this.hide();
    }//GEN-LAST:event_salirActionPerformed

    private void guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
 
    jTabbedPane1.setSelectedIndex(1);
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btncargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarActionPerformed

    try{
        String nit = txtnit.getText();
    ClienteServicio conexionCliente = new ClienteServicio();
   Cliente clienteobtenido =  conexionCliente.recuperarPorId(Conexion.obtener(), nit);
    
    
    if(clienteobtenido != null){
    txtnombre.setText(clienteobtenido.getNombre());
    txtapellido.setText(clienteobtenido.getApellido());
    txtdireccion.setText(clienteobtenido.getDireccion());
    txttelefono.setText(clienteobtenido.getTelefono());  
    }else{
   Cargar_cliente.setVisible(true);
    }
    }
    catch(Exception e){
  
 }

    }//GEN-LAST:event_btncargarActionPerformed

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoActionPerformed

    private void agregarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCompraActionPerformed
   
   jTabbedPane1.setSelectedIndex(0);
    
    Vector d =new Vector();
    
     txtTotal.setText("");
     txtiva.setText("");
     txtsubtotal.setText("");

     
     DecimalFormat formato1 = new DecimalFormat("#.00");
    String codigo = "81";
    String descripcion= "hamburuesa";
    double precio_u= 10;
    int cantidad= Integer.parseInt(txtcantidad.getText() );
    
    double sub_total = precio_u * cantidad;
    
    double total = sub_total + suma; 
    formato1.format(sub_total);
    formato1.format(total);
    
    
    d.addElement(codigo);
    d.addElement(descripcion);
    d.addElement(precio_u);
    d.addElement(cantidad);
    d.addElement(sub_total);
    tb.addRow(d);
    jTable1.setModel(tb);
    suma = total + 0;
    
    double iva = total * 0.12;
    double subT = total - iva;      
    txtTotal.setText("Q." + total);
    txtiva.setText("Q."+ formato1.format(iva));
    txtsubtotal.setText("Q."+ formato1.format(subT));
    txtNo.setText(total + "");

    sumaIva = iva + 0;
    sumaSub = subT + 0;

    String n = txtNo.getText();
    jTextArea2.setText("La cantidad a pagar es " + cantidadConLetra(n)+ "Quetzales");
  
    txtcantidad.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarCompraActionPerformed

   
    
    
    private void Cargar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cargar_clienteActionPerformed

        String nom = txtnombre.getText();
        String p1 = nom.substring(0,2);
        String ap = txtapellido.getText();
        String p2 = ap.substring(0,2);
        String ni = txtnit.getText();
        String p3 = ni.substring(0,5);
        String codigoo = p1 + p2+ p3 ;
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setCodigo(codigoo);
        nuevoCliente.setDireccion(txtdireccion.getText());
        nuevoCliente.setApellido(txtapellido.getText());
        nuevoCliente.setNit(txtnit.getText());
        nuevoCliente.setNombre(txtnombre.getText());
        nuevoCliente.setTelefono(txttelefono.getText());
        try 
        {
        ClienteServicio conexionCliente = new ClienteServicio();
        conexionCliente.guardar(Conexion.obtener(), nuevoCliente);
        Conexion.cerrar();
                    // TODO add your handling code here:
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            
        }
    }//GEN-LAST:event_Cargar_clienteActionPerformed

    private void txtnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnitKeyTyped
        char presionada=evt.getKeyChar();
        if(presionada==KeyEvent.VK_ENTER)
        {
            btncargar.doClick();
        }
    }//GEN-LAST:event_txtnitKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      txtefectivo.setText("SI SIRVE");


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
        Venta ven = new Venta();
        ven.setIdVenta("variable");
        ven.setCodigoCliente("variable");
        ven.setCod_vendedor("variable");
        ven.setFecha("variable");
        ven.setHora("variable");
        ven.setTotal(14.5);
  
        try 
        {
        VentaServicio conexionUsuario = new VentaServicio();
        conexionUsuario.guardar(Conexion.obtener(), ven);
        Conexion.cerrar();
                    // TODO add your handling code here:
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        












        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnitActionPerformed

    private void txtefectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtefectivoKeyTyped
    char presionada=evt.getKeyChar();
        if(presionada==KeyEvent.VK_ENTER)
        {
            txtcambio.setText("");
         double dinero= Integer.parseInt(txtefectivo.getText());
         
         double cambio = dinero - suma;
         if(cambio < 0){
         JOptionPane.showMessageDialog(null,"La cantidad de dinero a pagar, es insuficiente");
         txtefectivo.setText("");
         }else{
             txtcambio.setText(cambio +"");
         }  
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_txtefectivoKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     
        jPanel4.setVisible(true);
        txtc.requestFocus();
    // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtcFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcFocusGained

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    jPanel4.setVisible(false);
    DecimalFormat formato1 = new DecimalFormat("#.00");
    int filaSele = jTable1.getSelectedRow();
    String p = (jTable1.getValueAt(filaSele,2).toString());
    int pasado = Integer.parseInt(jTable1.getValueAt(filaSele,3).toString());
    
    String n = txtc.getText();
    int nuevo = 0;
    if(n.equals("")){
     nuevo = pasado;
    }else if(n.equals("0")){
    JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero");
    nuevo = pasado;
    }else{
    nuevo = Integer.parseInt(n);
    }
    double precio = Double.parseDouble(p);
    double nuevoprecio = precio * nuevo;
    double precioPasado = precio * pasado ; 
    tb.setValueAt( nuevo , filaSele, 3);
    tb.setValueAt( nuevoprecio , filaSele, 4);
     
    suma = suma - precioPasado + nuevoprecio;
    double iva = suma * 0.12;
    double subT = suma - iva;      
    txtTotal.setText("Q." + suma);
    txtiva.setText("Q."+ formato1.format(iva));
    txtsubtotal.setText("Q."+ formato1.format(subT));
    txtNo.setText(suma + "");
    String num = txtNo.getText();
    jTextArea2.setText("La cantidad a pagar es " + cantidadConLetra(num)+ "Quetzales"); 
    
    txtc.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    int indice=jTable1.getSelectedRow();
    double total = 0;
    if(indice<0){
    JOptionPane.showConfirmDialog(null, "Fila no Seleccionada");
    }else{
    jPanel4.setVisible(false);
    DecimalFormat formato1 = new DecimalFormat("#.00");
    int filaSele = jTable1.getSelectedRow();
    String p = (jTable1.getValueAt(filaSele,2).toString());
    int pasado = Integer.parseInt(jTable1.getValueAt(filaSele,3).toString()); 
    double precio = Double.parseDouble(p);
    double precioPasado = precio * pasado ; 
    suma = suma - precioPasado;
    double iva = suma * 0.12;
    double subT = suma - iva;      
    txtTotal.setText("Q." + suma);
    txtiva.setText("Q."+ formato1.format(iva));
    txtsubtotal.setText("Q."+ formato1.format(subT));
    txtNo.setText(suma + "");
    String num = txtNo.getText();
    jTextArea2.setText("La cantidad a pagar es " + cantidadConLetra(num)+ "Quetzales"); 
    tb.removeRow(indice);
    }


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
    char validar = evt.getKeyChar();
    if(Character.isLetter(validar)){
    getToolkit().beep();
    evt.consume();
    }
          
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
    


        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void txtefectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtefectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtefectivoActionPerformed

    private void txtcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcActionPerformed

    private void txtcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcKeyTyped
    char validar = evt.getKeyChar();
    if(Character.isLetter(validar)){
    getToolkit().beep();
    evt.consume();
    } // TODO add your handling code here:
    }//GEN-LAST:event_txtcKeyTyped

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
            java.util.logging.Logger.getLogger(Registro_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Venta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Cargar_cliente;
    private javax.swing.JButton agregarCompra;
    private javax.swing.JButton btncargar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> cmbplatillos;
    private javax.swing.JComboBox<String> cmbvendedores;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton nuevo1;
    private javax.swing.JButton salir;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtc;
    private javax.swing.JTextField txtcambio;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtefectivo;
    private javax.swing.JTextField txtiva;
    private javax.swing.JTextField txtnit;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}

