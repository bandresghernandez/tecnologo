package datatypes;

import java.util.Set;

public class DtActividadDeportiva {
    private String nombre;
    private String descripcion;
    private Set<DtClase> clase;

    public DtActividadDeportiva(String nombre, String descripcion, Set<DtClase> clase) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.clase = clase;
    }

    // Métodos getters y setters para los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<DtClase> getClase() {
        return clase;
    }

    /public void setClase(DtClase clase) {
        this.clase = clase;
    }/

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Descripción: " + descripcion + ", Clase: " + clase;
    }
}
