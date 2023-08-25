package logica;
import java.util.ArrayList;
import java.util.List;

import datatypes.DtFecha;

class Socio extends Usuario {
	
	private List<Registro> registros ;
	
    public Socio(String nickname, String nombre, String apellido, String email, DtFecha fechaNac) {
        super(nickname, nombre, apellido, email, fechaNac);
        this.registros = null;
    }

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
    
    
}
