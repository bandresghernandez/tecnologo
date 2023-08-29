package logica;
import java.util.ArrayList;
import java.util.List;

import datatypes.DtFecha;
import datatypes.DtSocio;
import datatypes.DtUsuario;

class Socio extends Usuario {
	
	//private List<Registro> registros ;
	private List<Registro> registros = new ArrayList<>();
    
	public Socio(String nickname, String nombre, String apellido, String email, DtFecha fechaNac) {
        super(nickname, nombre, apellido, email, fechaNac);
        //this.registros = null;
    }

	/*public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}*/

	public void agregarRegistros(Socio socio, DtFecha fechaRegistro) {
		Registro r = new Registro(socio,fechaRegistro);
		registros.add(r);
	}
	@Override
	public DtUsuario getDtUsuario() {
		// TODO Auto-generated method stub
		return new DtSocio(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac());
		// Falta pasarle un DtClase al constructor
	}
    
    
}
