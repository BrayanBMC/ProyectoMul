/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Registro;

/**
 *
 * @author AngelDarkerZ
 */
public class PersonaDAO {
    
    Persona objP;

    public PersonaDAO(Persona objP) {
        this.objP = objP;
    }
    
    public PersonaDAO(){
        this.objP = new Persona();
    }
    
    public DefaultTableModel consultarP(){
         DefaultTableModel plantilla= new DefaultTableModel();
         ConexionBD con= new ConexionBD();
        try {
            con.conectar();
            Statement consulta= con.getConexion().createStatement();
            ResultSet datos= consulta.executeQuery("select * from persona");
            ResultSetMetaData campos=datos.getMetaData();
            for (int i = 1; i <= campos.getColumnCount(); i++) {
                plantilla.addColumn(campos.getColumnName(i));
            }
            while(datos.next()){
             Object fila[]=new Object[campos.getColumnCount()];
                for (int i = 0; i < campos.getColumnCount(); i++) {
                   fila[i]=datos.getObject(i+1);
                }
                plantilla.addRow(fila);
            }
            datos.close();
            con.getConexion().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return plantilla;
    }
    
        public String insertarP(){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into persona values(?,?,?,?,?)";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.setString(1,objP.getNombre());
            consulta.setString(2,objP.getEmail());
            consulta.setString(3,objP.getId());
            consulta.setString(4,objP.getTelefono());
            consulta.setInt(5, objP.getfNac().cantAnios());
            consulta.execute();
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
      return mensaje;  
    }
        
    public String actualizarM(){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "update persona set nombreP=?,emailP=?,telefonoP=?"+
                            " where idP='"+objP.getId()+"'";
            consulta=conexion.getConexion().prepareStatement(comando);
           // consulta.setString(1,objP.getCod());
            consulta.setString(1,objP.getNombre());
            consulta.setString(2,objP.getEmail());
            consulta.setString(3,objP.getTelefono());
            consulta.execute();
            mensaje="Actualización exitosa...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar actualizar...\n"+ex;
        }
      return mensaje;  
    }
    public String eliminarM(){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "delete from persona"+
                            " where idP='"+objP.getId()+"'";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.execute();
            mensaje="Eliminación exitosa...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar eliminar...\n"+ex;
        }
      return mensaje;
    }

    public Persona getObjP() {
        return objP;
    }

    public void setObjP(Persona objP) {
        this.objP = objP;
    }
    
}
