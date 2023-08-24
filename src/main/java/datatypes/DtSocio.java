package datatypes;
public class DtSocio extends DtUsuario {
    private DtClase clase;

    public DtSocio(String nickname, String nombre, String apellido, String email,DtFecha fechaNac, DtClase clase) {
        super(nickname, nombre, apellido, email,  fechaNac);
        this.clase = clase;
    }

    // Getter y setter para el atributo clase
    public DtClase getClase() {
        return clase;
    }

    public void setClase(DtClase clase) {
        this.clase = clase;
    }
}

