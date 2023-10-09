package excepciones;

public class LoginExcepcion extends Exception{
	private static final long serialVersionUID = 1L;

	public LoginExcepcion(String string) {
        super(string);
    }
}
