package logica;

import datatypes.DtFecha;

public class ActividadDeportiva {
    private String nombre;
    private String descripcion;
    private int duracion;
    private float costo;
    private DtFecha fechaReg;

    public ActividadDeportiva(String nombre, String descripcion, int duracion, float costo, DtFecha fechaReg) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaReg = fechaReg;
    }

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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public DtFecha getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(DtFecha fechaReg) {
        this.fechaReg = fechaReg;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Costo: $" + costo);
        System.out.println("Fecha de Registro: " + fechaReg);
    }

    public static void main(String[] args) {
        DtFecha fecha = new DtFecha(8, 8, 2023);
        ActividadDeportiva actividad = new ActividadDeportiva("Clase de Yoga", "Clase de yoga para relajación", 60, 10.99f, fecha);

        actividad.mostrarInformacion();
    }
}
