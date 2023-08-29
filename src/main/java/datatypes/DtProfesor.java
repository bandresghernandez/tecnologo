package datatypes;

import java.util.List;

public class DtProfesor extends DtUsuario{
	   private String descripcion;
	   private String biografia;
	   private String sitioweb;
	   private List<DtActividadDeportiva> actividades;
	   private List<DtClase> clases;
	
	
	public DtProfesor (String nickname, String nombre, String apellido, String email,
            DtFecha fechaNac, String descripcion, String biografia, String sitioweb,List<DtActividadDeportiva> actividades,List<DtClase> clases) {
super(nickname, nombre, apellido, email,fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
		this.actividades = actividades;
		this.clases = clases;
}


public String getDescripcion()
{
return descripcion;
}

public String getBiogrfia()
{
return biografia;
}

public String getSitioweb()
{
return sitioweb;
}

		

}
