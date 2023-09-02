package interfaces;

import logica.CInstitucion;
import logica.CUsuario;

public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica(){}
	
	public static Fabrica getInstancia() {
		if (instancia == null)
			instancia = new Fabrica();
		return instancia;
	}
	
	public ICUsuario getICUsuario() {
		return new CUsuario();
	}

	public ICInstitucion getICInstitucion() {
		return new CInstitucion();
	}




}





