package interfaces;

import java.util.ArrayList;
import java.util.Set;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtHora;
import excepciones.InstitucionRepetidaExcepcion;
import excepciones.ActividadDeportivaRepetidaExcepcion;
import excepciones.ClaseRepetidaExcepcion;
import logica.Clase;

public interface ICInstitucion {

    public ArrayList<String> listarInstitucionDeportiva();
    public Set<String> selectInstitucionDeportiva(String institucion);
    public DtActividadDeportiva selectActividadDeportiva(String actividad);
    public boolean altaInstitucionDeportiva(String nombre_institucion, String descripcion, String url)throws InstitucionRepetidaExcepcion;
    public boolean altaClase(String nombre_inst, String actividad, String nombre, DtFecha fechaini, DtHora horaini, String profesor, String url, DtFecha fechaAlta) throws ClaseRepetidaExcepcion;
    public boolean altaActividadDeportiva(String nombre_institucion, String nombre, String descripcion, int duracion, Float costo, DtFecha fechaAlta)throws ActividadDeportivaRepetidaExcepcion;
    public DtClase selectClase(String nombre);
	public Clase obtenerClase(String clase);
	public String[] listarInstitucion();
	public String[] listarActividades(String nombre_inst);
}
