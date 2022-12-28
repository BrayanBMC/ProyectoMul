package modelo;

public class Persona
{
    private String nombre, email, id, telefono;
    private Fecha fNac;
    //constructores
    public Persona(String nombre, String email, String id, String telefono, Fecha fNac) {
        this.nombre = nombre;
        this.email = email;
        this.id = id;
        this.telefono = telefono;
        this.fNac = fNac;
    }
    
    public Persona(String nombre, String email, String id, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.id = id;
        this.telefono = telefono;
    }
    
    public Persona()
    {
        this.nombre = "";
        this.email = "";
        this.id = "";
        this.telefono = "";
        this.fNac= new Fecha();
    }
    //getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Fecha getfNac() {
        return fNac;
    }

    public void setfNac(Fecha fNac) {
        this.fNac = fNac;
    }
    
    public int edad()
    {
        return fNac.cantAnios();
    }
    
    @Override
    public String toString()
    { 
        return 
               "\nNombre: "+ nombre +
               "\nEmail: "+ email +
               "\nIdentificación: "+ id +
               "\nTelefono: "+ telefono +
               "\nFecha de nacimiento: "+ fNac.toString();
    }      
}