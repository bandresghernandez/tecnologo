package excepciones;

public class InstitucionRepetidaExcepcion extends Exception{
	private static final long serialVersionUID = 1L;

	public InstitucionRepetidaExcepcion(String string) {
        super(string);
    }
}
