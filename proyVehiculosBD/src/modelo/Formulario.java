//Presentado por: Daniel Callejas
//20212578014
package modelo;

public class Formulario {
    private String nroF;
    private Fecha fech;
    private Hora hour;
    private Persona usuario;
    private Vehiculo vehi;
   //constructores
    public Formulario(String nroF, Fecha fech, Hora hour, Persona usuario, Vehiculo vehi) {
        this.nroF = nroF;
        this.fech = fech;
        this.hour = hour;
        this.usuario = usuario;
        this.vehi = vehi;
    }  
    public Formulario() {
        int cod = (int)(Math.random()*999+100);
        this.nroF = "FMR-"+cod;
        this.fech = new Fecha();
        this.hour = new Hora();
        this.usuario = new Persona();
        this.vehi = null;
    }
    //getter and setter

    public String getNroF() {
        return nroF;
    }

    public void setNroF(String nroF) {
        this.nroF = nroF;
    }
    

    public Fecha getFech() {
        return fech;
    }

    public void setFech(Fecha fech) {
        this.fech = fech;
    }

    public Hora getHour() {
        return hour;
    }

    public void setHour(Hora hour) {
        this.hour = hour;
    }

    public Persona getUsuario() {
        return usuario;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public Vehiculo getVehi() {
        return vehi;
    }

    public void setVehi(Vehiculo vehi) {
        this.vehi = vehi;
    }
    
    //metodos
    public double valorPago(){
        return vehi.impuesto();
    }
    
    @Override
    public String toString()
    {
        return "\nFormulario N°: " + nroF+
               "\nFecha: " + fech.toString()+
               "\nHora: " + hour.toString() +
               "\nDatos Propietario: " + usuario.toString()+
               "\nEdad: " + usuario.edad()+
               "\nDatos Vehiculo: " + vehi.toString();                     
    }
}