/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author JOSS
 */
public class usuarioDTO {
    private int idUsuario;
    private String Nombre;
    private String apellido;
    private String Usuario;
    private String Pass;

    public usuarioDTO() {
    }

    public usuarioDTO(int idUsuario, String Nombre, String apellido, String Usuario, String Pass) {
        this.idUsuario = idUsuario;
        this.Nombre = Nombre;
        this.apellido = apellido;
        this.Usuario = Usuario;
        this.Pass = Pass;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    
}
