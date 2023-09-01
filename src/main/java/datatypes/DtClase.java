package datatypes;

public class DtClase {
    private String nombre;
    private DtFecha fecha;

    public DtClase(String nombre, DtFecha fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
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
        return "Nombre: " + nombre + ", Fecha: " + fecha;
    }
}
