package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtHora;
import interfaces.ICInstitucion;
import excepciones.InstitucionRepetidaExcepcion;

public class CInstitucion implements ICInstitucion {
	
	
	
	
	
	private String institucion;
	private String actividadDeportiva;
	private String clase;
	
	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getActividadDeportiva() {
		return actividadDeportiva;
	}

	public void setActividadDeportiva(String actividadDeportiva) {
		this.actividadDeportiva = actividadDeportiva;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public CInstitucion() {
		super();
	}
	
	@Override
	public ArrayList<String> listarInstitucionDeportiva() {
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		ArrayList<String> ni = mi.getNombres();
		return ni;
	}

	@Override
	public Set<String> selectInstitucionDeportiva(String institucion) {
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		Set<String> res = new HashSet<>();
		if(mi.existeInsttitucion(institucion)) { // si ya se que la institucion existe esto es al cuete
			this.setInstitucion(institucion);
			InstitucionDeportiva inst = mi.getInstitucion(institucion);
			res = inst.getActividades();
		}
		return res;
	}
	
	@Override
	public boolean altaInstitucionDeportiva(String nombre_institucion, String descripcion, String url)throws InstitucionRepetidaExcepcion {
		boolean res = false;
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		if(!mi.existeInsttitucion(nombre_institucion)) {
			InstitucionDeportiva inst = new InstitucionDeportiva(nombre_institucion, descripcion, url);
			mi.agregarInstitucion(nombre_institucion ,inst);
			res = true;
		}
		return res;
	}
	
	@Override
	public DtActividadDeportiva selectActividadDeportiva(String actividad) {
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva inst = mi.getInstitucion(this.institucion);
		return inst.getDtActividad(actividad);
	}
	
	@Override
	public boolean altaClase(String actividad, String nombre, DtFecha fechaIni, DtHora horaIni, String profesor, String url, DtFecha fechaAlta) {
		boolean res = false;
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva inst = mi.getInstitucion(this.institucion);
		Clase c = inst.crearClase(actividad, nombre, fechaIni, horaIni, profesor, url, fechaAlta);
		if(c != null) {
			ManejadorUsuario mu = ManejadorUsuario.getInstancia();
			Usuario profe = mu.buscarUsuario(profesor);
			if(profe instanceof Profesor) {
				Profesor prof = (Profesor) profe;
				prof.daClase(c);
			}
		}
		return res;
	}
	
	@Override
	public boolean altaActividadDeportiva(String nombre_institucion, String nombre, String descripcion, int duracion, Float costo, DtFecha fechaAlta) {
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva inst = mi.getInstitucion(nombre_institucion);
		return inst.crearActividadDeportiva(nombre, descripcion, duracion, costo, fechaAlta);
	}
	
	@Override
	public DtClase selectClase(String nombre) {
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva id = mi.getInstitucion(this.institucion);
		DtClase dtc = id.getDtClase(this.actividadDeportiva, nombre);
		return dtc;
	}
}
