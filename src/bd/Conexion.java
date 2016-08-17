/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;


import util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import java.sql.*;esto es para que imporet todas las herramientas
//import java.util.*;
//import javax.swing.*; es para importar todos los mensajes
/**
 *
 * @author alum.fial8
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DRIVER ="com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static Connection cx = null;
    
    public static Connection getConexion(){
        try {
            Class.forName(DRIVER);
            if(cx == null){
            cx = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexion: "+e);
        }
        return cx;
    }
    public static void cerrar(){
        if(cx!=null){
            cx = null;
        }
    }
}
