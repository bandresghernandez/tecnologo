package logica;

import java.util.Set;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import interfaces.ICUsuario;

import java.util.ArrayList;
import java.util.HashSet;
	
// falta el puntero a usuario
public class CUsuario implements ICUsuario{

	public CUsuario(){
		super();
	}
	
	@Override
	public void agregarUsuario(DtUsuario usuario) {
		// TODO Auto-generated method stub
		Usuario nuevoUsuario= null;
		if (usuario instanceof DtSocio)
			nuevoUsuario = new Socio(usuario.getNickname(),usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getFechaNac());	
		if (usuario instanceof DtProfesor)
			nuevoUsuario = new Profesor(usuario.getNickname(),usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getFechaNac(), ((DtProfesor) usuario).getDescripcion(),((DtProfesor) usuario).getBiogrfia(), ((DtProfesor) usuario).getSitioweb() );
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		mU.agregarUsuario(nuevoUsuario);
		
		
	}

	@Override
	public DtUsuario obtenerUsuario(String nickname) {// seria selecUsuario en el dcd
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = mU.buscarUsuario(nickname);
		
		DtUsuario dtUsuario = usuario.getDtUsuario();
		
		return dtUsuario;
	}

	@Override
	public Set<String> listarUsuarios(){
	    ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	    ArrayList<String> arrayUsuarios = mU.getUsuarios();
	    Set<String> usuariosSet = new HashSet<>(arrayUsuarios);
	    return usuariosSet;
	}

	@Override
	public Set<String> listarSocios(){
	    ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	    ArrayList<String> arraySocios = mU.getSocios();
	    Set<String> sociosSet = new HashSet<>(arraySocios);
	    return sociosSet;
	}


	/* encuentro el socio, encuentro la clase y si no existe el regitro de ese socio a esa clase lo creo
	@Override
	public boolean selecDatos(String socio, String clase, DtFecha fechaReg, Float costo){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = mU.buscarUsuario(socio);
		
		
 
	}
	*/

	
}
