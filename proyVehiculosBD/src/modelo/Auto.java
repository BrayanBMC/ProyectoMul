
package modelo;

public class Auto extends Vehiculo{

    public Auto(String placa, int modelo, String marca, double valor) {
        super(placa, modelo, marca, valor);
    }

    public Auto() {
        super();//Llamado a constructor basico de Vehiculo
    }
 
    @Override
    public double impuesto(){
        if(modelo<2000){
            return valor*0.05;
        }else{
            return valor*0.1;
        }
    } 
    
    public String datosArch(){
        return  placa + ";" + marca + ";" + modelo + ";" + valor + ";" + impuesto();
    }

 
    
}