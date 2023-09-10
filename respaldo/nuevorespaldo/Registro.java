package logica;

import datatypes.DtFecha;
import datatypes.DtClase;

//@Entity
//@IdClass(RegistroID.class)
public class Registro {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@ManyToOne
	private Socio socio;
	//@ManyToOne
	private Clase clase;
	//@Temporal(TemporalType.DATE)
    private DtFecha fechaReg;

    public Registro(DtFecha f) {
       super();
    	this.fechaReg = f;
    }

    public Registro() {
		super();
	}
	/*  public Registro() {
		super();
	}*/

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
