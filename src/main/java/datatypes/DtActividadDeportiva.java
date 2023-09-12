package datatypes;

import java.util.Set;

public class DtActividadDeportiva {
    private String nombre;
    private String descripcion;
    private Set<DtClase> clase;
      private int duracion;
    private float costo;
    private DtFecha fechaReg;
    
  public DtActividadDeportiva(String nombre, String descripcion, int duracion, float costo, DtFecha fechaReg) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        //this.clase = clase;
       this.duracion = duracion;
        this.costo = costo;
        this.fechaReg = fechaReg;
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
    /*
    public Set<DtClase> getClase() {
        return clase;
    }

     public void setClase(Set<DtClase> clase) {
        this.clase = clase;
    }*/
    
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

    
   @Override
	public String toString() {
		return "Nombre de la Actividad: " + nombre + " \n"+ "Descripcion: " + descripcion + " \n"+ "Duracion: " + duracion
				+ " \n"+ "Costo: " + costo +" \n"+  "FechaReg: " + fechaReg;
	}
}
