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
import excepciones.ActividadDeportivaRepetidaExcepcion;


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
			this.institucion = institucion;
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
	
	/*@Override
	public DtActividadDeportiva selectActividadDeportiva(String actividad) {
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva inst = mi.getInstitucion(this.institucion);
		this.actividadDeportiva = actividad;
		return inst.getDtActividad(actividad);
	}*/
	
	@Override
	public boolean altaClase(String nombre_inst, String actividad, String nombre, DtFecha fechaIni, DtHora horaIni, String profesor, String url, DtFecha fechaAlta) {
		boolean res = false;
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva inst = mi.getInstitucion(nombre_inst);
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
	public boolean altaActividadDeportiva(String nombre_institucion, String nombre, String descripcion, int duracion, Float costo, DtFecha fechaAlta)throws ActividadDeportivaRepetidaExcepcion {
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva inst = mi.getInstitucion(nombre_institucion);
		boolean res = false;
		if(inst.existeActividadDeportiva(nombre)) {
			throw new ActividadDeportivaRepetidaExcepcion("Ya existe una actividad conm el nombre: "+ nombre+ " por favor elija otro");
		}
		else {
			res = inst.crearActividadDeportiva(nombre, descripcion, duracion, costo, fechaAlta);
		}
		return res;
	}
	
	/*@Override
	public DtClase selectClase(String nombre) {
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva id = mi.getInstitucion(this.institucion);
		DtClase dtc = id.getDtClase(this.actividadDeportiva, nombre);
		return dtc;
	}*/
	
	@Override
	public Clase obtenerClase(String inst, String act, String clase) {
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva id = mi.getInstitucion(inst);
		
		Clase clac = id.obtenerClase(clase,act);
		return clac;
	}
	
	@Override
	public String[] listarInstitucion() {
		ArrayList<String> inst = listarInstitucionDeportiva();
		String[] inst_ret = new String[inst.size()];
        int i=0;
        for(String s:inst) {
            inst_ret[i]=s;
            i++;
        }
        return inst_ret;
	}
	
	@Override
	public String[] listarActividades(String nombre_inst) {
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva id = mi.getInstitucion(nombre_inst);
		Set<String> act = id.getActividades();
		String[] act_ret = new String[act.size()];
        int i=0;
        for(String s:act) {
            act_ret[i]=s;
            i++;
        }
        return act_ret;
	}
	
	@Override
	 public String[] listarClases(String nombre_inst, String nombre_actividad) {
        ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
        InstitucionDeportiva id = mi.getInstitucion(nombre_inst);
        ActividadDeportiva actividad = id.obtenerActividad(nombre_actividad);

        if (actividad != null) {
            Set<String> clases = actividad.getClases();
            String[] clases_ret = new String[clases.size()];
            int i = 0;
            for (String s : clases) {
                clases_ret[i] = s;
                i++;
            }
            return clases_ret;
        } else {
            return new String[0]; 
        }
    }
	
	@Override
	public DtClase selectClase(String inst, String act, String clase7) {
		
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva id = mi.getInstitucion(inst);
		
		ActividadDeportiva dta = id.obtenerActividad(act);//obtengo la actividad
		Clase c1 = dta.obtenerClase(clase7);

		return new DtClase(c1.getNombre(),c1.getFecha(),c1.getHoraInicio(),c1.getUrl(),c1.getFechaReg());

	}

	@Override
	public DtActividadDeportiva selectActividadDeportiva(String inst, String act) {
		
		ManejadorInstitucionDeportiva mi = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva insti = mi.getInstitucion(inst);
		ActividadDeportiva ac1 = insti.obtenerActividad(act);//obtengo la actividad
		//Clase c1 = ac1.obtenerClase(claseR);//obtengo la clase
		Set<String> clases = ac1.getClases();//las clases de la actividad
		
		Set<DtClase> dtc = new HashSet<>();
		
		String[] clases_ret = new String[clases.size()];
        
		int i = 0;
        for (String s : clases) {// hay que comentar porque al final no le paso la clase al DtActividadDeportiva
        	clases_ret[i]= s;
        	Clase c1= ac1.obtenerClase(s);
        	dtc.add(new DtClase(c1.getNombre(),c1.getFecha(),c1.getHoraInicio(),c1.getUrl(),c1.getFechaReg()));
           i++;
       }
      
		return new DtActividadDeportiva(ac1.getNombre(),ac1.getDescripcion(), ac1.getDuracion(), ac1.getCosto(), ac1.getFechaReg());
	
	}
	
}
