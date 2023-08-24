package datatypes;

public class DtProfesor extends DtUsuario{
	   public String descripcion;
	   public String biografia;
	   public String sitioweb;
	
	
	public DtProfesor (String nickname, String nombre, String apellido, String email,
            DtFecha fechaNac, String descripcion, String biografia, String sitioweb) {
super(nickname, nombre, apellido, email,fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
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
