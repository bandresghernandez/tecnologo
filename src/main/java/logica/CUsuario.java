package logica;

import java.util.Set;

import datatypes.DtFecha;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.UsuarioEnUsoExcepcion;
import interfaces.Fabrica;
import interfaces.ICInstitucion;
import interfaces.ICUsuario;

import java.util.ArrayList;
import java.util.HashSet;
	
// falta el puntero a usuario
public class CUsuario implements ICUsuario{

		public CUsuario(){
		super();
	}
	@Override
	public void agregarUsuario(DtUsuario usuario) throws UsuarioEnUsoExcepcion {
		// TODO Auto-generated method stub
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario nuevoUsuario = mU.buscarUsuario(usuario.getNickname());
		//Usuario nuevoUsuario= null;
		if (nuevoUsuario != null) {
			throw new UsuarioEnUsoExcepcion("El usuario" + usuario.getNickname() + "ya esta en uso"); 
		}else {
		if (usuario instanceof DtSocio) {
			nuevoUsuario = new Socio(usuario.getNickname(),usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getFechaNac());	
		}
		if (usuario instanceof DtProfesor) {
			nuevoUsuario = new Profesor(usuario.getNickname(),usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getFechaNac(), ((DtProfesor) usuario).getDescripcion(),((DtProfesor) usuario).getBiogrfia(), ((DtProfesor) usuario).getSitioweb() );
		}
		}
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


	// encuentro el socio, encuentro la clase y si no existe el regitro de ese socio a esa clase lo creo
	@Override
	public boolean selecDatos(String inst, String act, String socio, String clase, DtFecha fechaReg){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Fabrica db = Fabrica.getInstancia();
		ICInstitucion cin = db.getICInstitucion();
		
		Clase clac = cin.obtenerClase(inst, act, clase);		
		Socio usr = (Socio) mU.buscarUsuario(socio);
		
		usr.crearRegistro(clac, fechaReg);
		
		return false;
		
		
 
	}
	@Override
	public String[] listarUsuario() {
		ArrayList<String> usuarios;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		usuarios = mU.getUsuarios();
		String[] usuarios_ret = new String[usuarios.size()];
        int i=0;
        for(String u:usuarios) {
        	usuarios_ret[i]=u;
        	i++;
        }
        return usuarios_ret;
	}
	
	@Override
	public String[] devolverClases(String email) {
        ManejadorUsuario mU = ManejadorUsuario.getInstancia();
        Usuario usuarioBusc = mU.buscarUsuario(email);
        //ArrayList<String> usuariosBusc;
        //usuariosBusc = mU.getUsuarios();
        
        ArrayList<String> listClases = new ArrayList<>();
        
        if (usuarioBusc instanceof Profesor) {
            listClases = ((Profesor) usuarioBusc).obtenerClases();
        } else if (usuarioBusc instanceof Socio) {
            listClases = ((Socio) usuarioBusc).obtenerClases();
        }
        
        return listClases.toArray(new String[0]);
        
        
        
        //return null;
    }
	@Override
	public String getActividad(String nickname, String clase) {
		// TODO Auto-generated method stub
	      ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	        Usuario usuarioBusc = mU.buscarUsuario(nickname);
	        //ArrayList<String> usuariosBusc;
	        //usuariosBusc = mU.getUsuarios();
	        
	        String actividad= null;
	        
	        if (usuarioBusc instanceof Profesor) {
	           actividad = ((Profesor) usuarioBusc).obtenerActividad(clase);
	        }
		
	        
		return actividad;
	}
	

	
}
