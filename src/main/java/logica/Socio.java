package logica;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtSocio;
import datatypes.DtUsuario;

@Entity
@DiscriminatorValue("Socio")
class Socio extends Usuario {
	
	//private List<Registro> registros ;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Registro> registros = new ArrayList<>();
    
	public Socio(String nickname, String pass, String nombre, String apellido, String email, DtFecha fechaNac) {
        super(nickname, pass, nombre, apellido, email, fechaNac);
        //this.registros = null;
    }
	public Socio() {
		super();
	}

	/*public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
*/
	public void agregarRegistros(Clase clase, DtFecha fechaRegistro) {
		Registro r = new Registro(clase,fechaRegistro);
		registros.add(r);
	}
	@Override
	public DtUsuario getDtUsuario() {
		// TODO Auto-generated method stub
		return new DtSocio(this.getNickname(), this.getPass(), this.getNombre(), this.getApellido(), this.getEmail(), this.getFechaNac());
		//return null;
		// Falta pasarle un DtClase al constructor
	}

	@Override
	public DtUsuario obtenerInfo() {
		List<DtClase> clases = new ArrayList<>();
		for(Registro i : registros) {
			//Guardo cada clase que esta vinculada al Socio en "clases"
			clases.add(i.obtenerInfoClase());			
		}
		
		//una ves teniendo todas las clases creo el DtSocio
		DtSocio data = new DtSocio(this.getNickname(), this.getPass(), this.getNombre(), this.getApellido(), this.getEmail(),this.getFechaNac());
		//String nickname, String nombre, String apellido, String email,DtFecha fechaNac,List<DtClase> clases
		return data;
	}
    
	
	public Boolean crearRegistro(Clase c, DtFecha fechaReg) {
		DtFecha fecha = null;
		Boolean flag = false;
		
		for(Registro r: registros) {
			fecha = r.getFechaReg();
			
			//Si encuentro una fecha igual salgo del for
			if (fecha.getAnio() == fechaReg.getAnio() &&
				    fecha.getMes() == fechaReg.getMes() &&
				    fecha.getDia() == fechaReg.getDia() &&
				    c.getNombre().equals(r.getClase().getNombre())) {
				    flag = true;
				    break;
			}		
		}
		
		//Si flag es True es por que esta repetido por lo tanto no debe crearse el registro
		//si flag es False entonces se pude crear el registro ya que no hay un repetido
		
		if (!flag) {
			Registro reg = new Registro(c,fechaReg);
			this.registros.add(reg);
		}
		
		return !flag;
	}

	@Override
	public ArrayList<String> obtenerClases(){
        ArrayList<String> arrayClas = new ArrayList<String>();
        for(Registro i: registros) {
            arrayClas.add(i.getClase().getNombre());
        }
        return arrayClas;
    }
}
