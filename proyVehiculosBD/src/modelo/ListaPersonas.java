//Presentado por: Daniel Callejas
//20212578014
package modelo;

import java.util.ArrayList;

public class ListaPersonas {
    
    private ArrayList <Persona> listaP;
    //constructores
    public ListaPersonas(ArrayList<Persona> listaP) {
        this.listaP = listaP;
    }
    public ListaPersonas() {
        this.listaP = new ArrayList <Persona>();
    }
    //getter and setter
    public ArrayList<Persona> getlistaP() {
        return listaP;
    }
    public void setlistaP(ArrayList<Persona> listaP) {
        this.listaP = listaP;
    }

    
    @Override
    public String toString() {
        String pr = "";
        for (int i=0; i<listaP.size();i++){
            pr+= "Persona: " + (i+1)+":"+listaP.get(i).toString();
        }
        return "\nListaPersona: \n"+pr;
    }
}
