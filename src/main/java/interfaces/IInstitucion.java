package interfaces;

import java.util.ArrayList;
import java.util.Set;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtHora;

public interface IInstitucion {
    public ArrayList<String> listarInstitucionDeportiva();
    public Set<String> selectInstitucionDeportiva(String institucion);
    public DtActividadDeportiva selectActividadDeportiva(String actividad);
    public boolean altaInstitucionDeportiva(String nombre_institucion, String descripcion, String url);
    public boolean altaClase(String actividad, String nombre, DtFecha fechaini, DtHora horaini, String profesor, String url, DtFecha fechaAlta);
    public boolean altaActividadDeportiva(String nombre_institucion, String nombre, String descripcion, int duracion, Float costo, DtFecha fechaAlta);
    public DtClase selectClase(String nombre);
}