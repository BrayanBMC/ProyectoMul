/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sonia Pinzón
 */
public class ConexionBD {
  private Connection conexion;
  private String bd,usuario, clave,mensaje;

    public ConexionBD(Connection conexion, String bd, String usuario, String clave, String mensaje) {
        this.conexion = conexion;
        this.bd = bd;
        this.usuario = usuario;
        this.clave = clave;
        this.mensaje = mensaje;
    }
   public ConexionBD() {
        this.conexion = null;
        this.bd = "productos";
        this.usuario = "root";
        this.clave = "";
        this.mensaje = "";
    }
public void conectar(){
      try {
          Class.forName("com.mysql.jdbc.Driver");
          String ruta="jdbc:mysql://localhost/"+bd; //localhost:3307 - 3306
          System.out.println(ruta);
          conexion= DriverManager.getConnection(ruta,usuario,clave);
          mensaje="Conexión exitosa...";
      } catch (ClassNotFoundException ex) {
          mensaje="No se pudo establecer conexion...";
      } catch (SQLException ex) {
           mensaje=" No se puede conectar con MySQL...";
      }
}
   
    @Override
    public String toString() {
        return "Conexion{" + "conexion=" + conexion + ", bd=" + bd + ", usuario=" + usuario + ", clave=" + clave + ", mensaje=" + mensaje + '}';
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
   
}
