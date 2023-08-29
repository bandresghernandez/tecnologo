package logica;

import datatypes.DtFecha;
import datatypes.DtSocio;

public class Registro {
	private Socio socio;
    private DtFecha fechaReg;

    public Registro(DtFecha f) {
       super();
    	this.fechaReg = f;
    }

    public Registro() {
		super();
	}

	public Registro(Socio socio, DtFecha fecha) {
		super();
		this.socio = socio;
		this.fechaReg = fecha;
	}

	public Registro(Socio socio, Clase clase) {
		super();
		this.socio = socio;
	}
	
    public DtFecha getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(DtFecha f) {
        fechaReg = f;
    }
    public Socio getSocio() {
		return socio;
	}
    public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public String getNicknameSocio() {
		return this.socio.getNickname();
	}

	public DtSocio getDtSocio(){
		return new DtSocio(socio.getNickname(), socio.getNombre(), socio.getApellido(), socio.getEmail(), socio.getFechaNac());
	}
	
}
