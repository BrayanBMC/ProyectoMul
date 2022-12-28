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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AngelDarkerZ
 */
public class AutoDAO {

    Auto objA;

    public AutoDAO(Auto objA) {
        this.objA = objA;
    }
    
    public AutoDAO(){
        this.objA = new Auto();
    }
    
    public DefaultTableModel consultarA(){
         DefaultTableModel plantilla= new DefaultTableModel();
         ConexionBD con= new ConexionBD();
        try {
            con.conectar();
            Statement consulta= con.getConexion().createStatement();
            ResultSet datos= consulta.executeQuery("select * from auto");
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
    
        public String insertarA(){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into auto values(?,?,?,?)";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.setString(1,objA.getPlaca());
            consulta.setInt(2,objA.getModelo());
            consulta.setString(3,objA.getMarca());
            consulta.setDouble(4,objA.getValor());
            consulta.execute();
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
      return mensaje;  
    }
        
    public String actualizarA(){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "update auto set modeloA=?,marcaA=?,valorA=?"+
                            " where placaA='"+objA.getPlaca()+"'";
            consulta=conexion.getConexion().prepareStatement(comando);
           // consulta.setString(1,objP.getCod());
            consulta.setInt(1,objA.getModelo());
            consulta.setString(2,objA.getMarca());
            consulta.setDouble(3,objA.getValor());
            consulta.execute();
            mensaje="Actualización exitosa...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar actualizar...\n"+ex;
        }
      return mensaje;  
    }
    public String eliminarA(){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "delete from auto"+
                            " where placaA='"+objA.getPlaca()+"'";
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

    public Auto getObjA() {
        return objA;
    }

    public void setObjA(Auto objA) {
        this.objA = objA;
    }

    @Override
    public String toString() {
        return objA.toString();
    }
    
}
