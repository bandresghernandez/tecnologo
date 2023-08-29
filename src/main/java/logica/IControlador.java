package logica;

import datatypes.DtActividadDeportiva;
import datatypes.DtUsuario;

public interface IControlador {

	
	public void agregarUsuario(DtUsuario usuario);
	
	public DtUsuario obtenerUsuario(String nickname);// en pav usabamos el main para iterar y mostrar toda la info de usuario
	
	//public void agregarActividadDeportiva(DtActividadDeportiva actividad);
	
	public abstract void agregarActividadDeportiva(DtActividadDeportiva actividad);
		
	
}
