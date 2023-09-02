package interfaces;

import java.util.ArrayList;
import java.util.Set;

import datatypes.DtUsuario;

public interface ICUsuario {
	public void agregarUsuario(DtUsuario usuario);
	
	public DtUsuario obtenerUsuario(String nickname);// en pav usabamos el main para iterar y mostrar toda la info de usuario
	
	
	
	/*
	   // public ArrayList<DtSocio> listarSocios ();

			
		//public void selectDatos (String socio, String clase, DtFecha FechaReg, float costo);

	//public void listarSocio(); 
	public Set<String> listarSocios();


	
 //  public Set<DtSocio> listarSocio ();
		
	public void ingresarSocio (String nickname, String nombre, String apellido, String email, DtFecha fechaNac) ;

			
	//	public void selectUsuario (String usuario);
					

		//public void ingresarProfesor (String nickname, String nombre, String apellido, String email,
          //      DtFecha fechaNac, String descripcion, String biografia, String sitioweb);


	*/	
	}
