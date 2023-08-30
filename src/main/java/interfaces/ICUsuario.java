package interfaces;

import java.util.ArrayList;

public interface ICUsuario {

	   // public ArrayList<DtSocio> listarSocios ();

			
		//public void selectDatos (String socio, String clase, DtFecha FechaReg, float costo);

	public void listarSocio(); 


	
 //  public Set<DtSocio> listarSocio ();
		
	public void ingresarSocio (String nickname, String nombre, String apellido, String email, DtFecha fechaNac) ;

			
	//	public void selectUsuario (String usuario);
					

		//public void ingresarProfesor (String nickname, String nombre, String apellido, String email,
          //      DtFecha fechaNac, String descripcion, String biografia, String sitioweb);


		
	}
