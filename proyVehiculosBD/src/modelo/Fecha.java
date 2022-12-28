//Presentado por: Daniel Callejas
//20212578014
package modelo;

import java.util.Calendar;

public class Fecha {
    private int dd,mm,aa;

    public Fecha(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }
    public Fecha() {
        Calendar fech = Calendar.getInstance();
        this.dd = fech.get(Calendar.DAY_OF_MONTH);
        this.mm = fech.get(Calendar.MONTH)+1;
        this.aa = fech.get(Calendar.YEAR);
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }
    //metodo
    public int cantAnios(){
        Calendar fech = Calendar.getInstance();
        return fech.get(Calendar.YEAR) - aa;
    }
    
    @Override
    public String toString() {
        return dd + "/" + mm + "/" + aa;
    }
    
}
