package logica;

import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import java.util.HashMap;
import java.util.HashSet;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtHora;

@Entity
public class ActividadDeportiva {
	@Id
    private String nombre;
    private String descripcion;
    private int duracion;
    private float costo;
    @Type(type = "logica.DtFechaUserType")
    private DtFecha fechaReg;
	@OneToMany(mappedBy = "actividadDepo",cascade = CascadeType.ALL)
    private Map<String, Clase> clases;

    public ActividadDeportiva() {
    	super();
    }
    public ActividadDeportiva(String nombre, String descripcion, int duracion, float costo, DtFecha fechaReg) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaReg = fechaReg;
       this.clases = new HashMap<>();
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
    
    public boolean existeClase(String nombre) {
    	boolean res = false;
    	if(clases.containsKey(nombre))
    		res = true;
    	return res;
    }
    
    public Clase crearClase(String nombre, DtFecha fechaIni, DtHora horaIni, String url, DtFecha fechaAlta, ActividadDeportiva actividadDepo) {
    	Clase c = null;
    	if(!existeClase(nombre)) {
    		c = new Clase(nombre, fechaIni, horaIni, url, fechaAlta, actividadDepo);
    		clases.put(nombre, c);
    	}
    	return c;
    }
    
    public DtActividadDeportiva getDtActividadDeportiva() {
    	Set<DtClase> dtc = new HashSet<>();
    	for(Clase c : clases.values())
    		dtc.add(c.getDtClase());
    	return new DtActividadDeportiva(this.nombre, this.descripcion, this.duracion, this.costo,  this.fechaReg);
    }
    
    public DtClase getDtClase(String nombre) {
    	return clases.get(nombre).getDtClase();
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

	public DtActividadDeportiva obtenerInfo() {
		// TODO Auto-generated method stub
		return new DtActividadDeportiva(this.nombre, this.descripcion, this.duracion, this.costo,  this.fechaReg);	}

	public Clase obtenerClase(String clase) {
		return this.clases.get(clase);
	}
	
	 public Set<String> getClases() {
        return clases.keySet(); // Devuelve el conjunto de nombres de las clases
    }
}
