package logica;
import datatypes.DtFecha;
//import logica.Usuario;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ni ,n, ap,e ;
		ni = n = ap = "";
		e = "Email@prueba.com";
		DtFecha fn = new DtFecha(1,1,1);
		
		System.out.print("hola");
		Usuario prueba = new Usuario( ni,  n, ap,  e, fn);
		
		
		System.out.print(prueba.getEmail());
	}

	



}
