package datatypes;

public class DtClase {
    private String nombre;
    private DtFecha fecha;

    public DtClase(String nombre, DtFecha fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    // Métodos getters y setters para los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DtFecha getFecha() {
        return fecha;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Fecha: " + fecha;
    }
}

