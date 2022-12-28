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
public class FormularioDAO {
    
    Formulario objFrm;
    Fecha objF;
    Hora objH;
    Persona objP;
    Vehiculo objV;
    
    public FormularioDAO(Formulario objFrm) {
        this.objFrm = objFrm;
    }
    
    public FormularioDAO(){
        this.objFrm = new Formulario();
    }

    public Formulario getObjFrm() {
        return objFrm;
    }

    public void setObjFrm(Formulario objFrm) {
        this.objFrm = objFrm;
    }

    public DefaultTableModel consultarFac(){
         DefaultTableModel plantilla= new DefaultTableModel();
         ConexionBD con= new ConexionBD();
        try {
            con.conectar();
            Statement consulta= con.getConexion().createStatement();
            ResultSet datos= consulta.executeQuery("select * from formulario");
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
            String comando= "insert into formulario values(?,?,?,?,?,?)";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.setString(1,objFrm.getNroF());
            consulta.setString(2,objF.toString());
            consulta.setString(3,objH.toString());
            consulta.setString(4,objP.getNombre());
            consulta.setObject(5,objV.toString());
            consulta.setString(6,objFrm.getVehi().getPlaca());
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
            String comando= "update formulario set fechV=?,horaV=?,FK_nombreP=?, tipoV=?, FK_placaV=?"+
                            " where nroF='"+objFrm.getNroF()+"'";
            consulta=conexion.getConexion().prepareStatement(comando);
           // consulta.setString(1,objP.getCod());
            consulta.setString(1,objF.toString());
            consulta.setString(2,objH.toString());
            consulta.setString(3,objP.getNombre());
            consulta.setObject(4,objV.toString());
            consulta.setString(5,objFrm.getVehi().getPlaca());
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
            String comando= "delete from formulario"+
                            " where nroF='"+objFrm.getNroF()+"'";
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
    
    @Override
    public String toString() {
        return objFrm.toString();
    }
    
}