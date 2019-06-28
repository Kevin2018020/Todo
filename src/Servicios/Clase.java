package SeminarioForms;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario
 */
public class Clase {
    
    Connection com=null;    
public Connection conector(){
    try{
        Class.forName("org.gjt.mm.mysql.Driver");
        com=DriverManager.getConnection("jdbc:mysql://localhost/reysolbase","root","12345678");
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null,ex);
    }
return com;
}
    
}
