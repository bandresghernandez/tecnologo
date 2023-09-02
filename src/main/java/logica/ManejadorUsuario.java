package logica;

import java.util.List;
import java.util.ArrayList;

public class ManejadorUsuario {

	private static ManejadorUsuario instancia = null;
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	private ManejadorUsuario(){}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}

	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public Usuario buscarUsuario(String nickname) {// puede ser email tambien
		Usuario aretornar=null;
		for(Usuario u: usuarios) {
			if (u.getNickname().equals(nickname))
				aretornar=u;
		}
		return aretornar;
	}

	public ArrayList<String> getUsuarios(){
		ArrayList<String> UsuRet = new ArrayList<String>();
		for(Usuario i: usuarios) {
			UsuRet.add(i.getNickname());		
		}
		return UsuRet;
	}

	public ArrayList<String> getSocios(){
		ArrayList<String> SociosRet = new ArrayList<String>();
		for(Usuario i: usuarios) {
			if (i instanceof Socio) {
				SociosRet.add(i.getNickname());
			}	
		}
		return SociosRet;
	}

	
	
}
