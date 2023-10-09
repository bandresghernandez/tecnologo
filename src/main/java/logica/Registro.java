package logica;

import datatypes.DtFecha;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import datatypes.DtClase;

@Entity
public class Registro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//private Socio socio; segun cdc Registro ve Clase no Socio
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identificador autogenerado
	    private Long id; // Nuevo campo para el identificador
	 @ManyToOne
	 @JoinColumn(name = "clase_id")
	 private Clase clase;
	 @Type(type = "logica.DtFechaUserType")
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
