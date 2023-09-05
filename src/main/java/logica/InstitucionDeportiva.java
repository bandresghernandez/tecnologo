package logica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtHora;
import logica.ActividadDeportiva;


public class InstitucionDeportiva {
    private String nombre;
    private String descripcion;
    private String url;
    private Map<String, ActividadDeportiva> actividades;


    // Constructor
    public InstitucionDeportiva(String nombre, String descripcion, String url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.actividades = new HashMap<>();
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

    /*public List<ActividadDeportiva> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadDeportiva> actividades) {
    	this.actividades = actividades;
	}*/
    
	public Set<String> getActividades() {
		return actividades.keySet();
	}

	public Clase crearClase(String actividad, String nombre, DtFecha fechaIni, DtHora horaIni, String profesor, String url, DtFecha fechaAlta) {
		ActividadDeportiva act = actividades.get(actividad);
		Clase c = act.crearClase(nombre, fechaIni, horaIni, url, fechaAlta, act);
		return c;
	}
	
	public ActividadDeportiva getActividad(String nombre) {
    	ActividadDeportiva act = this.actividades.get(nombre);
    	return act;
    }
    
    public DtActividadDeportiva getDtActividad(String actividad) {
    	ActividadDeportiva act = actividades.get(actividad);
    	return act.getDtActividadDeportiva();
    }
    
    public boolean existeActividadDeportiva(String nombre) {
    	boolean res = false;
    	if(actividades.containsKey(nombre))
    		res = true;
    	return res;
    }
    
    public boolean crearActividadDeportiva(String nombre, String descripcion, int duracion, float costo, DtFecha fechaAlta) {
    	boolean res = false;
		if(!existeActividadDeportiva(nombre)) {
			ActividadDeportiva act = new ActividadDeportiva(nombre, descripcion, duracion, costo, fechaAlta);
			actividades.put(nombre, act);
			res = true;
		}
    	return res;
    }
    
    public DtClase getDtClase(String actividad, String clase) {
    	ActividadDeportiva act = actividades.get(actividad);
    	DtClase dtc = act.getDtClase(clase);
    	return dtc;
    }

	public Clase obtenerClase(String clase, String actividadDeportiva) {
		ActividadDeportiva act = this.actividades.get(actividadDeportiva);
		Clase clac = act.obtenerClase(clase);
		return clac;
	}

    /*public static void main(String[] args) {

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
    //}*/
}
