package datatypes;

import java.util.List;

public class DtSocio extends DtUsuario {
    private List<DtClase> clases;
    // en el DtSocio guardamos la lista de clases que esta inscripto

    public DtSocio(String nickname, String pass, String nombre, String apellido, String email,DtFecha fechaNac) {
        super(nickname, pass, nombre, apellido, email,  fechaNac);
        this.clases = clases;
    }

    // Getter 
    public List<DtClase> getClase() {
        return clases;
    }


}

