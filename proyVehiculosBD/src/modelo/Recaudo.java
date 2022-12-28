
package modelo;

import java.util.ArrayList;

public class Recaudo {
    private ArrayList <Formulario> listaF;
    //constructores
    public Recaudo(ArrayList<Formulario> listaF) {
        this.listaF = listaF;
    }
    public Recaudo() {
        this.listaF = new ArrayList<Formulario>();
    }
    //getter and setter
    public ArrayList<Formulario> getListaF() {
        return listaF;
    }

    public void setListaF(ArrayList<Formulario> listaF) {
        this.listaF = listaF;
    }
    
    // metodos
    
    @Override
    public String toString() {
        String form = "", tipoV;
        for(int i=0; i<listaF.size(); i++) {
            if(listaF.get(i).getVehi()instanceof Auto){
                tipoV = "Formulario Auto\n"; 
            }else{
                tipoV = "Formulario Moto\n";
            }
            form+=listaF.get(i).toString()+"\n"+
                    "Valor Impuesto: "+listaF.get(i).valorPago();
        }   
        return form + "\n";
    }

    public double totalRecaudo() {
        double form = 0;
        for(int i=0; i<listaF.size(); i++) {
            form+=listaF.get(i).valorPago();      
        }   
        return form;
    }
    
    public int cantAutos() {
        int cant = 0;
        for(int i=0; i<listaF.size(); i++) {
            if(listaF.get(i).getVehi()instanceof Auto)
                cant++; 
        }   
        return cant;
    }
    
    public int cantMoto() {
        int cant = 0;
        for(int i=0; i<listaF.size(); i++) {
            if(listaF.get(i).getVehi()instanceof Moto)
                cant++; 
        }   
        return cant;
    }
}
