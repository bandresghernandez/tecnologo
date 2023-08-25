package logica;
import java.util.ArrayList;
import java.util.List;

import datatypes.DtFecha;

public class Profesor extends Usuario {
    private String descripcion;
    private String biografia;
    private String sitioweb;
    private List<Clase> clases new ArrayList<>();
    private InstitucionDeportiva institucion;

    // Constructor
    public Profesor(String nickname, String nombre, String apellido, String email,
                    DtFecha fechaNac, String descripcion, String biografia, String sitioweb) {
        super(nickname, nombre, apellido, email,fechaNac);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioweb = sitioweb;
        this.institucion = institucion;
        
    }

    public  void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public void setBiografia(String biografia)
    {
        this.biografia = biografia;
    }

    public void setSitioweb(String sitioweb)
    {
        this.sitioweb = sitioweb;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }

    public String getBiogrfia()
    {
        return this.biografia;
    }

    public String getSitioweb()
    {
        return this.sitioweb;
    }

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public InstitucionDeportiva getInstitucion() {
		return this.institucion;
	}
	
	public void setInstitucion(InstitucionDeportiva institucion) {
		this.institucion = institucion;
	}
}
