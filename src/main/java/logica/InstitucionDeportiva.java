package logica;

public class InstitucionDeportiva {
    private String nombre;
    private String descripcion;
    private String url;

    // Constructor
    public InstitucionDeportiva(String nombre, String descripcion, String url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }

    // Métodos getter y setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getter y setter para descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos getter y setter para url
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Método para mostrar información de la institución
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("URL: " + url);
    }

    public static void main(String[] args) {
        // Crear una instancia de InstitucionDeportiva
        InstitucionDeportiva institucion = new InstitucionDeportiva("Club Deportivo XYZ", "Club deportivo para practicar varios deportes", "http://www.clubdeportivoxyz.com");

        // Mostrar información de la institución
        institucion.mostrarInformacion();
    }
}
