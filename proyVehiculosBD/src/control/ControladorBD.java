/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Auto;
import modelo.AutoDAO;
import modelo.Fecha;
import modelo.Formulario;
import modelo.FormularioDAO;
import modelo.ListaPersonas;
import modelo.Moto;
import modelo.MotoDAO;
import modelo.Persona;
import modelo.PersonaDAO;
import modelo.Recaudo;
import modelo.VehiculoDAO;
import vista.Consulta;
import vista.MDI;
import vista.Registro;

/**
 *
 * @author AngelDarkerZ
 */
public class ControladorBD implements ActionListener{
    
    private Registro frmReg;
    private Consulta frmCon;
    private MDI frmPr;
    private ListaPersonas lPer;
    private Recaudo objR;
    
    //constructores
    public ControladorBD(){
        this.frmReg = new Registro();
        this.frmCon = new Consulta();
        this.frmPr = new MDI();
        this.lPer = new ListaPersonas();
        this.objR = new Recaudo();
    }

    public ControladorBD(Registro frmReg, Consulta frmCon, MDI frmPr, ListaPersonas lPer) {
        this.frmReg = frmReg;
        this.frmCon = frmCon;
        this.frmPr = frmPr;
        this.lPer = lPer;
    }

    public ListaPersonas getlPer() {
        return lPer;
    }

    public void setlPer(ListaPersonas lPer) {
        this.lPer = lPer;
    }

    public Registro getFrmReg() {
        return frmReg;
    }

    public void setFrmReg(Registro frmReg) {
        this.frmReg = frmReg;
    }

    public Consulta getFrmCon() {
        return frmCon;
    }

    public void setFrmCon(Consulta frmCon) {
        this.frmCon = frmCon;
    }

    public MDI getFrmPr() {
        return frmPr;
    }

    public void setFrmPr(MDI frmPr) {
        this.frmPr = frmPr;
    }

    public Recaudo getObjR() {
        return objR;
    }

    public void setObjR(Recaudo objR) {
        this.objR = objR;
    }
    
    //iniciar
    public void iniciar(){
        
        frmPr.setTitle("Vehiculos UD");
        frmPr.getOpcRegistrar().addActionListener(this);
        frmPr.getOpcLista().addActionListener(this);
        frmPr.getOpcSalir().addActionListener(this);
        frmPr.getBtnCon().addActionListener(this);
        frmPr.getBtnReg().addActionListener(this);
        frmPr.getBtnSalir().addActionListener(this);
        
        
        frmCon.getRdbAuto().addActionListener(this);
        frmCon.getRdbMoto().addActionListener(this);
        frmCon.getBtnGroup().add(frmCon.getRdbAuto());
        frmCon.getBtnGroup().add(frmCon.getRdbMoto());
        frmCon.getRdbAuto().setSelected(true);
        
        frmReg.getBtnActualizar().setEnabled(false);
        frmReg.getBtnEliminar().setEnabled(false);
        frmReg.getBtnRegistrar().addActionListener(this);
        frmReg.getBtnActualizar().addActionListener(this);
        frmReg.getBtnConsultar().addActionListener(this);
        frmReg.getBtnEliminar().addActionListener(this);
        
        frmPr.setLocationRelativeTo(null);
        frmPr.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        PersonaDAO prDB = new PersonaDAO();
        VehiculoDAO vDB = new VehiculoDAO();
        Formulario objF = new Formulario();
        
            if(e.getSource()==frmPr.getBtnReg()|| e.getSource()==frmPr.getOpcRegistrar()){
                frmReg.setTitle("Registrar Datos");
                frmPr.getEscritorio().add(frmReg);      
                frmReg.setVisible(true);
            }if (e.getSource().equals(frmReg.getBtnConsultar())){
            //Datos de Persona
                frmReg.getTblDatosP().setModel(prDB.consultarP());
                switch(frmReg.getCmbVehiculo().getSelectedIndex()){
                //Auto
                    case 0:
                        frmReg.getTblDatosV().setModel(vDB.consultarA());
                    break;
                    //Moto
                    case 1:
                        frmReg.getTblDatosV().setModel(vDB.consultarM());
                    break;
                }    
                frmReg.getBtnActualizar().setEnabled(true);
                frmReg.getBtnEliminar().setEnabled(true);
            }if (e.getSource()==frmReg.getBtnRegistrar()){
            Persona objP = new Persona();

            try{
            objF.getUsuario().setNombre(frmReg.getTxtNom().getText());
            objF.getUsuario().setEmail(frmReg.getTxtEmail().getText());
            objF.getUsuario().setId(frmReg.getTxtId().getText());
            objF.getUsuario().setTelefono(frmReg.getTxtTel().getText());
            Calendar fech = frmReg.getjCalendar().getCalendar();
            objF.getUsuario().setfNac(new Fecha(fech.get(Calendar.DAY_OF_MONTH),
                                          fech.get(Calendar.MONTH)+1,
                                          fech.get(Calendar.YEAR)));
            //Datos de Vehiculo
            switch(frmReg.getCmbVehiculo().getSelectedIndex()){
            //Datos Auto
                case 0:
                Auto objA = new Auto();
                    objA.setPlaca(frmReg.getTxtPlaca().getText());
                    objA.setMarca(frmReg.getTxtMarca().getText());
                    objA.setModelo((int)frmReg.getSldModel().getValue());
                    objA.setValor(Double.parseDouble(frmReg.getTxtValor().getText()));
                    objF.setVehi(objA);
                    objR.getListaF().add(objF);
                    int cd1 = +(int)(Math.random()*999+100);
                    String numF = "FMR-"+cd1;
                    vDB.setObjA((Auto) objF.getVehi());
                    JOptionPane.showMessageDialog(frmReg, vDB.insertarA());
                    break;
                case 1:
                Moto objM = new Moto();
                    objM.setPlaca(frmReg.getTxtPlaca().getText());
                    objM.setMarca(frmReg.getTxtMarca().getText());
                    objM.setModelo((int)frmReg.getSldModel().getValue());
                    objM.setValor(Double.parseDouble(frmReg.getTxtValor().getText()));
                    objM.setCilindraje(Integer.parseInt(frmReg.getTxtCilind().getText()));
                    objF.setVehi(objM);
                    objR.getListaF().add(objF);
                    int cd2 = +(int)(Math.random()*999+100);
                    String numF2 = "FMR-"+cd2;
                    vDB.setObjM((Moto) objF.getVehi());
                    JOptionPane.showMessageDialog(frmReg, vDB.insertarM());
                    break;
            }
            lPer.getlistaP().add(objF.getUsuario());
            agregarDatosP(objF, frmReg.getTblDatosP());
            agregarDatosV(objF, frmReg.getTblDatosV());
            JOptionPane.showMessageDialog(frmReg, objF.toString());
            prDB.setObjP(objF.getUsuario());
            JOptionPane.showMessageDialog(frmReg, prDB.insertarP());
            }
            catch(NumberFormatException ex){
                    String []dato=ex.getMessage().split(":");
                JOptionPane.showMessageDialog(frmReg,"Error en dato numérico: "+dato[1]);
            //} catch (IOException ex) {
                JOptionPane.showMessageDialog(frmReg, "Error de escritura en archivo");
            }
            }if (e.getSource().equals(frmReg.getBtnActualizar())){
            enviarPersonaDAO(prDB, frmReg.getTblDatosP());
            JOptionPane.showMessageDialog(frmReg, prDB.actualizarM());
            }if (e.getSource().equals(frmReg.getBtnEliminar())){
            JTable tabla = frmReg.getTblDatosP();
            DefaultTableModel plantilla= (DefaultTableModel) tabla.getModel();
            enviarPersonaDAO(prDB, tabla);
            JOptionPane.showMessageDialog(frmReg, prDB.eliminarM());
            plantilla.removeRow(tabla.getSelectedRow());
        }
    }
    
    public void agregarDatosP(Formulario f, JTable tabla){
        Object datos[]= {f.getUsuario().getNombre(), f.getUsuario().getEmail(), f.getUsuario().getId(),
                         f.getUsuario().getTelefono(), f.getUsuario().getfNac().cantAnios()};
        DefaultTableModel plantilla= (DefaultTableModel) tabla.getModel();
        plantilla.addRow(datos);
    }
    
    public void agregarDatosV(Formulario f, JTable tabla){
        String tipo = "";
        if(f.getVehi() instanceof Moto)
           tipo = "Moto";
        if(f.getVehi() instanceof Auto)
           tipo = "Auto";
        
        Object datos[]= {tipo, f.getVehi().getPlaca(),
                        f.getVehi().getMarca(), f.getVehi().getModelo(), 
                        f.getVehi().getValor()};
        DefaultTableModel plantilla= (DefaultTableModel) tabla.getModel();
        plantilla.addRow(datos);
    }
    
    public void enviarVDAO(VehiculoDAO objVb, JTable tabla){
        int fila=tabla.getSelectedRow();
        switch(frmReg.getCmbVehiculo().getSelectedIndex()){
            //Auto
            case 0:
                objVb.setObjA(new Auto(tabla.getValueAt(fila, 0).toString(),
                                       Integer.parseInt(tabla.getValueAt(fila, 1).toString()),
                                       tabla.getValueAt(fila, 2).toString(),
                                       Double.parseDouble(tabla.getValueAt(fila, 3).toString())));
            break;
            //Moto
            case 1:
                objVb.setObjM(new Moto(tabla.getValueAt(fila, 0).toString(),
                                       Integer.parseInt(tabla.getValueAt(fila, 1).toString()),
                                       tabla.getValueAt(fila, 2).toString(),
                                       Double.parseDouble(tabla.getValueAt(fila, 3).toString()),
                                       Integer.parseInt(tabla.getValueAt(fila, 4).toString())));
            break;
                
        }
    }
    
    public void enviarPersonaDAO(PersonaDAO objPb, JTable tabla){
        int fila=tabla.getSelectedRow();
        objPb.setObjP(new Persona(tabla.getValueAt(fila, 0).toString(),
                                  tabla.getValueAt(fila, 1).toString(),
                                  tabla.getValueAt(fila, 2).toString(),
                                  tabla.getValueAt(fila, 3).toString()));
    }
    
}
