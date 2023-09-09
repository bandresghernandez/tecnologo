package interfaces;

import java.util.ArrayList;

import java.util.Set;

import datatypes.DtFecha;
import datatypes.DtUsuario;
import excepciones.UsuarioEnUsoExcepcion;

public interface ICUsuario {
	public void agregarUsuario(DtUsuario usuario) throws UsuarioEnUsoExcepcion;
	public DtUsuario obtenerUsuario(String nickname);// en pav usabamos el main para iterar y mostrar toda la info de usuario
	public Set<String> listarUsuarios();
	public Set<String> listarSocios();
	//public boolean selecDatos(String socio, String clase, DtFecha fechaReg, Float costo);
	boolean selecDatos(String socio, String clase, DtFecha fechaReg);
	public String[] listarUsuario();
	public String[] devolverClases(String nickname);

	public String getActividad(String nickname, String clase);

	}
