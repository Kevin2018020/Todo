/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeminarioForms;

import Servicios.conectar;
import com.sun.glass.events.KeyEvent;
import entidades.Productos;
import entidades.Proveedores;
import entidades.stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Inventario extends javax.swing.JFrame {
    conectar cc=new conectar();
    Connection cn=cc.Conexionn();
    Productos prods=new Productos();
    stock prodss=new stock();
    Proveedores provs=new Proveedores();
    DateFormat f= DateFormat.getDateInstance(); 
    String p="";
    String p1="";
    String productos="";
    DefaultTableModel m;
    /**
     * Creates new form Inventario
     */
    public Inventario() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrar("");
        
   
    }
    
    public void mostrar (String valor){
    String titulos[]={"IdProducto","Nombre","Categoría","Proveedor","Cantidad","Fecha_Vencimiento","Precio"};
    String registro[]=new String[7];
    String sql="select*from stock";
    String sql1="select*from productos";
    m=new DefaultTableModel(null,titulos);
    
    try{
    Statement st=cn.createStatement();
    ResultSet r=st.executeQuery(sql);
    Statement st1=cn.createStatement();
    ResultSet r1=st1.executeQuery(sql1);
    while(r1.next()&& r.next() ){
    registro[0]=r1.getString("IdProducto");
    registro[1]=r1.getString("Nombre");
    registro[2]=r1.getString("Categoria");
     registro[3]=r.getString("NitProveedor");
    registro[4]=r.getString("Cantidad");
    registro[5]=r.getString("FechaVencimiento");
    registro[6]=r.getString("Precio");
    m.addRow(registro);
    }
    tabla.setModel(m);
    }catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    }
   
    }
   public void BuscarProductos()
{
    Vector dato=new Vector();
    
    String bus=txtcodpro.getText();
          String idproducto=prods.getIdprodycto();
                          String Nombre=prods.getNombre();
                          int categoria=prods.getCategoria();
                          int activo=prods.getActivo();
           String nitproveedor=prodss.getNitproveedor();
                          String F_vencimiento=prodss.getFechaVencimiento();
                          int cantidad=prodss.getCantidad();
                          double precio=prodss.getPrecio();
            try
                {
                      String sql="select *from productos where IdProducto='"+bus+"'";
                      String sql1="select *from stock where IdProducto='"+bus+"'";
                      PreparedStatement pes=cn.prepareStatement(sql);
                      PreparedStatement pes1=cn.prepareStatement(sql1);
                      ResultSet raton=pes.executeQuery();
                      
                      while(raton.next() )
                      {
                         
                          idproducto=raton.getString("IdProducto");
                          Nombre=raton.getString("Nombre");
                           categoria=raton.getInt("Categoria");
                           activo =raton.getInt("Activo");
                          
                          
                          if(categoria==0)
                          {
                             cmbregistro.setSelectedItem("Panaderia");
                          } else  if(categoria==1)
                          {
                              cmbregistro.setSelectedItem("Lacteos");
                          }else if(categoria==2)
                          {
                              cmbregistro.setSelectedItem("Tienda");
                          }
                         
                           
                          txtcodpro.setText(idproducto);
                          txtnombrepro.setText(Nombre);
                         descripcion.setText(String.valueOf(activo));
                         
                          
                          
                      }
                      ResultSet raton1=pes1.executeQuery();
                      while(raton1.next())
                      {
                         
                           nitproveedor=raton1.getString("NitProveedor");
                           cantidad=raton1.getInt("Cantidad");
                            F_vencimiento=raton1.getString("FechaVencimiento");
                           precio=raton1.getDouble("Precio");
                           
                      }
                     
     
                }
            catch(Exception e)
                {
                        JOptionPane.showMessageDialog(rootPane, e);
                }
}
    public void Filtrar(){
        String bus=txtcodpro.getText();
        String bnom=txtnombrepro.getText();
        
     String titulos[]={"IdProducto","Nombre","Categoría","Proveedor","Cantidad","Fecha_Vencimiento","Precio"};
    String registro[]=new String[7];
    String sql1="select*from productos where IdProducto like '%"+ bus +"%'";
    String sql="select*from stock where IdProducto like '%"+ bus +"%'";
    m=new DefaultTableModel(null,titulos);
    try{
    Statement st=cn.createStatement();
    ResultSet r=st.executeQuery(sql);
    Statement st1=cn.createStatement();
    ResultSet r1=st1.executeQuery(sql1);
    while(r1.next()&& r.next() ){
    registro[0]=r1.getString("IdProducto");
    registro[1]=r1.getString("Nombre");
    registro[2]=r1.getString("Categoria");
     registro[3]=r.getString("NitProveedor");
    registro[4]=r.getString("Cantidad");
    registro[5]=r.getString("FechaVencimiento");
    registro[6]=r.getString("Precio");
    m.addRow(registro);
    }
    tabla.setModel(m);
    }catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    }
    }
     public void Filtrar1(){
        String bus=txtcodpro.getText();
        String bnom=txtnombrepro.getText();
        
     String titulos[]={"IdProducto","Nombre","Categoría","Proveedor","Cantidad","Fecha_Vencimiento","Precio"};
    String registro[]=new String[7];
    String sql1="select*from productos where Nombre like '%"+ bnom +"%'";
    String sql="select*from stock";
    m=new DefaultTableModel(null,titulos);
    try{
    Statement st=cn.createStatement();
    ResultSet r=st.executeQuery(sql);
    Statement st1=cn.createStatement();
    ResultSet r1=st1.executeQuery(sql1);
    while(r1.next()&& r.next() ){
    registro[0]=r1.getString("IdProducto");
    registro[1]=r1.getString("Nombre");
    registro[2]=r1.getString("Categoria");
     registro[3]=r.getString("NitProveedor");
    registro[4]=r.getString("Cantidad");
    registro[5]=r.getString("FechaVencimiento");
    registro[6]=r.getString("Precio");
    m.addRow(registro);
    }
    tabla.setModel(m);
    }catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    }
    }
    int categoria;
    public void Filtrar2(){
        String cat=cmbregistro.getSelectedItem().toString();
        if(cat.equalsIgnoreCase("Panaderia"))
        {
            categoria=0;
        }
        else if(cat.equalsIgnoreCase("Lacteos"))
        {
            categoria=1;
        }
        else if(cat.equalsIgnoreCase("Tienda"))
        {
            categoria=2;
        }
        else if(cat.equalsIgnoreCase("Todo"))
        {
            categoria=2;
        }
         String titulos[]={"IdProducto","Nombre","Categoría","Proveedor","Cantidad","Fecha_Vencimiento","Precio"};
    String registro[]=new String[7];
    String sql1="select*from productos where Categoria like '%"+categoria+"%'";
    String sql="select*from stock";
    m=new DefaultTableModel(null,titulos);
    try{
    Statement st=cn.createStatement();
    ResultSet r=st.executeQuery(sql);
    Statement st1=cn.createStatement();
    ResultSet r1=st1.executeQuery(sql1);
    while(r1.next()&& r.next() ){
    registro[0]=r1.getString("IdProducto");
    registro[1]=r1.getString("Nombre");
    registro[2]=r1.getString("Categoria");
     registro[3]=r.getString("NitProveedor");
    registro[4]=r.getString("Cantidad");
    registro[5]=r.getString("FechaVencimiento");
    registro[6]=r.getString("Precio");
    m.addRow(registro);
    }
    tabla.setModel(m);
    }catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex);
    }
        
    }
    
    
    

  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnbodega = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        Inventario = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtcodpro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnombrepro = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        cmbregistro = new javax.swing.JComboBox<>();
        btnbuscar = new javax.swing.JButton();
        bfcod = new javax.swing.JButton();
        bfcod1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnbodega.setText("Bodega");
        btnbodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbodegaActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jButton8.setText("Filtro");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Buscar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Buscar Productos"));

        txtcodpro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodproKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombre del producto* :");

        jLabel7.setText("Codigo de producto* :");

        txtnombrepro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreproKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Descripcion"));

        descripcion.setColumns(20);
        descripcion.setRows(5);
        descripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(descripcion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel8.setText("Se registra en* :");

        cmbregistro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Panaderia", "Lacteos", "Tienda", " " }));
        cmbregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbregistroActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        btnbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnbuscarKeyTyped(evt);
            }
        });

        bfcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfcodActionPerformed(evt);
            }
        });

        bfcod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfcod1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 186, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcodpro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombrepro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bfcod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(bfcod1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(66, 66, 66))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodpro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bfcod, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombrepro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bfcod1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        Inventario.addTab("Buscar Productos", jPanel2);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabla);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );

        Inventario.addTab("Filtro", jPanel3);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu_general12.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(930, 930, 930)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(920, 920, 920)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(930, 930, 930)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(920, 920, 920)
                .addComponent(btnbodega, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(btnbodega, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
         Menu_administrador prin = new  Menu_administrador();
        prin.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnbodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbodegaActionPerformed
        Bodega prin = new  Bodega();
        prin.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnbodegaActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
  BuscarProductos();
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void cmbregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbregistroActionPerformed
        Filtrar2();
    }//GEN-LAST:event_cmbregistroActionPerformed

    private void txtcodproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodproKeyTyped
        char presionada=evt.getKeyChar();
        if(presionada==KeyEvent.VK_ENTER)
        {
            bfcod.doClick();
            
        }
         char presionada1=evt.getKeyChar();
        if(presionada1==KeyEvent.VK_ENTER)
        {
            btnbuscar.doClick();
        }
        
    }//GEN-LAST:event_txtcodproKeyTyped

    private void bfcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfcodActionPerformed
        Filtrar();
        
        
    }//GEN-LAST:event_bfcodActionPerformed

    private void btnbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnbuscarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscarKeyTyped

    private void bfcod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfcod1ActionPerformed
        Filtrar1();
        
    }//GEN-LAST:event_bfcod1ActionPerformed

    private void txtnombreproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreproKeyTyped
       char presionada=evt.getKeyChar();
        if(presionada==KeyEvent.VK_ENTER)
        {
            bfcod1.doClick();
            
        }
    }//GEN-LAST:event_txtnombreproKeyTyped

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Inventario.setSelectedIndex(1);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Inventario.setSelectedIndex(0);
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Inventario;
    private javax.swing.JButton bfcod;
    private javax.swing.JButton bfcod1;
    private javax.swing.JButton btnbodega;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cmbregistro;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtcodpro;
    private javax.swing.JTextField txtnombrepro;
    // End of variables declaration//GEN-END:variables
}
