package modelo;

public class Moto extends Vehiculo{
    
    private int cilindraje;
    
    public Moto(String placa, int modelo, String marca, double valor, int cilindraje) {
        super(placa, modelo, marca, valor);
        this.cilindraje = cilindraje;
    }

    public Moto() {
        super();//Llamado a constructor basico de Vehiculo
        cilindraje = 0;
    }
 
    @Override
    public double impuesto(){
        if(cilindraje>125){
            return valor*0.1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString()+ "\ncilindraje: " + cilindraje;
    }

    public String datosArch(){
        return  placa + ";" + marca + ";" + modelo + ";" + valor + ";" + cilindraje + ";" + impuesto();
    }
    
    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }  
}
