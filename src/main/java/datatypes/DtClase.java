package datatypes;

public class DtClase {
    private String nombre;
    private DtFecha fecha;
    private DtHora horaInicio;
    private String url;
    private DtFecha fechaReg;

    public DtClase(String nombre, DtFecha fecha,DtHora horaInicio,String url,DtFecha fechaReg ) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.horaInicio =horaInicio ;
        this.url=url;
        this.fechaReg=fechaReg;
    }

    // Métodos getters 
    public String getNombre() {
        return nombre;
    }



    public DtFecha getFecha() {
        return fecha;
    }



    @Override
    public String toString() {
        return "Nombre: " + nombre + " \n"+ "Fecha: " + fecha + " \n" + "Hora de inicio: " + horaInicio + " \n" + "URL : "+ url + " \n" + "Fecha de Alta : " + fechaReg;
    }
}