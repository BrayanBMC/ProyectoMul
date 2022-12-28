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
public class MotoDAO {
    
    Moto objM;

    public MotoDAO(Moto objM) {
        this.objM = objM;
    }
    
    public MotoDAO(){
        this.objM = new Moto();
    }
    
    public DefaultTableModel consultarM(){
         DefaultTableModel plantilla= new DefaultTableModel();
         ConexionBD con= new ConexionBD();
        try {
            con.conectar();
            Statement consulta= con.getConexion().createStatement();
            ResultSet datos= consulta.executeQuery("select * from moto");
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
    
        public String insertarM(){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into moto values(?,?,?,?,?)";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.setString(1,objM.getPlaca());
            consulta.setInt(2,objM.getModelo());
            consulta.setString(3,objM.getMarca());
            consulta.setDouble(4,objM.getValor());
            consulta.setInt(5,objM.getCilindraje());
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
            String comando= "update moto set modeloM=?,marcaM=?,valorM=?, cilindrajeM=?"+
                            " where placaM='"+objM.getPlaca()+"'";
            consulta=conexion.getConexion().prepareStatement(comando);
           // consulta.setString(1,objP.getCod());
            consulta.setInt(1,objM.getModelo());
            consulta.setString(2,objM.getMarca());
            consulta.setDouble(3,objM.getValor());
            consulta.setInt(4,objM.getCilindraje());
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
            String comando= "delete from moto"+
                            " where placaM='"+objM.getPlaca()+"'";
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

    public Moto getObjM() {
        return objM;
    }

    public void setObjM(Moto objM) {
        this.objM = objM;
    }

    @Override
    public String toString() {
        return objM.toString();
    }
    
}
