/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.usuarioDTO;
import interfaces.Operaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.Conexion;

/**
 *
 * @author JOSS
 */
public class usuarioDAO implements Operaciones<usuarioDTO>{
    private Connection cx;
    private ResultSet rs;
    private PreparedStatement ps;
    
    
    private final String SQL_VALIDARuser = "SELECT *FROM usuario WHERE usser=?";
    private final String SQL_VALIDARpass = "SELECT *FROM usuario WHERE usser=?";
    private final String SQL_VALIDAR = "SELECT *FROM usuario WHERE usser=? AND pass=?";

    private final String SQL_CREATE = "INSERT INTO usuario(idusuario,nombre, apellido, usser, pass) VALUES(NULL ,? ,?,?,?)";
    private final String SQL_UPDATE = "UPDATE usuario SET  nombre=?, apellido=?, usser=?, pass=? WHERE  idusuario=?";
    private final String SQL_DELETE = "DELETE FROM usuario WHERE idusuario=?";
    private final String SQL_READ = "SELECT *FROM usuario WHERE idusuario=?";
    private final String SQL_READALL = "SELECT *FROM usuario";
    private final String SQL_READ2 = "SELECT *FROM usuario WHERE usser=?";
    
    public boolean validarUser(String usuario) {
        boolean cd = false;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_VALIDARuser);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                cd = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente: " + e);
        } finally {
            Conexion.cerrar();
        }
        return cd;
    }

    public boolean validarPass(String pass) {
        boolean cd = false;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_VALIDARpass);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                cd = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente: " + e);
        } finally {
            Conexion.cerrar();
        }
        return cd;
    }

    public boolean validarUser(String usuario, String pass) {
        boolean ud = false;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_VALIDAR);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                ud = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "User: " + e);
        } finally {
            Conexion.cerrar();
        }
        return ud;
    }

    @Override
    public int create(usuarioDTO e) {
     int ud = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_CREATE);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getUsuario());
            ps.setString(4, e.getPass());
            ud = ps.executeUpdate();
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "User: " + x);
        } finally {
            Conexion.cerrar();
        }
        return ud;
    }

    @Override
    public int update(usuarioDTO e) {
      int ud = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_UPDATE);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getUsuario());
            ps.setString(4, e.getPass());
            ud = ps.executeUpdate();  
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "User: " + x);
        } finally {
            Conexion.cerrar();
        }
        return ud;
    }

    @Override
    public int delete(Object key) {
     int ud = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_DELETE);
            ps.setObject(1, key);
            ud = ps.executeUpdate();
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "User: " + x);
        } finally {
            Conexion.cerrar();
        }
        return ud;
    }

    @Override
    public List<usuarioDTO> readAll() {
     List<usuarioDTO> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuarioDTO udto = new usuarioDTO();
                udto.setIdUsuario(rs.getInt("idusuario"));
                udto.setNombre(rs.getString("nombre"));
                udto.setApellido(rs.getString("apellido"));
                udto.setIdUsuario(rs.getInt("usuario"));
                udto.setPass(rs.getString("pass"));
                lista.add(udto);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "User: " + e);
        } finally {
            Conexion.cerrar();
        }
        return lista;
    }

    @Override
    public usuarioDTO read(Object key) {
    usuarioDTO udto = new usuarioDTO();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_READ);
            ps.setObject(1, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                udto.setIdUsuario(rs.getInt("idusuario"));
                udto.setNombre(rs.getString("nombre"));
                udto.setApellido(rs.getString("apellido"));
                udto.setUsuario(rs.getString("usuario"));
                udto.setPass(rs.getString("pass"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "read: " + e);
        } finally {
            Conexion.cerrar();
        }
        return udto;
    }

    @Override
    public boolean search(String e) {
    boolean ud = false;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_READ2);
            ps.setString(1, e);
            rs = ps.executeQuery();
            while (rs.next()) {
                ud = true;
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "search: " + e);
        } finally {
            Conexion.cerrar();
        }

        return ud;
    }
    
}
