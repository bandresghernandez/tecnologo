package datatypes;

public class DtProfesor extends DtUsuario {
    private String descripcion;
    private String bio;
    private String web;
    private DtActividadDeportiva actividad;
    private DtClase clase;

    public DtProfesor(String nickname, String nombre, String apellido, String email,
    		DtFecha fechaNac,String descripcion, String bio, String web,
                      DtActividadDeportiva actividad, DtClase clase) {
        super(nickname, nombre, apellido, email, fechaNac);
        this.descripcion = descripcion;
        this.bio = bio;
        this.web = web;
        this.actividad = actividad;
        this.clase = clase;
    }

    // Getters y setters para los atributos
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public DtActividadDeportiva getActividad() {
        return actividad;
    }

    public void setActividad(DtActividadDeportiva actividad) {
        this.actividad = actividad;
    }

    public DtClase getClase() {
        return clase;
    }

    public void setClase(DtClase clase) {
        this.clase = clase;
    }
}

