package logica;

import logica.Clase;
import datatypes.DtFecha;
import datatypes.DtClase;
import datatypes.DtSocio;

public class Registro {
	//private Socio socio; segun cdc Registro ve Clase no Socio
	private Clase clase;
    private DtFecha fechaReg;

    public Registro(DtFecha f) {
       super();
    	this.fechaReg = f;
    }

    public Registro() {
		super();
	}

	public Registro(Clase clase, DtFecha fecha) {
		super();
		this.clase = clase;
		this.fechaReg = fecha;
	}

	
    public DtFecha getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(DtFecha f) {
        fechaReg = f;
    }
    public Clase getClase() {
		return clase;
	}
    public void setClase(Clase clase) {
		this.clase = clase;
	}
	
	
	public DtClase obtenerInfoClase()
	{
		return this.clase.obtenerinfo();		
	}
	
/*
	public DtSocio getDtSocio(){
		return new DtSocio(socio.getNickname(), socio.getNombre(), socio.getApellido(), socio.getEmail(), socio.getFechaNac());
	}
	// Falta pasarle un DtClase al constructor
	*/
}
