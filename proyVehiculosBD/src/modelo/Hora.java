//Presentado por: Daniel Callejas
//20212578014
package modelo;

import java.util.Calendar;

public class Hora {
    private int hh,mm,ss;
    //constructores
    public Hora(int hh, int mm, int ss) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }
    public Hora() {
        Calendar hora = Calendar.getInstance();
        this.hh = hora.get(Calendar.HOUR_OF_DAY);
        this.mm = hora.get(Calendar.MINUTE);
        this.ss = hora.get(Calendar.SECOND);
    }
    //Getter and setter

    public int getHh() {
        return hh;
    }

    public void setHh(int hh) {
        this.hh = hh;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }
    
    @Override
    public String toString() {
        return hh + ":" + mm + ":" + ss;
    }
    
}