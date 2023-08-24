package datatypes;
public class DtSocio extends DtUsuario {
    private DtClase clase;

    public DtSocio(String nickname, String nombre, String apellido, String email,DtFecha fechaNac, DtClase clase) {
        super(nickname, nombre, apellido, email,  fechaNac);
        this.clase = clase;
    }

    // Getter 
    public DtClase getClase() {
        return clase;
    }


}

