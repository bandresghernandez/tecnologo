package logica;

import datatypes.DtActividadDeportiva;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import logica.IControlador;

public class Controlador implements IControlador {
	
	public Controlador() {
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
	public void agregarActividadDeportiva(DtActividadDeportiva actividad) {
		// TODO Auto-generated method stub
		System.out.print("algo");
	}
	
	
}