package logica;
import java.util.ArrayList;
import java.util.List;

import logica.ActividadDeportiva;

public class InstitucionDeportiva {
    private String nombre;
    private String descripcion;
    private String url;
    private List<ActividadDeportiva> actividades;


    // Constructor
    public InstitucionDeportiva(String nombre, String descripcion, String url, List<ActividadDeportiva> actividades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.actividades = actividades;
    }
    
 // Getters y setters para los atributos

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ActividadDeportiva> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadDeportiva> actividades) {
        this.actividades = actividades;
    }

    public static void main(String[] args) {

        // Crear una lista de actividades deportivas
       List<ActividadDeportiva> actividades = new ArrayList<>();
        actividades.add(new ActividadDeportiva("Fútbol", "de futbol",0, 0, null));
        actividades.add(new ActividadDeportiva("Yoga", "de YOGA",0, 0, null));
       

        // Crear una instancia de InstitucionDeportiva utilizando el constructor
        InstitucionDeportiva institucion = new InstitucionDeportiva("Deportes Total",
                "Centro deportivo con varias instalaciones",
                "http://www.deportestotal.com",
                actividades);

        // Imprimir información de la institución
        System.out.println("Nombre: " + institucion.getNombre());
        System.out.println("Descripción: " + institucion.getDescripcion());
        System.out.println("URL: " + institucion.getUrl());
        System.out.println("Actividades:");

        for (ActividadDeportiva actividad : institucion.getActividades()) {
            System.out.println("- " + actividad.getNombre());
        }
    }
    
    
    
    

    // Método para mostrar información de la institución
//    public void mostrarInformacion() {
//        System.out.println("Nombre: " + nombre);
//        System.out.println("Descripción: " + descripcion);
 //       System.out.println("URL: " + url);
  //  }

  //  public static void main(String[] args) {
        // Crear una instancia de InstitucionDeportiva
    //    InstitucionDeportiva institucion = new InstitucionDeportiva("Club Deportivo XYZ", "Club deportivo para practicar varios deportes", "http://www.clubdeportivoxyz.com");

        // Mostrar información de la institución
      //  institucion.mostrarInformacion();
    //}
}
