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
	public DtUsuario obtenerUsuario(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = mU.buscarUsuario(nickname);
		
		DtUsuario dtUsuario = usuario.getDtUsuario();
		
		return dtUsuario;
	}

	@Override
	public Set<String> listarUsuarios(){
	    ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	    ArrayList<String> arrayUsuarios = mU.getUsuarios();//Asumo que usamos un manejador con esta funcion
	    Set<String> usuariosSet = new HashSet<>(arrayUsuarios);// Creo el set y agrego los socios
	    return usuariosSet;
	}

	@Override
	public Set<String> listarSocios(){
	    ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	    ArrayList<String> arraySocios = mU.getSocios();//Asumo que usamos un manejador con esta funcion
	    Set<String> sociosSet = new HashSet<>(arraySocios);// Creo el set y agrego los socios
	    return sociosSet;
	}

	/*
	
	@Override
	public boolean selecDatos(String socio, String clase, DtFecha fechaReg, Float costo);


	@Override
    public DtUsuario selecUsuario(String usuario);// busca el usuario y devuelve un dtUsuario, deberia estar en el manejador?


*/
}
