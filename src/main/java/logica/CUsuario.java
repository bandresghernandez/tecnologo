package logic;

import interfaces.IUsuario;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

// falta el puntero a usuario
public class CUsuario implements IUsuario{

	public CUsuario(){
		super();
	}
	
	@Override
	public Set<String> listarSocios(){
    ManejadorUsuario mU = ManejadorUsuario.getInstancia();
    ArrayList<String> arraySocios = mU.getSocios();//Asumo que usamos un manejador con esta funcion
    Set<String> sociosSet = new HashSet<>(arraySocios);// Creo el set y agrego los socios
    return sociosSet;
	}

	@Override
	public boolean selecDatos(String socio, String clase, DtFecha fechaReg, Float costo);

	@Override
	public Set<String> listarUsuarios(){
    ManejadorUsuario mU = ManejadorUsuario.getInstancia();
    ArrayList<String> arrayUsuarios = mU.getUsuarios();//Asumo que usamos un manejador con esta funcion
    Set<String> usuariosSet = new HashSet<>(arrayUsuarios);// Creo el set y agrego los socios
    return usuariosSet;
	}

	@Override
    public DtUsuario selecUsuario(String usuario);// busca el usuario y devuelve un dtUsuario, deberia estar en el manejador?



	//tengo dudas en la creacion de estos usuarios de tipo socio y profe, deberia hacer una funcion sola y que en ella se haga el instanceof para ver de que tipo de usuario es?
	@Override
    public void ingresarSocio(String nickname, String nombre, String apellido, String email, DtFecha fechaNac){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(!(mU.existeNick(nickname) && mU.existeEmail(email))){// si no existe el nick ni el email
			Usuario nuevoUsuario = new Socio(nickname, nombre, apellido, email, fechaNac);//creo el socio
			mU.agregarUsuario(nuevoUsuario);//agrego el socio a la col
		}
	}

	@Override
    public void ingresarProfesor(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, String institucion, String desc, String bio, String link){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(!(mU.existeNick(nickname) && mU.existeEmail(email))){// si no existe el nick ni el email
			Usuario nuevoUsuario = new Profesor(nickname, nombre, apellido, email, fechaNac, institucion, desc, bio, link);//creo el profe
			mU.agregarUsuario(nuevoUsuario);//agrego el profe a la col
		}
	}

}