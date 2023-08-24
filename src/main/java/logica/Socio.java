package logica;

import java.util.ArrayList;
import datatypes.DtFecha;


class Socio extends Usuario {
	
	 private ArrayList<Registro> registros;

	
    public Socio(String nickname, String nombre, String apellido, String email, DtFecha fechaNac) {
        super(nickname, nombre, apellido, email, fechaNac);
    }
    
    
    // Getter and setter for the 'registros' attribute
    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<Registro> registros) {
        this.registros = registros;
    }
}



