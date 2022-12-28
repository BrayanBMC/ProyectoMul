
package modelo;

public abstract class Vehiculo {
    protected String placa;
    protected int modelo;
    protected String marca;
    protected double valor;

    public Vehiculo(String placa, int modelo, String marca, double valor) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.valor = valor;
    }
    
    public Vehiculo(){
        placa = "";
        modelo = 0;
        marca = "";
        valor = 0;
    }
    
    public abstract double impuesto();
    
    public String getPlaca() {
        return placa;
    }

    public int getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getValor() {
        return valor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + 
                "\nModelo: " + modelo + 
                "\nMarca: " + marca + 
                "\nValor: " + String.format("%.0f", valor);
    } 
}
